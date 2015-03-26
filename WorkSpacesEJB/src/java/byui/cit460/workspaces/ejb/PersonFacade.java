/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Person;
import byui.cit460.workspaces.ejb.javabeans.DocumentList;
import byui.cit460.workspaces.exceptions.WorkspacesException;
import java.util.Collection;
import java.util.HashMap;
import javax.ejb.EJB;
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
public class PersonFacade extends AbstractFacade<Person> implements byui.cit460.workspaces.ejb.PersonFacadeRemote {
   
    @PersistenceContext(unitName = "WorkSpacesEJBPU")
    private EntityManager em;
    
    @EJB
    private DocumentFacadeRemote documentFacade;
     
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonFacade() {
        super(Person.class);
    }
    
    public HashMap<String, Object> authenticate(String username, String password) throws WorkspacesException {
    
        Person person = null;  
        HashMap<String, Object> portalInfo  = new HashMap<>();
        
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
        } catch (NoResultException nre) {
            throw new WorkspacesException("Invalid username and/or password");
        } catch (Exception e) {
            throw new WorkspacesException(e.getMessage());
        }
        
        // get all portal documents
        Collection<Object> eventsAndGrades = documentFacade.getallPersonalEventsAndGrades(person.getPersonId());     
        Collection<Object> personalWorkspaceDocuments = documentFacade.getPersonalWorkspaceDocuments(person.getPersonId());
        DocumentList documentList = new DocumentList();
        documentList.add(personalWorkspaceDocuments);
        documentList.add(eventsAndGrades);
        
        portalInfo.put("person", person);
        portalInfo.put("documents", documentList);
        
        return portalInfo;
    }
    
}
