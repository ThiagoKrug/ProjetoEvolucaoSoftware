/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.IEntidade;
import br.com.model.entity.NotaProvaEscrita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Helison
 */
public class NotaProvaEscritaDao implements IDao{

    @Override
    public NotaProvaEscrita inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof NotaProvaEscrita) {
            NotaProvaEscrita notaProvaEscrita = (NotaProvaEscrita) entidade;

            String sql = "INSERT into nota_prova_escrita (idnota_prova_escrita, id_examinador,"
                    + " id_candidato, id_prova_escrita, nota_prova_escrita)"
                    + " values (?,?,?,?,?)";
            Connection connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                if (notaProvaEscrita.getIdNotaProvaEscrita() != 0) {
                    stmt.setInt(1, notaProvaEscrita.getIdNotaProvaEscrita());
                } else {
                    stmt.setString(1, null);
                }
                stmt.setInt(2, notaProvaEscrita.getIdExaminador());
                stmt.setInt(3, notaProvaEscrita.getIdCandidato());
                stmt.setInt(4, notaProvaEscrita.getIdNotaProvaEscrita());
                stmt.setFloat(5, notaProvaEscrita.getNotaProvaEscrita());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    notaProvaEscrita.setIdNotaProvaEscrita(rs.getInt(1));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return notaProvaEscrita;
        }

        return null;
    }

    @Override
    public IEntidade alterar(IEntidade entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IEntidade excluir(IEntidade entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IEntidade pesquisarPorId(int id) throws SQLException {
        String sql = "SELECT * from nota_prova_escrita WHERE idnota_prova_escrita = ?";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        NotaProvaEscrita nota = null;

        if (rs.next()) {
            nota = new NotaProvaEscrita();
            nota.setIdNotaProvaEscrita(rs.getInt("idnota_prova_escrita"));
            nota.setIdExaminador(rs.getInt("id_examinador"));
            nota.setIdCandidato(rs.getInt("id_candidato"));
            nota.setIdProvaEscrita(rs.getInt("id_prova_escrita"));
            nota.setNotaProvaEscrita(rs.getFloat("nota_prova_escrita"));
        }
        return nota;
    }

       public NotaProvaEscrita pesquisarPorCandidatoId(int id) throws SQLException {
        String sql = "SELECT * from nota_prova_escrita WHERE id_candidato = ?";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        NotaProvaEscrita nota = null;

        if (rs.next()) {
            nota = new NotaProvaEscrita();
            nota.setIdNotaProvaEscrita(rs.getInt("idnota_prova_escrita"));
            nota.setIdExaminador(rs.getInt("id_examinador"));
            nota.setIdCandidato(rs.getInt("id_candidato"));
            nota.setIdProvaEscrita(rs.getInt("id_prova_escrita"));
            nota.setNotaProvaEscrita(rs.getFloat("nota_prova_escrita"));
        }
        return nota;


    }
    @Override
    public List<? extends IEntidade> pesquisarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<? extends IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
