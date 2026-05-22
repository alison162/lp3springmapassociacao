package com.ifms.lp3spring.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "gerente")
public class GerenteModel extends FuncionarioModel {

    @Min(value = 1, message = "Nível de acesso deve ser no mínimo 1")
    private Integer nivelDeAcesso;

    @OneToMany(mappedBy = "gerente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DepartamentoModel> departamentos;

    public GerenteModel() {
    }

    
    public GerenteModel(String nome, String email, Double salario, LocalDate dataAdmissao, String status, String cpf,
            LocalDate dataNascimento, Integer nivelDeAcesso) {
        super(nome, email, salario, dataAdmissao, status, cpf, dataNascimento);
        this.nivelDeAcesso = nivelDeAcesso;

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
