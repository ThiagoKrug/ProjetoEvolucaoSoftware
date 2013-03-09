/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class Classe {
    
    private int idClasse;
    private String nomeClasse;
    private float pesoClasse;
    private float notaReferenciaClasse;
    private ArrayList<ItemClasse> itens;

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public float getPesoClasse() {
        return pesoClasse;
    }

    public void setPesoClasse(float pesoClasse) {
        this.pesoClasse = pesoClasse;
    }

    public float getNotaReferenciaClasse() {
        return notaReferenciaClasse;
    }

    public void setNotaReferenciaClasse(float notaReferenciaClasse) {
        this.notaReferenciaClasse = notaReferenciaClasse;
    }

    public ArrayList<ItemClasse> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemClasse> itens) {
        this.itens = itens;
    }
    
    
}
