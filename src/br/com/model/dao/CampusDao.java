package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.Campus;
import br.com.model.entity.IEntidade;
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
public class CampusDao implements IDao {

    @Override
    public Campus inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof Campus) {
            Campus campus = (Campus) entidade;

            String sql = "insert into campus(id_campus, cidade_campus)";
            sql += " values (?,?)";
            Connection connection = ConnectionFactory.getConnection();
            
            try {
                
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        
                if (campus.getIdCampus() != 0) {
                    stmt.setInt(1, campus.getIdCampus());
                } else {
                    stmt.setString(1, null);
                }
                stmt.setString(2, campus.getCidadeCampus());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    campus.setIdCampus(rs.getInt(1));
                }

            } catch (Exception e) {
                
            }
            return campus;
        }

        return null;
    }

    @Override
    public Campus alterar(IEntidade entidade) throws SQLException {
        if (entidade instanceof Campus) {
            Campus campus = (Campus) entidade;

            String sql = "UPDATE campus SET "
                    + " id_campus = ?"
                    + " cidade_campus = ?"
                    + " WHERE id_campus = ?";

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, campus.getIdCampus());
            stmt.setString(2, campus.getCidadeCampus());

            if (stmt.executeUpdate() == 1) {
                return campus;
            }
        }

        return null;
    }

    @Override
    public Campus excluir(IEntidade entidade) throws SQLException {
        Campus campus = (Campus) entidade;
        String sql = "DELETE FROM campus WHERE id_campus = ? ";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, campus.getIdCampus());

        if (stmt.executeUpdate() == 1) {
            return campus;
        }
        return null;
    }

    @Override
    public Campus pesquisarPorId(int id) throws SQLException {
        String sql = "SELECT * from campus WHERE id_campus = ? ";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Campus campus = null;

        if (rs.next()) {

            campus = new Campus();
            campus.setIdCampus(rs.getInt("id_campus"));
            campus.setCidadeCampus(rs.getString("cidade_campus"));
        }

        return campus;
    }

    @Override
    public List<Campus> pesquisarTodos() throws SQLException {
        String sql = "SELECT * from campus";
        List<Campus> listCampus = pesquisar(sql);
        return listCampus;

    }

    @Override
    public List<? extends IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        String sql = "SELECT * from campus ORDER BY "+criterioOrdenamento;
        List<Campus> listCampus = pesquisar(sql);
        return listCampus;
    }

    private List<Campus> pesquisar(String sql) throws SQLException {
        List<Campus> listCampus = new ArrayList<Campus>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Campus campus = new Campus();
            campus.setIdCampus(rs.getInt("id_campus"));
            campus.setCidadeCampus(rs.getString("cidade_campus"));
            listCampus.add(campus);
        }        
        return listCampus;
    }
}
