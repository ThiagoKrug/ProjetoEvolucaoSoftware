/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.IEntidade;
import br.com.model.entity.NotaProvaTitulo;
//import br.com.model.entity.NotaMemorial;
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
public class NotaProvaTituloDao implements IDao {

    @Override
    public NotaProvaTitulo inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof NotaProvaTitulo) {
            NotaProvaTitulo notaProvaTitulo = (NotaProvaTitulo) entidade;

            String sql = "INSERT into nota_prova_titulo (idnota_prova_titulos, id_examinador,"
                    + " id_candidato, id_prova_titulos, nota_prova_titulos)"
                    + " values (?,?,?,?,?)";
            Connection connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                if (notaProvaTitulo.getIdNotaProvaTitulo() != 0) {
                    stmt.setInt(1, notaProvaTitulo.getIdNotaProvaTitulo());
                } else {
                    stmt.setString(1, null);
                }
                stmt.setInt(2, notaProvaTitulo.getIdExaminador());
                stmt.setInt(3, notaProvaTitulo.getIdCandidato());
                stmt.setInt(4, notaProvaTitulo.getIdNotaProvaTitulo());
                stmt.setFloat(5, notaProvaTitulo.getNotaProvaTitulo());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    notaProvaTitulo.setIdNotaProvaTitulo(rs.getInt(1));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return notaProvaTitulo;
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
    public NotaProvaTitulo pesquisarPorId(int id) throws SQLException {
        String sql = "SELECT * from nota_prova_titulos WHERE idnota_prova_titulos = ?";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        NotaProvaTitulo nota = null;

        if (rs.next()) {
            nota = new NotaProvaTitulo();
            nota.setIdNotaProvaTitulo(rs.getInt("idnota_prova_titulos"));
            nota.setIdExaminador(rs.getInt("id_examinador"));
            nota.setIdCandidato(rs.getInt("id_candidato"));
            nota.setIdProvaTitulo(rs.getInt("id_prova_titulo"));
            nota.setNotaProvaTitulo(rs.getFloat("nota_prova_titulos"));
        }
        return nota;
    }

    public NotaProvaTitulo pesquisarPorCandidatoId(int id) throws SQLException {
        String sql = "SELECT * from nota_prova_titulos WHERE id_candidato = ?";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        NotaProvaTitulo nota = null;

        if (rs.next()) {
            nota = new NotaProvaTitulo();
            nota.setIdNotaProvaTitulo(rs.getInt("idnota_prova_titulos"));
            nota.setIdExaminador(rs.getInt("id_examinador"));
            nota.setIdCandidato(rs.getInt("id_candidato"));
            nota.setIdProvaTitulo(rs.getInt("id_prova_titulo"));
            nota.setNotaProvaTitulo(rs.getFloat("nota_prova_titulos"));
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
