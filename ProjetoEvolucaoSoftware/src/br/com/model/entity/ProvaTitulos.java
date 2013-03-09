/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

/**
 *
 * @author Bruno
 */
public class ProvaTitulos {
 
    private int idProvaTitulos;
    private Concurso concurso;
    private Classe classe1;
    private Classe classe2;
    private Classe classe3;

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
    
    
}
