/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Person;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ryan
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
    
    
    public String authenticateUser(String username, String password){
        Query auth = em.createQuery("select p from Person as p where p.userName = :username and p.password = :password");
        auth.setParameter("username", username);
        auth.setParameter("password", password);
        
        Person personUser = (Person) auth.getSingleResult();
        String documentDescriptions = null;
        return  documentDescriptions;
    }
}
