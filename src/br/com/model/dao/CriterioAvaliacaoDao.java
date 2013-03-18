/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.CriterioAvaliacao;
import br.com.model.entity.IEntidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class CriterioAvaliacaoDao implements IDao{
    
    @Override
    public CriterioAvaliacao inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof CriterioAvaliacao) {
            CriterioAvaliacao criterio = (CriterioAvaliacao) entidade;

            String sql = "insert into criterio_avaliacao (criterio, peso, id_prova_escrita) values(?,?,?) ";
            Connection connection = ConnectionFactory.getConnection();
            try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, criterio.getCriterio());
                stmt.setFloat(2, criterio.getPeso());
                if(criterio.getProvaEscrita().getIdProvaEscrita() != 0)
                    stmt.setInt(3, criterio.getProvaEscrita().getIdProvaEscrita());
                else
                    stmt.setString(3, null);
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    criterio.setIdCriterioAvaliacao(rs.getInt(1));
                }
            }
            return criterio;
        }
        return null;
    }

    @Override
    public CriterioAvaliacao alterar(IEntidade entidade) throws SQLException {

        if (entidade instanceof CriterioAvaliacao) {

            CriterioAvaliacao criterio = (CriterioAvaliacao) entidade;
            String sql = "UPDATE criterio_avaliacao SET "
                    + "criterio = ?,"
                    + "peso = ?,"
                    + "WHERE id_criterio_avaliacao = ? ";

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, criterio.getCriterio());
            stmt.setFloat(2, criterio.getPeso());
            stmt.setInt(3, criterio.getIdCriterioAvaliacao());

            if (stmt.executeUpdate() == 1) {
                return criterio;
            }
        }
        return null;
    }

    @Override
    public CriterioAvaliacao excluir(IEntidade entidade) throws SQLException {
        if (entidade instanceof CriterioAvaliacao) {
            CriterioAvaliacao criterio = (CriterioAvaliacao) entidade;
            String sql = "DELETE FROM criterio_avaliacao WHERE id_criterio_avaliacao = ? ";

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, criterio.getIdCriterioAvaliacao());

            if (stmt.executeUpdate() == 1) {
                return criterio;
            }
        }
        return null;
    }

    @Override
    public CriterioAvaliacao pesquisarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM criterio_avaliacao where id_criterio_avaliacao = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        CriterioAvaliacao criterio = null;
        if (rs.next()) {
            criterio = new CriterioAvaliacao();
            criterio.setIdCriterioAvaliacao(rs.getInt("id_criterio_avaliacao"));
            criterio.setCriterio(rs.getString("criterio"));
            criterio.setPeso(rs.getFloat("peso"));
        }
        return criterio;
    }

    @Override
    public List<CriterioAvaliacao> pesquisarTodos() throws SQLException {
        String sql = "SELECT * FROM criterio_avaliacao";
        List<CriterioAvaliacao> listCriterio = pesquisar(sql);
        return listCriterio;
    }

    @Override
    public List<CriterioAvaliacao> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        String sql = "SELECT * FROM criterio_avaliacao ORDER BY " + criterioOrdenamento;
        List<CriterioAvaliacao> listCriterio = pesquisar(sql);
        return listCriterio;
    }

    private List<CriterioAvaliacao> pesquisar(String sql) throws SQLException {
        List<CriterioAvaliacao> listCriterio = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            CriterioAvaliacao criterio = new CriterioAvaliacao();
            criterio.setIdCriterioAvaliacao(rs.getInt("id_criterio_avaliacao"));
            criterio.setCriterio(rs.getString("criterio"));
            criterio.setPeso(rs.getFloat("peso"));
            listCriterio.add(criterio);
        }
        return listCriterio;
    }
}
