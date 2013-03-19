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
public class ProvaTitulos implements IEntidade {
 
    private String local;
    @NotNull 
    private int idProvaTitulos;
    @NotNull 
    private Concurso concurso;
    @NotNull 
    private Classe classe1;
    @NotNull 
    private Classe classe2;
    @NotNull 
    private Classe classe3;

    public ProvaTitulos(int idProvaTitulos, Concurso concurso, Classe classe1, Classe classe2, Classe classe3) {
        this.idProvaTitulos = idProvaTitulos;
        this.concurso = concurso;
        this.classe1 = classe1;
        this.classe2 = classe2;
        this.classe3 = classe3;
    }

    public ProvaTitulos() {
    }

    public String getLocal() {
        return local;
    }
    
    public void setLocal(String local) {
        this.local = local;
    }
    
    public int getIdProvaTitulos() {
        return idProvaTitulos;
    }

    public void setIdProvaTitulos(int idProvaTitulos) {
        this.idProvaTitulos = idProvaTitulos;
    }

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    public Classe getClasse1() {
        return classe1;
    }

    public void setClasse1(Classe classe1) {
        this.classe1 = classe1;
    }

    public Classe getClasse2() {
        return classe2;
    }

    public void setClasse2(Classe classe2) {
        this.classe2 = classe2;
    }

    public Classe getClasse3() {
        return classe3;
    }

    public void setClasse3(Classe classe3) {
        this.classe3 = classe3;
    }
    
    public void criarProvaTitulos() {
        
    }
    
}
