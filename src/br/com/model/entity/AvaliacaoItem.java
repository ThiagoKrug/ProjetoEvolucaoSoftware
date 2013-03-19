/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Bruno
 */
public class AvaliacaoItem implements IEntidade {
    
    @NotNull(message="O valor não pode ser nulo!")
    private int idAvaliacaoItem;
    
    @NotNull(message="O valor não pode ser nulo!")
    private AvaliacaoProvaTitulo avaliacaoProvaTitulo;
    
    @NotNull(message="O valor não pode ser nulo!")
    private ItemClasse itemClasse;
    
    @NotNull(message="O valor não pode ser nulo!")
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
