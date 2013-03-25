/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

/**
 *
 * @author Nasser
 */
public class CriterioAvaliacaoDidatica {
     private String criterio;
    private Float peso;

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
    
    
    //public String toString(CriterioAvaliacaoDidatica cad){
    //    return cad.getCriterio() + "   " + cad.getPeso().toString();
    //}

    @Override
    public String toString() {
        return  criterio + ", peso=" + peso ;
    }
    
}
