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
public class CriterioAvaliacao implements IEntidade {
    
    private int idCriterioAvaliacao;
    private String criterio;
    private float peso;
    
    private ProvaEscrita provaEscrita;

    public int getIdCriterioAvaliacao() {
        return idCriterioAvaliacao;
    }

    public void setIdCriterioAvaliacao(int idCriterioAvaliacao) {
        this.idCriterioAvaliacao = idCriterioAvaliacao;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public ProvaEscrita getProvaEscrita() {
        return provaEscrita;
    }

    public void setProvaEscrita(ProvaEscrita provaEscrita) {
        this.provaEscrita = provaEscrita;
    }

    @Override
    public String toString() {
        return  this.criterio + " - " + this.peso ;
    }
    
    
    
}
