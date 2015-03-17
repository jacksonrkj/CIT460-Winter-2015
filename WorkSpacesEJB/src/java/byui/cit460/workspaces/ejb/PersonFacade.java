/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;


import byui.cit460.workspaces.data.Document;
import byui.cit460.workspaces.data.Person;
import byui.cit460.workspaces.data.Workspace;
import byui.cit460.workspaces.exceptions.WorkspacesException;
import java.util.Collection;
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
        Collection<Document> workspaces;
        Collection<Document> gradesEvents;

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
        Query queryWorkspace = em.createQuery("SELECT r.document FROM Workspace AS w "
                + "INNER JOIN w.membershipCollection as m "
                + "INNER JOIN w.references as r "
                + "WHERE m.membershipPK.personId = :personid "
                + "AND w.workspaceType = 'CTIG'");
        
       queryWorkspace.setParameter("personid", person.getPersonId()); 
       
       
       
       try{
           workspaces = (Collection<Document>) queryWorkspace.getResultList();
        }
        catch (Exception e) { // catch all other exceptions and throw custom exception
            throw new WorkspacesException(e.getMessage());
        }
       
       Query grades = em.createQuery("SELECT r.document FROM Membership AS m "
               + "INNER JOIN m.workspace AS w "
               + "INNER JOIN w.references AS r "
               + "WHERE m.membershipPK.personId = :personId "
               + "AND r.document.contextType  IN ('CTFG', 'CTEV') "
               + "ORDER BY r.document.contextType");
       
       grades.setParameter("personId", person.getPersonId());
       
       try{
           gradesEvents = (Collection<Document>) grades.getResultList();
       }
       catch (Exception e) { // catch all other exceptions and throw custom exception
            throw new WorkspacesException(e.getMessage());
        }
              
         
        return portalDocuments;
    }
}
