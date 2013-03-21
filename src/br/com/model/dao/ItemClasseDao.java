/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.ItemClasse;
import br.com.model.entity.ItemClasse;
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
 * @author renanmarceluchoa
 */
public class ItemClasseDao implements IDao {
    
    private class Fields {
        
        private String table_name = "itemClasse";
        
        private String[][] campos =
        {
            {"id_item_classe", "Integer"},
            {"discriminacao", "String"},
            {"pontuacao", "Float"},
            {"id_classe", "Integer"}
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
        
        public void prepare(PreparedStatement stmt, ItemClasse itemClasse) throws SQLException{
            try {
                HashMap<String, Method[]> map = itemClasse.getTablemap();
                int i = 1;
                while (i < this.campos.length - 1) {
                    Method method = map.get(this.campos[i][0])[0];
                    this.setStatement(i, stmt, method.invoke(itemClasse, new Object[] {}));
                    i++;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
//            stmt.setDate(1, new java.sql.Date(itemClasse.getHoraInicio().getTime()));
//            stmt.setString(2, itemClasse.getLocal());
//            stmt.setString(3, itemClasse.getPortaria());
//            stmt.setString(4, itemClasse.getEmissor());
//            stmt.setInt(5, itemClasse.getIdConcurso());
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
            
            if (s.equals("Float")) {
                return 4;
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
                case 4:
                    stmt.setFloat(i, (Float)stuff);
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
        
        public void prepareUpdate(PreparedStatement stmt, ItemClasse itemClasse) throws SQLException {
            this.prepare(stmt, itemClasse);
            Integer endField = this.campos.length;
            String idField = this.campos[0][0];
            try {
                Method method = itemClasse.getTablemap().get(idField)[0];
                stmt.setInt(endField, (Integer)method.invoke(itemClasse, new Object[] {}));
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
        
        public void setsFromDatabase(ItemClasse itemClasse, ResultSet rs) throws SQLException {
            try {
                int i = 0;
                HashMap<String, Method[]> map = itemClasse.getTablemap();
                while (i < this.campos.length) {
                    Method method = map.get(this.campos[i][0])[1];
                    method.invoke(itemClasse, new Object [] {
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
//            itemClasse.setEmissor(rs.getString(this.campos[4][0]));
//            itemClasse.setHoraInicio(rs.getDate(this.campos[1][0]));
//            itemClasse.setIdItemClasse(rs.getInt(this.campos[0][0]));
//            itemClasse.setIdConcurso(rs.getInt(this.campos[5][0]));
//            itemClasse.setLocal(rs.getString(this.campos[2][0]));
//            itemClasse.setPortaria(rs.getString(this.campos[3][0]));
        }
        
        
        
        public String getAllSql() {
            String sql = "SELECT * FROM " + this.table_name;
            return sql;
        }
        
        
    }

    public ItemClasseDao() {
    }

    @Override
    public IEntidade inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof ItemClasse) {
            ItemClasse itemClasse = (ItemClasse) entidade;
            ItemClasseDao.Fields fields = new ItemClasseDao.Fields();
            String sql = fields.getInsertSql();
            Connection connection = ConnectionFactory.getConnection();
            try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                fields.prepare(stmt, itemClasse);
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    itemClasse.setIdItemClasse(rs.getInt(1));
                }
            }
            return itemClasse;
        }
        return null;
    }

    @Override
    public IEntidade alterar(IEntidade entidade) throws SQLException {
        if (entidade instanceof ItemClasse) {

            ItemClasse itemClasse = (ItemClasse) entidade;
            ItemClasseDao.Fields fields = new ItemClasseDao.Fields();
            String sql = fields.getUpdateSql();

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            fields.prepareUpdate(stmt, itemClasse);

            if (stmt.executeUpdate() == 1) {
                return itemClasse;
            }
        }
        return null;
    }

    @Override
    public IEntidade excluir(IEntidade entidade) throws SQLException {
        if (entidade instanceof ItemClasse) {
            ItemClasse itemClasse = (ItemClasse) entidade;
            ItemClasseDao.Fields fields = new ItemClasseDao.Fields();
            String sql = fields.getDeleteSql();

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, itemClasse.getIdItemClasse());

            if (stmt.executeUpdate() == 1) {
                return itemClasse;
            }
        }
        return null;
    }

    @Override
    public IEntidade pesquisarPorId(int id) throws SQLException {
        ItemClasseDao.Fields fields = new ItemClasseDao.Fields();
        String sql = fields.getGetIdSql();

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        ItemClasse itemClasse = null;
        if (rs.next()) {
            fields.setsFromDatabase(itemClasse, rs);
        }
        return itemClasse;
    }

    @Override
    public List<? extends IEntidade> pesquisarTodos() throws SQLException {
        List<ItemClasse> itemClasses = new ArrayList<ItemClasse>();
        ItemClasseDao.Fields fields = new ItemClasseDao.Fields();
        String sql = fields.getAllSql();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ItemClasse itemClasse = new ItemClasse();
            fields.setsFromDatabase(itemClasse, rs);
            itemClasses.add(itemClasse);
        }
        return itemClasses;
    }



    @Override
    public List<? extends IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
