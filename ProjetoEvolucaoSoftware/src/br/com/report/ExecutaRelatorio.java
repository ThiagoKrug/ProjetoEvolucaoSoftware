package br.com.report;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import br.com.jdbc.ConnectionFactory;
import br.com.report.ReportUtils;

/**
 * Ponto de entrada do projeto.
 *
 * @author David Buzatto
 */
public class ExecutaRelatorio {

    //static String caminho = System.getProperty("user.dir");
    String rel = "";

    /**
     * @param args the command line arguments
     */
    //   public static void main(String[] args) {
    //       new ExecutaRelatorio().abrirRelatorioClientes(rel);
    //   }
    public void abrirRelatorioClientes(String relatorio) {

        rel = relatorio;
        /*
         * Obtendo o arquivo do relatório. Note que estamos utilizando um
         * InputStream para obter o arquivo que está dentro do nosso projeto.
         * Fazendo isso, não teremos problema quando nosso projeto for
         * empacotado em um .jar.
         *
         * Note que o caminho do .jasper inicia com /, ou seja, a raiz da
         * localização das classes compiladas do nosso projeto (o pacote
         * default).
         *
         * Utilize a aba Files (canto superior esquerdo) e veja que os arquivos
         * .jasper e .jrxml são copiados para o diretório /build/classes e por
         * consequencia para o .jar que for criado.
         *
         * Se não os estiver vendo, mande dar um Clean and Build no projeto
         * (botão direito no nó raiz do projeto, Clean and Build (Limpar e
         * Construir)
         *
         */
        //InputStream inputStream = getClass().getResourceAsStream("../relatorios/" + rel);
        InputStream inputStream = getClass().getResourceAsStream(rel);

        // mapa de parâmetros do relatório (ainda vamos aprender a usar)
        Map parametros = new HashMap();


        try {

            // abre o relatório
            ReportUtils.openReport("Relatorio de Venda", inputStream, parametros,
                    ConnectionFactory.getConnection());

        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (JRException exc) {
            exc.printStackTrace();
        }

    }
    

    public void abrirRelatorioParcelasConvenio(Object convenio, Object periodo) {


        InputStream inputStream = getClass().getResourceAsStream("RelatorioParcelasConvenio.jasper");

        Map<String, Object> parametros = new HashMap<String, Object>();

        parametros.put("CONVENIO", convenio);
        parametros.put("PERIODO", periodo);

        try {
            // abre o relatório
            ReportUtils.openReport("Relatório de Parcelas por Convênio", inputStream, parametros, ConnectionFactory.getConnection());
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (JRException exc) {
            exc.printStackTrace();
        }


    }

    public void abrirRelatorioVendaPorPeriodo(Object dataIni, Object dataFim) {


        InputStream inputStream = getClass().getResourceAsStream("RelatorioVenda.jasper");

        Map<String, Object> parametros = new HashMap<String, Object>();

        parametros.put("dataInicial", dataIni);
        parametros.put("dataFinal", dataFim);

        try {
            // abre o relatório
            ReportUtils.openReport("Relatório de Vendas por Período", inputStream, parametros, ConnectionFactory.getConnection());
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (JRException exc) {
            exc.printStackTrace();
        }


    }

    public void abrirRelatorioClientes(String relatorio, HashMap param) {

        rel = relatorio;
        /*
         * Obtendo o arquivo do relatório. Note que estamos utilizando um
         * InputStream para obter o arquivo que está dentro do nosso projeto.
         * Fazendo isso, não teremos problema quando nosso projeto for
         * empacotado em um .jar.
         *
         * Note que o caminho do .jasper inicia com /, ou seja, a raiz da
         * localização das classes compiladas do nosso projeto (o pacote
         * default).
         *
         * Utilize a aba Files (canto superior esquerdo) e veja que os arquivos
         * .jasper e .jrxml são copiados para o diretório /build/classes e por
         * consequencia para o .jar que for criado.
         *
         * Se não os estiver vendo, mande dar um Clean and Build no projeto
         * (botão direito no nó raiz do projeto, Clean and Build (Limpar e
         * Construir)
         *
         */
        //InputStream inputStream = getClass().getResourceAsStream("../relatorios/" + rel);
        InputStream inputStream = getClass().getResourceAsStream(rel);

        // mapa de parâmetros do relatório (ainda vamos aprender a usar)
        HashMap parametros = new HashMap();
        parametros = param;


        try {

            // abre o relatório
            ReportUtils.openReport("Digite aqui o titulo", inputStream, parametros,
                    ConnectionFactory.getConnection());

        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (JRException exc) {
            exc.printStackTrace();
        }

    }
}