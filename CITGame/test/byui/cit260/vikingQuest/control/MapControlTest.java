/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.vikingQuest.control;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Krys
 */
public class MapControlTest {
    
    public MapControlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcLevelPoints method, of class MapControl.
     */
    @Test
    public void testCalcLevelPoints() {
        System.out.println("calcLevelPoints");
        
        System.out.println("\tTest case #1");
        
        int questionLevel = 3;
        int ansCorrectly = 3;
        MapControl instance = new MapControl();
        double expResult = 20.0;
        double result = instance.calcLevelPoints(questionLevel, ansCorrectly);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("\tTest case #2");
        
        questionLevel = 3;
        ansCorrectly = 2;
        expResult = 0.0;
        result = instance.calcLevelPoints(questionLevel, ansCorrectly);
        assertEquals(expResult, result, 0.0);
        
        /* Instructor: 
         * Missing test case for invalid case: questionLevel < 3 
         */
        
        System.out.println("\tTest case #3");
        
        questionLevel = 3;
        ansCorrectly = 1;
        expResult = 0.0;
        result = instance.calcLevelPoints(questionLevel, ansCorrectly);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest case #4");
        
        questionLevel = 3;
        ansCorrectly = 0;
        expResult = 0.0;
        result = instance.calcLevelPoints(questionLevel, ansCorrectly);
        assertEquals(expResult, result, 0.0);
        
    }
    
}
