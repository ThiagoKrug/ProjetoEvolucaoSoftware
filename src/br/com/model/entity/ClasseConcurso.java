
package br.com.model.entity;

/**
 * @author Thiago Lima <thiagolimaes@gmail.com>
 */
public class ClasseConcurso implements IEntidade {
    
    private int idClasseConcurso;
    private String nome;
    
    public ClasseConcurso() {
        
    }

    public int getIdClasseConcurso() {
        return idClasseConcurso;
    }

    public String getNome() {
        return nome;
    }

    public void setIdClasseConcurso(int idClasseConcurso) {
        this.idClasseConcurso = idClasseConcurso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
