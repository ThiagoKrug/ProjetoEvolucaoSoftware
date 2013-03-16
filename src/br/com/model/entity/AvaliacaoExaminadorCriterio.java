/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** 
 *
 * @author Bruno
 */
public class AvaliacaoExaminadorCriterio implements IEntidade {
    
    
    @NotNull(message="O valor não pode ser nulo!")
    private int idAvaliacaoExaminadorCriterio;
    
    @NotNull(message="O valor não pode ser nulo!")
    @Min(2)
    @Max(10)
    private float ponto;
    
    @NotNull(message="O valor não pode ser nulo!")
    private CriterioAvaliacao criterioAvaliacaoProvaMemorial;
    
    @NotNull(message="O valor não pode ser nulo!")
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

    public CriterioAvaliacao getCriterioAvaliacaoProvaMemorial() {
        return criterioAvaliacaoProvaMemorial;
    }

    public void setCriterioAvaliacaoProvaMemorial(CriterioAvaliacao criterioAvaliacaoProvaMemorial) {
        this.criterioAvaliacaoProvaMemorial = criterioAvaliacaoProvaMemorial;
    }

    public Examinador getExaminador() {
        return examinador;
    }

    public void setExaminador(Examinador examinador) {
        this.examinador = examinador;
    }
    
    
}
