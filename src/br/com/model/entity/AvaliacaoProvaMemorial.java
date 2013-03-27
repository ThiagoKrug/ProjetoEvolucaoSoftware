/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

import java.util.ArrayList;
import javax.validation.constraints.NotNull;

/** 
 *
 * @author Bruno
 */
public class AvaliacaoProvaMemorial implements IEntidade {
    
    @NotNull(message="O valor não pode ser nulo!")
    private int idAvaliacaoProvaMemorial;
    
    @NotNull(message="O valor não pode ser nulo!")
    private Candidato candidato;
    
    @NotNull(message="O valor não pode ser nulo!")
    private ProvaMemorial provaMemorial;
    
    @NotNull(message="O valor não pode ser nulo!")
    private ArrayList<AvaliacaoExaminadorCriterio> examinadorCriterio;
    
    @NotNull(message="O valor não pode ser nulo!")
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
