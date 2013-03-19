/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

import br.com.model.dao.ConcursoDao;
import java.sql.SQLException;
import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Usuario
 */
public class Cronograma implements IEntidade {
    
    @NotNull(message="O id não pode ser nulo.")
    private Integer idCronograma;
    
    //atividade, data, local, concurso
    private String atividade, local;
    
    private Date data;
    
    @NotNull(message="O concurso não pode ser nulo.")
    private Integer idConcurso;
    
    private Concurso concurso;

    /**
     * @return the idCronograma
     */
    public Integer getIdCronograma() {
        return idCronograma;
    }

    /**
     * @param idCronograma the idCronograma to set
     */
    public void setIdCronograma(Integer idCronograma) {
        this.idCronograma = idCronograma;
    }

    /**
     * @return the atividade
     */
    public String getAtividade() {
        return atividade;
    }

    /**
     * @param atividade the atividade to set
     */
    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the idConcurso
     */
    public Integer getIdConcurso() {
        return idConcurso;
    }

    /**
     * @param idConcurso the idConcurso to set
     */
    public void setIdConcurso(Integer idConcurso) {
        this.idConcurso = idConcurso;
    }

    /**
     * @return the concurso
     */
    public Concurso getConcurso() throws SQLException {
        if (this.concurso == null) {
            this.concurso = (new ConcursoDao()).pesquisarPorId(this.getIdConcurso());
        }
        return concurso;
    }

    /**
     * @param concurso the concurso to set
     */
    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }
    
    
    
}
