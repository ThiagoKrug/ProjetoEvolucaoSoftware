/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

import br.com.model.dao.PessoaDao;
import br.com.model.dao.TitulacaoDao;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Bruno
 */
public class Examinador implements IEntidade {
    
    private HashMap<String, Method[]> tablemap;

    private Integer idExaminador;
    private Integer idPessoa;
    private Pessoa pessoa;
    private Integer idTitulacao;
    private Titulacao titulacao;

    public Examinador() {
        this.tablemap = new HashMap<String, Method[]>();
        try {
        Method[] ids = new Method[] {
            this.getClass().getMethod("getIdExaminador", new Class<?>[] {}),
            this.getClass().getMethod("setIdExaminador", new Class<?>[] {this.idExaminador.getClass()})
        };
        this.tablemap.put("id_examinador", ids);
        
        this.tablemap.put("id_pessoa", new Method[] {
            this.getClass().getMethod("getIdPessoa", new Class<?>[] {}),
            this.getClass().getMethod("setIdPessoa", new Class<?>[] {this.idPessoa.getClass()})
        });
        
        this.tablemap.put("id_titulacao", new Method[] {
            this.getClass().getMethod("getIdTitulacao", new Class<?>[] {}),
            this.getClass().getMethod("setIdTitulacao", new Class<?>[] {this.idTitulacao.getClass()})
        });

        
        } catch (NoSuchMethodException e) {
            System.out.println("Erro na reflection.");
            e.printStackTrace();
        }
    }

    public int getIdExaminador() {
        return idExaminador;
    }

    public void setIdExaminador(int idExaminador) {
        this.idExaminador = idExaminador;
    }

    public Pessoa getPessoa() throws SQLException {
        if (pessoa == null) {
            pessoa = new PessoaDao().pesquisarPorId(getIdPessoa());
        }
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Titulacao getTitulacao() throws SQLException {
        if (titulacao == null) {
            titulacao = (Titulacao)new TitulacaoDao().pesquisarPorId(getIdTitulacao());
        }
        return titulacao;
    }

    public void setTitulacao(Titulacao titulacao) {
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

    /**
     * @return the idPessoa
     */
    public Integer getIdPessoa() {
        return idPessoa;
    }

    /**
     * @param idPessoa the idPessoa to set
     */
    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    /**
     * @return the idTitulacao
     */
    public Integer getIdTitulacao() {
        return idTitulacao;
    }

    /**
     * @param idTitulacao the idTitulacao to set
     */
    public void setIdTitulacao(Integer idTitulacao) {
        this.idTitulacao = idTitulacao;
    }
}
