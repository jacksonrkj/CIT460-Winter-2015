/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import javax.ejb.embeddable.EJBContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import byui.cit460.workspaces.data.Person;
import byui.cit460.workspaces.data.Workspace;
import java.math.BigDecimal;
/**
 *
 * @author starr_000
 */
public class DocumentFacadeTest {

    public DocumentFacadeTest() {
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
    public void testRetrieveAssignments() throws Exception {
        System.out.println("retrieve assignments");
        
        Person user = new Person();
        Workspace workspace = new Workspace();
        
        user.setPersonId(new BigDecimal(1));
        workspace.setWorkspaceId(new BigDecimal(10));
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        
        DocumentFacade instance = (DocumentFacade)container.getContext().lookup("java:global/classes/DocumentFacade");
        String expResult = "";
        
        String result = instance.retrieveAssignments(user, workspace);
        
        System.out.println("\n\n*********************************************************************");
        System.out.println("Person's portal assignments: \n" + result);
        System.out.println("*********************************************************************\n\n");
        
        //assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
