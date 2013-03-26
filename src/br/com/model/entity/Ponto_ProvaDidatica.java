/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

/**
 *
 * @author Juliano R. M.
 */
public class Ponto_ProvaDidatica implements IEntidade {

    private int idPontoProvaDidatica;
    private String descricaoPonto;
    private ProvaDidatica provaDidatica;

    public Ponto_ProvaDidatica(int idPontoProvaDidatica, String descricaoPonto) {
        this.idPontoProvaDidatica = idPontoProvaDidatica;
        this.descricaoPonto = descricaoPonto;
    }

    public int getIdPontoProvaDidatica() {
        return idPontoProvaDidatica;
    }

    public void setIdPontoProvaDidatica(int idPontoProvaDidatica) {
        this.idPontoProvaDidatica = idPontoProvaDidatica;
    }

    public String getDescricaoPonto() {
        return descricaoPonto;
    }

    public void setDescricaoPonto(String descricaoPonto) {
        this.descricaoPonto = descricaoPonto;
    }

    public ProvaDidatica getProvaDidatica() {
        return provaDidatica;
    }

    public void setProvaDidatica(ProvaDidatica provaDidatica) {
        this.provaDidatica = provaDidatica;
    }
    
    
    
}
