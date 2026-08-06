package com.ifms.framespring.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class MatriculaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_matricula", nullable = false)
    private LocalDate dataMatricula;

    @Column(name = "status", nullable = false, length = 80)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_aluno")
    private AlunoModel aluno;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_curso")
    private CursoModel curso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public AlunoModel getAluno() {
        return aluno;
    }

    public void setAluno(AlunoModel aluno) {
        this.aluno = aluno;
    }

    public CursoModel getCurso() {
        return curso;
    }
    public void setCurso(CursoModel curso) {
        this.curso = curso;
    }


}
