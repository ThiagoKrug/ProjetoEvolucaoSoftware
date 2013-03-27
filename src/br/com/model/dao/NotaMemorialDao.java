/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.Candidato;
import br.com.model.entity.IEntidade;
import br.com.model.entity.NotaMemorial;
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
public class NotaMemorialDao implements IDao {

    @Override
    public NotaMemorial inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof NotaMemorial) {
            NotaMemorial notaMemorial = (NotaMemorial) entidade;

            String sql = "INSERT into nota_memorial (id_nota_memorial, id_examinador,"
                    + " id_candidato, id_prova_memorial, nota_memorial)"
                    + " values (?,?,?,?,?)";
            Connection connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                if (notaMemorial.getIdNotaProvaMemorial() != 0) {
                    stmt.setInt(1, notaMemorial.getIdNotaProvaMemorial());
                } else {
                    stmt.setString(1, null);
                }
                stmt.setInt(2, notaMemorial.getIdExaminador());
                stmt.setInt(3, notaMemorial.getIdCandidato());
                stmt.setInt(4, notaMemorial.getIdProvaMemorial());
                stmt.setFloat(5, notaMemorial.getNotaProvaMemorial());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    notaMemorial.setIdNotaProvaMemorial(rs.getInt(1));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return notaMemorial;
        }

        return null;
    }

    @Override
    public NotaMemorial alterar(IEntidade entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public NotaMemorial excluir(IEntidade entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public NotaMemorial pesquisarPorId(int id) throws SQLException {
        String sql = "SELECT * from nota_memorial WHERE id_nota_memorial = ?";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        NotaMemorial nota = null;

        if (rs.next()) {
            nota = new NotaMemorial();
            nota.setIdNotaProvaMemorial(rs.getInt("id_nota_memorial"));
            nota.setIdExaminador(rs.getInt("id_examinador"));
            nota.setIdCandidato(rs.getInt("id_candidato"));
            nota.setIdProvaMemorial(rs.getInt("id_prova_memorial"));
            nota.setNotaProvaMemorial(rs.getFloat("nota_memorial"));
        }
        return nota;
    }

    public NotaMemorial pesquisarPorCandidatoId(int id) throws SQLException {
        String sql = "SELECT * from nota_memorial WHERE candidato_id = ?";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        NotaMemorial nota = null;

        if (rs.next()) {
            nota = new NotaMemorial();
            nota.setIdNotaProvaMemorial(rs.getInt("id_nota_memorial"));
            nota.setIdExaminador(rs.getInt("id_examinador"));
            nota.setIdCandidato(rs.getInt("id_candidato"));
            nota.setIdProvaMemorial(rs.getInt("id_prova_memorial"));
            nota.setNotaProvaMemorial(rs.getFloat("nota_memorial"));
        }
        return nota;


    }

    @Override
    public List<NotaMemorial> pesquisarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<NotaMemorial> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
