package com.ifms.lp3spring.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "coordenador")
public class CoordenadorModel extends FuncionarioModel {

    @Column(name = "carga_horaria")
    @Min(value = 1, message = "Carga horária deve ser no mínimo 1 hora")
    private Integer cargaHoraria;

    @Column(name = "observacoes")
    @Size(max = 255, message = "Observações não podem exceder 255 caracteres")
    private String observacoes;

    @OneToMany(mappedBy = "coordenador")
    private List<DepartamentoModel> departamentos;

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

    public List<DepartamentoModel> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<DepartamentoModel> departamentos) {
        this.departamentos = departamentos;
    }

}