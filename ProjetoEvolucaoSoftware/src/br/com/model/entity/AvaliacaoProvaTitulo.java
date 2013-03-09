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
public class AvaliacaoProvaTitulo {
    @NotNull(message="O valor não pode ser nulo!")
    private int idAvaliacaoProvaTitulo;
    
    @NotNull(message="O valor não pode ser nulo!")
    private ProvaTitulos provaTitulos;
    
    @NotNull(message="O valor não pode ser nulo!")
    private Candidato candidato;
    
    @NotNull(message="O valor não pode ser nulo!")
    private ArrayList<AvalicaoItem> avaliacaoItens;

    public int getIdAvaliacaoProvaTitulo() {
        return idAvaliacaoProvaTitulo;
    }

    public void setIdAvaliacaoProvaTitulo(int idAvaliacaoProvaTitulo) {
        this.idAvaliacaoProvaTitulo = idAvaliacaoProvaTitulo;
    }

    public ProvaTitulos getProvaTitulos() {
        return provaTitulos;
    }

    public void setProvaTitulos(ProvaTitulos provaTitulos) {
        this.provaTitulos = provaTitulos;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public ArrayList<AvalicaoItem> getAvaliacaoItens() {
        return avaliacaoItens;
    }

    public void setAvaliacaoItens(ArrayList<AvalicaoItem> avaliacaoItens) {
        this.avaliacaoItens = avaliacaoItens;
    }
    
        
    
}
