/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit460.workspaces.ejb;

import byui.cit460.workspaces.data.Person;
import byui.cit460.workspaces.ejb.javabeans.DocumentList;
import java.util.HashMap;
import javax.ejb.embeddable.EJBContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.quickconnect.json.JSONUtilities;

/**
 *
 * @author jacksonrkj
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
     * Test of login method, of class PersonFacade.
     */
    @Test
    public void testAuthenticate() throws Exception {
        System.out.println("login");
        String username = "flintstonef";
        String password = "pebbles";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PersonFacadeRemote instance = (PersonFacadeRemote)container.getContext().lookup("java:global/classes/PersonFacade");
        String[] expDocuments = 
                {"11C56EC050D160F2E05378E4C99D8360",
                 "11C56EC050BD60F2E05378E4C99D8360",
                 "11C56EC050BC60F2E05378E4C99D8360",
                 "11C56EC050BA60F2E05378E4C99D8360",
                 "11C56EC050B960F2E05378E4C99D8360",
                 "11C56EC050D460F2E05378E4C99D8360", 
                 "11C56EC050D360F2E05378E4C99D8360",
                 "11C56EC050D260F2E05378E4C99D8360",
                 "11C56EC050CC60F2E05378E4C99D8360",
                 "11C56EC050B260F2E05378E4C99D8360",
                 "11C56EC050C160F2E05378E4C99D8360",
                 "11C56EC050A160F2E05378E4C99D8360"};
                
        HashMap<String, Object> result = instance.authenticate(username, password);
        if (result.size() < 2) {
            fail("testLogin failed - objects not returned");
        }
        
        Person person = (Person) result.get("person");
        DocumentList docList =  (DocumentList) result.get("documents");
        JSONUtilities jsonUtilities = new JSONUtilities();
        String json = jsonUtilities.stringify(docList);
       

        System.out.println("\n\n=========== Portal documents ================");
        System.out.println(json);
        System.out.println(expDocuments);
        System.out.println("================================================");
        assertEquals(username, person.getUserName());
        
        for (int i = 0; i < expDocuments.length; i++) {
            String expDocument = expDocuments[i];
            if (!json.contains(json)) {
                fail("authenticate: document list does not match");
            } 
        }
        
//        boolean done = false;
//        while(!done) {
//            // get position of next documentNo
//            // if position not found
//                // break
//            // extract the documentNo
//            // add document to documentNo list
//            // set start of search after documentNo
//            
//            
//        }
        
        // if number documents is not 8
            // fail test
        // for all found documents
            // verify document is in the list
            // if not in list
                // fail test
        
        assertTrue(true);
        
        container.close();
     
    }

  
    
}
