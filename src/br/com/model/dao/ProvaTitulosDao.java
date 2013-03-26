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
import java.util.ArrayList;
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
            
            String sql = "INSERT INTO prova_titulo (local, concurso, classe1, classe2, classe3) "
                    + "VALUES (?,?,?,?,?)";
            
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, provaTitulos.getLocal());
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
        
        if (entidade instanceof ProvaTitulos) {
            
            ProvaTitulos provaTitulos = (ProvaTitulos) entidade;
            
            String sql = "UPDATE prova_titulo SET local = ?, concurso = ?, classe1 = ?, classe2 = ? classe = ? "
                    + "WHERE id_prova_titulo = ? ";
            
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, provaTitulos.getConcurso().getIdConcurso());
            stmt.setInt(2, provaTitulos.getClasse1().getIdClasse());
            stmt.setInt(3, provaTitulos.getClasse2().getIdClasse());
            stmt.setInt(4, provaTitulos.getClasse3().getIdClasse());
            stmt.setInt(5, provaTitulos.getIdProvaTitulos());
            
            if (stmt.executeUpdate() == 1) {
                return provaTitulos;       
            }
            
        }
        return null;
        
    }

    @Override
    public IEntidade excluir(IEntidade entidade) throws SQLException {
        
        if (entidade instanceof ProvaTitulos) {
            
            ProvaTitulos provaTitulos = (ProvaTitulos) entidade;
            
            String sql = "DELETE FROM prova_titulo WHERE id_prova_titulo = ? ";
            
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, provaTitulos.getIdProvaTitulos());
            
            if (stmt.executeUpdate() == 1) {
                return provaTitulos;
            }
            
        }
        return null;
        
    }

    @Override
    public IEntidade pesquisarPorId(int id) throws SQLException {
        
        String sql = "SELECT * FROM prova_titulo WHERE id_prova_titulo = ? ";
        ProvaTitulos provaTitulos = new ProvaTitulos();
        
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            provaTitulos.setIdProvaTitulos(rs.getInt("id_prova_titulo"));
            provaTitulos.setClasse1(new ClasseDAO().pesquisarPorId(rs.getInt("classe1")));
            provaTitulos.setClasse2(new ClasseDAO().pesquisarPorId(rs.getInt("classe2")));
            provaTitulos.setClasse3(new ClasseDAO().pesquisarPorId(rs.getInt("classe3")));
            return provaTitulos;
        }
        return null;
        
    }

    @Override
    public List<ProvaTitulos> pesquisarTodos() throws SQLException {
        
        String sql = "SELECT * FROM prova_titulo ";
        List<ProvaTitulos> listProvaTitulos = new ArrayList<>();
        
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            ProvaTitulos provaTitulos = new ProvaTitulos();
            provaTitulos.setIdProvaTitulos(rs.getInt("id_prova_titulo"));
            provaTitulos.setClasse1(new ClasseDAO().pesquisarPorId(rs.getInt("classe1")));
            provaTitulos.setClasse2(new ClasseDAO().pesquisarPorId(rs.getInt("classe2")));
            provaTitulos.setClasse3(new ClasseDAO().pesquisarPorId(rs.getInt("classe3")));
            listProvaTitulos.add(provaTitulos);
        }
        
        return listProvaTitulos;
        
    }

    @Override
    public List<IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) {

        return null;
    }
    
}
