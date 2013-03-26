/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.report.abertura;

import br.com.model.entity.Abertura;
import br.com.model.entity.Concurso;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class AberturaReports {

    public String htmlOpen(String fileName) {

        String returnValue = "";
        FileReader file = null;

        try {
            file = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(file);
            String line = "";
            while ((line = reader.readLine()) != null) {
                returnValue += line + "\n";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    // Ignore issues during closing 
                }
            }
        }
        return returnValue;
    }

    public void saveHtml(String s, String fileName) {
        FileWriter output = null;
        try {
            output = new FileWriter(fileName);
            BufferedWriter writer = new BufferedWriter(output);
            writer.write(s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    // Ignore issues during closing
                }
            }
        }

    }
    

//    private String intToPort(int n) {
//        String[] numbers = ("um "
//                + "dois "
//                + "três "
//                + "quatro "
//                + "cinco seis sete oito nove dez "
//                + "onze doze treze quatorze quinze dezesseis "
//                + "dezessete dezoito dezenove vinte "
//                + "trinta quarenta cinquenta sessenta "
//                + "setenta oitente noventa cem duzentos trezentos "
//                + "quatrocentos quinhentos seiscentos oitocentos "
//                + "novecentos mil").split(" ");
//        String pt = "";
//        String pi = "" + n;
//        if (pi.length() == 4) {
//            if (pi.charAt(0) == '0') {
//                return "" + intToPort(
//                    Integer.parseInt(pi.substring(1)));
//            }
//            int first = Integer.parseInt(pi.charAt(0) + "");
//            return numbers[first - 1] + " mil e " + intToPort(
//                    Integer.parseInt(pi.substring(1)));
//        }
//        
//        if (pi.length() == 3) {
//            if (pi.charAt(0) == '0') {
//                return "" + intToPort(
//                    Integer.parseInt(pi.substring(1)));
//            }
//            int first = Integer.parseInt(pi.charAt(0) + "");
//            pt += numbers[first - 1] + " mil e " + intToPort(
//                    Integer.parseInt(pi.substring(1)));
//        }
//        
//        return pt;
//    }
    
    public String sayDate(Date date) {
        
        String[] months = new String[] {
            "Janeiro", "Fevereiro", "Março",
            "Abril", "Maio", "Junho", "Julho",
            "Agosto", "Setembro", "Outubro",
            "Novembro", "Dezembro"
        };
        
        String dt = "";
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DAY_OF_YEAR);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        dt += day + " dias do mês de " + months[month];
        dt += " de " + year;
        return dt;
    }

    public void createAta(Abertura abertura) throws SQLException {
        Integer nroAta = Integer.parseInt(JOptionPane.showInputDialog("Número da Ata: "));
        String html = this.htmlOpen("ata_abertura.html");
        Concurso concurso = abertura.getConcurso();
        html = html.replace("{{ministerio}}", concurso.getMinisterio())
                .replace("{{area}}", concurso.getArea())
                .replace("{{campus}}", concurso.getCampus().getCidadeCampus())
                .replace("{{classe}}", concurso.getClasseConcurso().getNome())
                .replace("{{instituicao}}", concurso.getInstituicao())
                .replace("{{n_ata}}", nroAta.toString())
                .replace("{{local}}", abertura.getLocal())
                .replace("{{banca1}}", concurso.getBancaExaminadora().getPresidente().getPessoa().getNome())
                .replace("{{banca2}}", concurso.getBancaExaminadora().getExaminador2().getPessoa().getNome())
                .replace("{{banca3}}", concurso.getBancaExaminadora().getExaminador3().getPessoa().getNome())
                .replace("{{portaria}}", concurso.getPortaria())
                .replace("{{dataInicio}}", this.sayDate(abertura.getHoraInicio()));
        this.saveHtml("ata_abertura.html", html);
    }
}
