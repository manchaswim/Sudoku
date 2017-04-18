/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bettymunoz
 */
public class IteradorArregloTest {
    
    public IteradorArregloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of hasNext method, of class IteradorArreglo.
     */
    @Test
    public void testHasNext() {
        System.out.println("hasNext");
        IteradorArreglo instance = new IteradorArreglo();
        boolean expResult = false;
        boolean result = instance.hasNext();
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class IteradorArreglo.
    */ 
    @Test
    public void testNext() {
        System.out.println("next");
        Integer arre[]={1,2,3,4};
        IteradorArreglo instance = new IteradorArreglo(arre,4);
        Object expResult = 1;
        Object result = instance.next();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class IteradorArreglo.
     
    @Test
    public void testRemove() {
        System.out.println("remove");
        IteradorArreglo instance = new IteradorArreglo();
        instance.remove();
    }
    */
    
}
