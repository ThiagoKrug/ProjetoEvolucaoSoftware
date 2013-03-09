/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

/**
 *
 * @author Bruno
 */
public class AvaliacaoExaminadorCriterio implements IEntidade {
    
    private int idAvaliacaoExaminadorCriterio;
    private float ponto;
    private CriterioAvaliacaoProvaMemorial criterioAvaliacaoProvaMemorial;
    private Examinador examinador;

    public int getIdAvaliacaoExaminadorCriterio() {
        return idAvaliacaoExaminadorCriterio;
    }

    public void setIdAvaliacaoExaminadorCriterio(int idAvaliacaoExaminadorCriterio) {
        this.idAvaliacaoExaminadorCriterio = idAvaliacaoExaminadorCriterio;
    }

    public float getPonto() {
        return ponto;
    }

    public void setPonto(float ponto) {
        this.ponto = ponto;
    }

    public CriterioAvaliacaoProvaMemorial getCriterioAvaliacaoProvaMemorial() {
        return criterioAvaliacaoProvaMemorial;
    }

    public void setCriterioAvaliacaoProvaMemorial(CriterioAvaliacaoProvaMemorial criterioAvaliacaoProvaMemorial) {
        this.criterioAvaliacaoProvaMemorial = criterioAvaliacaoProvaMemorial;
    }

    public Examinador getExaminador() {
        return examinador;
    }

    public void setExaminador(Examinador examinador) {
        this.examinador = examinador;
    }
    
    
}
