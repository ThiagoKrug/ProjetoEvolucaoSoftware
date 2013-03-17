
package br.com.model.entity;

import java.util.ArrayList;
import java.util.Date;

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
    
    private ArrayList<Ponto> pontos;
    
    
    private Date horaInicioResultado;
    private String localResultado;

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
    
    
    
    
}
