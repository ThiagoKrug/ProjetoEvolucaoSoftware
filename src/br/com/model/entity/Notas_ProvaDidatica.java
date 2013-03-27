/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

/**
 *
 * @author Juliano R. M.
 */
public class Notas_ProvaDidatica implements IEntidade{

    private int idNotaProvaDidatica;
    private float notaProvaDidatica;
    private int idCandidato;
    private int idExaminador;
    private int idProvaDidatica;

    public int getIdNotaProvaDidatica() {
        return idNotaProvaDidatica;
    }

    public void setIdNotaProvaDidatica(int idNotaProvaDidatica) {
        this.idNotaProvaDidatica = idNotaProvaDidatica;
    }

    public float getNotaProvaDidatica() {
        return notaProvaDidatica;
    }

    public void setNotaProvaDidatica(float notaProvaDidatica) {
        this.notaProvaDidatica = notaProvaDidatica;
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

    public int getIdProvaDidatica() {
        return idProvaDidatica;
    }

    public void setIdProvaDidatica(int idProvaDidatica) {
        this.idProvaDidatica = idProvaDidatica;
    }
    
}
