/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

/**
 *
 * @author Bruno
 */
public class Examinador implements IEntidade {

    private int idExaminador;
    private Pessoa pessoa;
    private Titulacao titulacao;

    public Examinador() {
    }

    public int getIdExaminador() {
        return idExaminador;
    }

    public void setIdExaminador(int idExaminador) {
        this.idExaminador = idExaminador;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Titulacao getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(Titulacao titulacao) {
        this.titulacao = titulacao;
    }
}
