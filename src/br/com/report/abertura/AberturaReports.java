/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.report.abertura;

import br.com.model.entity.Abertura;
import br.com.model.entity.Concurso;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class AberturaReports {
    
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
                
                .replace("{{dataInicio}}", this.sayDate(abertura.getHoraInicio()))
        this.saveHtml("ata_abertura.html", html);
    }
    
}
