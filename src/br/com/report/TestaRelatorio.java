/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.report;

import br.com.jdbc.ConnectionFactory;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Nasser
 */
public class TestaRelatorio {
    
            public void abrirRelatorioTeste(){
        
          //InputStream inputStream = getClass().getResourceAsStream("../relatorios/" + rel);
        InputStream inputStream = getClass().getResourceAsStream("report1.jasper");

        // mapa de parâmetros do relatório (ainda vamos aprender a usar)
        Map parametros = new HashMap();


        try {

            // abre o relatório
            ReportUtils.openReport("Relatorio de Venda", inputStream, parametros,
                    ConnectionFactory.getConnection());

        } catch (JRException exc) {
            exc.printStackTrace();
        }

    
    
    }
    
    
    public static void main(String args[]){
        
        new TestaRelatorio().abrirRelatorioTeste();
        
        
        }
      
}
