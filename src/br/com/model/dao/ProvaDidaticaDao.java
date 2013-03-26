/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.Concurso;
import br.com.model.entity.IEntidade;
import br.com.model.entity.ProvaDidatica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juliano R. M.
 */
public class ProvaDidaticaDao implements IDao {

    @Override
    public IEntidade inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof ProvaDidatica) {

            ProvaDidatica provaDidatica = (ProvaDidatica) entidade;
            String sql_InserirDidaticaDao = "INSERT INTO prova_didatica (id_concurso, local) values(?,?)";
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt_InserirDidaticaDao = connection.prepareStatement(sql_InserirDidaticaDao, Statement.RETURN_GENERATED_KEYS);

            this.setInt(stmt_InserirDidaticaDao, 1, provaDidatica.getConcurso().getIdConcurso());
            stmt_InserirDidaticaDao.setString(2, provaDidatica.getLocalRealizacaoProvaDidatica());
            stmt_InserirDidaticaDao.executeUpdate();

            /*
             if(!provaDidatica.getCandidatosAptosProvaDidatica().isEmpty()){
            
             ArrayList<Candidato> list_CandAptos = provaDidatica.getCandidatosAptosProvaDidatica();
             Iterator<Candidato> iterator = list_CandAptos.iterator();
                    
             while(iterator.hasNext()){
                    
             Candidato obj_Candidato = iterator.next();
             String sql_InsereCandidato = "INSERT INTO ";
             }
             }
             */
            ResultSet rs_ = stmt_InserirDidaticaDao.getGeneratedKeys();

            if (rs_.next()) {

                provaDidatica.setIdProvaDidatica(rs_.getInt(1));
            }
            return provaDidatica;
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
    public List<? extends IEntidade> pesquisarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<? extends IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setInt(PreparedStatement stmt, int index, int value) throws SQLException {
        if (value != 0) {
            stmt.setInt(index, value);
        } else {
            stmt.setString(index, null);
        }
    }

    public int pesquisarPorIdConcurso(int idConcurso) throws SQLException {

        String sql_pesquisaIdConcurso = "SELECT * FROM prova_didatica id_concurso = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt_pesqIdConcurso = connection.prepareStatement(sql_pesquisaIdConcurso);
        stmt_pesqIdConcurso.setInt(1, idConcurso);
        ResultSet rs_IdConcurso = stmt_pesqIdConcurso.executeQuery();

        if (rs_IdConcurso.next()) {

            return rs_IdConcurso.getInt("id_concurso");
        }
        return -1;
    }
}
