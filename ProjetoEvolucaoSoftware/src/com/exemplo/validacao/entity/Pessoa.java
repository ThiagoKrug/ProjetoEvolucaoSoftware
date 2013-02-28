package com.exemplo.validacao.entity;

import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * Documentação do Hibernate Validator
 * http://docs.jboss.org/hibernate/validator/4.3/reference/en-US/html_single/#validator-customconstraints
 *
 */
public class Pessoa {

    @NotBlank //não pode estar vazio, diferente de @NotNull que pode ser uma string vazia
    @Size(min = 4, max = 50)
    private String nome;
    @NotNull
    @Past //data deve ser inferior a data de hoje
    private Date dataNascimento;
    @NotBlank
    @CPF
    private String cpf;
    @NotNull(message="não é permitido ficar nulo!")//se quiser alterar mensagem, use (message="...")
    private String rg;
    @NotNull
    @Min(18)
    private int idade;
    @NotBlank
    @Email
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
