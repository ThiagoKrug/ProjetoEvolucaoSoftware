/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bruno
 */
public class Candidato extends Pessoa implements IEntidade {

    private Integer idCandidato;
    
    private HashMap<String, Method[]> tablemap;
    
    @NotNull(message="O Valor não pode ser nulo!")
    private Integer idConcurso;
    private Integer idPessoa;
    
    private Integer idProvaDidatica;
    private Integer idProvaEscrita;
    
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

//    public Candidato(boolean aptoProvaEscrita, boolean presenteProvaEscrita, boolean aptoProvaTitulos, boolean presenteProvaTitulos, boolean aptoProvaDidatica, boolean presenteProvaDidatica, boolean aptoProvaMemorial, boolean presenteProvaMemorial, String nome, String sexo, Date dataNascimento) {
//        super(nome, sexo, dataNascimento);
//        this.aptoProvaEscrita = aptoProvaEscrita;
//        this.presenteProvaEscrita = presenteProvaEscrita;
//        this.aptoProvaTitulos = aptoProvaTitulos;
//        this.presenteProvaTitulos = presenteProvaTitulos;
//        this.aptoProvaDidatica = aptoProvaDidatica;
//        this.presenteProvaDidatica = presenteProvaDidatica;
//        this.aptoProvaMemorial = aptoProvaMemorial;
//        this.presenteProvaMemorial = presenteProvaMemorial;
//    }

    public Candidato() {
        this.tablemap = new HashMap<String, Method[]>();
        try {
        Method[] ids = new Method[] {
            Candidato.class.getMethod("getIdCandidato", new Class<?>[] {}),
            Candidato.class.getMethod("setIdCandidato", new Class<?>[] {Integer.class})
        };
        this.tablemap.put("id_candidato", ids);
        
        this.tablemap.put("id_prova_didatica", new Method[] {
            Candidato.class.getMethod("getIdProvaDidatica", new Class<?>[] {}),
            Candidato.class.getMethod("setIdProvaDidatica", new Class<?>[] {Integer.class})
        });
        
        this.tablemap.put("id_prova_escrita", new Method[] {
            Candidato.class.getMethod("getIdProvaEscrita", new Class<?>[] {}),
            Candidato.class.getMethod("setIdProvaEscrita", new Class<?>[] {Integer.class})
        });
        
        this.tablemap.put("apto_prova_escrita", new Method[] {
            Candidato.class.getMethod("getAptoProvaEscrita", new Class<?>[] {}),
            Candidato.class.getMethod("setAptoProvaEscrita", new Class<?>[] {Boolean.class})
        });
        
        this.tablemap.put("apto_prova_didatica", new Method[] {
            Candidato.class.getMethod("getAptoProvaDidatica", new Class<?>[] {}),
            Candidato.class.getMethod("setAptoProvaDidatica", new Class<?>[] {Boolean.class})
        });
        
        this.tablemap.put("id_concurso", new Method[] {
            Candidato.class.getMethod("getIdConcurso", new Class<?>[] {}),
            Candidato.class.getMethod("setIdConcurso", new Class<?>[] {Integer.class})
        });
        
        this.tablemap.put("id_pessoa", new Method[] {
            Candidato.class.getMethod("getIdPessoa", new Class<?>[] {}),
            Candidato.class.getMethod("setIdPessoa", new Class<?>[] {Integer.class})
        });
        

        
        } catch (NoSuchMethodException e) {
            System.out.println("Erro na reflection.");
            e.printStackTrace();
        }
    }

    public int getIdConcurso() {
        return idConcurso;
    }

    public void setIdConcurso(int idConcurso) {
        this.setIdConcurso((Integer) idConcurso);
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
        this.setIdProvaDidatica((Integer) idProvaDidatica);
    }

    public void setIdProvaEscrita(int idProvaEscrita) {
        this.setIdProvaEscrita((Integer) idProvaEscrita);
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
        this.setIdCandidato((Integer) idCandidato);
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }

    /**
     * @param idCandidato the idCandidato to set
     */
    public void setIdCandidato(Integer idCandidato) {
        this.idCandidato = idCandidato;
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
    public void setTablemap(HashMap<String, Method[]> tablemap) {
        this.tablemap = tablemap;
    }

    /**
     * @param idConcurso the idConcurso to set
     */
    public void setIdConcurso(Integer idConcurso) {
        this.idConcurso = idConcurso;
    }

    /**
     * @param idPessoa the idPessoa to set
     */
    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    /**
     * @param idProvaDidatica the idProvaDidatica to set
     */
    public void setIdProvaDidatica(Integer idProvaDidatica) {
        this.idProvaDidatica = idProvaDidatica;
    }

    /**
     * @param idProvaEscrita the idProvaEscrita to set
     */
    public void setIdProvaEscrita(Integer idProvaEscrita) {
        this.idProvaEscrita = idProvaEscrita;
    }
}
