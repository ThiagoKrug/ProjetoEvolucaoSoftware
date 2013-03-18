
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.Concurso;
import br.com.model.entity.IEntidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author Thiago Lima <thiagolimaes@gmail.com>
 */
public class ConcursoDao implements IDao {

    @Override
    public Concurso inserir(IEntidade entidade) throws SQLException {
        
        if ( entidade instanceof Concurso ) {
            
            Concurso concurso     = (Concurso) entidade;
            Connection connection = ConnectionFactory.getConnection();
            
            String sql  = " INSERT INTO concurso ( ";
                   sql += "   ministerio,instituicao,id_campus,area,edital, ";
                   sql += "   id_classe_concurso,data_inicio,tem_prova_escrita, ";
                   sql += "   tem_prova_titulo,tem_prova_didatica,tem_prova_memorial ";
                   sql += " ) VALUES ( ";
                   sql += "   ?,?,?,?,?,?,?,?,?,?,? ";
                   sql += " ) ";
                   
            try ( PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ) {
                
                stmt.setString(1, concurso.getMinisterio());
                stmt.setString(2, concurso.getInstituicao());
                
                if ( concurso.getCampus().getIdCampus() != 0 ) {
                    stmt.setInt(3, concurso.getCampus().getIdCampus());
                } else {
                    stmt.setString(3, null);
                }
                
                stmt.setString(4, concurso.getArea());
                stmt.setString(5, concurso.getEdital());
                
                if ( concurso.getClasseConcurso().getIdClasseConcurso() != 0 ) {
                    stmt.setInt(6, concurso.getClasseConcurso().getIdClasseConcurso());
                } else {
                    stmt.setString(6, null);
                }
                
                stmt.setDate(7, new java.sql.Date(concurso.getDataInicio().getTime()));
                stmt.setBoolean(8, concurso.isTemProvaEscrita());
                stmt.setBoolean(9, concurso.isTemProvaTitulos());
                stmt.setBoolean(10, concurso.isTemProvaDidática());
                stmt.setBoolean(11, concurso.isTemProvaMemorial());
                
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                
                if ( rs.next() ) {
                    concurso.setIdConcurso( rs.getInt(1) );
                }
                
            }
            
            return concurso;
            
        }
        
        return null;

    }

    @Override
    public Concurso alterar(IEntidade entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Concurso excluir(IEntidade entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Concurso pesquisarPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Concurso> pesquisarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Concurso> pesquisarTodosOrdenadoPor(String criterioOrdenamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
