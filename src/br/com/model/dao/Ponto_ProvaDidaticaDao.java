/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.IEntidade;
import br.com.model.entity.Ponto_ProvaDidatica;
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
public class Ponto_ProvaDidaticaDao implements IDao {

    public Ponto_ProvaDidaticaDao() {
    }

    /**
     *
     * @param entidade
     * @return
     * @throws SQLException
     */
    @Override
    public Ponto_ProvaDidatica inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof Ponto_ProvaDidatica) {

            Ponto_ProvaDidatica ponto_ProvaDidatica = (Ponto_ProvaDidatica) entidade;
            String sql_InseriPontoDidatica = "INSERT INTO ponto_prova_didatica (id_prova_didatica, descricao) values(?,?)";
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt_inserir = connection.prepareStatement(sql_InseriPontoDidatica, Statement.RETURN_GENERATED_KEYS);

            stmt_inserir.setInt(1, ponto_ProvaDidatica.getProvaDidatica().getIdProvaDidatica());

            stmt_inserir.setString(2, ponto_ProvaDidatica.getDescricaoPonto());
            stmt_inserir.executeUpdate();
            ResultSet rs_pontoInseriDidatica = stmt_inserir.getGeneratedKeys();

            if (rs_pontoInseriDidatica.next()) {
                ponto_ProvaDidatica.setIdPontoProvaDidatica(rs_pontoInseriDidatica.getInt(1));
            }
            return ponto_ProvaDidatica;
        }
        return null;
    }

    @Override
    public IEntidade alterar(IEntidade entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ponto_ProvaDidatica excluir(IEntidade entidade) throws SQLException {
        if (entidade instanceof Ponto_ProvaDidatica) {

            Ponto_ProvaDidatica excluirPonto = (Ponto_ProvaDidatica) entidade;
            String sql_Excluir = "DELETE FROM ponto_prova_didatica WHERE id_ponto_prova_didatica = ?";

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmtExcluir = connection.prepareStatement(sql_Excluir);
            stmtExcluir.setInt(1, excluirPonto.getIdPontoProvaDidatica());

            if (stmtExcluir.executeUpdate() == 1) {
                return excluirPonto;
            }
        }
        return null;
    }

    @Override
    public IEntidade pesquisarPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<? extends IEntidade> pesquisarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<? extends IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
