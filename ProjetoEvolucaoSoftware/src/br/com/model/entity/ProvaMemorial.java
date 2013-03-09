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
public class ProvaMemorial {
    
   private int idProvaMemorial;
   private Concurso concurso;
   private ArrayList<CriterioAvaliacaoProvaMemorial> criterios;

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

    public ArrayList<CriterioAvaliacaoProvaMemorial> getCriterios() {
        return criterios;
    }

    public void setCriterios(ArrayList<CriterioAvaliacaoProvaMemorial> criterios) {
        this.criterios = criterios;
    }
   
   
    
}
