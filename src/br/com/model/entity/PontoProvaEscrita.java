/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

/**
 *
 * @author Rafael
 */
public class PontoProvaEscrita implements IEntidade {
    
    private int idPontoProvaEscrita;
    private String descricao;
    private ProvaEscrita provaEscrita;

    public PontoProvaEscrita(int idPontoProvaEscrita, String descricao) {
        this.idPontoProvaEscrita = idPontoProvaEscrita;
        this.descricao = descricao;
    }

    public PontoProvaEscrita() {
    }

    public int getIdPontoProvaEscrita() {
        return idPontoProvaEscrita;
    }

    public void setIdPontoProvaEscrita(int idPontoProvaEscrita) {
        this.idPontoProvaEscrita = idPontoProvaEscrita;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ProvaEscrita getProvaEscrita() {
        return provaEscrita;
    }

    public void setProvaEscrita(ProvaEscrita provaEscrita) {
        this.provaEscrita = provaEscrita;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idPontoProvaEscrita;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PontoProvaEscrita other = (PontoProvaEscrita) obj;
        if (this.idPontoProvaEscrita != other.idPontoProvaEscrita) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return  descricao;
    }
    
    
    
}
