package com.ifms.lp3spring.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;


@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class FuncionarioModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected LocalDate dataNascimento;

    @Email
    private String email;

    @Positive
    private Double salario;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataAdmissao;
    
    private String status;

     public FuncionarioModel() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public LocalDate getDataNascimento() {
        return dataNascimento;
    }


    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataAdmissaoFormatada() {
    return dataAdmissao != null ? dataAdmissao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
}

    public FuncionarioModel(String nome, String email, Double salario, LocalDate dataAdmissao, String status, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
        this.status = status;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

}
