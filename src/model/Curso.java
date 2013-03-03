package model;

/**
 *
 * @author Douglas F. Almeida- 101151405
 * @version 28/02/2013
 * 
 */
public class Curso {
    
    private String sTitulo;
    private String sDuracao;
    private String sFormacao;
    private String sUniversidade;
    private String sCampus;
    
    public Curso() {}

    public String getsFormacao() {
        return sFormacao;
    }

    public void setsFormacao(String sFormacao) {
        this.sFormacao = sFormacao;
    }

    public String getsTitulo() {
        return sTitulo;
    }

    public void setsTitulo(String sTitulo) {
        this.sTitulo = sTitulo;
    }

    public String getsDuracao() {
        return sDuracao;
    }

    public void setsDuracao(String sDuracao) {
        this.sDuracao = sDuracao;
    }

    public String getsUniversidade() {
        return sUniversidade;
    }

    public void setsUniversidade(String sUniversidade) {
        this.sUniversidade = sUniversidade;
    }

    public String getsCampus() {
        return sCampus;
    }

    public void setsCampus(String sCampus) {
        this.sCampus = sCampus;
    }
    
    
    
}
