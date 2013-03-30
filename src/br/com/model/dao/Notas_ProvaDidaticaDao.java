/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.IEntidade;
import br.com.model.entity.Notas_ProvaDidatica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Juliano R. M.
 */
public class Notas_ProvaDidaticaDao implements IDao {

    /**
     * Insere a Nota da prova didatica do candidato
     *
     * @param entidade
     * @return
     * @throws SQLException
     */
    @Override
    public Notas_ProvaDidatica inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof Notas_ProvaDidatica) {
            Notas_ProvaDidatica notaProvaDidatica = (Notas_ProvaDidatica) entidade;

            String sql = "INSERT into notas_prova_didatica (id_notas_prova_didatica, id_examinador,"
                    + " id_candidato, id_prova_didatica, notas_prova)"
                    + " values (?,?,?,?,?)";
            Connection connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                if (notaProvaDidatica.getIdNotaProvaDidatica() != 0) {
                    stmt.setInt(1, notaProvaDidatica.getIdNotaProvaDidatica());
                } else {
                    stmt.setString(1, null);
                }
                stmt.setInt(2, notaProvaDidatica.getIdExaminador());
                stmt.setInt(3, notaProvaDidatica.getIdCandidato());
                stmt.setInt(4, notaProvaDidatica.getIdNotaProvaDidatica());
                stmt.setFloat(5, notaProvaDidatica.getNotaProvaDidatica());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    notaProvaDidatica.setIdNotaProvaDidatica(rs.getInt(1));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return notaProvaDidatica;
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

    /**
     * Pesquisa uma nota de uma prova didatica pelo ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Notas_ProvaDidatica pesquisarPorId(int id) throws SQLException {
        String sql = "SELECT * from notas_prova_didatica WHERE id_notas_prova_didatica = ?";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Notas_ProvaDidatica nota = null;

        if (rs.next()) {
            nota = new Notas_ProvaDidatica();
            nota.setIdNotaProvaDidatica(rs.getInt("id_notas_prova_didatica"));
            nota.setIdExaminador(rs.getInt("id_examinador"));
            nota.setIdCandidato(rs.getInt("id_candidato"));
            nota.setIdProvaDidatica(rs.getInt("id_prova_didatica"));
            nota.setNotaProvaDidatica(rs.getFloat("notas_prova"));
        }
        return nota;
    }

    /**
     * Pesquisa a nota da prova didatica pelo ID do candidato
     * @param id
     * @return
     * @throws SQLException 
     */
    public Notas_ProvaDidatica pesquisarPorCandidatoId(int id) throws SQLException {
        String sql = "SELECT * from notas_prova_didatica WHERE id_candidato = ?";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Notas_ProvaDidatica nota = null;

        if (rs.next()) {
            nota = new Notas_ProvaDidatica();
            nota.setIdNotaProvaDidatica(rs.getInt("id_notas_prova_didatica"));
            nota.setIdExaminador(rs.getInt("id_examinador"));
            nota.setIdCandidato(rs.getInt("id_candidato"));
            nota.setIdProvaDidatica(rs.getInt("id_prova_didatica"));
            nota.setNotaProvaDidatica(rs.getFloat("notas_prova"));
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
