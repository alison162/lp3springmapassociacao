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
import jakarta.validation.constraints.PastOrPresent;

@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
@Table(name = "gerente")
public class GerenteModel extends PessoaModel {
    @PastOrPresent
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataPosse;
    @OneToMany(mappedBy="gerente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DisciplinaModel> disciplinas;

    public GerenteModel() {
    }

    public GerenteModel(String nome, Long cpf, Date dataNascimento, Date dataPosse) {
        super(nome, cpf, dataNascimento);
    
        this.dataPosse = dataPosse;
    }

 
    public Date getDataPosse() {
        return dataPosse;
    }

    public void setDataPosse(Date dataPosse) {
        this.dataPosse = dataPosse;
    }

    public List<DisciplinaModel> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<DisciplinaModel> disciplinas) {
        this.disciplinas = disciplinas;
    }

}
