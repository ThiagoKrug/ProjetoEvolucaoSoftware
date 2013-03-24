
package br.com.model.entity;

import br.com.model.dao.ConcursoDao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Thiago Lima <thiagolimaes@gmail.com>
 */
public class BancaExaminadora implements IEntidade {
    
    private int idBanca;
    private int idConcurso;
    private ArrayList<Examinador> examinadores;
    
    public BancaExaminadora() {
        this.examinadores = new ArrayList<>();
    }
    
    /**
     * Adiciona examinadores na Banca.
     * @param examinador 
     */
    public void adicionaExaminador(Examinador examinador) {
        if (this.examinadores.size() < 2) {
            this.examinadores.add(examinador);
        }
    }
    
    /**
     * Retorna o objeto do Concurso da banca examinadora.
     * @return Concurso
     * @throws SQLException 
     */
    public Concurso getConcurso() throws SQLException {
        
        ConcursoDao concursoDao = new ConcursoDao();
        Concurso concurso       = (Concurso) concursoDao.pesquisarPorId(this.idConcurso);
        
        return concurso;
        
    }

    public int getIdBanca() {
        return idBanca;
    }

    public int getIdConcurso() {
        return idConcurso;
    }

    public ArrayList<Examinador> getExaminadores() {
        return examinadores;
    }

    public void setIdBanca(int idBanca) {
        this.idBanca = idBanca;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }

    public void setExaminadores(ArrayList<Examinador> examinadores) {
        this.examinadores = examinadores;
    }
    
}
