package br.com.model.entity;

import br.com.model.dao.ConcursoDao;
import br.com.model.dao.ExaminadorDao;
import java.sql.SQLException;

/**
 * @author Thiago Lima <thiagolimaes@gmail.com>
 */
public class BancaExaminadora implements IEntidade {

    private int idBanca;
    private int idConcurso;
    private Examinador presidente;
    private Examinador examinador2;
    private Examinador examinador3;

    public BancaExaminadora() {
    }

    /**
     * Retorna o objeto do Concurso da banca examinadora.
     *
     * @return Concurso
     * @throws SQLException
     */
    public Concurso getConcurso() throws SQLException {

        ConcursoDao concursoDao = new ConcursoDao();
        Concurso concurso = (Concurso) concursoDao.pesquisarPorId(this.idConcurso);

        return concurso;

    }

    public int getIdBanca() {
        return idBanca;
    }

    public int getIdConcurso() {
        return idConcurso;
    }

    public void setIdBanca(int idBanca) {
        this.idBanca = idBanca;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }

    public Examinador getPresidente() {
        return presidente;
    }

    public Examinador getPresidenteDoBanco() {
        ExaminadorDao edao = new ExaminadorDao();
        try {
            presidente = edao.pesquisarPorId(presidente.getIdExaminador());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return presidente;
    }

    public void setPresidente(Examinador presidente) {
        this.presidente = presidente;
    }

    public Examinador getExaminador2() {
        return examinador2;
    }

    public Examinador getExaminador2DoBanco() {
        ExaminadorDao edao = new ExaminadorDao();
        try {
            examinador2 = edao.pesquisarPorId(examinador2.getIdExaminador());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return examinador2;
    }

    public void setExaminador2(Examinador examinador2) {
        this.examinador2 = examinador2;
    }

    public Examinador getExaminador3() {
        return examinador3;
    }

    public Examinador getExaminador3DoBanco() {
        ExaminadorDao edao = new ExaminadorDao();
        try {
            examinador3 = edao.pesquisarPorId(examinador3.getIdExaminador());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return examinador3;
    }

    public void setExaminador3(Examinador examinador3) {
        this.examinador3 = examinador3;
    }
}
