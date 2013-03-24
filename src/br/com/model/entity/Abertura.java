/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;
import br.com.model.dao.ConcursoDao;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Usuario
 */
public class Abertura implements IEntidade {
    
    private HashMap<String, Method[]> tablemap;
    
    @NotNull(message="O id da abertura não pode ser nulo.")
    private Integer idAbertura;
    
    private Date horaInicio;
    private String local, portaria, emissor;
    
    private Concurso concurso;
    
    @NotNull(message="O id do concurso não pode ser nulo.")
    private Integer idConcurso;
    
    
    public Abertura() {
        this.tablemap = new HashMap<String, Method[]>();
        try {
        Method[] ids = new Method[] {
            Abertura.class.getMethod("getIdAbertura", new Class<?>[] {}),
            Abertura.class.getMethod("setIdAbertura", new Class<?>[] {Integer.class})
        };
        this.tablemap.put("id_abertura", ids);
        
        this.tablemap.put("hora_inicio", new Method[] {
            Abertura.class.getMethod("getHoraInicio", new Class<?>[] {}),
            Abertura.class.getMethod("setHoraInicio", new Class<?>[] {Date.class})
        });
        
        this.tablemap.put("local", new Method[] {
            Abertura.class.getMethod("getLocal", new Class<?>[] {}),
            Abertura.class.getMethod("setLocal", new Class<?>[] {String.class})
        });
        
        this.tablemap.put("portaria", new Method[] {
            Abertura.class.getMethod("getPortaria", new Class<?>[] {}),
            Abertura.class.getMethod("setPortaria", new Class<?>[] {String.class})
        });
        
        this.tablemap.put("emissor", new Method[] {
            Abertura.class.getMethod("getEmissor", new Class<?>[] {}),
            Abertura.class.getMethod("setEmissor", new Class<?>[] {String.class})
        });
        
        this.tablemap.put("id_concurso", new Method[] {
            Abertura.class.getMethod("getIdConcurso", new Class<?>[] {}),
            Abertura.class.getMethod("setIdConcurso", new Class<?>[] {Integer.class})
        });
        

        
        } catch (NoSuchMethodException e) {
            System.out.println("Erro na reflection.");
            e.printStackTrace();
        }
    }
    
//    public void updateMap() {
//        this.tablemap.put("id_abertura", this.idAbertura);
//        this.tablemap.put("hora_inicio", this.horaInicio);
//        this.tablemap.put("local", this.local);
//        this.tablemap.put("portaria", this.portaria);
//        this.tablemap.put("emissor", this.emissor);
//        this.tablemap.put("id_concurso", this.idConcurso);
//    }

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
//        updateMap();
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
//        updateMap();
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
//        updateMap();
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
//        updateMap();
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
//        updateMap();
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
        this.idConcurso = concurso.getIdConcurso();
//        updateMap();
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
//        updateMap();
    }

    /**
     * @return the tablemap
     */
    public HashMap<String, Method[]> getTablemap() {
        return tablemap;
    }

    /**
     * @param tablemap the tablemap to set
     */
//    public void setTablemap(HashMap<String, Object> tablemap) {
//        this.tablemap = tablemap;
//        this.idAbertura = (Integer)this.tablemap.get("id_abertura");
//        this.emissor = (String)this.tablemap.get("emissor");
//        this.horaInicio = (Date)this.tablemap.get("hora_inicio");
//        this.idConcurso = (Integer)this.tablemap.get("id_concurso");
//        this.local = (String)this.tablemap.get("local");
//        this.portaria = (String)this.tablemap.get("portaria");
//    }
    
    
}
