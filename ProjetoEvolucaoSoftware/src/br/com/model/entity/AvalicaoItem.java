/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

/**
 *
 * @author Bruno
 */
public class AvalicaoItem {
    
    private int idAvaliacaoItem;
    private AvaliacaoProvaTitulo avaliacaoProvaTitulo;
    private ItemClasse itemClasse;
    private int quantidade;

    public int getIdAvaliacaoItem() {
        return idAvaliacaoItem;
    }

    public void setIdAvaliacaoItem(int idAvaliacaoItem) {
        this.idAvaliacaoItem = idAvaliacaoItem;
    }

    public AvaliacaoProvaTitulo getAvaliacaoProvaTitulo() {
        return avaliacaoProvaTitulo;
    }

    public void setAvaliacaoProvaTitulo(AvaliacaoProvaTitulo avaliacaoProvaTitulo) {
        this.avaliacaoProvaTitulo = avaliacaoProvaTitulo;
    }

    public ItemClasse getItemClasse() {
        return itemClasse;
    }

    public void setItemClasse(ItemClasse itemClasse) {
        this.itemClasse = itemClasse;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
