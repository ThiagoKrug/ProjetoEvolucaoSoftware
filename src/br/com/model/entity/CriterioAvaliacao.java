/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

import br.com.model.dao.ProvaDidaticaDao;
import br.com.model.dao.ProvaEscritaDao;
import br.com.model.dao.ProvaMemorialDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class CriterioAvaliacao implements IEntidade {
    
    private int idCriterioAvaliacao;
    private int idProvaMemorial;
    private int idProvaEscrita;
    private int idProvaDidatica;
    private String criterio;
    private float peso;
    private ProvaEscrita provaEscrita;
    private ProvaMemorial provaMemorial;
    private ProvaDidatica provaDidatica;

    public int getIdProvaMemorial() {
        return idProvaMemorial;
    }

    public void setIdProvaMemorial(int idProvaMemorial) {
        this.idProvaMemorial = idProvaMemorial;
    }

    public int getIdProvaEscrita() {
        return idProvaEscrita;
    }

    public void setIdProvaEscrita(int idProvaEscrita) {
        this.idProvaEscrita = idProvaEscrita;
    }

    public int getIdProvaDidatica() {
        return idProvaDidatica;
    }

    public void setIdProvaDidatica(int idProvaDidatica) {
        this.idProvaDidatica = idProvaDidatica;
    }
    
    

    public ProvaMemorial getProvaMemorial() {
        ProvaMemorialDao provaMemorialDao = new ProvaMemorialDao();
        return  (ProvaMemorial) provaMemorialDao.pesquisarPorId(idProvaMemorial);
    }


    public ProvaDidatica getProvaDidatica() {
        ProvaDidaticaDao provaDidaticaDao = new ProvaDidaticaDao();
        try {
           provaDidatica = provaDidaticaDao.pesquisarPorId(idProvaDidatica);
        } catch (SQLException ex) {
            Logger.getLogger(CriterioAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return provaDidatica;
    }

    public void setProvaDidatica(ProvaDidatica provaDidatica) {
        this.provaDidatica = provaDidatica;
    }
    
    
    
    public int getIdCriterioAvaliacao() {
        return idCriterioAvaliacao;
    }

    public void setIdCriterioAvaliacao(int idCriterioAvaliacao) {
        this.idCriterioAvaliacao = idCriterioAvaliacao;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public ProvaEscrita getProvaEscrita() {
        ProvaEscritaDao provaEscritaDao = new ProvaEscritaDao();
        try {
        provaEscrita = provaEscritaDao.pesquisarPorId(this.idProvaEscrita);
        } catch (SQLException ex) {
            Logger.getLogger(CriterioAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return provaEscrita;
    }


    @Override
    public String toString() {
        return  this.criterio + " - " + this.peso ;
    }
    
    
    
}
