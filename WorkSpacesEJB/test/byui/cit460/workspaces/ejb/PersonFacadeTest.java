/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Person;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Preston
 */
public class PersonFacadeTest {
    
    public PersonFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

   
    /**
     * Test of authenticate method, of class PersonFacade.
     */
    @Test
    public void testAuthenticate() throws Exception {
        System.out.println("authenticate");
        String username = "flintstonef";
        String password = "pebbles";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PersonFacadeRemote instance = (PersonFacadeRemote)container.getContext().lookup("java:global/classes/PersonFacade");
        String expResult = "";
        String result = instance.authenticate(username, password);
        
        System.out.println("\n\n*********************************************************************");
        System.out.println("Person's portal documnents: \n" + result);
        System.out.println("*********************************************************************\n\n");
        
        //assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
