package br.com.model.entity;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Juliano R. M.
 * @since 23/03/2013
 * @see Ponto_ProvaDidatica
 * @see Notas_ProvaDidatica
 */
public class ProvaDidatica implements IEntidade {

    private int idProvaDidatica;
    private Concurso concurso;
    private String localRealizacaoProvaDidatica;
    private ArrayList<CriterioAvaliacaoDidatica> candidatosAptosProvaDidatica;
    private ArrayList<Ponto_ProvaDidatica> pontos_ProvaDidatica;

    public ProvaDidatica() {
        this.candidatosAptosProvaDidatica = new ArrayList<CriterioAvaliacaoDidatica>();
        this.pontos_ProvaDidatica = new ArrayList<Ponto_ProvaDidatica>();
    }

    public int getIdProvaDidatica() {
        return idProvaDidatica;
    }

    public void setIdProvaDidatica(int idProvaDidatica) {
        this.idProvaDidatica = idProvaDidatica;
    }

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    public String getLocalRealizacaoProvaDidatica() {
        return localRealizacaoProvaDidatica;
    }

    public void setLocalRealizacaoProvaDidatica(String localRealizacaoProvaDidatica) {
        this.localRealizacaoProvaDidatica = localRealizacaoProvaDidatica;
    }

    public ArrayList<CriterioAvaliacaoDidatica> getCandidatosAptosProvaDidatica() {
        return candidatosAptosProvaDidatica;
    }

    public void setCandidatosAptosProvaDidatica(ArrayList<CriterioAvaliacaoDidatica> candidatosAptosProvaDidatica) {
        this.candidatosAptosProvaDidatica = candidatosAptosProvaDidatica;
    }

    /**
     * <p>Método que adiciona um Ponto da Prova Didatica</p>
     * 
     * @param ponto_ProvaDidatica <E>   O ponto enviado por parâmetro
     */
    public void adcionarPontoProvaDidatica(Ponto_ProvaDidatica ponto_ProvaDidatica) {

        Iterator<Ponto_ProvaDidatica> iteratorPontoDidatica = this.pontos_ProvaDidatica.iterator();

        while (iteratorPontoDidatica.hasNext()) {
            Ponto_ProvaDidatica obj_PontoDidatica = iteratorPontoDidatica.next();

            if (obj_PontoDidatica.getIdPontoProvaDidatica() == ponto_ProvaDidatica.getIdPontoProvaDidatica()) {
                return;
            }
        }
        this.pontos_ProvaDidatica.add(ponto_ProvaDidatica);
    }

    /**
     * <p>Método que Remove um Ponto da Prova Didatica</p>
     * 
     * @param ponto_ProvaDidatica <E>   O ponto enviado por parâmetro
     */
    public void removerPontoProvaDidatica(Ponto_ProvaDidatica ponto_ProvaDidatica) {

        Iterator<Ponto_ProvaDidatica> iteratorPontoDidatica = this.pontos_ProvaDidatica.iterator();

        while (iteratorPontoDidatica.hasNext()) {

            Ponto_ProvaDidatica obj_PontoDidatica = iteratorPontoDidatica.next();

            if (obj_PontoDidatica.getIdPontoProvaDidatica() == ponto_ProvaDidatica.getIdPontoProvaDidatica()) {
                this.pontos_ProvaDidatica.remove(obj_PontoDidatica);
            }
        }
    }
    
    
    
    
}
