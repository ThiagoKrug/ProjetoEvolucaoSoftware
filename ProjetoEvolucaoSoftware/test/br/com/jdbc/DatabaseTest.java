/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rafael
 */
public class DatabaseTest {
    
    public DatabaseTest() {
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
     * Test of criarBanco method, of class Database.
     */
    @Test
    public void testCriarBanco() throws Exception {
        System.out.println("criarBanco");
        Database instance = new Database();
        instance.criarBanco();
    }

    /**
     * Test of deletaBanco method, of class Database.
     */
    @Test
    public void testDeletaBanco() throws Exception {
        System.out.println("deletaBanco");
        Database instance = new Database();
        instance.deletaBanco();
    }
    
    @Test
    public void testCriarTabelas() throws Exception {
        System.out.println("criarTabelasBanco");
        Database instance = new Database();
        instance.criarBanco();
        instance.criarTabelas();
    }
}