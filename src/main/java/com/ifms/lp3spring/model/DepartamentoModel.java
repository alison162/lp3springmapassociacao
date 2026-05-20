package com.ifms.lp3spring.model;



import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamento")
public class DepartamentoModel {
    @Id
    @GeneratedValue
    private Long idDepartamento;
    private String nome;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_gerente")
    @Fetch(FetchMode.JOIN)
    private GerenteModel gerente;


    public DepartamentoModel() {
    }

    public DepartamentoModel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartemento) {
        this.idDepartamento = idDepartemento;
    }

}
