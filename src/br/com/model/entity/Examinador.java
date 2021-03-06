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
            Method[] ids = new Method[]{
                Examinador.class.getMethod("getIdExaminador", new Class<?>[]{}),
                Examinador.class.getMethod("setIdExaminador", new Class<?>[]{Integer.class})
            };
            this.tablemap.put("id_examinador", ids);

            this.tablemap.put("id_pessoa", new Method[]{
                Examinador.class.getMethod("getIdPessoa", new Class<?>[]{}),
                Examinador.class.getMethod("setIdPessoa", new Class<?>[]{Integer.class})
            });

            this.tablemap.put("id_titulacao", new Method[]{
                Examinador.class.getMethod("getIdTitulacao", new Class<?>[]{}),
                Examinador.class.getMethod("setIdTitulacao", new Class<?>[]{Integer.class})
            });


        } catch (NoSuchMethodException e) {
            System.out.println("Erro na reflection.");
            e.printStackTrace();
        }
    }

    public int getIdExaminador() {
        return idExaminador;
    }

    public void setIdExaminador(Integer idExaminador) {
        this.idExaminador = idExaminador;
    }

    public Pessoa getPessoa() {
        if (pessoa == null) {
            try {
                pessoa = new PessoaDao().pesquisarPorId(getIdPessoa());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Titulacao getTitulacao() {
        if (titulacao.getTitulacao() == null) {
            try {
                titulacao = new TitulacaoDao().pesquisarPorId(getIdTitulacao());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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

    @Override
    public String toString() {
        return this.getPessoa().getNome();
    }
    
    
}
