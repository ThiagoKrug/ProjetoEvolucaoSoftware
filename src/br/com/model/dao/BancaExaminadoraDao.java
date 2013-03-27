package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.BancaExaminadora;
import br.com.model.entity.Examinador;
import br.com.model.entity.IEntidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author thiago
 */
public class BancaExaminadoraDao implements IDao {

    @Override
    public BancaExaminadora inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof BancaExaminadora) {
            BancaExaminadora bancaExaminadora = (BancaExaminadora) entidade;
            String sql = "insert into banca_examinadora ("
                    + "examinador_1, "
                    + "examinador_2, "
                    + "examinador_3, "
                    + "id_concurso "
                    + ") values (?, ?, ?, ?) ";
            Connection connection = ConnectionFactory.getConnection();

            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            this.setInt(stmt, 1, bancaExaminadora.getPresidente().getIdExaminador());
            this.setInt(stmt, 2, bancaExaminadora.getExaminador2().getIdExaminador());
            this.setInt(stmt, 3, bancaExaminadora.getExaminador3().getIdExaminador());
            this.setInt(stmt, 4, bancaExaminadora.getIdConcurso());

            System.out.println(stmt.toString());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                bancaExaminadora.setIdBanca(rs.getInt(1));
            }
            return bancaExaminadora;
        }
        return null;
    }

    @Override
    public BancaExaminadora alterar(IEntidade entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BancaExaminadora excluir(IEntidade entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BancaExaminadora pesquisarPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BancaExaminadora> pesquisarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BancaExaminadora> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setInt(PreparedStatement stmt, int index, int value) throws SQLException {
        if (value != 0) {
            stmt.setInt(index, value);
        } else {
            stmt.setString(index, null);
        }
    }

    public BancaExaminadora pesquisarPorIdConcurso(int idConcurso) throws SQLException {
        String sql = "SELECT * FROM banca_examinadora where id_concurso = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idConcurso);
        System.out.println(stmt.toString());
        ResultSet rs = stmt.executeQuery();

        BancaExaminadora bancaExaminadora = null;
        if (rs.next()) {
            bancaExaminadora = new BancaExaminadora();
            bancaExaminadora.setIdBanca(rs.getInt("id_banca_examinadora"));
            bancaExaminadora.setIdConcurso(rs.getInt("id_concurso"));

            Examinador examinador1 = new Examinador();
            examinador1.setIdExaminador(rs.getInt("examinador_1"));
            examinador1.setIdPessoa(new ExaminadorDao().pesquisarPorId(rs.getInt("examinador_1")).getIdPessoa());
            bancaExaminadora.setPresidente(examinador1);

            Examinador examinador2 = new Examinador();
            examinador2.setIdExaminador(rs.getInt("examinador_2"));
            examinador2.setIdPessoa(new ExaminadorDao().pesquisarPorId(rs.getInt("examinador_2")).getIdPessoa());
            bancaExaminadora.setExaminador2(examinador2);

            Examinador examinador3 = new Examinador();
            examinador3.setIdExaminador(rs.getInt("examinador_3"));
            examinador3.setIdPessoa(new ExaminadorDao().pesquisarPorId(rs.getInt("examinador_3")).getIdPessoa());
            bancaExaminadora.setExaminador3(examinador3);
        }
        return bancaExaminadora;
    }
}
