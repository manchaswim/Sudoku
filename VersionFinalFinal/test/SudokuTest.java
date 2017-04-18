/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class SudokuTest {
    
    public SudokuTest() {
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
     * Test of agregaDigito method, of class Sudoku.
     */
    @Test
    public void testAgregaDigito() {
        System.out.println("agregaDigito");
        int numero = 1;
        int ren = 0;
        int col = 0;
        Sudoku instance = new Sudoku();
        boolean expResult = true;
        boolean result = instance.agregaDigito(numero, ren, col);
        assertEquals(expResult, result);
    }
    
}
