package com.ifms.framespring.model;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "curso")
public class CursoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    @NotBlank(message = "O nome do curso é obrigatório")
    @Size(min = 3, max = 80)
    @Column(name= "nome_curso", nullable = false, length = 80)
    private String nome;

    @Column(name = "carga_horaria", nullable = false)
    private int cargaHoraria;

     @OneToMany(mappedBy = "curso")
    private List<MatriculaModel> matriculas;


    public CursoModel() {
    }

    public CursoModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<MatriculaModel> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<MatriculaModel> matriculas) {
        this.matriculas = matriculas;
    }

}
