/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.IEntidade;
import br.com.model.entity.ProvaEscrita;
import br.com.model.entity.ProvaMemorial;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class ProvaEscritaDao implements IDao{

    @Override
    public ProvaEscrita inserir(IEntidade entidade) throws SQLException {
        if(entidade instanceof ProvaEscrita){
          
          ProvaEscrita provaEscrita = (ProvaEscrita) entidade;
          
          String sql = "insert into prova_escrita (id_concurso) values(?) ";
         
            Connection connection = ConnectionFactory.getConnection();
            try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, provaEscrita.getConcurso().getIdConcurso());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                
                if (rs.next()) {
                    provaEscrita.setIdProvaEscrita(rs.getInt(1));
                }
            }
            return provaEscrita;
      } 
      return null;
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
    public List<IEntidade> pesquisarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
