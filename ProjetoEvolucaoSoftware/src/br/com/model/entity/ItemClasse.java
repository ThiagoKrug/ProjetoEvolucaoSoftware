/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

/**
 *
 * @author Bruno
 */
class ItemClasse {
    
    private int idItemClasse;
    private Classe classe;
    private String discriminacao;
    private float pontuacao;

    public int getIdItemClasse() {
        return idItemClasse;
    }

    public void setIdItemClasse(int idItemClasse) {
        this.idItemClasse = idItemClasse;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public String getDiscriminacao() {
        return discriminacao;
    }

    public void setDiscriminacao(String discriminacao) {
        this.discriminacao = discriminacao;
    }

    public float getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(float pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    
}
