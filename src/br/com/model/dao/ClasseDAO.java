/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.Classe;
import br.com.model.entity.IEntidade;
import br.com.model.entity.ItemClasse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author renanmarceluchoa
 */
public class ClasseDAO implements IDao {

    public ClasseDAO() {
        
    }

    public Classe pesquisarPorId(int id) throws SQLException {
        
        String sql = "SELECT * FROM classe WHERE id_classe = ? ";
        Classe classe = new Classe();
        
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            classe.setIdClasse(rs.getInt("id_classe"));
            classe.setNomeClasse(rs.getString("nome_classe"));
            classe.setPesoClasse(rs.getFloat("peso_classe"));
            classe.setNotaReferenciaClasse(rs.getFloat("nota_referencia_classe"));
            classe.setItens(new ArrayList<ItemClasse>());
            
            String sql2 = "SELECT * FROM item_classe WHERE id_classe = ? ";
            
            PreparedStatement stmt2 = connection.prepareStatement(sql2);
            stmt.setInt(1, classe.getIdClasse());
            
            ResultSet rs2 = stmt2.executeQuery();
            
            while (rs2.next()) {
                
                ItemClasse item = new ItemClasse();
                item.setIdItemClasse(rs.getInt("id_item_classe"));
                item.setDiscriminacao(rs.getString("discriminacao"));
                item.setPontuacao(rs.getFloat("pontuacao"));
                item.setClasse(classe);
                classe.getItens().add(item);
                
            }
            
            return classe;
        }
        
        return null;
        
    }

    @Override
    public IEntidade inserir(IEntidade entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
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
    public List<? extends IEntidade> pesquisarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
