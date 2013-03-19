/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.Abertura;
import br.com.model.entity.IEntidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class AberturaDao implements IDao {
    
    private class Fields {
        
        private String table_name = "abertura";
        
        private String[][] campos =
        {
            {"id_abertura", "Integer"},
            {"hora_inicio", "Date"},
            {"local", "String"},
            {"portaria", "String"},
            {"emissor", "String"},
            {"id_concurso", "Integer"}
        };
        
        public String getInsertSql() {
            String sql = "INSERT INTO " + this.table_name + " (";
            String qms = "(";
            int i = 1;
            while (i < this.campos.length - 1) {
                sql += this.campos[i][0] + ", ";
                qms += "?, ";
                i++;
            }
            qms += ")";
            sql += this.campos[i][0] + ") VALUES " + qms;
            return sql;
        }
        
        public void prepare(PreparedStatement stmt, Abertura abertura) throws SQLException{
            stmt.setDate(1, new java.sql.Date(abertura.getHoraInicio().getTime()));
            stmt.setString(2, abertura.getLocal());
            stmt.setString(3, abertura.getPortaria());
            stmt.setString(4, abertura.getEmissor());
            stmt.setInt(5, abertura.getIdConcurso());
        }
        
        public String getUpdateSql() {
            String sql = "UPDATE " + this.table_name + " SET ";
            int i = 1;
            while (i < this.campos.length - 1) {
                sql += this.campos[i][0] + " = ?, ";
                i++;
            }
            sql += this.campos[i][0] + "WHERE " + this.campos[0][0] + " = ?";
            return sql;
        }
        
        public void prepareUpdate(PreparedStatement stmt, Abertura abertura) throws SQLException {
            this.prepare(stmt, abertura);
            stmt.setInt(6, abertura.getIdAbertura());
        }
        
        public String getDeleteSql() {
            String sql = "DELETE FROM " + this.table_name + " WHERE "
                    + this.campos[0][0] + " = ?";
            return sql;
        }
        
        public String getGetIdSql() {
            String sql = "SELECT * FROM " + this.table_name + " "
                    + this.campos[0][0] + " = ?";
            return sql;
        }
        
        public void setsFromDatabase(Abertura abertura, ResultSet rs) throws SQLException {
            abertura.setEmissor(rs.getString(this.campos[4][0]));
            abertura.setHoraInicio(rs.getDate(this.campos[1][0]));
            abertura.setIdAbertura(rs.getInt(this.campos[0][0]));
            abertura.setIdConcurso(rs.getInt(this.campos[5][0]));
            abertura.setLocal(rs.getString(this.campos[2][0]));
            abertura.setPortaria(rs.getString(this.campos[3][0]));
        }
        
        public String getAllSql() {
            String sql = "SELECT * FROM " + this.table_name;
            return sql;
        }
        
        
    }

    @Override
    public IEntidade inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof Abertura) {
            Abertura abertura = (Abertura) entidade;
            Fields fields = new Fields();
            String sql = fields.getInsertSql();
            Connection connection = ConnectionFactory.getConnection();
            try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                fields.prepare(stmt, abertura);
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    abertura.setIdAbertura(rs.getInt(1));
                }
            }
            return abertura;
        }
        return null;
    }

    @Override
    public IEntidade alterar(IEntidade entidade) throws SQLException {
        if (entidade instanceof Abertura) {

            Abertura abertura = (Abertura) entidade;
            Fields fields = new Fields();
            String sql = fields.getUpdateSql();

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            fields.prepareUpdate(stmt, abertura);

            if (stmt.executeUpdate() == 1) {
                return abertura;
            }
        }
        return null;
    }

    @Override
    public IEntidade excluir(IEntidade entidade) throws SQLException {
        if (entidade instanceof Abertura) {
            Abertura abertura = (Abertura) entidade;
            Fields fields = new Fields();
            String sql = fields.getDeleteSql();

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, abertura.getIdAbertura());

            if (stmt.executeUpdate() == 1) {
                return abertura;
            }
        }
        return null;
    }

    @Override
    public IEntidade pesquisarPorId(int id) throws SQLException {
        Fields fields = new Fields();
        String sql = fields.getGetIdSql();

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Abertura abertura = null;
        if (rs.next()) {
            fields.setsFromDatabase(abertura, rs);
        }
        return abertura;
    }

    @Override
    public List<? extends IEntidade> pesquisarTodos() throws SQLException {
        List<Abertura> aberturas = new ArrayList<Abertura>();
        Fields fields = new Fields();
        String sql = fields.getAllSql();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Abertura abertura = new Abertura();
            fields.setsFromDatabase(abertura, rs);
            aberturas.add(abertura);
        }
        return aberturas;
    }

    @Override
    public List<? extends IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
