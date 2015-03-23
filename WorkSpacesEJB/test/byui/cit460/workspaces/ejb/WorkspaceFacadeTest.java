/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Membership;
import byui.cit460.workspaces.data.MembershipPK;
import byui.cit460.workspaces.data.Workgroup;
import byui.cit460.workspaces.data.Workspace;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
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
public class WorkspaceFacadeTest {
    
    public WorkspaceFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    
    /**
     * Test of addGroup method, of class WorkspaceFacade.
     */
 /*   @Test
    public void testAddGroup() throws Exception {
        System.out.println("addGroup");
        Workgroup newWorkGroup = null;
        BigInteger size = new BigInteger("3");
        BigInteger owner = new BigInteger("1");
        
        
        BigInteger user2ID = new BigInteger("2");
        BigInteger user2WID = new BigInteger("2");
        short seven = 7;
        
        
        MembershipPK user2Pk = new MembershipPK(user2ID, user2WID);
        
        Membership user2 = new Membership(); 
        user2.setRoleType("RTPR");
        user2.setPermission(seven);
        user2.setMembershipPK(user2Pk);
        
        
        Collection<Membership> theGroup = null;
        theGroup.add(user2);
        
        
        newWorkGroup.setOwner(owner);
        newWorkGroup.setDescription("Warriors Test Group");
        newWorkGroup.setWorkspaceType("GTSD");
        newWorkGroup.setMaxSize(size);
        newWorkGroup.setGroupMember(theGroup);
        
        
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        WorkspaceFacadeRemote instance = (WorkspaceFacadeRemote)container.getContext().lookup("java:global/classes/WorkspaceFacade");
        String expResult = "";
        String result = instance.addGroup(newWorkGroup);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }



    /**
     * Test of viewGroup method, of class WorkspaceFacade.
     */
    @Test
    public void testViewGroup() throws Exception {
        System.out.println("viewGroup");
        int personId = 2;
        int workspaceId =  10;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        WorkspaceFacadeRemote instance = (WorkspaceFacadeRemote)container.getContext().lookup("java:global/classes/WorkspaceFacade");
        String expResult = "";
        String result = instance.viewGroup(personId, workspaceId);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of deleteGroup method, of class WorkspaceFacade.
     */
    @Test
    public void testDeleteGroup() throws Exception {
        System.out.println("deleteGroup");
        int personId = 2;
        int workspaceId = 10;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        WorkspaceFacadeRemote instance = (WorkspaceFacadeRemote)container.getContext().lookup("java:global/classes/WorkspaceFacade");
        String expResult = "";
        String result = instance.deleteGroup(personId, workspaceId);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMember method, of class WorkspaceFacade.
     */
    @Test
    public void testAddMember() throws Exception {
        System.out.println("addMember");
        int personId = 2;
        int workspaceId = 10;
        int newMember = 5;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        WorkspaceFacadeRemote instance = (WorkspaceFacadeRemote)container.getContext().lookup("java:global/classes/WorkspaceFacade");
        String expResult = "";
        String result = instance.addMember(personId, workspaceId, newMember);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
