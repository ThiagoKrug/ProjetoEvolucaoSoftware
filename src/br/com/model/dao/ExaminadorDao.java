/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.Examinador;
import br.com.model.entity.IEntidade;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ExaminadorDao implements IDao {
    private class Fields {
        
        private String table_name = "examinador";
        
        private String[][] campos =
        {
            {"id_examinador", "Integer"},
            {"id_titulacao", "Integer"},
            {"id_pessoa", "Integer"}
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
        
        public void prepare(PreparedStatement stmt, Examinador examinador) throws SQLException{
            try {
                HashMap<String, Method[]> map = examinador.getTablemap();
                int i = 1;
                while (i < this.campos.length - 1) {
                    Method method = map.get(this.campos[i][0])[0];
                    this.setStatement(i, stmt, method.invoke(examinador, new Object[] {}));
                    i++;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
//            stmt.setDate(1, new java.sql.Date(examinador.getHoraInicio().getTime()));
//            stmt.setString(2, examinador.getLocal());
//            stmt.setString(3, examinador.getPortaria());
//            stmt.setString(4, examinador.getEmissor());
//            stmt.setInt(5, examinador.getIdConcurso());
        }
        
        private Integer s_to_int(String s) {
            if (s.equals("Integer")) {
                return 0;
            }
            if (s.equals("String")) {
                return 1;
            }
            if (s.equals("Date")) {
                return 2;
            }
            if (s.equals("Boolean")) {
                return 3;
            }
            return -1;
        }
        
        public void setStatement(Integer i, PreparedStatement stmt, Object stuff) throws SQLException{
            switch (this.s_to_int(this.campos[i][1])) {
                case 0:
                    stmt.setInt(i, (Integer)stuff);
                    break;
                case 1:
                    stmt.setString(i, (String)stuff);
                    break;
                case 2:
                    java.util.Date date = (java.util.Date)stuff;
                    stmt.setDate(i, new java.sql.Date(date.getTime()));
                    break;
                case 3:
                    stmt.setBoolean(i, (Boolean)stuff);
                    break;
            }
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
        
        public void prepareUpdate(PreparedStatement stmt, Examinador examinador) throws SQLException {
            this.prepare(stmt, examinador);
            Integer endField = this.campos.length;
            String idField = this.campos[0][0];
            try {
                Method method = examinador.getTablemap().get(idField)[0];
                stmt.setInt(endField, (Integer)method.invoke(examinador, new Object[] {}));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
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
        
        public void setsFromDatabase(Examinador examinador, ResultSet rs) throws SQLException {
            try {
                int i = 0;
                HashMap<String, Method[]> map = examinador.getTablemap();
                while (i < this.campos.length) {
                    Method method = map.get(this.campos[i][0])[1];
                    method.invoke(examinador, new Object [] {
                        method.getParameterTypes()[0].cast(rs.getObject(this.campos[i][0]))
                    });
                    //map.put(this.campos[i][0], rs.getObject(this.campos[i][0]));
                    i++;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
//            examinador.setEmissor(rs.getString(this.campos[4][0]));
//            examinador.setHoraInicio(rs.getDate(this.campos[1][0]));
//            examinador.setIdExaminador(rs.getInt(this.campos[0][0]));
//            examinador.setIdConcurso(rs.getInt(this.campos[5][0]));
//            examinador.setLocal(rs.getString(this.campos[2][0]));
//            examinador.setPortaria(rs.getString(this.campos[3][0]));
        }
        
        
        
        public String getAllSql() {
            String sql = "SELECT * FROM " + this.table_name;
            return sql;
        }
        
        
    }

    @Override
    public IEntidade inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof Examinador) {
            Examinador examinador = (Examinador) entidade;
            ExaminadorDao.Fields fields = new ExaminadorDao.Fields();
            String sql = fields.getInsertSql();
            Connection connection = ConnectionFactory.getConnection();
//            try {
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                fields.prepare(stmt, examinador);
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    examinador.setIdExaminador(rs.getInt(1));
                }
//            }
            return examinador;
        }
        return null;
    }

    @Override
    public IEntidade alterar(IEntidade entidade) throws SQLException {
        if (entidade instanceof Examinador) {

            Examinador examinador = (Examinador) entidade;
            ExaminadorDao.Fields fields = new ExaminadorDao.Fields();
            String sql = fields.getUpdateSql();

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            fields.prepareUpdate(stmt, examinador);

            if (stmt.executeUpdate() == 1) {
                return examinador;
            }
        }
        return null;
    }

    @Override
    public IEntidade excluir(IEntidade entidade) throws SQLException {
        if (entidade instanceof Examinador) {
            Examinador examinador = (Examinador) entidade;
            ExaminadorDao.Fields fields = new ExaminadorDao.Fields();
            String sql = fields.getDeleteSql();

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, examinador.getIdExaminador());

            if (stmt.executeUpdate() == 1) {
                return examinador;
            }
        }
        return null;
    }

    @Override
    public IEntidade pesquisarPorId(int id) throws SQLException {
        ExaminadorDao.Fields fields = new ExaminadorDao.Fields();
        String sql = fields.getGetIdSql();

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Examinador examinador = null;
        if (rs.next()) {
            fields.setsFromDatabase(examinador, rs);
        }
        return examinador;
    }

    @Override
    public List<? extends IEntidade> pesquisarTodos() throws SQLException {
        List<Examinador> examinadors = new ArrayList<Examinador>();
        ExaminadorDao.Fields fields = new ExaminadorDao.Fields();
        String sql = fields.getAllSql();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Examinador examinador = new Examinador();
            fields.setsFromDatabase(examinador, rs);
            examinadors.add(examinador);
        }
        return examinadors;
    }

    @Override
    public List<? extends IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
