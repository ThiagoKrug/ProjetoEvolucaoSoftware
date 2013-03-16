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
public class ProvaMemorial {
   
   @NotNull 
   private int idProvaMemorial;
   @NotNull 
   private Concurso concurso;
   @NotNull 
   private ArrayList<CriterioAvaliacao> criterios;

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
