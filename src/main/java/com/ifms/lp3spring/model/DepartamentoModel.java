package com.ifms.lp3spring.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "departamento")
public class DepartamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartamento;

   
    @NotBlank(message = "O nome do departamento é obrigatório")
    @Size(min = 3, max = 80)
    @Column(name= "nome_departamento", nullable = false, length = 80)
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_gerente")
    @Fetch(FetchMode.JOIN)
    private GerenteModel gerente;

    @ManyToOne
    @JoinColumn(name = "id_coordenador")
    private CoordenadorModel coordenador;

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

    public GerenteModel getGerente() {
        return gerente;
    }

    public void setGerente(GerenteModel gerente) {
        this.gerente = gerente;
    }

    public CoordenadorModel getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(CoordenadorModel coordenador) {
        this.coordenador = coordenador;
    }

}
