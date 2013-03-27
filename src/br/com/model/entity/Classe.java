package br.com.model.entity;

import br.com.model.dao.ItemClasseDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Bruno
 */
public class Classe implements IEntidade {

    @NotNull
    private int idClasse;
    @NotBlank
    private String nomeClasse;
    @NotNull
    @Min(0)
    @Max(10)
    private float pesoClasse;
    @NotNull
    @Min(0)
    @Max(10)
    private float notaReferenciaClasse;
    @NotNull
    private List<ItemClasse> itens;

    public Classe() {
    }

    public Classe(String nomeClasse, float pesoClasse, float notaReferenciaClasse, ArrayList<ItemClasse> itens) {

        this.nomeClasse = nomeClasse;
        this.pesoClasse = pesoClasse;
        this.notaReferenciaClasse = notaReferenciaClasse;
        this.itens = itens;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public float getPesoClasse() {
        return pesoClasse;
    }

    public void setPesoClasse(float pesoClasse) {
        this.pesoClasse = pesoClasse;
    }

    public float getNotaReferenciaClasse() {
        return notaReferenciaClasse;
    }

    public void setNotaReferenciaClasse(float notaReferenciaClasse) {
        this.notaReferenciaClasse = notaReferenciaClasse;
    }

    public List<ItemClasse> getItens() {
        if (itens == null) {
            ItemClasseDao itemClasseDao = new ItemClasseDao();
            try {
                itens = itemClasseDao.pesquisarPorIdClasse(idClasse);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return itens;
    }

    public void setItens(ArrayList<ItemClasse> itens) {
        this.itens = itens;
    }
}
