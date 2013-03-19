
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.Campus;
import br.com.model.entity.ClasseConcurso;
import br.com.model.entity.Concurso;
import br.com.model.entity.IEntidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import util.Datas;

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
        
        return null;
        
    }

    @Override
    public Concurso excluir(IEntidade entidade) throws SQLException {
        
        if ( entidade instanceof Concurso ) {
            
            Concurso concurso     = (Concurso) entidade;
            Connection connection = ConnectionFactory.getConnection();
            
            String sql = " DELETE FROM concurso WHERE id_concurso = ? ";
            
            try ( PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ) {
                
                stmt.setInt(1, concurso.getIdConcurso());
                
                if ( stmt.executeUpdate() == 1 ) {
                    return concurso;
                }
                
            }
            
        }
        
        return null;
        
    }

    @Override
    public Concurso pesquisarPorId(int id) throws SQLException {
        
        Datas datas            = new Datas();
        Concurso concurso      = new Concurso();
        
        String sql             = " SELECT * FROM concurso WHERE id_concurso = ? ";
               
        Connection connection  = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {
            
            concurso.setIdConcurso( rs.getInt( "id_concurso" ) );
            concurso.setMinisterio( rs.getString( "ministerio" ) );
            concurso.setInstituicao( rs.getString( "instituicao" ) );
            concurso.setArea( rs.getString( "area" ) );
            concurso.setEdital( rs.getString( "edital" ) );
            concurso.setDataInicio( rs.getDate("data_inicio") );
            concurso.setHoraInicio( rs.getDate("data_inicio") );
            concurso.setTemProvaEscrita( rs.getBoolean( "tem_prova_escrita" ) );
            concurso.setTemProvaTitulos( rs.getBoolean( "tem_prova_titulo" ) );
            concurso.setTemProvaDidática( rs.getBoolean( "tem_prova_didatica" ) );
            concurso.setTemProvaMemorial( rs.getBoolean( "tem_prova_memorial" ) );
            
            CampusDao campusDao = new CampusDao();
            concurso.setCampus( (Campus) campusDao.pesquisarPorId( rs.getInt( "id_campus" ) ) );
            
            ClasseConcursoDao classeConcursoDao = new ClasseConcursoDao();
            concurso.setClasseConcurso( (ClasseConcurso) classeConcursoDao.pesquisarPorId( rs.getInt( "id_classe_concurso" ) ) );
            
        }
        
        return concurso;
        
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
