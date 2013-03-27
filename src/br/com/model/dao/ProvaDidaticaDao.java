/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.Candidato;
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
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Juliano R. M.
 */
public class ProvaDidaticaDao implements IDao {

    @Override
    public ProvaDidatica inserir(IEntidade entidade) throws SQLException {
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

    /**
     * Inda em CONSTRUÇÃO!
     * @param entidade
     * @return
     * @throws SQLException 
     */
    @Override
    public ProvaDidatica alterar(IEntidade entidade) throws SQLException {

        Connection connection = ConnectionFactory.getConnection();
        ProvaDidatica provaDidatica = (ProvaDidatica) entidade;

        String sql_Altera = "DELETE FROM ";
        PreparedStatement stmtAletrar = connection.prepareStatement(sql_Altera);
        stmtAletrar.setInt(1, provaDidatica.getIdProvaDidatica());
        stmtAletrar.executeUpdate();

        if (!provaDidatica.getCandidatosAptosProvaDidatica().isEmpty()) {

            ArrayList<Candidato> listaAptos = provaDidatica.getCandidatosAptosProvaDidatica();
            Iterator<Candidato> iterator = listaAptos.iterator();

            while (iterator.hasNext()) {

                Candidato objCandidato = iterator.next();
                String sql_InsereApatos = "INSERT INTO ";
                PreparedStatement statement = connection.prepareStatement(sql_InsereApatos, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, objCandidato.getIdCandidato());
                statement.setInt(1, provaDidatica.getIdProvaDidatica());
                statement.executeUpdate();
            }
        }

        String sql_DeletaAptos = "";
        PreparedStatement statement2 = connection.prepareStatement(sql_DeletaAptos);
        statement2.setInt(1, provaDidatica.getIdProvaDidatica());
        statement2.executeUpdate();

        if (!provaDidatica.getCandidatosAptosProvaDidatica().isEmpty()) {

            ArrayList<Candidato> listaAptos = provaDidatica.getCandidatosAptosProvaDidatica();
            Iterator<Candidato> iterator = listaAptos.iterator();
            /*remove todos os candidadtos aptos*/

            while (iterator.hasNext()) {

                Candidato obj_Candidato = iterator.next();
                String sql_Insere = "INSERT INTO ";

                PreparedStatement stmt5 = connection.prepareStatement(sql_Insere, Statement.RETURN_GENERATED_KEYS);
                stmt5.setInt(1, obj_Candidato.getIdCandidato());
                stmt5.setInt(1, provaDidatica.getIdProvaDidatica());
                stmt5.executeUpdate();
            }
        }

        String sql_Update = "UPDATE ";

        PreparedStatement stmt6 = connection.prepareStatement(sql_Update);
//        this.setInt(stmt6, 1, value);
//        this.setInt(stmt6, 2, value);
//        this.setInt(stmt6, 3, value);

        System.out.println(stmt6.toString());
        if (stmt6.executeUpdate() == 1) {

            return provaDidatica;
        }
        return null;
    }

    @Override
    public ProvaDidatica excluir(IEntidade entidade) throws SQLException {
        if (entidade instanceof ProvaDidatica) {

            ProvaDidatica provaDidatica = (ProvaDidatica) entidade;
            String sql_Excluir = "DELETE FROM prova_didatica WHERE id_prova_didatica = ?";

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql_Excluir);
            stmt.setInt(1, provaDidatica.getIdProvaDidatica());

            if (stmt.executeUpdate() == 1) {
                return provaDidatica;
            }
        }
        return null;
    }

    @Override
    public IEntidade pesquisarPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProvaDidatica> pesquisarTodos() throws SQLException {
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
