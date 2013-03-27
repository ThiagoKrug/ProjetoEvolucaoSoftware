/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

/**
 *
 * @author Juliano R. M.
 */
public class CriterioAvaliacaoDidatica {

    private String criterio;
    private Float peso;
    private ProvaDidatica provaDidatica;

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public ProvaDidatica getProvaDidatica() {
        return provaDidatica;
    }

    public void setProvaDidatica(ProvaDidatica provaDidatica) {
        this.provaDidatica = provaDidatica;
    }

    @Override
    public String toString() {
        return criterio + ", peso=" + peso;
    }
}
