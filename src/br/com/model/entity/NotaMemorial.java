/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

/**
 *
 * @author Helison
 */
public class NotaMemorial implements IEntidade{
    private int idNotaProvaMemorial;
    private float notaProvaMemorial;
    private int idCandidato;
    private int  idExaminador;
    private int idProvaMemorial;

    public int getIdNotaProvaMemorial() {
        return idNotaProvaMemorial;
    }

    public void setIdNotaProvaMemorial(int idNotaProvaMemorial) {
        this.idNotaProvaMemorial = idNotaProvaMemorial;
    }

    public float getNotaProvaMemorial() {
        return notaProvaMemorial;
    }

    public void setNotaProvaMemorial(float notaProvaMemorial) {
        this.notaProvaMemorial = notaProvaMemorial;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public int getIdExaminador() {
        return idExaminador;
    }

    public void setIdExaminador(int idExaminador) {
        this.idExaminador = idExaminador;
    }

    public int getIdProvaMemorial() {
        return idProvaMemorial;
    }

    public void setIdProvaMemorial(int idProvaMemorial) {
        this.idProvaMemorial = idProvaMemorial;
    }

   }
