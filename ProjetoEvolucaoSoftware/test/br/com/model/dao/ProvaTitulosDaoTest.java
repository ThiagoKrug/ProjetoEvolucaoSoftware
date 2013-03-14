/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.model.entity.Classe;
import br.com.model.entity.Concurso;
import br.com.model.entity.IEntidade;
import br.com.model.entity.ProvaTitulos;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno
 */
public class ProvaTitulosDaoTest {
    
    private static ProvaTitulos novaProva;
    
    public ProvaTitulosDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        Concurso concurso = new Concurso();
        String sql = "INSERT INTO concurso";
        
        Classe classe1 = new Classe();
        Classe classe2 = new Classe();
        Classe classe3 = new Classe();
        
        novaProva = new ProvaTitulos();
        
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
     * Test of inserir method, of class ProvaTitulosDao.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        IEntidade entidade = null;
        ProvaTitulosDao instance = new ProvaTitulosDao();
        IEntidade expResult = null;
        IEntidade result = instance.inserir(entidade);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class ProvaTitulosDao.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        IEntidade entidade = null;
        ProvaTitulosDao instance = new ProvaTitulosDao();
        IEntidade expResult = null;
        IEntidade result = instance.alterar(entidade);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class ProvaTitulosDao.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        IEntidade entidade = null;
        ProvaTitulosDao instance = new ProvaTitulosDao();
        IEntidade expResult = null;
        IEntidade result = instance.excluir(entidade);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarPorId method, of class ProvaTitulosDao.
     */
    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        int id = 0;
        ProvaTitulosDao instance = new ProvaTitulosDao();
        IEntidade expResult = null;
        IEntidade result = instance.pesquisarPorId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarTodos method, of class ProvaTitulosDao.
     */
    @Test
    public void testPesquisarTodos() throws Exception {
        System.out.println("pesquisarTodos");
        ProvaTitulosDao instance = new ProvaTitulosDao();
        List expResult = null;
        List result = instance.pesquisarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarTodosOrdenadoPor method, of class ProvaTitulosDao.
     */
    @Test
    public void testPesquisarTodosOrdenadoPor() {
        System.out.println("pesquisarTodosOrdenadoPor");
        String criterioOrdenamento = "";
        ProvaTitulosDao instance = new ProvaTitulosDao();
        List expResult = null;
        List result = instance.pesquisarTodosOrdenadoPor(criterioOrdenamento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}