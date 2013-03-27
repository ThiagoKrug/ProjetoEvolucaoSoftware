/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
   private ArrayList<Candidato> candidatosAptosProva = new ArrayList<>();

   

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
   
     public void adicionarCandidatoApto(Candidato c) {
        Iterator<Candidato> iterator = this.candidatosAptosProva.iterator();
        while (iterator.hasNext()) {
            Candidato object = iterator.next();
            if (object.getIdCandidato() == c.getIdCandidato()) {
                return;
            }
        }
        this.candidatosAptosProva.add(c);
    }
     
     public ArrayList<Candidato> getCandidatosAptosProva() {
        return candidatosAptosProva;
    }
   
    
}
