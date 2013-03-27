/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

/**
 *
 * @author Helison
 */
public class NotaProvaTitulo implements IEntidade {

    private int idNotaProvaTitulo;
    private float notaProvaTitulo;
    private int idCandidato;
    private int idExaminador;
    private int idProvaTitulo;

    public int getIdNotaProvaTitulo() {
        return idNotaProvaTitulo;
    }

    public void setIdNotaProvaTitulo(int idNotaProvaTitulo) {
        this.idNotaProvaTitulo = idNotaProvaTitulo;
    }

    public float getNotaProvaTitulo() {
        return notaProvaTitulo;
    }

    public void setNotaProvaTitulo(float notaProvaTitulo) {
        this.notaProvaTitulo = notaProvaTitulo;
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

    public int getIdProvaTitulo() {
        return idProvaTitulo;
    }

    public void setIdProvaTitulo(int idProvaTitulo) {
        this.idProvaTitulo = idProvaTitulo;
    }
}
