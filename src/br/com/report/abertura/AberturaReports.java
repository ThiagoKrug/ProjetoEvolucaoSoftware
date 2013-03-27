/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.report.abertura;

import br.com.model.dao.AvaliacaoItemDao;
import br.com.model.dao.AvaliacaoProvaTitulosDao;
import br.com.model.dao.ClasseDAO;
import br.com.model.dao.ItemClasseDao;
import br.com.model.entity.Abertura;
import br.com.model.entity.AvaliacaoItem;
import br.com.model.entity.AvaliacaoProvaTitulo;
import br.com.model.entity.BancaExaminadora;
import br.com.model.entity.Candidato;
import br.com.model.entity.Classe;
import br.com.model.entity.Concurso;
import br.com.model.entity.Cronograma;
import br.com.model.entity.Examinador;
import br.com.model.entity.IEntidade;
import br.com.model.entity.ItemClasse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import util.Datas;

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
        Writer output = null;
        try {
            File nfile = new File(fileName);
            System.out.println(nfile.getAbsolutePath());
            if (!nfile.exists())
                nfile.createNewFile();
            output = new BufferedWriter(new FileWriter(nfile.getAbsoluteFile()));
            output.write(s);
            
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
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
    
    public String sayDateExt(Date date) {
        return Datas.getDataExtenso(date);
    }

    public void createAta(Abertura abertura) throws SQLException {
        System.out.println(System.getProperty("user.dir"));
        Integer nroAta = Integer.parseInt(JOptionPane.showInputDialog("Número da Ata: "));
        String html = this.htmlOpen("ata_abertura_temp.html");
        Concurso concurso = abertura.getConcurso();
//        System.out.println(concurso.getMinisterio());
        html = html.replace("{{ministerio}}",
                concurso.getMinisterio());
        html = html
                .replace("{{area}}", concurso.getArea());
        html = html
                .replace("{{campus}}", concurso.getCampus().getCidadeCampus());
        html = html
                .replace("{{classe}}", concurso.getClasseConcurso().getNome());
        html = html
                .replace("{{instituicao}}", concurso.getInstituicao());
        html = html
                .replace("{{n_ata}}", nroAta.toString());
        html = html
                .replace("{{local}}", abertura.getLocal());
        BancaExaminadora examinador = concurso.getBancaExaminadora();
        html = html
                .replace("{{banca1}}", concurso.getBancaExaminadora().getPresidente().getPessoa().getNome());
        html = html
                .replace("{{banca2}}", concurso.getBancaExaminadora().getExaminador2().getPessoa().getNome())
                .replace("{{banca3}}", concurso.getBancaExaminadora().getExaminador3().getPessoa().getNome());
        System.out.println(abertura.getPortaria());
        html = html
                .replace("{{portaria}}", abertura.getPortaria());
        html = html
                .replace("{{data_ata}}", this.sayDateExt(concurso.getDataInicio()));
        html = html
                .replace("{{data_assin}}", this.sayDate(Calendar.getInstance().getTime()));
        html = html
                .replace("{{hora_inicio}}", Datas.getHoraToString());
        html = html
                .replace("{{emissor}}", abertura.getEmissor());
        this.saveHtml(html, "ata_instalacaoklo.html");
//        System.out.println("Ok!" + html);
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
        this.saveHtml(html + html2, "cronograma.html");
    }
    
    public void gerarRecibo(Abertura abertura) throws SQLException {
        String html = this.htmlOpen("reciboTemp.html");
        Concurso concurso = abertura.getConcurso();
        html = html.replace("{{ministerio}}", concurso.getMinisterio())
                .replace("{{area}}", concurso.getArea())
                .replace("{{campus}}", concurso.getCampus().getCidadeCampus())
                .replace("{{classe}}", concurso.getClasseConcurso().getNome())
                .replace("{{instituicao}}", concurso.getInstituicao())
                .replace("{{banca1}}", concurso.getBancaExaminadora().getPresidente().getPessoa().getNome())
                .replace("{{data}}", this.sayDate(Calendar.getInstance().getTime()));
        this.saveHtml(html, "recibo.html");
    }
    
    public void gerarListaPresenca(List<Candidato> candidatos) {
        String html = this.htmlOpen("listaPresTempBegin.html");
        Concurso concurso = candidatos.get(0).getConcurso();
        html = html.replace("{{ministerio}}", concurso.getMinisterio())
                .replace("{{area}}", concurso.getArea())
                .replace("{{campus}}", concurso.getCampus().getCidadeCampus())
                .replace("{{classe}}", concurso.getClasseConcurso().getNome())
                .replace("{{instituicao}}", concurso.getInstituicao());
                
        
        for (int i = 0; i < candidatos.size(); i++) {
            html += "<tr>";
            html += "<td>" + i + "</td>";
            html += "<td>" + candidatos.get(i).getNome() + "</td>";
            html += "<td></td>";
            html += "</tr>";
        }
        String html2 = this.htmlOpen("listaPresTempEnd.html");
        html2 = html2.replace("{{banca1}}", concurso.getBancaExaminadora().getPresidente().getPessoa().getNome())
                .replace("{{banca2}}", concurso.getBancaExaminadora().getExaminador2().getPessoa().getNome())
                .replace("{{banca3}}", concurso.getBancaExaminadora().getExaminador3().getPessoa().getNome())
                .replace("{{data}}", this.sayDate(Calendar.getInstance().getTime()));
        this.saveHtml(html + html2, "listaPres.html");
    }
    
    
    
    public void gerarPlanilhaProvaTits(Candidato candidato) throws SQLException{
        String html = this.htmlOpen("planilhaPTTempBegin.html");
        Concurso concurso = candidato.getConcurso();
        html = html.replace("{{ministerio}}", concurso.getMinisterio())
                .replace("{{area}}", concurso.getArea())
                .replace("{{campus}}", concurso.getCampus().getCidadeCampus())
                .replace("{{classe}}", concurso.getClasseConcurso().getNome())
                .replace("{{instituicao}}", concurso.getInstituicao())
                .replace("{{cand_nome}}", candidato.getNome());
        
        AvaliacaoProvaTitulo apt = null;
        List<AvaliacaoProvaTitulo> apts = (List<AvaliacaoProvaTitulo>)new AvaliacaoProvaTitulosDao().pesquisarTodos();
        for (AvaliacaoProvaTitulo ap: apts) {
            if (ap.getCandidato().getIdCandidato() == candidato.getIdCandidato()) {
                apt = ap;
            }
        }
        
        if (apt != null) {
            List<Classe> classes = (List<Classe>)new ClasseDAO().pesquisarTodos();
            for (Classe classe: classes) {
                html += "<div><h2>" + classe.getNomeClasse() + "</h2>";
                List<ItemClasse> titens = (List<ItemClasse>)new ItemClasseDao().pesquisarTodos();
                List<ItemClasse> itens = new ArrayList<ItemClasse>();
                for (int i = 0; i < titens.size(); i++) {
                    ItemClasse item = titens.get(i);
                    if (item.getClasse().getIdClasse() == classe.getIdClasse()) {
                        itens.add(item);
                    }
                }
                html += "<table>";
                html += "<tr>"
                        + "<td>Item</td>"
                        + "<td>Discriminação</td>"
                        + "<td>Pontuação por Unidade</td>"
                        + "<td>Quantidade</td>"
                        + "<td>Pontuação</td>"
                        + "</tr>";
                
                for (int j = 0; j < itens.size(); j++) {
                    html += "<tr>";
                    ItemClasse item = itens.get(j);
                    html += "<td>" + j + "</td>";
                    html += "<td>" + item.getDiscriminacao() + "</td>";
                    html += "<td>" + item.getPontuacao() + "</td>";
                    html += "<td>{{quantidade}}</td>";
                    html += "<td>{{pontuacao}}</td>";
                    List<AvaliacaoItem> avs = (List<AvaliacaoItem>)new AvaliacaoItemDao().pesquisarTodos();
                    AvaliacaoItem avit = null;
                    for (AvaliacaoItem av: avs) {
                        if (av.getItemClasse().getIdItemClasse() == item.getIdItemClasse()) {
                            avit = av;
                        }
                    }
                    if (avit != null) {
                        html = html.replace("{{quantidade}}", avit.getQuantidade() + "")
                                .replace("{{pontuacao}}", (item.getPontuacao() * avit.getQuantidade()) + "");
                                
                    } else {
                        html = html.replace("{{quantidade}}", "")
                                .replace("{{pontuacao}}", "");
                    }
                    html += "</tr>";
                    
                }
                html += "</table>";
                html += "</div>";
            }
        }
        
        String html2 = this.htmlOpen("planilhaPTTempEnd.html");
        html2 = html2.replace("{{banca1}}", concurso.getBancaExaminadora().getPresidente().getPessoa().getNome())
                .replace("{{banca2}}", concurso.getBancaExaminadora().getExaminador2().getPessoa().getNome())
                .replace("{{banca3}}", concurso.getBancaExaminadora().getExaminador3().getPessoa().getNome())
                .replace("{{data}}", this.sayDate(Calendar.getInstance().getTime()));
        this.saveHtml(html + html2, "listaPres.html");
    }
    
    
    public void createAtaRecep(Abertura abertura) throws SQLException {
        Integer nroAta = Integer.parseInt(JOptionPane.showInputDialog("Número da Ata: "));
        String html = this.htmlOpen("ata_recep.html");
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
                .replace("{{dataInicio}}", this.sayDateExt(abertura.getHoraInicio()));
        this.saveHtml("ata_abertura.html", html);
    }
}
