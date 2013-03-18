/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.IEntidade;
import br.com.model.entity.PontoProvaEscrita;
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
public class PontoProvaEscritaDao implements IDao {
    
     @Override
    public PontoProvaEscrita inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof PontoProvaEscrita) {
            PontoProvaEscrita pontoProvaEscrita = (PontoProvaEscrita) entidade;

            String sql = "insert into ponto_prova_escrita (id_prova_escrita, descricao) values(?,?) ";
            Connection connection = ConnectionFactory.getConnection();
            try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                if(pontoProvaEscrita.getProvaEscrita().getIdProvaEscrita() != 0)
                    stmt.setInt(1, pontoProvaEscrita.getProvaEscrita().getIdProvaEscrita());
                else
                    stmt.setString(1, null);
                stmt.setString(2, pontoProvaEscrita.getDescricao());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    pontoProvaEscrita.setIdPontoProvaEscrita(rs.getInt(1));
                }
            }
            return pontoProvaEscrita;
        }
        return null;
    }

    @Override
    public PontoProvaEscrita alterar(IEntidade entidade) throws SQLException {

        if (entidade instanceof PontoProvaEscrita) {

            PontoProvaEscrita pontoProvaEscrita = (PontoProvaEscrita) entidade;
            String sql = "UPDATE ponto_prova_escrita SET"
                    + "id_prova_escrita = ?,"
                    + "descricao = ?,"
                    + "WHERE id_ponto_prova_escrita = ? ";

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pontoProvaEscrita.getProvaEscrita().getIdProvaEscrita());
            stmt.setString(2, pontoProvaEscrita.getDescricao());
            stmt.setInt(3, pontoProvaEscrita.getIdPontoProvaEscrita());

            if (stmt.executeUpdate() == 1) {
                return pontoProvaEscrita;
            }
        }
        return null;
    }

    @Override
    public PontoProvaEscrita excluir(IEntidade entidade) throws SQLException {
        if (entidade instanceof PontoProvaEscrita) {
            PontoProvaEscrita pontoProvaEscrita = (PontoProvaEscrita) entidade;
            String sql = "DELETE FROM ponto_prova_escrita WHERE id_ponto_prova_escrita = ? ";

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pontoProvaEscrita.getIdPontoProvaEscrita());

            if (stmt.executeUpdate() == 1) {
                return pontoProvaEscrita;
            }
        }
        return null;
    }

    @Override
    public PontoProvaEscrita pesquisarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM ponto_prova_escrita where id_ponto_prova_escrita = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        PontoProvaEscrita pontoProvaEscrita = null;
        if (rs.next()) {
            pontoProvaEscrita = new PontoProvaEscrita();
            pontoProvaEscrita.setIdPontoProvaEscrita(rs.getInt("id_ponto_prova_escrita"));
            pontoProvaEscrita.setProvaEscrita(new ProvaEscritaDao().pesquisarPorId(rs.getInt("id_prova_escrita")));
            pontoProvaEscrita.setDescricao(rs.getString("descricao"));
        }
        return pontoProvaEscrita;
    }

    @Override
    public List<PontoProvaEscrita> pesquisarTodos() throws SQLException {
        String sql = "SELECT * FROM ponto_prova_escrita";
        List<PontoProvaEscrita> listPontoProvaEscrita = pesquisar(sql);
        return listPontoProvaEscrita;
    }

    @Override
    public List<PontoProvaEscrita> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        String sql = "SELECT * FROM ponto_prova_escrita ORDER BY " + criterioOrdenamento;
        List<PontoProvaEscrita> listPontoProvaEscrita = pesquisar(sql);
        return listPontoProvaEscrita;
    }

    private List<PontoProvaEscrita> pesquisar(String sql) throws SQLException {
        List<PontoProvaEscrita> listPontoProvaEscrita = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            PontoProvaEscrita pontoProvaEscrita = new PontoProvaEscrita();
            pontoProvaEscrita.setIdPontoProvaEscrita(rs.getInt("id_ponto_prova_escrita"));
            pontoProvaEscrita.setProvaEscrita(new ProvaEscritaDao().pesquisarPorId(rs.getInt("id_prova_escrita")));
            pontoProvaEscrita.setDescricao(rs.getString("descricao"));
            listPontoProvaEscrita.add(pontoProvaEscrita);
        }
        return listPontoProvaEscrita;
    }
    
}
