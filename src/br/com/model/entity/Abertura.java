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
public class Abertura implements IEntidade {
    
    @NotNull(message="O id da abertura não pode ser nulo.")
    private Integer idAbertura;
    
    private Date horaInicio;
    private String local, portaria, emissor;
    
    private Concurso concurso;
    
    @NotNull(message="O id do concurso não pode ser nulo.")
    private Integer idConcurso;

    /**
     * @return the idAbertura
     */
    public Integer getIdAbertura() {
        return idAbertura;
    }

    /**
     * @param idAbertura the idAbertura to set
     */
    public void setIdAbertura(Integer idAbertura) {
        this.idAbertura = idAbertura;
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
     * @return the emissor
     */
    public String getEmissor() {
        return emissor;
    }

    /**
     * @param emissor the emissor to set
     */
    public void setEmissor(String emissor) {
        this.emissor = emissor;
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
    
    
}
