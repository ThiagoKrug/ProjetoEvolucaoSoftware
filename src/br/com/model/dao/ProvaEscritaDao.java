/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.jdbc.ConnectionFactory;
import br.com.model.entity.Candidato;
import br.com.model.entity.IEntidade;
import br.com.model.entity.ProvaEscrita;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class ProvaEscritaDao implements IDao {

    @Override
    public ProvaEscrita inserir(IEntidade entidade) throws SQLException {
        if (entidade instanceof ProvaEscrita) {
            ProvaEscrita provaEscrita = (ProvaEscrita) entidade;
            String sql = "insert into prova_escrita ("
                    + "id_concurso,"
                    + "id_ponto_sorteado_prova_escrita,"
                    + "data_ponto_sorteado,"
                    + "hora_inicio_prova,"
                    + "hora_fim_prova,"
                    + "local_realizacao,"
                    + "hora_inicio_leitura,"
                    + "hora_fim_leitura,"
                    + "local_leitura,"
                    + "hora_inicio_julgamento,"
                    + "local_julgamento,"
                    + "hora_inicio_resultado,"
                    + "local_resultado"
                    + ") values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            Connection connection = ConnectionFactory.getConnection();
            try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                this.setInt(stmt, 1, provaEscrita.getConcurso().getIdConcurso());
                this.setInt(stmt, 2, provaEscrita.getPontoSorteado().getIdPontoProvaEscrita());
                stmt.setDate(3, (Date) provaEscrita.getDataPontoSorteado());
                stmt.setDate(4, (Date) provaEscrita.getHoraInicioProva());
                stmt.setDate(5, (Date) provaEscrita.getHoraFimProva());
                stmt.setString(6, provaEscrita.getLocalRealizacao());
                stmt.setDate(7, (Date) provaEscrita.getHoraInicioLeitura());
                stmt.setDate(8, (Date) provaEscrita.getHoraFimLeitura());
                stmt.setString(9, provaEscrita.getLocalLeitura());
                stmt.setDate(10, (Date) provaEscrita.getHoraInicioJulgamento());
                stmt.setString(11, provaEscrita.getLocalJulgamento());
                stmt.setDate(12, (Date) provaEscrita.getHoraInicioResultado());
                stmt.setString(13, provaEscrita.getLocalResultado());
                stmt.executeUpdate();

                if (provaEscrita.getCandidatosAptosProva().isEmpty() == false) {
                    ArrayList<Candidato> listaAptos = provaEscrita.getCandidatosAptosProva();
                    Iterator<Candidato> iterator = listaAptos.iterator();
                    while (iterator.hasNext()) {
                        Candidato object = iterator.next();
                        String sql2 = "insert into candidatos_aptos_prova_escrita (id_candidato, id_prova_escrita) values(?,?)";
                        PreparedStatement stmt2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
                        stmt2.setInt(1, object.getIdCandidato());
                        stmt2.setInt(2, provaEscrita.getIdProvaEscrita());
                        stmt2.executeUpdate();
                    }
                }


                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    provaEscrita.setIdProvaEscrita(rs.getInt(1));
                }
            }
            return provaEscrita;
        }
        return null;
    }

    @Override
    public ProvaEscrita alterar(IEntidade entidade) throws SQLException {

        if (entidade instanceof ProvaEscrita) {

            ProvaEscrita provaEscrita = (ProvaEscrita) entidade;
            String sql = "UPDATE prova_escrita SET "
                    + "id_concurso = ?,"
                    + "id_ponto_sorteado_prova_escrita = ?,"
                    + "data_ponto_sorteado = ? ,"
                    + "hora_inicio_prova = ?,"
                    + "hora_fim_prova = ?,"
                    + "local_realizacao = ?,"
                    + "hora_inicio_leitura = ?,"
                    + "hora_fim_leitura = ?,"
                    + "local_leitura = ?,"
                    + "hora_inicio_julgamento = ?,"
                    + "local_julgamento = ?,"
                    + "hora_inicio_resultado = ?,"
                    + "local_resultado = ?"
                    + "WHERE id_prova_escrita = ? ";

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            this.setInt(stmt, 1, provaEscrita.getConcurso().getIdConcurso());
            this.setInt(stmt, 2, provaEscrita.getPontoSorteado().getIdPontoProvaEscrita());
            stmt.setDate(3, (Date) provaEscrita.getDataPontoSorteado());
            stmt.setDate(4, (Date) provaEscrita.getHoraInicioProva());
            stmt.setDate(5, (Date) provaEscrita.getHoraFimProva());
            stmt.setString(6, provaEscrita.getLocalRealizacao());
            stmt.setDate(7, (Date) provaEscrita.getHoraInicioLeitura());
            stmt.setDate(8, (Date) provaEscrita.getHoraFimLeitura());
            stmt.setString(9, provaEscrita.getLocalLeitura());
            stmt.setDate(10, (Date) provaEscrita.getHoraInicioJulgamento());
            stmt.setString(11, provaEscrita.getLocalJulgamento());
            stmt.setDate(12, (Date) provaEscrita.getHoraInicioResultado());
            stmt.setString(13, provaEscrita.getLocalResultado());
            stmt.setInt(14, provaEscrita.getIdProvaEscrita());

            if (stmt.executeUpdate() == 1) {
                return provaEscrita;
            }
        }
        return null;
    }

    @Override
    public ProvaEscrita excluir(IEntidade entidade) throws SQLException {
        if (entidade instanceof ProvaEscrita) {
            ProvaEscrita provaEscrita = (ProvaEscrita) entidade;
            String sql = "DELETE FROM prova_escrita WHERE id_prova_escrita = ? ";

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, provaEscrita.getIdProvaEscrita());

            if (stmt.executeUpdate() == 1) {
                return provaEscrita;
            }
        }
        return null;
    }

    @Override
    public ProvaEscrita pesquisarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM prova_escrita where id_prova_escrita = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        ProvaEscrita provaEscrita = null;
        if (rs.next()) {
            provaEscrita = new ProvaEscrita();
            provaEscrita.setIdProvaEscrita(rs.getInt("id_prova_escrita"));
            provaEscrita.setConcurso(new ConcursoDao().pesquisarPorId(rs.getInt("id_concurso")));
            provaEscrita.setLocalJulgamento(rs.getString("local_julgamento"));
            provaEscrita.setLocalLeitura(rs.getString("local_leitura"));
            provaEscrita.setLocalRealizacao(rs.getString("local_realizacao"));
            provaEscrita.setLocalResultado(rs.getString("local_resultado"));
            provaEscrita.setHoraFimLeitura(rs.getDate("hora_fim_leitura"));
            provaEscrita.setHoraFimProva(rs.getDate("hora_fim_prova"));
            provaEscrita.setHoraInicioJulgamento(rs.getDate("hora_inicio_julgamento"));
            provaEscrita.setHoraInicioLeitura(rs.getDate("hora_inicio_leitura"));
            provaEscrita.setHoraInicioProva(rs.getDate("hora_inicio_prova"));
            provaEscrita.setHoraInicioResultado(rs.getDate("hora_inicio_resultado"));
            provaEscrita.setDataPontoSorteado(rs.getDate("data_ponto_sorteado"));
        }
        return provaEscrita;
    }

    @Override
    public List<ProvaEscrita> pesquisarTodos() throws SQLException {
        String sql = "SELECT * FROM prova_escrita";
        List<ProvaEscrita> listProvaEscrita = pesquisar(sql);
        return listProvaEscrita;
    }

    @Override
    public List<ProvaEscrita> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        String sql = "SELECT * FROM prova_escrita ORDER BY " + criterioOrdenamento;
        List<ProvaEscrita> listProvaEscrita = pesquisar(sql);
        return listProvaEscrita;
    }

    private List<ProvaEscrita> pesquisar(String sql) throws SQLException {
        List<ProvaEscrita> listProvaEscrita = new ArrayList<ProvaEscrita>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ProvaEscrita provaEscrita = new ProvaEscrita();
            provaEscrita.setIdProvaEscrita(rs.getInt("id_prova_escrita"));
            provaEscrita.setConcurso(new ConcursoDao().pesquisarPorId(rs.getInt("id_concurso")));
            provaEscrita.setLocalJulgamento(rs.getString("local_julgamento"));
            provaEscrita.setLocalLeitura(rs.getString("local_leitura"));
            provaEscrita.setLocalRealizacao(rs.getString("local_realizacao"));
            provaEscrita.setLocalResultado(rs.getString("local_resultado"));
            provaEscrita.setHoraFimLeitura(rs.getDate("hora_fim_leitura"));
            provaEscrita.setHoraFimProva(rs.getDate("hora_fim_prova"));
            provaEscrita.setHoraInicioJulgamento(rs.getDate("hora_inicio_julgamento"));
            provaEscrita.setHoraInicioLeitura(rs.getDate("hora_inicio_leitura"));
            provaEscrita.setHoraInicioProva(rs.getDate("hora_inicio_prova"));
            provaEscrita.setHoraInicioResultado(rs.getDate("hora_inicio_resultado"));
            provaEscrita.setDataPontoSorteado(rs.getDate("data_ponto_sorteado"));

            /**
             * Buscar candidatos
             */
            String sql2 = "select * from candidato_aptos_prova_escrita as cap, candidato as c, pessoa as p "
                    + "where cap.id_prova_escrita = ? "
                    + "AND cap.id_candidato = c.id_candidato "
                    + "AND p.id_pessoa = c.id_pessoa";
            PreparedStatement stmt2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            stmt2.setInt(1, provaEscrita.getIdProvaEscrita());
            ResultSet rs2 = stmt2.executeQuery();
            while (rs2.next()) {
                Candidato can = new Candidato();
                can.setIdCandidato(rs2.getInt("id_candidato"));
                can.setIdPessoa(rs2.getInt("id_pessoa"));
                can.setNome(rs2.getString("nome"));
                can.setDataNascimento(rs2.getDate("data_nascimento"));
                can.setSexo(rs2.getString("sexo"));
                can.setAptoProvaDidatica(rs2.getBoolean("apto_prova_didatica"));
                can.setAptoProvaEscrita(rs2.getBoolean("apto_prova_escrita"));
                can.setAptoProvaMemorial(rs2.getBoolean("apto_prova_memorial"));
                can.setAptoProvaTitulos(rs2.getBoolean("apto_prova_titulos"));
                provaEscrita.getCandidatosAptosProva().add(can);
            }
            /**
             * Fim buscar candidatos
             */
            listProvaEscrita.add(provaEscrita);
        }
        return listProvaEscrita;
    }

    private void setInt(PreparedStatement stmt, int index, int value) throws SQLException {
        if (value != 0) {
            stmt.setInt(index, value);
        } else {
            stmt.setString(index, null);
        }
    }
}
