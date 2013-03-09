/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class AvaliacaoProvaMemorial implements IEntidade {
    
    private int idAvaliacaoProvaMemorial;
    private Candidato candidato;
    private ProvaMemorial provaMemorial;
    private ArrayList<AvaliacaoExaminadorCriterio> examinadorCriterio;
    private Examinador examinador;

    public int getIdAvaliacaoProvaMemorial() {
        return idAvaliacaoProvaMemorial;
    }

    public void setIdAvaliacaoProvaMemorial(int idAvaliacaoProvaMemorial) {
        this.idAvaliacaoProvaMemorial = idAvaliacaoProvaMemorial;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public ProvaMemorial getProvaMemorial() {
        return provaMemorial;
    }

    public void setProvaMemorial(ProvaMemorial provaMemorial) {
        this.provaMemorial = provaMemorial;
    }

    public ArrayList<AvaliacaoExaminadorCriterio> getExaminadorCriterio() {
        return examinadorCriterio;
    }

    public void setExaminadorCriterio(ArrayList<AvaliacaoExaminadorCriterio> examinadorCriterio) {
        this.examinadorCriterio = examinadorCriterio;
    }

    public Examinador getExaminador() {
        return examinador;
    }

    public void setExaminador(Examinador examinador) {
        this.examinador = examinador;
    }
    
    
    
}
