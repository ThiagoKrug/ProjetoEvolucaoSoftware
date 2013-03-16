
package br.com.model.entity;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Rafael
 */
public class ProvaEscrita {
    
    private int pontoSorteado;
    private Date horaPontoSorteado;
    private Date horaInicioProva;
    private Date horaFimProva;
    
    private String localRealizacao;
    
    private ArrayList<Candidato> candidatosAptosLeitura;
    private Date horaInicioLeitura;
    private String localRealizacaoLeitura;
    
    private ArrayList<CriterioAvaliacao> criterios;
    
    private Date horaInicioJulgamento;
    private String localJulgamento;
     
     
     
    private ArrayList<Candidato> candidatosAptosProva;
    
    private ArrayList<Ponto> pontos;
    
    
    private Date horaInicioResultado;
    private String localResultado;
    
}
