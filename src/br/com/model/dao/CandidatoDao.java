
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.Candidato;
import br.com.model.entity.IEntidade;
import br.com.model.entity.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Thiago Lima <thiagolimaes@gmail.com>
 */
public class CandidatoDao implements IDao {

    @Override
    public Candidato inserir(IEntidade entidade) throws SQLException {
        
        if ( entidade instanceof Candidato ) {
            
            Candidato candidato = (Candidato) entidade;
            
            String sql  = " INSERT INTO `candidato` (";
                   sql += "   id_pessoa,id_concurso,apto_prova_escrita,apto_prova_didatica,";
                   sql += "   id_prova_didatica,id_prova_escrita";
                   sql += " ) VALUES (?,?,?,?,?,?) ";
            Connection connection = ConnectionFactory.getConnection();       
            
            try {
                
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                if (candidato.getIdPessoa() != 0) {
                    stmt.setInt(1, candidato.getIdPessoa());
                } else {
                    stmt.setString(1, null);
                }
                
                if (candidato.getIdConcurso() != 0) {
                    stmt.setInt(2, candidato.getIdConcurso());
                } else {
                    stmt.setString(2, null);
                }
                
                stmt.setBoolean(3, candidato.isAptoProvaEscrita());
                stmt.setBoolean(4, candidato.isAptoProvaDidatica());
                
                if (candidato.getIdProvaDidatica() != 0) {
                    stmt.setInt(5, candidato.getIdProvaDidatica());
                } else {
                    stmt.setString(5, null);
                }
                
                if (candidato.getIdProvaEscrita() != 0) {
                    stmt.setInt(6, candidato.getIdProvaEscrita());
                } else {
                    stmt.setString(6, null);
                }
                
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                
                if (rs.next()) {
                    candidato.setIdCandidato(rs.getInt(1));
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            return candidato;
            
        }
        
        return null;
        
    }

    @Override
    public Candidato alterar(IEntidade entidade) throws SQLException {
        
        if ( entidade instanceof Candidato ) {
            
            Candidato candidato   = (Candidato) entidade;
            Connection connection = ConnectionFactory.getConnection();
            
            String  sql  = " UPDATE `candidato` SET ";
                    sql += "     id_pessoa = ?, ";
                    sql += "     id_concurso = ?, ";
                    sql += "     apto_prova_escrita = ?, ";
                    sql += "     apto_prova_didatica = ?, ";
                    sql += "     id_prova_didatica = ?, ";
                    sql += "     id_prova_escrita = ? ";
                    sql += " WHERE id_candidato = ? ";
                    
            try {
                
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        
                if ( candidato.getIdPessoa() != 0 ) {
                    stmt.setInt(1, candidato.getIdPessoa());
                } else {
                    stmt.setString(1, null);
                }
                
                if ( candidato.getIdConcurso() != 0 ) {
                    stmt.setInt(2, candidato.getIdConcurso());
                } else {
                    stmt.setString(2, null);
                }
                
                stmt.setBoolean(3, candidato.isAptoProvaEscrita());
                stmt.setBoolean(4, candidato.isAptoProvaDidatica());
                
                if ( candidato.getIdProvaDidatica() != 0 ) {
                    stmt.setInt(5, candidato.getIdProvaDidatica());
                } else {
                    stmt.setString(5, null);
                }
                
                if (candidato.getIdProvaEscrita() != 0) {
                    stmt.setInt(6, candidato.getIdProvaEscrita());
                } else {
                    stmt.setString(6, null);
                }
                
                if ( stmt.executeUpdate() == 1 ) {
                    return candidato;
                }
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
        return null;
        
    }

    @Override
    public Candidato excluir(IEntidade entidade) throws SQLException {
        
        if ( entidade instanceof Candidato ) {
            
            Candidato candidato   = (Candidato) entidade;
            Connection connection = ConnectionFactory.getConnection();
            
            String sql  = " DELETE FROM `candidato` WHERE id_candidato = ? ";
            
            try {
                
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                stmt.setInt(1, candidato.getIdCandidato());
                
                if ( stmt.executeUpdate() == 1 ) {
                    return candidato;
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
        return null;
        
    }

    @Override
    public Candidato pesquisarPorId(int id) throws SQLException {
        
        Candidato candidato    = new Candidato();
        String sql             = " SELECT * FROM candidato WHERE id_candidato = ? ";
        
        Connection connection  = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {
            
            candidato.setIdCandidato( rs.getInt( "id_candidato" ) );
            candidato.setIdPessoa( rs.getInt( "id_pessoa" ) );
            candidato.setIdConcurso( rs.getInt( "id_concurso" ) );
            candidato.setAptoProvaEscrita( rs.getBoolean( "apto_prova_escrita" ) );
            candidato.setAptoProvaDidatica( rs.getBoolean( "apto_prova_didatica" ) );
            candidato.setIdProvaDidatica( rs.getInt( "id_prova_didatica" ) );
            candidato.setIdProvaEscrita( rs.getInt( "id_prova_escrita" ) );
            
            PessoaDao pessoaDao = new PessoaDao();
            Pessoa pessoa       = pessoaDao.pesquisarPorId( candidato.getIdPessoa() );
            
            candidato.setNome( pessoa.getNome() );
            candidato.setSexo( pessoa.getSexo() );
            candidato.setDataNascimento( pessoa.getDataNascimento() );
            
        }
        
        if ( candidato.getIdCandidato() != 0 ) {
            return candidato;
        } else {
            return null;
        }
        
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
        List<Candidato> listCandidato = new ArrayList<Candidato>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {
            
            Candidato candidato = new Candidato();
            
            candidato.setIdCandidato( rs.getInt( "id_candidato" ) );
            candidato.setIdPessoa( rs.getInt( "id_pessoa" ) );
            candidato.setIdConcurso( rs.getInt( "id_concurso" ) );
            candidato.setAptoProvaEscrita( rs.getBoolean( "apto_prova_escrita" ) );
            candidato.setAptoProvaDidatica( rs.getBoolean( "apto_prova_didatica" ) );
            candidato.setIdProvaDidatica( rs.getInt( "id_prova_didatica" ) );
            candidato.setIdProvaEscrita( rs.getInt( "id_prova_escrita" ) );
            
            candidato.setNome( rs.getString( "nome" ) );
            candidato.setSexo( rs.getString( "sexo" ) );
            candidato.setDataNascimento( rs.getDate( "data_nascimento" ) );
            
            listCandidato.add(candidato);
            
        }
        
        return listCandidato;
        
    }
    
}
