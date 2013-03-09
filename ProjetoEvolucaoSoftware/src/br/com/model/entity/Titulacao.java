/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Bruno
 */
public class Titulacao {
    
    @NotNull 
    private int idTitulacao;
    @NotBlank
    private String titulacao;

    public Titulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public Titulacao() {
    }

    public int getIdTitulacao() {
        return idTitulacao;
    }

    public void setIdTitulacao(int idTitulacao) {
        this.idTitulacao = idTitulacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
    
    
}
