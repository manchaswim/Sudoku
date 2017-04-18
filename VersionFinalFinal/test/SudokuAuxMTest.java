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
public class SudokuAuxMTest {
    
    public SudokuAuxMTest() {
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
     * Test of getRes method, of class SudokuAuxM.
     */
    @Test
    public void testGetRes() {
        System.out.println("getRes");
        int sudoku[][]={{0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},};
        
        int res[][]={{0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},};
        SudokuAuxM instance = new SudokuAuxM(sudoku, res);
        int[][] expResult = {{0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},};;
        int[][] result = instance.getRes();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of sudokuSolver method, of class SudokuAuxM.
     */
    @Test
    public void testSudokuSolver() {
        System.out.println("sudokuSolver");
        int sudoku[][]={{0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},};
        
        int res[][]={{0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},};
        SudokuAuxM instance = new SudokuAuxM(sudoku, res);
        instance.sudokuSolver();
    }

    /**
     * Test of sudokuSolverR method, of class SudokuAuxM.
     */
    @Test
    public void testSudokuSolverR() {
        System.out.println("sudokuSolverR");
        int sudoku[][]={{0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},};
        
        int res[][]={{0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},};
        SudokuAuxM instance = new SudokuAuxM(sudoku, res);
        instance.sudokuSolverR();
    }

    
}
