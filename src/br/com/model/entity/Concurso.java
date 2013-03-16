/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

import java.util.Date;

/**
 *
 * @author Bruno
 */
public class Concurso implements IEntidade {
    
    private int idConcurso;
    private String instituicao;
    private Campus campus;
    private String area;
    private String edital;
    private Date dataInicio;
    private Date horaInicio;
    private CategoriaConcurso categoria;
    private String portaria;
    private String orgaoEmissor;
    private boolean temProvaEscrita;
    private boolean temProvaTitulos;
    private boolean temProvaDidática;
    private boolean temProvaMemorial;

    public Concurso() {
    }

    public Concurso(int idConcurso, String instituicao, Campus campus, String area, String edital, Date dataInicio, Date horaInicio, CategoriaConcurso categoria, String portaria, String orgaoEmissor, boolean temProvaEscrita, boolean temProvaTitulos, boolean temProvaDidática, boolean temProvaMemorial) {
        this.idConcurso = idConcurso;
        this.instituicao = instituicao;
        this.campus = campus;
        this.area = area;
        this.edital = edital;
        this.dataInicio = dataInicio;
        this.horaInicio = horaInicio;
        this.categoria = categoria;
        this.portaria = portaria;
        this.orgaoEmissor = orgaoEmissor;
        this.temProvaEscrita = temProvaEscrita;
        this.temProvaTitulos = temProvaTitulos;
        this.temProvaDidática = temProvaDidática;
        this.temProvaMemorial = temProvaMemorial;
    }

    /**
     * @return the idConcurso
     */
    public int getIdConcurso() {
        return idConcurso;
    }

    /**
     * @param idConcurso the idConcurso to set
     */
    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }

    /**
     * @return the instituicao
     */
    public String getInstituicao() {
        return instituicao;
    }

    /**
     * @param instituicao the instituicao to set
     */
    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    /**
     * @return the campus
     */
    public Campus getCampus() {
        return campus;
    }

    /**
     * @param campus the campus to set
     */
    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the edital
     */
    public String getEdital() {
        return edital;
    }

    /**
     * @param edital the edital to set
     */
    public void setEdital(String edital) {
        this.edital = edital;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the horaInicio
     */
    public Date getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the categoria
     */
    public CategoriaConcurso getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(CategoriaConcurso categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the portaria
     */
    public String getPortaria() {
        return portaria;
    }

    /**
     * @param portaria the portaria to set
     */
    public void setPortaria(String portaria) {
        this.portaria = portaria;
    }

    /**
     * @return the orgaoEmissor
     */
    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    /**
     * @param orgaoEmissor the orgaoEmissor to set
     */
    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    /**
     * @return the temProvaEscrita
     */
    public boolean isTemProvaEscrita() {
        return temProvaEscrita;
    }

    /**
     * @param temProvaEscrita the temProvaEscrita to set
     */
    public void setTemProvaEscrita(boolean temProvaEscrita) {
        this.temProvaEscrita = temProvaEscrita;
    }

    /**
     * @return the temProvaTitulos
     */
    public boolean isTemProvaTitulos() {
        return temProvaTitulos;
    }

    /**
     * @param temProvaTitulos the temProvaTitulos to set
     */
    public void setTemProvaTitulos(boolean temProvaTitulos) {
        this.temProvaTitulos = temProvaTitulos;
    }

    /**
     * @return the temProvaDidática
     */
    public boolean isTemProvaDidática() {
        return temProvaDidática;
    }

    /**
     * @param temProvaDidática the temProvaDidática to set
     */
    public void setTemProvaDidática(boolean temProvaDidática) {
        this.temProvaDidática = temProvaDidática;
    }

    /**
     * @return the temProvaMemorial
     */
    public boolean isTemProvaMemorial() {
        return temProvaMemorial;
    }

    /**
     * @param temProvaMemorial the temProvaMemorial to set
     */
    public void setTemProvaMemorial(boolean temProvaMemorial) {
        this.temProvaMemorial = temProvaMemorial;
    }
    
}
