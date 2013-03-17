/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.Candidato;
import br.com.model.entity.IEntidade;
import br.com.model.entity.PontoProvaEscrita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class CandidatoDao implements IDao {

    @Override
    public IEntidade inserir(IEntidade entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IEntidade alterar(IEntidade entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IEntidade excluir(IEntidade entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IEntidade pesquisarPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Candidato> pesquisarTodos() throws SQLException {
        String sql = "SELECT * FROM candidato as c, pessoa as p where c.id_pessoa = p.id_pessoa";
        List<Candidato> listCandidato = pesquisar(sql);
        return listCandidato;
    }

    @Override
    public List<Candidato> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        String sql = "SELECT * FROM candidato as c, pessoa as p where c.id_pessoa = p.id_pessoa ORDER BY " + criterioOrdenamento;
        List<Candidato> listCandidato = pesquisar(sql);
        return listCandidato;
    }

    private List<Candidato> pesquisar(String sql) throws SQLException {
        List<Candidato> listCandidato = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Candidato c = new Candidato();
            c.setIdCandidato(rs.getInt("id_candidato"));
            c.setNome(rs.getString("nome"));
            listCandidato.add(c);
        }
        return listCandidato;
    }
    
}
