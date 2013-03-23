package br.com.model.dao;
// 
import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.ClasseConcurso;
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
public class ClasseConcursoDao implements IDao {

    @Override
    public ClasseConcurso inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof ClasseConcurso) {
            ClasseConcurso classeConcurso = (ClasseConcurso) entidade;

            String sql = "insert into classe_concurso(id_classe, nome)";
            sql += " values (?,?)";
            Connection connection = ConnectionFactory.getConnection();
            try {
                
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                if (classeConcurso.getIdClasseConcurso() != 0) {
                    stmt.setInt(1, classeConcurso.getIdClasseConcurso());
                } else {
                    stmt.setString(1, null);
                }
                
                stmt.setString(2, classeConcurso.getNome());
                stmt.executeUpdate();
                
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    classeConcurso.setIdClasseConcurso(rs.getInt(1));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            
            return classeConcurso;
            
        }

        return null;
    }

    @Override
    public ClasseConcurso alterar(IEntidade entidade) throws SQLException {
        if (entidade instanceof ClasseConcurso) {
            ClasseConcurso classeConcurso = (ClasseConcurso) entidade;

            String sql = "UPDATE classe_concurso SET "
                    + " id_classe = ?"
                    + " nome = ?"
                    + " WHERE id_classe = ?";

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, classeConcurso.getIdClasseConcurso());
            stmt.setString(2, classeConcurso.getNome());

            if (stmt.executeUpdate() == 1) {
                return classeConcurso;
            }
        }

        return null;
    }

    @Override
    public ClasseConcurso excluir(IEntidade entidade) throws SQLException {
        ClasseConcurso classeConcurso = (ClasseConcurso) entidade;
        String sql = "DELETE FROM classe_concurso WHERE id_classe = ? ";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, classeConcurso.getIdClasseConcurso());

        if (stmt.executeUpdate() == 1) {
            return classeConcurso;
        }
        return null;
    }

    @Override
    public ClasseConcurso pesquisarPorId(int id) throws SQLException {
        String sql = "SELECT * from classe_concurso WHERE id_classe = ? ";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        ClasseConcurso classeConcurso = null;

        if (rs.next()) {

            classeConcurso = new ClasseConcurso();
            classeConcurso.setIdClasseConcurso(rs.getInt("id_classe"));
            classeConcurso.setNome(rs.getString("nome"));
        }

        return classeConcurso;
    }

    @Override
    public List<ClasseConcurso> pesquisarTodos() throws SQLException {
        String sql = "SELECT * from classe_concurso";
        List<ClasseConcurso> listClasseConcurso = pesquisar(sql);
        return listClasseConcurso;

    }

    @Override
    public List<? extends IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        String sql = "SELECT * from classe_concurso ORDER BY "+criterioOrdenamento;
        List<ClasseConcurso> listClasseConcurso = pesquisar(sql);
        return listClasseConcurso;
    }

    private List<ClasseConcurso> pesquisar(String sql) throws SQLException {
        List<ClasseConcurso> listClasseConcurso = new ArrayList<ClasseConcurso>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ClasseConcurso classeConcurso = new ClasseConcurso();
            classeConcurso.setIdClasseConcurso(rs.getInt("id_classe"));
            classeConcurso.setNome(rs.getString("nome"));
            listClasseConcurso.add(classeConcurso);
        }        
        return listClasseConcurso;
    }
}
