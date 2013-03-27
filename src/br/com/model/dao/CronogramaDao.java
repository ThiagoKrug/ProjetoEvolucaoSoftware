/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.Abertura;
import br.com.model.entity.Cronograma;
import br.com.model.entity.IEntidade;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CronogramaDao implements IDao {

    private class Fields {

        private String table_name = "cronograma";
        private String[][] campos = {
            {"id_cronograma", "Integer"},
            {"local", "String"},
            {"atividade", "String"},
            {"data", "Date"},
            {"id_concurso", "Integer"},
            {"horario", "Time"}
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
            qms += "?)";
            sql += this.campos[i][0] + ") VALUES " + qms;
            return sql;
        }

        public void prepare(PreparedStatement stmt, Cronograma cronograma) throws SQLException {
            try {
                HashMap<String, Method[]> map = cronograma.getTablemap();
                int i = 1;
                while (i < this.campos.length) {
                    Method method = map.get(this.campos[i][0])[0];
                    Object obj = method.invoke(cronograma, new Object[]{});
                    System.out.println(obj);
                    this.setStatement(i, stmt, obj);
                    i++;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
//            stmt.setDate(1, new java.sql.Date(cronograma.getHoraInicio().getTime()));
//            stmt.setString(2, cronograma.getLocal());
//            stmt.setString(3, cronograma.getPortaria());
//            stmt.setString(4, cronograma.getEmissor());
//            stmt.setInt(5, cronograma.getIdConcurso());
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

            if (s.equals("Time")) {
                return 4;
            }
            return -1;
        }

        public void setStatement(Integer i, PreparedStatement stmt, Object stuff) throws SQLException {
            switch (this.s_to_int(this.campos[i][1])) {
                case 0:
                    stmt.setInt(i, (Integer) stuff);
                    break;
                case 1:
                    stmt.setString(i, (String) stuff);
                    break;
                case 2:
                    java.util.Date date = (java.util.Date) stuff;
                    stmt.setDate(i, new java.sql.Date(date.getTime()));
                    break;
                case 3:
                    stmt.setBoolean(i, (Boolean) stuff);
                    break;
                case 4:
                    stmt.setTime(i, new java.sql.Time(((Date) stuff).getTime()));
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

        public void prepareUpdate(PreparedStatement stmt, Cronograma cronograma) throws SQLException {
            this.prepare(stmt, cronograma);
            Integer endField = this.campos.length;
            String idField = this.campos[0][0];
            try {
                Method method = cronograma.getTablemap().get(idField)[0];
                stmt.setInt(endField, (Integer) method.invoke(cronograma, new Object[]{}));
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
            String sql = "SELECT * FROM " + this.table_name + " WHERE "
                    + this.campos[0][0] + " = ?";
            return sql;
        }

        public void setsFromDatabase(Cronograma cronograma, ResultSet rs) throws SQLException {
            try {
                int i = 0;
                HashMap<String, Method[]> map = cronograma.getTablemap();
                while (i < this.campos.length) {
                    Method method = map.get(this.campos[i][0])[1];
                    method.invoke(cronograma, new Object[]{
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
//            cronograma.setEmissor(rs.getString(this.campos[4][0]));
//            cronograma.setHoraInicio(rs.getDate(this.campos[1][0]));
//            cronograma.setIdCronograma(rs.getInt(this.campos[0][0]));
//            cronograma.setIdConcurso(rs.getInt(this.campos[5][0]));
//            cronograma.setLocal(rs.getString(this.campos[2][0]));
//            cronograma.setPortaria(rs.getString(this.campos[3][0]));
        }

        public String getAllSql() {
            String sql = "SELECT * FROM " + this.table_name;
            return sql;
        }
    }

    @Override
    public IEntidade inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof Cronograma) {
            Cronograma cronograma = (Cronograma) entidade;
            Fields fields = new Fields();
            String sql = fields.getInsertSql();
            Connection connection = ConnectionFactory.getConnection();
//            try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            fields.prepare(stmt, cronograma);
           // System.out.println(stmt.toString());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                cronograma.setIdCronograma(rs.getInt(1));
            }
//            }
            return cronograma;
        }
        return null;
    }

    @Override
    public IEntidade alterar(IEntidade entidade) throws SQLException {
        if (entidade instanceof Cronograma) {

            Cronograma cronograma = (Cronograma) entidade;
            Fields fields = new Fields();
            String sql = fields.getUpdateSql();

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            fields.prepareUpdate(stmt, cronograma);

            if (stmt.executeUpdate() == 1) {
                return cronograma;
            }
        }
        return null;
    }

    @Override
    public IEntidade excluir(IEntidade entidade) throws SQLException {
        if (entidade instanceof Cronograma) {
            Cronograma cronograma = (Cronograma) entidade;
            Fields fields = new Fields();
            String sql = fields.getDeleteSql();

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cronograma.getIdCronograma());

            if (stmt.executeUpdate() == 1) {
                return cronograma;
            }
        }
        return null;
    }

    @Override
    public IEntidade pesquisarPorId(int id) throws SQLException {
        Fields fields = new Fields();
        String sql = fields.getGetIdSql();

        System.out.println(sql);
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Cronograma cronograma = new Cronograma();
        if (rs.next()) {
            fields.setsFromDatabase(cronograma, rs);
        }
        return cronograma;
    }

    @Override
    public List<Cronograma> pesquisarTodos() throws SQLException {
        List<Cronograma> cronogramas = new ArrayList<Cronograma>();
        Fields fields = new Fields();
        String sql = fields.getAllSql();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Cronograma cronograma = new Cronograma();
            fields.setsFromDatabase(cronograma, rs);
            cronogramas.add(cronograma);
        }
        return cronogramas;
    }
    
    
    public List<Cronograma> pesquisarPorIdConcurso(int idConcurso) throws SQLException {
        String sql = "SELECT * FROM cronograma where id_concurso = ?";
        List<Cronograma> cronogramas = new ArrayList<Cronograma>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idConcurso);
        System.out.println(stmt.toString());
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Cronograma cronograma = new Cronograma();
            //abertura.setIdAbertura(rs.getInt("id_abertura"));
            cronograma.setIdCronograma(rs.getInt("id_cronograma"));
            cronograma.setAtividade(rs.getString("atividade"));
            //concurso.setDataInicio( rs.getDate("data_inicio") );
            cronograma.setData(rs.getDate("data"));
            //abertura.setHoraInicio(rs.getTime("hora_inicio"));
            cronograma.setHorario(rs.getTime("horario"));
            cronograma.setLocal(rs.getString("local"));
            cronograma.setIdConcurso(rs.getInt("id_concurso"));
            //fields.setsFromDatabase(cronograma, rs);
            cronogramas.add(cronograma);
        }
        return cronogramas;
    }
    @Override
    public List<? extends IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   /* 
    public Abertura pesquisarPorIdConcurso(int idConcurso) throws SQLException {
        String sql = "SELECT * FROM abertura where id_concurso = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idConcurso);
        System.out.println(stmt.toString());
        ResultSet rs = stmt.executeQuery();

        Abertura abertura = null;
        if (rs.next()) {
            abertura = new Abertura();
            abertura.setIdAbertura(rs.getInt("id_abertura"));
            //bancaExaminadora.setIdBanca(rs.getInt("id_banca_examinadora"));
            abertura.setIdConcurso(rs.getInt("id_concurso"));
            abertura.setHoraInicio(rs.getTime("hora_inicio"));
            abertura.setLocal(rs.getString("local"));
            abertura.setPortaria(rs.getString("portaria"));
            abertura.setEmissor(rs.getString("emissor"));
        }
        return abertura;
    } */
    
    
    
    
}
