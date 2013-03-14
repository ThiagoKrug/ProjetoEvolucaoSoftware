/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.IEntidade;
import br.com.model.entity.ProvaTitulos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class ProvaTitulosDao implements IDao {
    
    @Override
    public IEntidade inserir(IEntidade entidade) throws SQLException {
        
        if (entidade instanceof ProvaTitulos) {
            
            ProvaTitulos provaTitulos = (ProvaTitulos) entidade;
            
            String sql = "INSERT INTO prova_titulo (concurso, classe1, classe2, classe3) "
                    + "VALUES (?,?,?,?)";
            
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, provaTitulos.getConcurso().getIdConcurso());
            stmt.setInt(2, provaTitulos.getClasse1().getIdClasse());
            stmt.setInt(3, provaTitulos.getClasse2().getIdClasse());
            stmt.setInt(4, provaTitulos.getClasse3().getIdClasse());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if (rs.next()) {
                
                provaTitulos.setIdProvaTitulos(rs.getInt(1));
                
            }
            
            stmt.close();
            return provaTitulos;
            
        }
        return null;
        
    }

    @Override
    public IEntidade alterar(IEntidade entidade) throws SQLException {

        return null;
    }

    @Override
    public IEntidade excluir(IEntidade entidade) throws SQLException {

        return null;
    }

    @Override
    public IEntidade pesquisarPorId(int id) throws SQLException {

        return null;
    }

    @Override
    public List<IEntidade> pesquisarTodos() throws SQLException {

        return null;
    }

    @Override
    public List<IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) {

        return null;
    }
    
}
