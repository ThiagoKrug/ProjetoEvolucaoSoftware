/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author renanmarceluchoa
 */
public class AvaliacaoProvaTitulosDao implements IDao {
    
    @Override
    public IEntidade inserir(IEntidade entidade) throws SQLException {
        
        if (entidade instanceof AvaliacaoProvaTitulo) {
            
            AvaliacaoProvaTitulo avaliacaoProvaTitulos = (AvaliacaoProvaTitulo) entidade;
            String sql = "INSERT INTO avaliacao_prova_titulo (id_candidato, id_prova_titulo) "
                    + "VALUES (?,?)";
            
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, avaliacaoProvaTitulos.getCandidato().getIdCandidato());
            stmt.setInt(2, avaliacaoProvaTitulos.getProvaTitulos().getIdProvaTitulos());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                
                avaliacaoProvaTitulos.setIdAvaliacaoProvaTitulo(rs.getInt(1));
                for (AvaliacaoItem avaliacaoItem : avaliacaoProvaTitulos.getAvaliacaoItens()) {
                    
                    String sql2 = "INSERT INTO avaliacao_item (id_item_classe, id_avaliacao_prova_titulo, quantidade) "
                            + "VALUES (?,?,?)";
                    PreparedStatement stmt2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
                    stmt2.setInt(1, avaliacaoItem.getItemClasse().getIdItemClasse());
                    stmt2.setInt(2, avaliacaoItem.getAvaliacaoProvaTitulo().getIdAvaliacaoProvaTitulo());
                    stmt2.setInt(3, avaliacaoItem.getQuantidade());
                    stmt2.executeUpdate();
                    
                    ResultSet rs2 = stmt2.getGeneratedKeys();
                    if (rs.next()) {
                        avaliacaoItem.setIdAvaliacaoItem(rs2.getInt(1));
                    }
                    stmt2.close();
                    
                }
                
            }
            
            stmt.close();
            return avaliacaoProvaTitulos;
            
        }
        return null;
        
    }

    @Override
    public IEntidade alterar(IEntidade entidade) throws SQLException {
        
        if (entidade instanceof AvaliacaoProvaTitulo) {
            
            AvaliacaoProvaTitulo avaliacaoProvaTitulo = (AvaliacaoProvaTitulo) entidade;
            boolean alterado = true;
            for (AvaliacaoItem item : avaliacaoProvaTitulo.getAvaliacaoItens()) {
                
                String sql = "UPDATE avaliacao_item SET quantidade = ? WHERE id_avaliacao_item = ? ";

                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, item.getQuantidade());
                stmt.setInt(2, item.getIdAvaliacaoItem());
                
                if (stmt.executeUpdate() != 1) {
                    alterado = false;
                }
            
            }
            
            if (alterado) {
                return avaliacaoProvaTitulo;
            }
            
        }
        return null;
        
    }

    @Override
    public IEntidade excluir(IEntidade entidade) throws SQLException {
        
        if (entidade instanceof AvaliacaoProvaTitulo) {
            
            AvaliacaoProvaTitulo avaliacaoProvaTitulo = (AvaliacaoProvaTitulo) entidade;
            String sql = "DELETE FROM avaliacao_prova_titulo WHERE id_avaliacao_prova_titulo = ? ";
            
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, avaliacaoProvaTitulo.getIdAvaliacaoProvaTitulo());
            
            if (stmt.executeUpdate() == 1) {
                
                //String sql2 = "DELETE * FROM avaliacao_item WHERE id_avaliacao_prova_titulo = ? ";
                //PreparedStatement stmt2 = connection.prepareStatement(sql2);
                //stmt2.setInt(1, avaliacaoProvaTitulo.getIdAvaliacaoProvaTitulo());
                
                //if (stmt2.executeUpdate() == avaliacaoProvaTitulo.getAvaliacaoItens().size()) {
                    return avaliacaoProvaTitulo;
                //}
                
            }
            
        }
        return null;
        
    }

    @Override
    public IEntidade pesquisarPorId(int id) throws SQLException {
        
        String sql = "SELECT * FROM avaliacao_prova_titulo WHERE id_avaliacao_prova_titulo = ? ";
        AvaliacaoProvaTitulo avaliacaoProvaTitulo = new AvaliacaoProvaTitulo();
        
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            avaliacaoProvaTitulo.setIdAvaliacaoProvaTitulo(rs.getInt("id_avaliacao_prova_titulo"));
            avaliacaoProvaTitulo.setCandidato((Candidato) new CandidatoDao().pesquisarPorId(rs.getInt("id_candidato")));
            avaliacaoProvaTitulo.setProvaTitulos((ProvaTitulos) new ProvaTitulosDao().pesquisarPorId(rs.getInt("id_prova_titulo")));
            
            String sql2 = "SELECT * FROM avaliacao_item WHERE id_avaliacao_prova_titulo = ? ";
            avaliacaoProvaTitulo.setAvaliacaoItens(new ArrayList<AvaliacaoItem>());
            
            PreparedStatement stmt2 = connection.prepareStatement(sql2);
            stmt2.setInt(1, avaliacaoProvaTitulo.getIdAvaliacaoProvaTitulo());
            ResultSet rs2 = stmt2.executeQuery();
            
            while (rs2.next()) {
                AvaliacaoItem avaliacaoItem = new AvaliacaoItem();
                avaliacaoItem.setIdAvaliacaoItem(rs2.getInt("id_avaliacao_item"));
                avaliacaoItem.setItemClasse((ItemClasse) new ItemClasseDao().pesquisarPorId(rs2.getInt("id_item_classe")));
                avaliacaoItem.setAvaliacaoProvaTitulo(avaliacaoProvaTitulo);
                avaliacaoItem.setQuantidade(rs.getInt("quantidade"));
                avaliacaoProvaTitulo.getAvaliacaoItens().add(avaliacaoItem);
            }
            return avaliacaoProvaTitulo;
            
        }
        return null;
        
    }

    @Override
    public List<? extends IEntidade> pesquisarTodos() throws SQLException {
        
        String sql = "SELECT * FROM avaliacao_prova_titulo ";
        List<IEntidade> listaAvaliacaoProvaTitulos = new ArrayList<IEntidade>();
        
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            
            AvaliacaoProvaTitulo avaliacaoProvaTitulo = new AvaliacaoProvaTitulo();
            avaliacaoProvaTitulo.setIdAvaliacaoProvaTitulo(rs.getInt("id_avaliacao_prova_titulo"));
            avaliacaoProvaTitulo.setCandidato((Candidato) new CandidatoDao().pesquisarPorId(rs.getInt("id_candidato")));
            avaliacaoProvaTitulo.setProvaTitulos((ProvaTitulos) new ProvaTitulosDao().pesquisarPorId(rs.getInt("id_prova_titulo")));
            
            String sql2 = "SELECT * FROM avaliacao_item WHERE id_avaliacao_prova_titulo = ? ";
            avaliacaoProvaTitulo.setAvaliacaoItens(new ArrayList<AvaliacaoItem>());
            
            PreparedStatement stmt2 = connection.prepareStatement(sql2);
            stmt2.setInt(1, avaliacaoProvaTitulo.getIdAvaliacaoProvaTitulo());
            ResultSet rs2 = stmt2.executeQuery();
            
            while (rs2.next()) {
                AvaliacaoItem avaliacaoItem = new AvaliacaoItem();
                avaliacaoItem.setIdAvaliacaoItem(rs2.getInt("id_avaliacao_item"));
                avaliacaoItem.setItemClasse((ItemClasse) new ItemClasseDao().pesquisarPorId(rs2.getInt("id_item_classe")));
                avaliacaoItem.setAvaliacaoProvaTitulo(avaliacaoProvaTitulo);
                avaliacaoItem.setQuantidade(rs.getInt("quantidade"));
                avaliacaoProvaTitulo.getAvaliacaoItens().add(avaliacaoItem);
            }
            listaAvaliacaoProvaTitulos.add(avaliacaoProvaTitulo);
            
        }
        return listaAvaliacaoProvaTitulos;
        
    }

    @Override
    public List<? extends IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
