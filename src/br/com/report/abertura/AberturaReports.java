/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.report.abertura;

import br.com.model.entity.Abertura;
import br.com.model.entity.Concurso;
import br.com.model.entity.Cronograma;
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
import java.util.List;
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
    
    public void createCronograma(List<Cronograma> cronogramas) throws SQLException {
        String html = this.htmlOpen("cronograma_begin.html");
        Concurso concurso = cronogramas.get(0).getConcurso();
        html = html.replace("{{ministerio}}", concurso.getMinisterio())
                .replace("{{area}}", concurso.getArea())
                .replace("{{campus}}", concurso.getCampus().getCidadeCampus())
                .replace("{{classe}}", concurso.getClasseConcurso().getNome())
                .replace("{{instituicao}}", concurso.getInstituicao());
        for (Cronograma cronograma: cronogramas) {
            html += "<tr>";
            html += "<td>" + cronograma.getAtividade() + "</td>";
            html += "<td>" + cronograma.getData() + "</td>";
            html += "<td>" + cronograma.getHorario()+ "</td>";
            html += "<td>" + cronograma.getLocal()+ "</td>";
            html += "</tr>";
        }
        
        String html2 = this.htmlOpen("cronograma_end.html");
        html2 = html2.replace("{{banca1}}", concurso.getBancaExaminadora().getPresidente().getPessoa().getNome())
                .replace("{{banca2}}", concurso.getBancaExaminadora().getExaminador2().getPessoa().getNome())
                .replace("{{banca3}}", concurso.getBancaExaminadora().getExaminador3().getPessoa().getNome())
                .replace("{{data}}", this.sayDate(Calendar.getInstance().getTime()));
        this.saveHtml("cronograma.html", html + html2);
    }
    
    public void gerarRecibo(Abertura abertura) throws SQLException {
        String html = this.htmlOpen("reciboTemp.html");
        Concurso concurso = abertura.getConcurso();
        html = html.replace("{{ministerio}}", concurso.getMinisterio())
                .replace("{{area}}", concurso.getArea())
                .replace("{{campus}}", concurso.getCampus().getCidadeCampus())
                .replace("{{classe}}", concurso.getClasseConcurso().getNome())
                .replace("{{instituicao}}", concurso.getInstituicao())
                .replace("{{data}}", this.sayDate(Calendar.getInstance().getTime()));
        this.saveHtml(html, "recibo.html");
    }
}
