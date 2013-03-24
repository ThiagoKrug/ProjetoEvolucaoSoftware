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
public class Cronograma implements IEntidade {
    
    private HashMap<String, Method[]> tablemap;
    
    @NotNull(message="O id não pode ser nulo.")
    private Integer idCronograma;
    
    //atividade, data, local, concurso
    private String atividade, local;
    
    private Date data, horario;
    
    private Date horario;
    
    @NotNull(message="O concurso não pode ser nulo.")
    private Integer idConcurso;
    
    private Concurso concurso;
    
    
    public Cronograma() {
        this.tablemap = new HashMap<String, Method[]>();
        try {
        Method[] ids = new Method[] {
            this.getClass().getMethod("getIdCronograma", new Class<?>[] {}),
            this.getClass().getMethod("setIdCronograma", new Class<?>[] {this.idCronograma.getClass()})
        };
        this.tablemap.put("id_abertura", ids);
        
        this.tablemap.put("local", new Method[] {
            this.getClass().getMethod("getLocal", new Class<?>[] {}),
            this.getClass().getMethod("setLocal", new Class<?>[] {this.local.getClass()})
        });
        
        this.tablemap.put("atividade", new Method[] {
            this.getClass().getMethod("getAtividade", new Class<?>[] {}),
            this.getClass().getMethod("setAtividade", new Class<?>[] {this.atividade.getClass()})
        });
        
        this.tablemap.put("data", new Method[] {
            this.getClass().getMethod("getData", new Class<?>[] {}),
            this.getClass().getMethod("setData", new Class<?>[] {this.data.getClass()})
        });
        
        this.tablemap.put("id_concurso", new Method[] {
            this.getClass().getMethod("getIdConcurso", new Class<?>[] {}),
            this.getClass().getMethod("setIdConcurso", new Class<?>[] {this.idConcurso.getClass()})
        });
        
        this.tablemap.put("horario", new Method[] {
            this.getClass().getMethod("horario", new Class<?>[] {}),
            this.getClass().getMethod("horario", new Class<?>[] {this.horario.getClass()})
        });

        
        } catch (NoSuchMethodException e) {
            System.out.println("Erro na reflection.");
            e.printStackTrace();
        }
    }
    
//    public void updateMap() {
//        this.tablemap.put("id_cronograma", this.idCronograma);
//        this.tablemap.put("atividade", this.atividade);
//        this.tablemap.put("local", this.local);
//        this.tablemap.put("data", this.data);
//        this.tablemap.put("id_concurso", this.idConcurso);
//    }

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
//        updateMap();
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
     * @return the tablemap
     */
    public HashMap<String, Method[]> getTablemap() {
        return tablemap;
    }

    /**
     * @return the horario
     */
    public Date getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(Date horario) {
        this.horario = horario;
    }

    /**
     * @param tablemap the tablemap to set
     */
//    public void setTablemap(HashMap<String, Object> tablemap) {
//        this.tablemap = tablemap;
//        idCronograma = (Integer)tablemap.get("id_cronograma");
//        this.atividade = (String)tablemap.get("atividade");
//        this.data = (Date)tablemap.get("data");
//        this.idConcurso = (Integer)tablemap.get("id_concurso");
//        this.local = (String)tablemap.get("local");
//        this.getClass()
//    }
//    
    
    
}
