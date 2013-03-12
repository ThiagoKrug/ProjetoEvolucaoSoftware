package model;

/**
 *
 * @author Douglas F. Almeida - 101151405
 * @version 28/02/2013
 * 
 */
public class Disciplina { 

    private String sNome;
    private String sCargaHorariaPratica;
    private String sCargaHorariaTeorica;
    private String sPeriodo;
    private String sEmenta;
    
    public Disciplina () {}

    public String getsNome() {
        return sNome;
    }

    public void setsNome(String sNome) {
        this.sNome = sNome;
    }

    public String getsCargaHorariaPratica() {
        return sCargaHorariaPratica;
    }

    public void setsCargaHorariaPratica(String sCHPratica) {
        this.sCargaHorariaPratica = sCHPratica;
    }

    public String getsCargaHorariaTeorica() {
        return sCargaHorariaTeorica;
    }

    public void setsCargaHorariaTeorica(String sCHTeorica) {
        this.sCargaHorariaTeorica = sCHTeorica;
    }

    public String getsPeriodo() {
        return sPeriodo;
    }

    public void setsPeriodo(String sPeriodo) {
        this.sPeriodo = sPeriodo;
    }

    public String getsEmenta() {
        return sEmenta;
    }

    public void setsEmenta(String sEmenta) {
        this.sEmenta = sEmenta;
    }
    
    
}
