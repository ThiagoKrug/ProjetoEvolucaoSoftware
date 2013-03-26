package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.Candidato;
import br.com.model.entity.Concurso;
import br.com.model.entity.IEntidade;
import br.com.model.entity.ProvaEscrita;
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
 * @author thiago
 */
public class CandidatoDao implements IDao {

    @Override
    public Candidato inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof Candidato) {
            Candidato candidato = (Candidato) entidade;

            String sql = "INSERT into candidato ("
                    + "id_pessoa, "
                    + "id_concurso, "
                    + "apto_prova_escrita, "
                    + "apto_prova_didatica, "
                    + "id_prova_escrita "
                    + ") VALUES (?, ?, ?, ?, ?)";
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, candidato.getIdPessoa());
            stmt.setInt(2, candidato.getConcurso().getIdConcurso());
            stmt.setBoolean(3, candidato.getAptoProvaEscrita());
            stmt.setBoolean(4, candidato.getAptoProvaDidatica());
            stmt.setInt(5, candidato.getProvaEscrita().getIdProvaEscrita());

            System.out.println(stmt.toString());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                candidato.setIdCandidato(rs.getInt(1));
                return candidato;
            }
        }
        return null;
    }

    @Override
    public Candidato alterar(IEntidade entidade) throws SQLException {
        if (entidade instanceof Candidato) {
            Candidato candidato = (Candidato) entidade;

            String sql = "UPDATE candidato SET ("
                    + "id_pessoa = ?, "
                    + "id_concurso = ?, "
                    + "apto_prova_escrita = ?, "
                    + "apto_prova_didatica = ?, "
                    + "id_prova_escrita = ? "
                    + "WHERE id_candidato = ?";
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, candidato.getIdPessoa());
            stmt.setInt(2, candidato.getConcurso().getIdConcurso());
            stmt.setBoolean(3, candidato.getAptoProvaEscrita());
            stmt.setBoolean(4, candidato.getAptoProvaDidatica());
            stmt.setInt(5, candidato.getProvaEscrita().getIdProvaEscrita());
            stmt.setInt(6, candidato.getIdCandidato());

            System.out.println(stmt.toString());
            if (stmt.executeUpdate() == 1) {
                return candidato;
            }
        }
        return null;
    }

    @Override
    public Candidato excluir(IEntidade entidade) throws SQLException {
        if (entidade instanceof Candidato) {
            Candidato candidato = (Candidato) entidade;
            String sql = "DELETE FROM candidato WHERE id_candidato = ? ";

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, candidato.getIdCandidato());

            System.out.println(stmt.toString());
            if (stmt.executeUpdate() == 1) {
                return candidato;
            }
        }
        return null;
    }

    @Override
    public Candidato pesquisarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM candidato where id_candidato = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);

        System.out.println(stmt.toString());
        ResultSet rs = stmt.executeQuery();

        Candidato candidato = null;
        if (rs.next()) {
            candidato = setsFromDatabase(rs);
        }
        return candidato;
    }

    @Override
    public List<Candidato> pesquisarTodos() throws SQLException {
        String sql = "SELECT * FROM candidato";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        System.out.println(stmt.toString());
        ResultSet rs = stmt.executeQuery();

        List<Candidato> candidatos = new ArrayList<>();
        while (rs.next()) {
            candidatos.add(setsFromDatabase(rs));
        }
        if (candidatos.size() > 0) {
            return candidatos;
        }
        return null;
    }

    @Override
    public List<Candidato> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        String sql = "SELECT * FROM candidato ORDER BY " + criterioOrdenamento;

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        System.out.println(stmt.toString());
        ResultSet rs = stmt.executeQuery();

        List<Candidato> candidatos = new ArrayList<>();
        while (rs.next()) {
            candidatos.add(setsFromDatabase(rs));
        }
        if (candidatos.size() > 0) {
            return candidatos;
        }
        return null;
    }

    public List<Candidato> pesquisarPorIdConcurso(int idConcurso) throws SQLException {
        String sql = "SELECT * FROM candidato WHERE id_concurso = ? ";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idConcurso);

        System.out.println(stmt.toString());
        ResultSet rs = stmt.executeQuery();

        List<Candidato> candidatos = new ArrayList<>();
        while (rs.next()) {
            candidatos.add(setsFromDatabase(rs));
        }
        if (candidatos.size() > 0) {
            return candidatos;
        }
        return null;
    }

    private Candidato setsFromDatabase(ResultSet rs) throws SQLException {
        Candidato candidato = new Candidato();
        candidato.setIdCandidato(rs.getInt("id_candidato"));
        candidato.setIdPessoa(rs.getInt("id_pessoa"));
        Concurso concurso = new Concurso();
        concurso.setIdConcurso(rs.getInt("id_concurso"));
        candidato.setConcurso(concurso);
        candidato.setAptoProvaEscrita(rs.getBoolean("apto_prova_escrita"));
        candidato.setAptoProvaDidatica(rs.getBoolean("apto_prova_didatica"));
        ProvaEscrita provaEscrita = new ProvaEscrita();
        provaEscrita.setIdProvaEscrita(rs.getInt("id_prova_escrita"));
        candidato.setProvaEscrita(provaEscrita);

        return candidato;
    }
}
