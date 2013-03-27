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
    private ArrayList<Candidato> candidatosAptosProvaDidatica;
    private ArrayList<Ponto_ProvaDidatica> pontos_ProvaDidatica;
    private ArrayList<CriterioAvaliacaoDidatica> criterios;

    public ProvaDidatica() {
        this.candidatosAptosProvaDidatica = new ArrayList<Candidato>();
        this.pontos_ProvaDidatica = new ArrayList<Ponto_ProvaDidatica>();
        this.criterios = new ArrayList<CriterioAvaliacaoDidatica>();
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

    public ArrayList<Candidato> getCandidatosAptosProvaDidatica() {
        return candidatosAptosProvaDidatica;
    }

    public void setCandidatosAptosProvaDidatica(ArrayList<Candidato> candidatosAptosProvaDidatica) {
        this.candidatosAptosProvaDidatica = candidatosAptosProvaDidatica;
    }

    public ArrayList<Ponto_ProvaDidatica> getPontos_ProvaDidatica() {
        return pontos_ProvaDidatica;
    }

    public void setPontos_ProvaDidatica(ArrayList<Ponto_ProvaDidatica> pontos_ProvaDidatica) {
        this.pontos_ProvaDidatica = pontos_ProvaDidatica;
    }

    public ArrayList<CriterioAvaliacaoDidatica> getCriterios() {
        return criterios;
    }

    public void setCriterios(ArrayList<CriterioAvaliacaoDidatica> criterios) {
        this.criterios = criterios;
    }

    /**
     * <p>Método que adiciona um Ponto da Prova Didatica</p>
     *
     * @param ponto_ProvaDidatica <E> O ponto enviado por parâmetro
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
     * @param ponto_ProvaDidatica <E> O ponto enviado por parâmetro
     */
    public void removerPontoProvaDidatica(Ponto_ProvaDidatica ponto_ProvaDidatica) {
        Iterator<Ponto_ProvaDidatica> iteratorPontoDidatica = this.pontos_ProvaDidatica.iterator();
        while (iteratorPontoDidatica.hasNext()) {
            Ponto_ProvaDidatica obj_PontoDidatica = iteratorPontoDidatica.next();

            if (obj_PontoDidatica.getIdPontoProvaDidatica() == ponto_ProvaDidatica.getIdPontoProvaDidatica()) {
                this.pontos_ProvaDidatica.remove(obj_PontoDidatica);
                return;
            }
        }
    }

    public float getSomaPontosCriterioAvaliacao() {
        float soma = 0f;
        try {
            Iterator<CriterioAvaliacaoDidatica> iterator = this.criterios.iterator();
            while (iterator.hasNext()) {
                CriterioAvaliacaoDidatica object = iterator.next();
                soma += object.getPeso();
            }
        } catch (Exception exceptError) {
            exceptError.printStackTrace();
        }
        return soma;
    }

    public void adicionarCandidatoAptoDidatica(Candidato c) {
        try {
            Iterator<Candidato> iterator = this.candidatosAptosProvaDidatica.iterator();
            while (iterator.hasNext()) {
                Candidato object = iterator.next();
                if (object.getIdCandidato() == c.getIdCandidato()) {
                    return;
                }
            }
        } catch (Exception exceptError) {
            exceptError.printStackTrace();
        }

        this.candidatosAptosProvaDidatica.add(c);
    }
}
