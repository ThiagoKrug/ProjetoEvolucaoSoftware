package br.com.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Rafael
 */
public class ProvaEscrita implements IEntidade {

    private int idProvaEscrita;
    private Concurso concurso;
    private int pontoSorteado;
    private Date horaPontoSorteado;
    private Date horaInicioProva;
    private Date horaFimProva;
    private String localRealizacao;
    private ArrayList<Candidato> candidatosAptosLeitura;
    private Date horaInicioLeitura;
    private String localLeitura;
    private ArrayList<CriterioAvaliacao> criterios;
    private Date horaInicioJulgamento;
    private String localJulgamento;
    private ArrayList<Candidato> candidatosAptosProva;
    private ArrayList<PontoProvaEscrita> pontos;
    private Date horaInicioResultado;
    private String localResultado;

    public ProvaEscrita() {
        this.candidatosAptosProva = new ArrayList<>();
        this.criterios = new ArrayList<>();
        this.pontos = new ArrayList<>();
    }

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    public ArrayList<Candidato> getCandidatosAptosProva() {
        return candidatosAptosProva;
    }

    public void setCandidatosAptosProva(ArrayList<Candidato> candidatosAptosProva) {
        this.candidatosAptosProva = candidatosAptosProva;
    }

    public ArrayList<PontoProvaEscrita> getPontos() {
        return pontos;
    }

    public void setPontos(ArrayList<PontoProvaEscrita> pontos) {
        this.pontos = pontos;
    }

    public ArrayList<CriterioAvaliacao> getCriterios() {
        return criterios;
    }

    public void setCriterios(ArrayList<CriterioAvaliacao> criterios) {
        this.criterios = criterios;
    }

    public int getIdProvaEscrita() {
        return idProvaEscrita;
    }

    public void setIdProvaEscrita(int idProvaEscrita) {
        this.idProvaEscrita = idProvaEscrita;
    }

    public void adicionarPonto(PontoProvaEscrita p) {
        Iterator<PontoProvaEscrita> iterator = this.pontos.iterator();
        while (iterator.hasNext()) {
            PontoProvaEscrita object = iterator.next();
            if (object.getIdPontoProvaEscrita() == p.getIdPontoProvaEscrita()) {
                return;
            }
        }
        this.pontos.add(p);
    }

    public void removerPonto(PontoProvaEscrita p) {
        Iterator<PontoProvaEscrita> iterator = this.pontos.iterator();
        while (iterator.hasNext()) {
            PontoProvaEscrita object = iterator.next();
            if (object.getIdPontoProvaEscrita() == p.getIdPontoProvaEscrita()) {
                this.pontos.remove(object);
                return;
            }
        }
    }

    public void alterarPonto(PontoProvaEscrita p) {
        Iterator<PontoProvaEscrita> iterator = this.pontos.iterator();
        while (iterator.hasNext()) {
            PontoProvaEscrita object = iterator.next();
            if (object.getIdPontoProvaEscrita() == p.getIdPontoProvaEscrita()) {
                object.setIdPontoProvaEscrita(p.getIdPontoProvaEscrita());
                object.setDescricao(p.getDescricao());
                object.setProvaEscrita(p.getProvaEscrita());
                return;
            }
        }
    }

    public void adicionarCandidatoApto(Candidato c) {
        Iterator<Candidato> iterator = this.candidatosAptosProva.iterator();
        while (iterator.hasNext()) {
            Candidato object = iterator.next();
            if (object.getIdCandidato() == c.getIdCandidato()) {
                return;
            }
        }
        this.candidatosAptosProva.add(c);
    }

    public void adicionarCriterioAvaliacao(CriterioAvaliacao c) {
        Iterator<CriterioAvaliacao> iterator = this.criterios.iterator();
        while (iterator.hasNext()) {
            CriterioAvaliacao object = iterator.next();
            if (object.getIdCriterioAvaliacao() == c.getIdCriterioAvaliacao()) {
                return;
            }
        }
        this.criterios.add(c);
    }

    public void removerCriterioAvaliacao(CriterioAvaliacao c) {
        Iterator<CriterioAvaliacao> iterator = this.criterios.iterator();
        while (iterator.hasNext()) {
            CriterioAvaliacao object = iterator.next();
            if (object.getIdCriterioAvaliacao() == c.getIdCriterioAvaliacao()) {
                this.criterios.remove(object);
                return;
            }
        }
    }

    public void alterarCriterioAvaliacao(CriterioAvaliacao c) {
        Iterator<CriterioAvaliacao> iterator = this.criterios.iterator();
        while (iterator.hasNext()) {
            CriterioAvaliacao object = iterator.next();
            if (object.getIdCriterioAvaliacao() == c.getIdCriterioAvaliacao()) {
                object.setIdCriterioAvaliacao(c.getIdCriterioAvaliacao());
                object.setCriterio(c.getCriterio());
                object.setPeso(c.getPeso());
                object.setProvaEscrita(c.getProvaEscrita());
                return;
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idProvaEscrita;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProvaEscrita other = (ProvaEscrita) obj;
        if (this.idProvaEscrita != other.idProvaEscrita) {
            return false;
        }
        return true;
    }
    
}
