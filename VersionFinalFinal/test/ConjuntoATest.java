/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;
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
public class ConjuntoATest<T> {
    
    public ConjuntoATest() {
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
     * Test of iterator method, of class ConjuntoA.
     
    @Test
    public void testIterator() {
        System.out.println("iterator");
        ConjuntoA instance = new ConjuntoA();
        T conj[] = (T[]) new Object[10];
        Iterator expResult = new IteradorArreglo(conj,0);
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
    }

    /**
     * Test of agrega method, of class ConjuntoA.
     */
    @Test
    public void testAgrega() {
        System.out.println("agrega");
        Object dato = 1;
        ConjuntoA instance = new ConjuntoA();
        boolean expResult = true;
        boolean result = instance.agrega(dato);
        assertEquals(expResult, result);
    }

    /**
     * Test of quita method, of class ConjuntoA.
     */
    @Test
    public void testQuita() {
        System.out.println("quita");
        Object dato = 1;
        ConjuntoA instance = new ConjuntoA();
        Object expResult = null;
        Object result = instance.quita(dato);
        assertEquals(expResult, result);
    }

    /**
     * Test of quitaAleat method, of class ConjuntoA.
     */
    @Test
    public void testQuitaAleat() {
        System.out.println("quitaAleat");
        ConjuntoA instance = new ConjuntoA();
        Object expResult = null;
        Object result = instance.quitaAleat();
        assertEquals(expResult, result);
    }

    /**
     * Test of contiene method, of class ConjuntoA.
     */
    @Test
    public void testContiene() {
        System.out.println("contiene");
        Object dato = 1;
        ConjuntoA instance = new ConjuntoA();
        boolean expResult = false;
        boolean result = instance.contiene(dato);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ConjuntoA.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        ConjuntoA otro = new ConjuntoA();
        ConjuntoA instance = new ConjuntoA();
        boolean expResult = true;
        boolean result = instance.equals(otro);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCardinalidad method, of class ConjuntoA.
     */
    @Test
    public void testGetCardinalidad() {
        System.out.println("getCardinalidad");
        ConjuntoA instance = new ConjuntoA();
        int expResult = 0;
        int result = instance.getCardinalidad();
        assertEquals(expResult, result);
    }

    /**
     * Test of estaVacio method, of class ConjuntoA.
     */
    @Test
    public void testEstaVacio() {
        System.out.println("estaVacio");
        ConjuntoA instance = new ConjuntoA();
        boolean expResult = true;
        boolean result = instance.estaVacio();
        assertEquals(expResult, result);
    }

    /**
     * Test of expande method, of class ConjuntoA.
     */
    @Test
    public void testExpande() {
        System.out.println("expande");
        ConjuntoA instance = new ConjuntoA();
        instance.expande();
    }

    /**
     * Test of toString method, of class ConjuntoA.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ConjuntoA instance = new ConjuntoA();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of union method, of class ConjuntoA.
     */
    @Test
    public void testUnion() {
        System.out.println("union");
        ConjuntoA instance = new ConjuntoA();
        ConjuntoADT expResult = null;
        ConjuntoADT result = instance.union(null);
        assertEquals(expResult, result);
    }

    /**
     * Test of interseccion method, of class ConjuntoA.
     */
    @Test
    public void testInterseccion() {
        System.out.println("interseccion");
        ConjuntoA instance = new ConjuntoA();
        ConjuntoADT expResult = null;
        ConjuntoADT result = instance.interseccion(null);
        assertEquals(expResult, result);
    }

    /**
     * Test of diferencia method, of class ConjuntoA.
     */
    @Test
    public void testDiferencia() {
        System.out.println("diferencia");
        ConjuntoA instance = new ConjuntoA();
        ConjuntoADT expResult = null;
        ConjuntoADT result = instance.diferencia(null);
        assertEquals(expResult, result);
    }
    
}
