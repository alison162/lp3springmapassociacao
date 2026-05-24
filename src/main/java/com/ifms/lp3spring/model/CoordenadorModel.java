package com.ifms.lp3spring.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "coordenador")
public class CoordenadorModel extends FuncionarioModel {

    @Min(value = 1, message = "Carga horária deve ser no mínimo 1 hora")
    private Integer cargaHoraria;

    @Size(max = 255, message = "Observações não podem exceder 255 caracteres")
    private String observacoes;

    @ManyToOne
    private DepartamentoModel departamento;

    public CoordenadorModel() {
    }

    public CoordenadorModel(String nome, String email, LocalDate dataAdmissao, String status,
            Integer cargaHoraria, String observacoes, String cpf, LocalDate dataNascimento, Cargo cargo) {
        super(nome, email, dataAdmissao, status, cpf, dataNascimento, cargo);
        this.cargaHoraria = cargaHoraria;
        this.observacoes = observacoes;

    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public DepartamentoModel getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoModel departamento) {
        this.departamento = departamento;
    }

}