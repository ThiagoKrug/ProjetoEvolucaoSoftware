package br.com.model.entity;

import br.com.model.dao.ClasseDAO;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Bruno
 */
public class ItemClasse implements IEntidade {

    @NotNull
    private Integer idItemClasse;
    private Integer idClasse;
    @NotNull
    private Classe classe;
    @NotBlank
    private String discriminacao;
    @Min(0)
    @Max(10)
    @NotNull
    private Float pontuacao;
    private HashMap<String, Method[]> tablemap;

    public ItemClasse() {
        this.tablemap = new HashMap<String, Method[]>();
        try {
            Method[] ids = new Method[]{
                ItemClasse.class.getMethod("getIdItemClasse", new Class<?>[]{}),
                ItemClasse.class.getMethod("setIdItemClasse", new Class<?>[]{Integer.class})
            };
            this.tablemap.put("id_item_classe", ids);

            this.tablemap.put("discriminacao", new Method[]{
                ItemClasse.class.getMethod("getDiscriminacao", new Class<?>[]{}),
                ItemClasse.class.getMethod("setDiscriminacao", new Class<?>[]{String.class})
            });

            this.tablemap.put("pontuacao", new Method[]{
                ItemClasse.class.getMethod("getPontuacao", new Class<?>[]{}),
                ItemClasse.class.getMethod("setPontuacao", new Class<?>[]{Float.class})
            });

            this.tablemap.put("id_classe", new Method[]{
                ItemClasse.class.getMethod("getIdClasse", new Class<?>[]{}),
                ItemClasse.class.getMethod("setIdClasse", new Class<?>[]{Integer.class})
            });

        } catch (NoSuchMethodException e) {
            System.out.println("Erro na reflection.");
            e.printStackTrace();
        }
    }

    public Integer getIdItemClasse() {
        return idItemClasse;
    }

    public void setIdItemClasse(Integer idItemClasse) {
        this.idItemClasse = idItemClasse;
    }

    public Classe getClasse() throws SQLException {
        if (classe == null) {
            ClasseDAO cd = new ClasseDAO();
            this.classe = (Classe) cd.pesquisarPorId(getIdClasse());
        }
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
        this.setIdClasse((Integer) classe.getIdClasse());
    }

    public String getDiscriminacao() {
        return discriminacao;
    }

    public void setDiscriminacao(String discriminacao) {
        this.discriminacao = discriminacao;
    }

    public Float getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Float pontuacao) {
        this.pontuacao = pontuacao;
    }

    /**
     * @return the idClasse
     */
    public Integer getIdClasse() {
        return idClasse;
    }

    /**
     * @param idClasse the idClasse to set
     */
    public void setIdClasse(Integer idClasse) {
        this.idClasse = idClasse;
    }

    /**
     * @return the tablemap
     */
    public HashMap<String, Method[]> getTablemap() {
        return tablemap;
    }
}
