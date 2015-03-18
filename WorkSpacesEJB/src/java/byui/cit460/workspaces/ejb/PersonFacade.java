/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;


import byui.cit460.workspaces.data.DocItem;
import byui.cit460.workspaces.data.Person;
import byui.cit460.workspaces.exceptions.WorkspacesException;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jacksonrkj
 */
@Stateless
public class PersonFacade extends AbstractFacade<Person> implements PersonFacadeRemote {
    @PersistenceContext(unitName = "WorkSpacesEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonFacade() {
        super(Person.class);
    }
    
    
    /**
     * Authenticate user at login in and get all information for the portal
     * @param username
     * @param password
     * @return a JSON object containing all of the objects for the main portal
     * @throws WorkspacesException 
     */
    @Override
    public String authenticate(String username, String password) throws WorkspacesException {
   
        Person person = null;
        String portalDocuments = "";
        Collection<Object> workspaces;
        Collection<Object> gradesEvents;

        if (username == null || password == null) {
            throw new WorkspacesException("Invalid username and/or password");
        }
        Query query = em.createQuery(
                        "SELECT p from Person AS p "
                        + "WHERE p.userName = :username "
                        + "AND p.password = :password"
                      );
        
        query.setParameter("username", username);
        query.setParameter("password", password);
        
        try {
            person = (Person) query.getSingleResult(); 
        } catch (NoResultException nre) { // thrown if no records found
            throw new WorkspacesException("Invalid username and/or password");
        } catch (Exception e) { // catch all other exceptions and throw custom exception
            throw new WorkspacesException(e.getMessage());
        }
        
        // get all portal documents
        
        // Get the Persons Workspace 
        Query queryWorkspace = em.createQuery("SELECT r.document.documentNo, r.document.contextType, r.document.shortDescr FROM Membership AS m "
                + "INNER JOIN m.workspace as w "
                + "INNER JOIN w.references as r "
                + "WHERE m.membershipPK.personId = :personid "
                + "AND w.workspaceType = 'GTIG' "
                + "ORDER BY r.document.shortDescr");
        
       queryWorkspace.setParameter("personid", person.getPersonId()); 
       
       
       
       try{
           workspaces = (Collection<Object>) queryWorkspace.getResultList();
        }
        catch (Exception e) { // catch all other exceptions and throw custom exception
            throw new WorkspacesException(e.getMessage());
        }
       
       Query grades = em.createQuery("SELECT DISTINCT r.document.documentNo, r.document.contextType, r.document.shortDescr FROM Membership AS m "
               + "INNER JOIN m.workspace AS w "
               + "INNER JOIN w.references AS r "
               + "WHERE m.membershipPK.personId = :personId "
               + "AND r.document.contextType  IN ('CTFG', 'CTEV') "
               + "ORDER BY r.document.contextType");
       
       grades.setParameter("personId", person.getPersonId());
       
       try{
           gradesEvents = (Collection<Object>) grades.getResultList();
       }
       catch (Exception e) { // catch all other exceptions and throw custom exception
            throw new WorkspacesException(e.getMessage());
        }
       
        PortalInfo portalDocs = new PortalInfo();
        portalDocs.setPersonId(person.getPersonId());
        
        ArrayList<DocItem> sections = new ArrayList<>(); 
        ArrayList<DocItem> userGrades = new ArrayList<>(); 
        ArrayList<DocItem> events = new ArrayList<>();
       
        for (Object obj : workspaces) {
            Object[] objValues = (Object[]) obj;
            sections.add(new DocItem((String) objValues[0], (String) objValues[2]));
        }
        
        for(Object obj: gradesEvents){
            Object[] objValues = (Object[]) obj;
            String contextType = (String) objValues[1];
            if(contextType.equals("CTFG")){
                userGrades.add(new DocItem((String)objValues[0], (String)objValues[1]));
            }
            else
                events.add(new DocItem((String)objValues[0], (String)objValues[1]));
        }
       
       portalDocs.getDocuments().put("sections", sections);
       portalDocs.getDocuments().put("events", events);
       portalDocs.getDocuments().put("grades", userGrades);
       
       portalDocuments = portalDocs.toJson();
       
        return portalDocuments;
    }
    
    class PortalInfo{

        private BigDecimal personId; 
        private HashMap<String, ArrayList<DocItem>> documents = new HashMap<>();     

        public PortalInfo() {
        }

        public BigDecimal getPersonId() {
            return personId;
        }

        public void setPersonId(BigDecimal personId) {
            this.personId = personId;
        }


        

        public HashMap<String, ArrayList<DocItem>> getDocuments() {
            return documents;
        }

        public void setDocuments(HashMap<String, ArrayList<DocItem>> documents) {
            this.documents = documents;
        }

        
        public String toJson() {
            Gson gson = new Gson();
            String jsonString = gson.toJson(this);
            return jsonString;
        }
        
    }
    
}
