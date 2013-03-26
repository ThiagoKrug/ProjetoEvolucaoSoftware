package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.Candidato;
import br.com.model.entity.Candidato;
import br.com.model.entity.IEntidade;
import br.com.model.entity.Pessoa;
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
 * @author Thiago Lima <thiagolimaes@gmail.com>
 */
public class CandidatoDao implements IDao {

    private class Fields {

        private String table_name = "candidato";
        private String[][] campos = {
            {"id_candidato", "Integer"},
            {"id_pessoa", "Integer"},
            {"id_concurso", "Integer"},
            {"id_prova_escrita", "Integer"},
            //{"id_prova_didatica", "Integer"},
            {"apto_prova_escrita", "Boolean"},
            {"apto_prova_didatica", "Boolean"}
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

        public void prepare(PreparedStatement stmt, Candidato candidato) throws SQLException {
            try {
                HashMap<String, Method[]> map = candidato.getTablemap();
                int i = 1;
                while (i < this.campos.length) {
                    Method method = map.get(this.campos[i][0])[0];
                    //this.setStatement(i, stmt, method.invoke(candidato, new Object[] {}));
                    Object obj = method.invoke(candidato, new Object[]{});
                    System.out.println(obj);
                    this.setStatement(i, stmt, obj);




                    i++;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
//            stmt.setDate(1, new java.sql.Date(candidato.getHoraInicio().getTime()));
//            stmt.setString(2, candidato.getLocal());
//            stmt.setString(3, candidato.getPortaria());
//            stmt.setString(4, candidato.getEmissor());
//            stmt.setInt(5, candidato.getIdConcurso());
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

        public void prepareUpdate(PreparedStatement stmt, Candidato candidato) throws SQLException {
            this.prepare(stmt, candidato);
            Integer endField = this.campos.length;
            String idField = this.campos[0][0];
            try {
                Method method = candidato.getTablemap().get(idField)[0];
                stmt.setInt(endField, (Integer) method.invoke(candidato, new Object[]{}));
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

        public void setsFromDatabase(Candidato candidato, ResultSet rs) throws SQLException {
            try {
                int i = 0;
                HashMap<String, Method[]> map = candidato.getTablemap();
                while (i < this.campos.length) {
                    Method method = map.get(this.campos[i][0])[1];
                    method.invoke(candidato, new Object[]{
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
//            candidato.setEmissor(rs.getString(this.campos[4][0]));
//            candidato.setHoraInicio(rs.getDate(this.campos[1][0]));
//            candidato.setIdCandidato(rs.getInt(this.campos[0][0]));
//            candidato.setIdConcurso(rs.getInt(this.campos[5][0]));
//            candidato.setLocal(rs.getString(this.campos[2][0]));
//            candidato.setPortaria(rs.getString(this.campos[3][0]));
        }

        public String getAllSql() {
            String sql = "SELECT * FROM " + this.table_name;
            return sql;
        }
    }

    @Override
    public Candidato inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof Candidato) {

            Candidato candidato = (Candidato) entidade;
            Fields fields = new Fields();
            String sql = fields.getInsertSql();
            Connection connection = ConnectionFactory.getConnection();
//            try {
            
            PessoaDao pdao = new PessoaDao();
            pdao.inserir(candidato);
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                fields.prepare(stmt, candidato);
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    candidato.setIdCandidato(rs.getInt(1));
                }
//            }
            return candidato;
        }
        return null;
        
    }
    
    @Override
    public Candidato alterar(IEntidade entidade) throws SQLException {
        
        if (entidade instanceof Candidato) {

            Candidato candidato = (Candidato) entidade;
            Fields fields = new Fields();
            String sql = fields.getUpdateSql();

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            fields.prepareUpdate(stmt, candidato);

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
            Fields fields = new Fields();
            String sql = fields.getDeleteSql();

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, candidato.getIdCandidato());

            if (stmt.executeUpdate() == 1) {
                return candidato;
            }
        }

        return null;

    }

    @Override
    public Candidato pesquisarPorId(int id) throws SQLException {

        Fields fields = new Fields();
        String sql = fields.getGetIdSql();
        Candidato candidato = new Candidato();

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            fields.setsFromDatabase(candidato, rs);
        }
        return candidato;
        

    }

    @Override
    public List<Candidato> pesquisarTodos() throws SQLException {

        String sql = "SELECT * FROM candidato as c, pessoa as p where c.id_pessoa = p.id_pessoa";
        List<Candidato> listCandidato = pesquisar(sql);

        return listCandidato;

    }

    @Override
    public List<Candidato> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {

        String sql = "SELECT * FROM candidato as c, pessoa as p where c.id_pessoa = p.id_pessoa ORDER BY " + criterioOrdenamento;
        List<Candidato> listCandidato = pesquisar(sql);

        return listCandidato;

    }

    private List<Candidato> pesquisar(String sql) throws SQLException {
        List<Candidato> listCandidato = new ArrayList<Candidato>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Candidato candidato = new Candidato();
            
            candidato.setIdCandidato( rs.getInt( "id_candidato" ) );
            candidato.setIdPessoa( rs.getInt( "id_pessoa" ) );
            candidato.setIdConcurso( rs.getInt( "id_concurso" ) );
            candidato.setAptoProvaEscrita( rs.getBoolean( "apto_prova_escrita" ) );
            candidato.setAptoProvaDidatica( rs.getBoolean( "apto_prova_didatica" ) );
//            candidato.setIdProvaDidatica( rs.getInt( "id_prova_didatica" ) );
            candidato.setIdProvaEscrita( rs.getInt( "id_prova_escrita" ) );
            
            candidato.setNome( rs.getString( "nome" ) );
            candidato.setSexo( rs.getString( "sexo" ) );
            candidato.setDataNascimento( rs.getDate( "data_nascimento" ) );

            listCandidato.add(candidato);

        }

        return listCandidato;

    }

    public List<Candidato> pesquisarPorIdConcurso(int idConcurso) throws SQLException {
        String sql = "SELECT * FROM candidato as c, pessoa as p where c.id_pessoa = p.id_pessoa and id_concurso = ?";
        List<Candidato> candidatos = new ArrayList<>();

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idConcurso);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Candidato candidato = new Candidato();
            candidato.setIdCandidato(rs.getInt("id_candidato"));
            candidato.setIdPessoa(rs.getInt("id_pessoa"));
            candidato.setIdConcurso(rs.getInt("id_concurso"));
            candidato.setAptoProvaEscrita(rs.getBoolean("apto_prova_escrita"));
            candidato.setAptoProvaDidatica(rs.getBoolean("apto_prova_didatica"));
            //candidato.setIdProvaDidatica( rs.getInt( "id_prova_didatica" ) );
            candidato.setIdProvaEscrita(rs.getInt("id_prova_escrita"));

            PessoaDao pessoaDao = new PessoaDao();
            Pessoa pessoa = pessoaDao.pesquisarPorId(candidato.getIdPessoa());

            candidato.setNome(pessoa.getNome());
            candidato.setSexo(pessoa.getSexo());
            candidato.setDataNascimento(pessoa.getDataNascimento());

            candidatos.add(candidato);
        }

        if (candidatos.size() > 0) {
            return candidatos;
        } else {
            return null;
        }
    }
}
