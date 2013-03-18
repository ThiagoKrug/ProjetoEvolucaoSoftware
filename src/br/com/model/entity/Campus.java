
package br.com.model.entity;

/**
 * @author Thiago Lima <thiagolimaes@gmail.com>
 */
public class Campus implements IEntidade {
    
    private int idCampus;
    private String cidadeCampus;
    
    public Campus() {
        
    }

    public int getIdCampus() {
        return idCampus;
    }

    public String getCidadeCampus() {
        return cidadeCampus;
    }

    public void setIdCampus(int idCampus) {
        this.idCampus = idCampus;
    }

    public void setCidadeCampus(String cidadeCampus) {
        this.cidadeCampus = cidadeCampus;
    }
    
}
