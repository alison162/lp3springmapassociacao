package com.ifms.lp3spring.model;

import java.time.LocalDate;

import org.hibernate.annotations.Collate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "holerite")
public class HoleriteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHolerite;

    @NotBlank(message = "O campo mês de referência é obrigatório")
    private String mesReferencia;

    @NotNull(message = "O campo ano de referência é obrigatório")
    @Positive(message = "O ano de referência deve ser um número positivo")
    private Double salarioBase;

    @Positive(message = "O ano de referência deve ser um número positivo")
    private Double descontos;
    
    @Positive(message = "O ano de referência deve ser um número positivo")
    private Double beneficios;

   
    private Double salarioLiquido;

    @NotNull(message = "A data de pagamento é obrigatória")
    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @ManyToOne
    private FuncionarioModel funcionario;

    public Long getIdHolerite() {
        return idHolerite;
    }

    public void setIdHolerite(Long idHolerite) {
        this.idHolerite = idHolerite;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Double getDescontos() {
        return descontos;
    }

    public void setDescontos(Double descontos) {
        this.descontos = descontos;
    }

    public Double getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(Double beneficios) {
        this.beneficios = beneficios;
    }

    public Double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(Double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }

}
