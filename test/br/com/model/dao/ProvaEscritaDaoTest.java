/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.Database;
import br.com.model.entity.Concurso;
import br.com.model.entity.IEntidade;
import br.com.model.entity.ProvaEscrita;
import java.util.List;
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
public class ProvaEscritaDaoTest {
    
    public ProvaEscritaDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Database database = new Database();
        database.deletaBanco();
        database.criarBanco();
        database.criarTabelas();
        database.populate();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class ProvaEscritaDao.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        ProvaEscrita entidade = new ProvaEscrita();
        ProvaEscritaDao instance = new ProvaEscritaDao();
        ConcursoDao concursoDao = new ConcursoDao();
        Concurso  c = concursoDao.inserir(new Concurso().setIdConcurso(1));
        entidade.setConcurso(c);
        ProvaEscrita result = instance.inserir(entidade);
        assertEquals(result.getIdProvaEscrita(), 1);
    }

    /**
     * Test of alterar method, of class ProvaEscritaDao.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        IEntidade entidade = null;
        ProvaEscritaDao instance = new ProvaEscritaDao();
        IEntidade expResult = null;
        IEntidade result = instance.alterar(entidade);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class ProvaEscritaDao.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        IEntidade entidade = null;
        ProvaEscritaDao instance = new ProvaEscritaDao();
        IEntidade expResult = null;
        IEntidade result = instance.excluir(entidade);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarPorId method, of class ProvaEscritaDao.
     */
    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        ProvaEscritaDao instance = new ProvaEscritaDao();
        ProvaEscrita result = (ProvaEscrita) instance.pesquisarPorId(1);
        assertNotNull(result);
        assertEquals(result.getIdProvaEscrita(), 1);

    }

    /**
     * Test of pesquisarTodos method, of class ProvaEscritaDao.
     */
    @Test
    public void testPesquisarTodos() throws Exception {
        System.out.println("pesquisarTodos");
        ProvaEscritaDao instance = new ProvaEscritaDao();
        List expResult = null;
        List result = instance.pesquisarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarTodosOrdenadoPor method, of class ProvaEscritaDao.
     */
    @Test
    public void testPesquisarTodosOrdenadoPor() {
        System.out.println("pesquisarTodosOrdenadoPor");
        String criterioOrdenamento = "";
        ProvaEscritaDao instance = new ProvaEscritaDao();
        List expResult = null;
        List result = instance.pesquisarTodosOrdenadoPor(criterioOrdenamento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}