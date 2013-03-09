/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.config;

import org.ini4j.Profile;
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
public class ConfigurationFactoryTest {
    
    public ConfigurationFactoryTest() {
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
     * Test of getConfiguration method, of class ConfigurationFactory.
     */
    @Test
    public void testGetConfiguration() throws Exception {
        System.out.println("getConfiguration");
        Profile.Section expResult = null;
        Profile.Section result = ConfigurationFactory.getConfiguration();
        assertEquals(result.get("db.user"), "root");
    }
}