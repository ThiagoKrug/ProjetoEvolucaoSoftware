
package br.com.model.entity;

/**
 *
 * @author Douglas F. Almeida- 101151405
 * @version 28/02/2013
 * 
 */
public class Bibliografia {
   
    private String sAutor;
    private String sTitulo;
    private String sEdicao;
    private String sLocalEdt;
    private String sAnoPublicacao;
    private int    iNumPg;
    private int    iNumExemplares;
    
    public Bibliografia() {}

    public String getsAutor() {
        return sAutor;
    }

    public void setsAutor(String sAutor) {
        this.sAutor = sAutor;
    }

    public String getsTitulo() {
        return sTitulo;
    }

    public void setsTitulo(String sTitulo) {
        this.sTitulo = sTitulo;
    }

    public String getsEdicao() {
        return sEdicao;
    }

    public void setsEdicao(String sEdicao) {
        this.sEdicao = sEdicao;
    }

    public String getsLocalEdt() {
        return sLocalEdt;
    }

    public void setsLocalEdt(String sLocalEdt) {
        this.sLocalEdt = sLocalEdt;
    }

    public String getsAnoPublicacao() {
        return sAnoPublicacao;
    }

    public void setsAnoPublicacao(String sAnoPublicacao) {
        this.sAnoPublicacao = sAnoPublicacao;
    }

    public int getiNumPg() {
        return iNumPg;
    }

    public void setiNumPg(int iNumPg) {
        this.iNumPg = iNumPg;
    }

    public int getiNumExemplares() {
        return iNumExemplares;
    }

    public void setiNumExemplares(int iNumExemplares) {
        this.iNumExemplares = iNumExemplares;
    }
    
    
    
}
