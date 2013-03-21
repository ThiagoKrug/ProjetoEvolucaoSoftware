/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.entity;

import br.com.model.dao.AvaliacaoProvaTitulosDao;
import br.com.model.dao.ItemClasseDao;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bruno
 */
public class AvaliacaoItem implements IEntidade {
    
    @NotNull(message="O valor não pode ser nulo!")
    private Integer idAvaliacaoItem;
    
    private Integer idAvaliacaoPT;
    
    @NotNull(message="O valor não pode ser nulo!")
    private AvaliacaoProvaTitulo avaliacaoProvaTitulo;
    
    private Integer idItemClasse;
    @NotNull(message="O valor não pode ser nulo!")
    private ItemClasse itemClasse;
    
    @NotNull(message="O valor não pode ser nulo!")
    private Integer quantidade;
    
    private HashMap<String, Method[]> tablemap;
    
    public AvaliacaoItem() {
        this.tablemap = new HashMap<String, Method[]>();
        try {
        Method[] ids = new Method[] {
            this.getClass().getMethod("getIdAvaliacaoItem", new Class<?>[] {}),
            this.getClass().getMethod("setIdAvaliacaoItem", new Class<?>[] {this.idAvaliacaoItem.getClass()})
        };
        this.tablemap.put("id_avaliacao_item", ids);
        
        this.tablemap.put("id_avaliacao_prova_titulo", new Method[] {
            this.getClass().getMethod("getIdAvaliacaoPT", new Class<?>[] {}),
            this.getClass().getMethod("setIdAvaliacaoPT", new Class<?>[] {this.idAvaliacaoPT.getClass()})
        });
        
        this.tablemap.put("id_item_classe", new Method[] {
            this.getClass().getMethod("getIdItemClasse", new Class<?>[] {}),
            this.getClass().getMethod("setIdItemClasse", new Class<?>[] {this.idItemClasse.getClass()})
        });
        
        this.tablemap.put("quantidade", new Method[] {
            this.getClass().getMethod("getQuantidade", new Class<?>[] {}),
            this.getClass().getMethod("setQuantidade", new Class<?>[] {this.quantidade.getClass()})
        });
        

        
        } catch (NoSuchMethodException e) {
            System.out.println("Erro na reflection.");
            e.printStackTrace();
        }
    }

    public int getIdAvaliacaoItem() {
        return idAvaliacaoItem;
    }

    public void setIdAvaliacaoItem(int idAvaliacaoItem) {
        this.idAvaliacaoItem = idAvaliacaoItem;
    }

    public AvaliacaoProvaTitulo getAvaliacaoProvaTitulo() throws SQLException {
        if (avaliacaoProvaTitulo == null) {
            avaliacaoProvaTitulo = (AvaliacaoProvaTitulo)new AvaliacaoProvaTitulosDao().pesquisarPorId(this.idAvaliacaoPT);
        }
        return avaliacaoProvaTitulo;
    }

    public void setAvaliacaoProvaTitulo(AvaliacaoProvaTitulo avaliacaoProvaTitulo) {
        this.avaliacaoProvaTitulo = avaliacaoProvaTitulo;
        this.idAvaliacaoPT = avaliacaoProvaTitulo.getIdAvaliacaoProvaTitulo();
    }

    public ItemClasse getItemClasse() throws SQLException {
        if (itemClasse == null) {
            this.itemClasse = (ItemClasse)new ItemClasseDao().pesquisarPorId(idItemClasse);
        }
        return itemClasse;
    }

    public void setItemClasse(ItemClasse itemClasse) {
        this.itemClasse = itemClasse;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.setQuantidade((Integer) quantidade);
    }

    /**
     * @return the idAvaliacaoPT
     */
    public Integer getIdAvaliacaoPT() {
        return idAvaliacaoPT;
    }

    /**
     * @param idAvaliacaoPT the idAvaliacaoPT to set
     */
    public void setIdAvaliacaoPT(Integer idAvaliacaoPT) {
        this.idAvaliacaoPT = idAvaliacaoPT;
    }

    /**
     * @return the idItemClasse
     */
    public Integer getIdItemClasse() {
        return idItemClasse;
    }

    /**
     * @param idItemClasse the idItemClasse to set
     */
    public void setIdItemClasse(Integer idItemClasse) {
        this.idItemClasse = idItemClasse;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the tablemap
     */
    public HashMap<String, Method[]> getTablemap() {
        return tablemap;
    }
    
    
}
