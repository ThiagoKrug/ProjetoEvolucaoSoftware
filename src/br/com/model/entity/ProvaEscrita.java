
package br.com.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Rafael
 */
public class ProvaEscrita implements IEntidade {
    
    private int idProvaEscrita;
    
    private Concurso concurso;
    
    private int pontoSorteado;
    private Date horaPontoSorteado;
    private Date horaInicioProva;
    private Date horaFimProva;
    
    private String localRealizacao;
    
    private ArrayList<Candidato> candidatosAptosLeitura;
    private Date horaInicioLeitura;
    private String localLeitura;
    
    private ArrayList<CriterioAvaliacao> criterios;
    
    private Date horaInicioJulgamento;
    private String localJulgamento;
     
     
     
    private ArrayList<Candidato> candidatosAptosProva;
    
    private ArrayList<PontoProvaEscrita> pontos;
    
    
    private Date horaInicioResultado;
    private String localResultado;

    public ProvaEscrita() {
        this.candidatosAptosProva = new ArrayList<>();
    }
    
    

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    public ArrayList<Candidato> getCandidatosAptosProva() {
        return candidatosAptosProva;
    }

    public void setCandidatosAptosProva(ArrayList<Candidato> candidatosAptosProva) {
        this.candidatosAptosProva = candidatosAptosProva;
    }

    public int getIdProvaEscrita() {
        return idProvaEscrita;
    }

    public void setIdProvaEscrita(int idProvaEscrita) {
        this.idProvaEscrita = idProvaEscrita;
    }
    
    public void adicionarPonto(PontoProvaEscrita p){
        this.pontos.add(p);
    }
    public void removerPonto(PontoProvaEscrita p){
        Iterator<PontoProvaEscrita> iterator = this.pontos.iterator();
        while (iterator.hasNext()) {
            PontoProvaEscrita object = iterator.next();
            if(object.getIdPontoProvaEscrita() == p.getIdPontoProvaEscrita()){
                this.pontos.remove(object);
                return;
            }
        }
    }
    
    public void alterarPonto(PontoProvaEscrita p){
        Iterator<PontoProvaEscrita> iterator = this.pontos.iterator();
        while (iterator.hasNext()) {
            PontoProvaEscrita object = iterator.next();
            if(object.getIdPontoProvaEscrita() == p.getIdPontoProvaEscrita()){
                object.setIdPontoProvaEscrita(p.getIdPontoProvaEscrita());
                object.setDescricao(p.getDescricao());
                object.setProvaEscrita(p.getProvaEscrita());
                return;
            }
        }
    }

    public void adicionarCandidatoApto(Candidato c) {
        if(this.candidatosAptosProva.contains(c) == false){
            this.candidatosAptosProva.add(c);
        }
    }
    
    
}
