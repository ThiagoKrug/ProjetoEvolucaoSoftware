/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Bruno
 */
public class ItemClasse implements IEntidade {
    
    @NotNull
    private int idItemClasse;
    @NotNull
    private Classe classe;
    @NotBlank
    private String discriminacao;
    @Min(0)
    @Max(10)
    @NotNull
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
