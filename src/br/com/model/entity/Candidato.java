/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bruno
 */
public class Candidato extends Pessoa implements IEntidade {

    private int idCandidato;
    
    @NotNull(message="O Valor não pode ser nulo!")
    private int idConcurso;
    
    private int idProvaDidatica;
    private int idProvaEscrita;
    
    @NotNull(message="O valor não pode ser nulo!")
    private boolean aptoProvaEscrita;
    
    @NotNull(message="O valor não pode ser nulo!")
    private boolean presenteProvaEscrita;
    
    @NotNull(message="O valor não pode ser nulo!")
    private boolean aptoProvaTitulos;
    
    @NotNull(message="O valor não pode ser nulo!")
    private boolean presenteProvaTitulos;
    
    @NotNull(message="O valor não pode ser nulo!")
    private boolean aptoProvaDidatica;
    
    @NotNull(message="O valor não pode ser nulo!")
    private boolean presenteProvaDidatica;
    
    @NotNull(message="O valor não pode ser nulo!")
    private boolean aptoProvaMemorial;
    
    @NotNull(message="O valor não pode ser nulo!")
    private boolean presenteProvaMemorial;

    public Candidato(boolean aptoProvaEscrita, boolean presenteProvaEscrita, boolean aptoProvaTitulos, boolean presenteProvaTitulos, boolean aptoProvaDidatica, boolean presenteProvaDidatica, boolean aptoProvaMemorial, boolean presenteProvaMemorial, String nome, String sexo, Date dataNascimento) {
        super(nome, sexo, dataNascimento);
        this.aptoProvaEscrita = aptoProvaEscrita;
        this.presenteProvaEscrita = presenteProvaEscrita;
        this.aptoProvaTitulos = aptoProvaTitulos;
        this.presenteProvaTitulos = presenteProvaTitulos;
        this.aptoProvaDidatica = aptoProvaDidatica;
        this.presenteProvaDidatica = presenteProvaDidatica;
        this.aptoProvaMemorial = aptoProvaMemorial;
        this.presenteProvaMemorial = presenteProvaMemorial;
    }

    public Candidato() {
        this.aptoProvaDidatica = false;
        this.aptoProvaEscrita  = false;
        this.aptoProvaMemorial = false;
        this.aptoProvaTitulos  = false;
    }

    public int getIdConcurso() {
        return idConcurso;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }

    public boolean isAptoProvaEscrita() {
        return aptoProvaEscrita;
    }

    public void setAptoProvaEscrita(boolean aptoProvaEscrita) {
        this.aptoProvaEscrita = aptoProvaEscrita;
    }

    public boolean isPresenteProvaEscrita() {
        return presenteProvaEscrita;
    }

    public void setPresenteProvaEscrita(boolean presenteProvaEscrita) {
        this.presenteProvaEscrita = presenteProvaEscrita;
    }

    public boolean isAptoProvaTitulos() {
        return aptoProvaTitulos;
    }

    public void setAptoProvaTitulos(boolean aptoProvaTitulos) {
        this.aptoProvaTitulos = aptoProvaTitulos;
    }

    public boolean isPresenteProvaTitulos() {
        return presenteProvaTitulos;
    }

    public int getIdProvaDidatica() {
        return idProvaDidatica;
    }

    public int getIdProvaEscrita() {
        return idProvaEscrita;
    }

    public void setIdProvaDidatica(int idProvaDidatica) {
        this.idProvaDidatica = idProvaDidatica;
    }

    public void setIdProvaEscrita(int idProvaEscrita) {
        this.idProvaEscrita = idProvaEscrita;
    }

    public void setPresenteProvaTitulos(boolean presenteProvaTitulos) {
        this.presenteProvaTitulos = presenteProvaTitulos;
    }

    public boolean isAptoProvaDidatica() {
        return aptoProvaDidatica;
    }

    public void setAptoProvaDidatica(boolean aptoProvaDidatica) {
        this.aptoProvaDidatica = aptoProvaDidatica;
    }

    public boolean isPresenteProvaDidatica() {
        return presenteProvaDidatica;
    }

    public void setPresenteProvaDidatica(boolean presenteProvaDidatica) {
        this.presenteProvaDidatica = presenteProvaDidatica;
    }

    public boolean isAptoProvaMemorial() {
        return aptoProvaMemorial;
    }

    public void setAptoProvaMemorial(boolean aptoProvaMemorial) {
        this.aptoProvaMemorial = aptoProvaMemorial;
    }

    public boolean isPresenteProvaMemorial() {
        return presenteProvaMemorial;
    }

    public void setPresenteProvaMemorial(boolean presenteProvaMemorial) {
        this.presenteProvaMemorial = presenteProvaMemorial;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }
}
