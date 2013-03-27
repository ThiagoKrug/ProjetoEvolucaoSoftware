/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

/**
 *
 * @author Helison
 */
public class NotaProvaEscrita implements IEntidade {

    private int idNotaProvaEscrita;
    private float notaProvaEscrita;
    private int idCandidato;
    private int idExaminador;
    private int idProvaEscrita;

    public int getIdNotaProvaEscrita() {
        return idNotaProvaEscrita;
    }

    public void setIdNotaProvaEscrita(int idNotaProvaEscrita) {
        this.idNotaProvaEscrita = idNotaProvaEscrita;
    }

    public float getNotaProvaEscrita() {
        return notaProvaEscrita;
    }

    public void setNotaProvaEscrita(float notaProvaEscrita) {
        this.notaProvaEscrita = notaProvaEscrita;
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

    public int getIdProvaEscrita() {
        return idProvaEscrita;
    }

    public void setIdProvaEscrita(int idProvaEscrita) {
        this.idProvaEscrita = idProvaEscrita;
    }
}
