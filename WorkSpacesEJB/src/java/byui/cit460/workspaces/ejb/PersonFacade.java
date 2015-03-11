/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workshops.execeptions.WorkspacesException;
import byui.cit460.workspaces.data.Person;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonFacade() {
        super(Person.class);
    }

    @Override
    public String authenticate(String username, String password) throws WorkspacesException {
         //To change body of generated methods, choose Tools | Templates.
        
        Query query = em.createQuery("SELECT p FROM Person AS p "
                + "WHERE p.userName = :username AND p.password = :password"); 
        
        query.setParameter("username", username); 
        query.setParameter("password", password);
        Person aPerson = (Person) query.getSingleResult();
        
      
        return aPerson.toString();
    }
    
}
