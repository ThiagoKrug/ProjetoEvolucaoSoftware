package br.com.model.entity;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 *
 * @author Bruno
 */
public class Titulacao implements IEntidade {

    private HashMap<String, Method[]> tablemap;
    //@NotNull
    private Integer idTitulacao;
    //@NotBlank
    private String titulacao;

    public Titulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public Titulacao() {
        this.tablemap = new HashMap<String, Method[]>();
        try {
            Method[] ids;
            ids = new Method[]{
                this.getClass().getMethod("getIdTitulacao", new Class<?>[]{}),
                this.getClass().getMethod("setIdTitulacao", new Class<?>[]{this.idTitulacao.getClass()})
            };
            this.tablemap.put("id_titulacao", ids);

            this.tablemap.put("titulacao", new Method[]{
                this.getClass().getMethod("getTitulacao", new Class<?>[]{}),
                this.getClass().getMethod("setTitulacao", new Class<?>[]{this.titulacao.getClass()})
            });


        } catch (NoSuchMethodException e) {
            System.out.println("Erro na reflection.");
            e.printStackTrace();
        }
    }

    public int getIdTitulacao() {
        return idTitulacao;
    }

    public void setIdTitulacao(int idTitulacao) {
        this.idTitulacao = idTitulacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
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
}
