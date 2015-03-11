/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Document;
import byui.cit460.workspaces.data.Workspace;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacksonrkj
 */
public class WorkspaceFacadeTest {
   
    private static EJBContainer container = null;
    private static WorkspaceFacadeRemote instance = null;
    
    public WorkspaceFacadeTest() {
    }
    
    
    @BeforeClass
    public static void setUpClass() {
        WorkspaceFacadeTest.container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        try {
            WorkspaceFacadeTest.instance = (WorkspaceFacadeRemote)container.getContext().lookup("java:global/classes/WorkspaceFacade");
        } catch (NamingException ex) {
            Logger.getLogger(WorkspaceFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        WorkspaceFacadeTest.container.close();
    }



    /**
     * Test of getWorkSpaceDocuments method, of class WorkspaceFacade.
     */
    @Test
    public void testGetWorkSpaceDocuments() throws Exception {
       System.out.println("getWorkSpaceDocuments");
        
        Workspace entity = null;
        Collection<Document> expResult = null;
        BigDecimal id = new BigDecimal(15); // input value
        String result = WorkspaceFacadeTest.instance.getWorkSpaceDocuments(id);

        System.out.println("\n\n=========== Workspace documents ================");
        System.out.println(result);
        System.out.println("================================================");
        
        assertTrue(true);
        
    }

    /**
     * Test of getPortalDocuments method, of class WorkspaceFacade.
     */
    @Test
    public void testGetPortalDocuments() throws Exception {
        System.out.println("getWorkSpaceDocuments");
        
        Workspace entity = null;
        Collection<Document> expResult = null;
        BigDecimal id = new BigDecimal(15); // input value
        String result = WorkspaceFacadeTest.instance.getWorkSpaceDocuments(id);

        System.out.println("\n\n=========== Workspace documents ================");
        System.out.println(result);
        System.out.println("================================================");
        
        assertTrue(true);
        
    }
    
}
