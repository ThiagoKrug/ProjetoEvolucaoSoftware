/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

/**
 *
 * @author Juliano R. M.
 */
public class Notas_ProvaDidatica {

    private int idNotaProvaDidatica;
    private float notaProvaDidatica;
    private Candidato candidato;
    private Examinador examinador;
    private ProvaDidatica provaDidatica;
    
    
    public Notas_ProvaDidatica() {
    }

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

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Examinador getExaminador() {
        return examinador;
    }

    public void setExaminador(Examinador examinador) {
        this.examinador = examinador;
    }

    public ProvaDidatica getProvaDidatica() {
        return provaDidatica;
    }

    public void setProvaDidatica(ProvaDidatica provaDidatica) {
        this.provaDidatica = provaDidatica;
    }
    
    
    
    
    
}
