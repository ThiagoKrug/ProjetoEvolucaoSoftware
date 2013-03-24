/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
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
 *
 * @author Helison
 */
public class PessoaDao implements IDao {

    @Override
    public Pessoa inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof Pessoa) {
            Pessoa pessoa = (Pessoa) entidade;

            String sql = "insert into pessoa (id_pessoa, nome, sexo, data_nascimento)";
            sql += " values (?,?,?,?)";

            Connection connection = ConnectionFactory.getConnection();

            try {
                
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                if (pessoa.getIdPessoa() != 0) {
                    stmt.setInt(1, pessoa.getIdPessoa());
                } else {
                    stmt.setString(1, null);
                }
                stmt.setString(2, pessoa.getNome());
                stmt.setString(3, pessoa.getSexo());
                if (pessoa.getDataNascimento() != null) {
                    stmt.setDate(4, new java.sql.Date(pessoa.getDataNascimento().getTime()));
                } else {
                    stmt.setString(4, null);
                }

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    pessoa.setIdPessoa(rs.getInt(1));
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            return pessoa;

        }
        return null;

    }

    @Override
    public Pessoa alterar(IEntidade entidade) throws SQLException {
        if (entidade instanceof Pessoa) {
            Pessoa pessoa = (Pessoa) entidade;
            String sql = "UPDATE pessoa SET"
                    + " id_pessoa = ?,"
                    + " nome = ?,"
                    + " sexo = ?,"
                    + " data_nascimento = ?,"
                    + " WHERE id_pessoa = ?";
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, pessoa.getIdPessoa());
            stmt.setString(2, pessoa.getNome());
            stmt.setString(3, pessoa.getSexo());
            stmt.setDate(4, new java.sql.Date(pessoa.getDataNascimento().getTime()));

            if (stmt.executeUpdate() == 1) {
                return pessoa;
            }

        }
        return null;
    }

    @Override
    public Pessoa excluir(IEntidade entidade) throws SQLException {
        Pessoa pessoa = (Pessoa) entidade;
        String sql = "DELETE FROM pessoa WHERE id_pessoa = ? ";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, pessoa.getIdPessoa());


        if (stmt.executeUpdate() == 1) {
            return pessoa;
        }
        return null;
    }

    @Override
    public Pessoa pesquisarPorId(int id) throws SQLException {
        String sql = "SELECT * from pessoa WHERE id_pessoa = ? ";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Pessoa pessoa = null;

        if (rs.next()) {
            pessoa = new Pessoa();
            pessoa.setIdPessoa(rs.getInt("id_pessoa"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setSexo(rs.getString("sexo"));
            pessoa.setDataNascimento(rs.getDate("data_nascimento"));
        }

        return pessoa;

    }

    @Override
    public List<? extends IEntidade> pesquisarTodos() throws SQLException {
        String sql = "SELECT * from pessoa";
        List<Pessoa> listPessoa = pesquisar(sql);
        return listPessoa;
    }

    @Override
    public List<? extends IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        String sql = "SELECT * from pessoa ORDER BY " + criterioOrdenamento;
        List<Pessoa> listPessoa = pesquisar(sql);
        return listPessoa;
    }

    private List<Pessoa> pesquisar(String sql) throws SQLException {
        List<Pessoa> listPessoa = new ArrayList<Pessoa>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Pessoa pessoa = new Pessoa();
            pessoa.setIdPessoa(rs.getInt("id_pessoa"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setSexo(rs.getString("sexo"));
            pessoa.setDataNascimento(rs.getDate("data_nascimento"));
            listPessoa.add(pessoa);

        }

        return listPessoa;
    }
}
