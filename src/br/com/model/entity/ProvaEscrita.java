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
    private PontoProvaEscrita pontoSorteado;
    private Date horaPontoSorteado;
    private Date horaInicioProva;
    private Date horaFimProva;
    private String localRealizacao;
    private ArrayList<Candidato> candidatosAptosLeitura;
    private Date horaInicioLeitura;
    private Date horaFimLeitura;
    private String localLeitura;
    private ArrayList<CriterioAvaliacao> criterios;
    private Date horaInicioJulgamento;
    private String localJulgamento;
    private ArrayList<Candidato> candidatosAptosProva;
    private ArrayList<PontoProvaEscrita> pontos;
    private Date horaInicioResultado;
    private String localResultado;

    public ProvaEscrita() {
        this.candidatosAptosProva = new ArrayList<Candidato>();
        this.candidatosAptosLeitura = new ArrayList<Candidato>();
        this.criterios = new ArrayList<CriterioAvaliacao>();
        this.pontos = new ArrayList<PontoProvaEscrita>();
    }

    public PontoProvaEscrita getPontoSorteado() {
        return pontoSorteado;
    }

    public void setPontoSorteado(PontoProvaEscrita pontoSorteado) {
        this.pontoSorteado = pontoSorteado;
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
    
    public void removerCandidatoApto(Candidato c){
        Iterator<Candidato> iterator = this.candidatosAptosProva.iterator();
        while (iterator.hasNext()){
            Candidato object = iterator.next();
            if (object.getIdCandidato() == c.getIdCandidato()){
                this.candidatosAptosProva.remove(c);
                return;
            }
        }
    }
    public void adicionarCandidatoAptoLeitura(Candidato c) {
        Iterator<Candidato> iterator = this.candidatosAptosLeitura.iterator();
        while (iterator.hasNext()) {
            Candidato object = iterator.next();
            if (object.getIdCandidato() == c.getIdCandidato()) {
                return;
            }
        }
        this.candidatosAptosLeitura.add(c);
    }

    public void removerCandidatoAptoLeitura(Candidato c){
        Iterator<Candidato> iterator = this.candidatosAptosLeitura.iterator();
        while (iterator.hasNext()){
            Candidato object = iterator.next();
            if (object.getIdCandidato() == c.getIdCandidato()){
                this.candidatosAptosLeitura.remove(c);
                return;
            }
        }
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
    public float getSomaPontosCriterioAvaliacao() {
        float soma = 0f;
        Iterator<CriterioAvaliacao> iterator = this.criterios.iterator();
        while (iterator.hasNext()) {
            CriterioAvaliacao object = iterator.next();
            soma += object.getPeso();
        }
        return soma;
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

    public Date getHoraPontoSorteado() {
        return horaPontoSorteado;
    }

    public void setHoraPontoSorteado(Date horaPontoSorteado) {
        this.horaPontoSorteado = horaPontoSorteado;
    }

    public Date getHoraInicioProva() {
        return horaInicioProva;
    }

    public void setHoraInicioProva(Date horaInicioProva) {
        this.horaInicioProva = horaInicioProva;
    }

    public Date getHoraFimProva() {
        return horaFimProva;
    }

    public void setHoraFimProva(Date horaFimProva) {
        this.horaFimProva = horaFimProva;
    }

    public String getLocalRealizacao() {
        return localRealizacao;
    }

    public void setLocalRealizacao(String localRealizacao) {
        this.localRealizacao = localRealizacao;
    }

    public ArrayList<Candidato> getCandidatosAptosLeitura() {
        return candidatosAptosLeitura;
    }

    public void setCandidatosAptosLeitura(ArrayList<Candidato> candidatosAptosLeitura) {
        this.candidatosAptosLeitura = candidatosAptosLeitura;
    }

    public Date getHoraInicioLeitura() {
        return horaInicioLeitura;
    }

    public void setHoraInicioLeitura(Date horaInicioLeitura) {
        this.horaInicioLeitura = horaInicioLeitura;
    }

    public String getLocalLeitura() {
        return localLeitura;
    }

    public void setLocalLeitura(String localLeitura) {
        this.localLeitura = localLeitura;
    }

    public Date getHoraInicioJulgamento() {
        return horaInicioJulgamento;
    }

    public void setHoraInicioJulgamento(Date horaInicioJulgamento) {
        this.horaInicioJulgamento = horaInicioJulgamento;
    }

    public String getLocalJulgamento() {
        return localJulgamento;
    }

    public void setLocalJulgamento(String localJulgamento) {
        this.localJulgamento = localJulgamento;
    }

    public Date getHoraInicioResultado() {
        return horaInicioResultado;
    }

    public void setHoraInicioResultado(Date horaInicioResultado) {
        this.horaInicioResultado = horaInicioResultado;
    }

    public String getLocalResultado() {
        return localResultado;
    }

    public void setLocalResultado(String localResultado) {
        this.localResultado = localResultado;
    }

    public Date getHoraFimLeitura() {
        return horaFimLeitura;
    }

    public void setHoraFimLeitura(Date horaFimLeitura) {
        this.horaFimLeitura = horaFimLeitura;
    }
    
    
    
}
