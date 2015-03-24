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
public class QuestionControlTest {
    
    public QuestionControlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcScore method, of class QuestionControl.
     */
    @Test
    public void testCalcScore() {
        System.out.println("calcScore");
        
        System.out.println("\tTest case #1");
        
        double timeTaken = 6.0;
        double timeLimit = 10.0;
        double question = 2.0;
        QuestionControl instance = new QuestionControl();
        double expResult = 4.0;
        double result = instance.calcScore(timeTaken, timeLimit, question);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("\tTest case #2");
        
        timeTaken = 6.0;
        timeLimit = 10.0;
        question = 0.0;
        expResult = 0.0;
        result = instance.calcScore(timeTaken, timeLimit, question);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("\tTest case #3");
        
        timeTaken = 9;
        timeLimit = 10.0;
        question = 1.0;
        expResult = .5;
        result = instance.calcScore(timeTaken, timeLimit, question);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("\tTest case #4");
        
        timeTaken = -2.0;
        timeLimit = 5.0;
        question = 2.0;
        expResult = -1.0;
        result = instance.calcScore(timeTaken, timeLimit, question);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("\tTest case #5");
        
        timeTaken = 2.0;
        timeLimit = -505.0;
        question = 2.0;
        expResult = -1.0;
        result = instance.calcScore(timeTaken, timeLimit, question);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("\tTest case #6");
        
        timeTaken = 6.0;
        timeLimit = 5.0;
        question = 2.0;
        expResult = -1.0;
        result = instance.calcScore(timeTaken, timeLimit, question);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("\tTest case #7");
        
        timeTaken = 2.0;
        timeLimit = 5.0;
        question = -2.0;
        expResult = -1.0;
        result = instance.calcScore(timeTaken, timeLimit, question);
        assertEquals(expResult, result, 0.0001);
        
    }

    /**
     * Test of endQuestionTime method, of class QuestionControl.
     */
    @Test
    public void testEndQuestionTime() {
        System.out.println("endQuestionTime");
        //Systems Current Time
        double currentTime = System.currentTimeMillis();
        
        System.out.println("\tTest case #1 - Start before End Time");
        //Set Start Time to a time in the future
        double questionStartTime = currentTime * 2000;
        double timeLimit = 20;
        QuestionControl instance = new QuestionControl();
        double expResult = -1;
        double result = instance.endQuestionTime(questionStartTime, timeLimit);
        assertEquals(expResult, result, 0.01);

        System.out.println("\tTest case #2 - Negative Time Limit");
        questionStartTime = currentTime - 60000;
        timeLimit = -5;
        expResult = -1;
        result = instance.endQuestionTime(questionStartTime, timeLimit);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("\tTest case #3 - Time Limit Less Then 5");
        questionStartTime = currentTime - 60000;
        timeLimit = 4;
        expResult = -1;
        result = instance.endQuestionTime(questionStartTime, timeLimit);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("\tTest case #4 - Answer within 1/2 Time Limit");
        questionStartTime = currentTime - 20000;
        timeLimit = 80;
        expResult = 82;
        result = instance.endQuestionTime(questionStartTime, timeLimit);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("\tTest case #5 - Answer after 1/2 Time Limit");
        questionStartTime = currentTime - 120000;
        timeLimit = 80;
        expResult = 78;
        result = instance.endQuestionTime(questionStartTime, timeLimit);
        assertEquals(expResult, result, 0.01);
    }
    
    
}
