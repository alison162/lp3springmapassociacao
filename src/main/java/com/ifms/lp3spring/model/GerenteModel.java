package com.ifms.lp3spring.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
@Table(name = "gerente")
public class GerenteModel extends PessoaModel {
    @PastOrPresent
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataAdmissao;

    @Min(value = 1, message = "Nível de acesso deve ser no mínimo 1")
    private Integer nivelDeAcesso;


    @OneToMany(mappedBy="gerente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DepartamentoModel> departamentos;

    public GerenteModel() {
    }

    public GerenteModel(String nome, Long cpf, Date dataNascimento, Date dataAdmissao) {
        super(nome, cpf, dataNascimento);
    
        this.dataAdmissao = dataAdmissao;
    }

 
    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public List<DepartamentoModel> getDepartamento() {
        return departamentos;
    }

    public void setDepartamento(List<DepartamentoModel> departamento) {
        this.departamentos = departamento;
    }

    public Integer getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(Integer nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }

}
