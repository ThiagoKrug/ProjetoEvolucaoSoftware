package br.com.model.entity;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Bruno
 */
public class Candidato extends Pessoa implements IEntidade {

    private Integer idCandidato;
    @NotNull(message = "O Valor não pode ser nulo!")
    private Concurso Concurso;
    private ProvaDidatica provaDidatica;
    private ProvaEscrita provaEscrita;
    @NotNull(message = "O valor não pode ser nulo!")
    private Boolean aptoProvaEscrita;
    @NotNull(message = "O valor não pode ser nulo!")
    private Boolean presenteProvaEscrita;
    @NotNull(message = "O valor não pode ser nulo!")
    private Boolean aptoProvaTitulos;
    @NotNull(message = "O valor não pode ser nulo!")
    private Boolean presenteProvaTitulos;
    @NotNull(message = "O valor não pode ser nulo!")
    private Boolean aptoProvaDidatica;
    @NotNull(message = "O valor não pode ser nulo!")
    private Boolean presenteProvaDidatica;
    @NotNull(message = "O valor não pode ser nulo!")
    private Boolean aptoProvaMemorial;
    @NotNull(message = "O valor não pode ser nulo!")
    private Boolean presenteProvaMemorial;

    public Integer getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(Integer idCandidato) {
        this.idCandidato = idCandidato;
    }

    public Concurso getConcurso() {
        return Concurso;
    }

    public void setConcurso(Concurso Concurso) {
        this.Concurso = Concurso;
    }

    public ProvaDidatica getProvaDidatica() {
        return provaDidatica;
    }

    public void setProvaDidatica(ProvaDidatica provaDidatica) {
        this.provaDidatica = provaDidatica;
    }

    public ProvaEscrita getProvaEscrita() {
        return provaEscrita;
    }

    public void setProvaEscrita(ProvaEscrita provaEscrita) {
        this.provaEscrita = provaEscrita;
    }

    public Boolean getAptoProvaEscrita() {
        return aptoProvaEscrita;
    }

    public void setAptoProvaEscrita(Boolean aptoProvaEscrita) {
        this.aptoProvaEscrita = aptoProvaEscrita;
    }

    public Boolean getPresenteProvaEscrita() {
        return presenteProvaEscrita;
    }

    public void setPresenteProvaEscrita(Boolean presenteProvaEscrita) {
        this.presenteProvaEscrita = presenteProvaEscrita;
    }

    public Boolean getAptoProvaTitulos() {
        return aptoProvaTitulos;
    }

    public void setAptoProvaTitulos(Boolean aptoProvaTitulos) {
        this.aptoProvaTitulos = aptoProvaTitulos;
    }

    public Boolean getPresenteProvaTitulos() {
        return presenteProvaTitulos;
    }

    public void setPresenteProvaTitulos(Boolean presenteProvaTitulos) {
        this.presenteProvaTitulos = presenteProvaTitulos;
    }

    public Boolean getAptoProvaDidatica() {
        return aptoProvaDidatica;
    }

    public void setAptoProvaDidatica(Boolean aptoProvaDidatica) {
        this.aptoProvaDidatica = aptoProvaDidatica;
    }

    public Boolean getPresenteProvaDidatica() {
        return presenteProvaDidatica;
    }

    public void setPresenteProvaDidatica(Boolean presenteProvaDidatica) {
        this.presenteProvaDidatica = presenteProvaDidatica;
    }

    public Boolean getAptoProvaMemorial() {
        return aptoProvaMemorial;
    }

    public void setAptoProvaMemorial(Boolean aptoProvaMemorial) {
        this.aptoProvaMemorial = aptoProvaMemorial;
    }

    public Boolean getPresenteProvaMemorial() {
        return presenteProvaMemorial;
    }

    public void setPresenteProvaMemorial(Boolean presenteProvaMemorial) {
        this.presenteProvaMemorial = presenteProvaMemorial;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
