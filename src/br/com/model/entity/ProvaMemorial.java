/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

import java.util.ArrayList;
import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bruno
 */
public class ProvaMemorial implements IEntidade{
   
   @NotNull 
   private int idProvaMemorial;
   @NotNull 
   private Concurso concurso;
   @NotNull 
   private ArrayList<CriterioAvaliacao> criterios;
   @NotNull
   private boolean compareceu;
   @NotNull
   private Date data_comparecimento;

    public Date getData_comparecimento() {
        return data_comparecimento;
    }

    public void setData_comparecimento(Date data_comparecimento) {
        this.data_comparecimento = data_comparecimento;
    }
   
   

    public boolean getCompareceu() {
        return compareceu;
    }

    public void setCompareceu(boolean compareceu) {
        this.compareceu = compareceu;
    }
   
   

    public int getIdProvaMemorial() {
        return idProvaMemorial;
    }

    public void setIdProvaMemorial(int idProvaMemorial) {
        this.idProvaMemorial = idProvaMemorial;
    }

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    public ArrayList<CriterioAvaliacao> getCriterios() {
        return criterios;
    }

    public void setCriterios(ArrayList<CriterioAvaliacao> criterios) {
        this.criterios = criterios;
    }
   
   
    
}
