/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.IEntidade;
import br.com.model.entity.ProvaMemorial;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcelo Maia
 */
public class ProvaMemorialDao  implements IDao{

    @Override
    public IEntidade inserir(IEntidade entidade) throws SQLException {
      
        if(entidade instanceof ProvaMemorial){
          
          ProvaMemorial provaMemorial = (ProvaMemorial) entidade;
          
          String sql = "insert into prova_memorial (id_concurso,data_comparecimento,compareceu) values(?,?,?) ";
         
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, provaMemorial.getConcurso().getIdConcurso());
//            stmt.setDate(2, new Date (provaMemorial.getData_comparecimento().getTime()));
//            stmt.setBoolean(3, provaMemorial.getCompareceu());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if (rs.next()) {
                
                provaMemorial.setIdProvaMemorial(rs.getInt(1));
                
            }
            
            stmt.close();
            return (IEntidade) provaMemorial;
      } 
      return null;
    }

    @Override
    public IEntidade alterar(IEntidade entidade) throws SQLException {
        if(entidade instanceof ProvaMemorial){
           
          
          ProvaMemorial provaMemorial = (ProvaMemorial) entidade;
            
          String sql = "update prova_memorial set id_concurso=?,compareceu=? where id_prova_memorial=? ";
         
//            System.out.println("data: "+provaMemorial.getData_comparecimento());
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, provaMemorial.getConcurso().getIdConcurso());
//            stmt.setDate(2, new Date (provaMemorial.getData_comparecimento().getTime()));
//            stmt.setBoolean(2, provaMemorial.getCompareceu());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if (rs.next()) {
                
                provaMemorial.setIdProvaMemorial(rs.getInt(1));
                
            }
            
            stmt.close();
            return (IEntidade) provaMemorial;
      }
        return null;
    }

    @Override
    public IEntidade excluir(IEntidade entidade) {
        if(entidade instanceof ProvaMemorial){
           String sql = "delete from prova_memorial where id_prova_memorial=?";
            ProvaMemorial provaMemorial = (ProvaMemorial) entidade;
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,provaMemorial.getIdProvaMemorial());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        }
        return null;
    }

    @Override
    public IEntidade pesquisarPorId(int id) {
       ProvaMemorial provaMemorial = new ProvaMemorial();
       String sql = "select * from prova_memorial where id_prova_memorial = ?"; 
       try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            int posicao = 0;
            while (rs.next()) {
                provaMemorial.setIdProvaMemorial(rs.getInt("id_prova_memorial"));
//                provaMemorial.setCompareceu(rs.getBoolean("compareceu"));
//                provaMemorial.setData_comparecimento(rs.getDate("data_comparecimento"));
                provaMemorial.setConcurso(null);
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
       return provaMemorial;
    }

    @Override
    public List<ProvaMemorial> pesquisarTodos()  {
       List<ProvaMemorial> listaProvaMemorial = new ArrayList<>() ;
      
       String sql = "select * from prova_memorial"; 
       try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            int posicao = 0;
            while (rs.next()) {
                ProvaMemorial provaMemorial = new ProvaMemorial();
                provaMemorial.setIdProvaMemorial(rs.getInt("id_prova_memorial"));
//                provaMemorial.setCompareceu(rs.getBoolean("compareceu"));
//                provaMemorial.setData_comparecimento(rs.getDate("data_comparecimento"));
                provaMemorial.setConcurso(null);
                
                listaProvaMemorial.add(provaMemorial);
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
       return  listaProvaMemorial;
    }

    @Override
    public List<IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) {
     List<IEntidade> listaProvaMemorial = new ArrayList<IEntidade>();
      
       String sql = "select * from prova_memorial order by "+criterioOrdenamento; 
       try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            int posicao = 0;
            while (rs.next()) {
                ProvaMemorial provaMemorial = new ProvaMemorial();
                provaMemorial.setIdProvaMemorial(rs.getInt("id_prova_memorial"));
//                provaMemorial.setCompareceu(rs.getBoolean("compareceu"));
//                provaMemorial.setData_comparecimento(rs.getDate("data_comparecimento"));
                provaMemorial.setConcurso(null);
                
                listaProvaMemorial.add(provaMemorial);
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
       return  listaProvaMemorial;
    }
    public ProvaMemorial pesquisarPorIdCurso(int id){
        ProvaMemorial provaMemorial = new ProvaMemorial();
        String sql = "SELECT * from prova_memorial where id_concurso = ?";
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                provaMemorial.setIdProvaMemorial(rs.getInt("id_prova_memorial"));
//                provaMemorial.setCompareceu(rs.getBoolean("compareceu"));
//                provaMemorial.setData_comparecimento(rs.getDate("data_comparecimento"));
                provaMemorial.setConcurso(null);
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
       return provaMemorial;
        
    }
    
}
