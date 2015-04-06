/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Document;
import javax.ejb.embeddable.EJBContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import byui.cit460.workspaces.data.Person;
import byui.cit460.workspaces.data.Workspace;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import org.quickconnect.json.JSONException;
import org.quickconnect.json.JSONUtilities;
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
        
        List<Object> result = instance.retrieveAssignments(user.getPersonId(), workspace.getWorkspaceId());
        
        String json;
        
        JSONUtilities jsonUtil = new JSONUtilities();
            try {
            json = jsonUtil.stringify((Serializable) result);
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
        System.out.println("\n\n*********************************************************************");
        System.out.println("Person's portal assignments: \n" + result);
        System.out.println("*********************************************************************\n\n");
        
        //assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
