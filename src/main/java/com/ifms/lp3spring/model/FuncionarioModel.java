package com.ifms.lp3spring.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class FuncionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 80)
    @NotBlank(message = "O nome do funcionário é obrigatório")
    private String nome;

    @Column(name = "cpf", unique = true, nullable = false, length = 11)
    @NotBlank(message = "O CPF do funcionário é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos numéricos sem pontos ou traços")
    private String cpf;

    @Column(name = "data_nascimento")
    @Past(message = "A data de nascimento deve ser no passado")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected LocalDate dataNascimento;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    @Email(message = "O email do funcionário é obrigatório")
    private String email;

    @Column(name = "data_admissao")
    @PastOrPresent(message = "A data de admissão deve ser no passado ou presente")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataAdmissao;

    @Column(nullable = false)
    @NotBlank(message = "O status do funcionário é obrigatório")
    private String status;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @OneToMany(mappedBy = "funcionario")
    private List<HoleriteModel> holerites;

    public FuncionarioModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataAdmissaoFormatada() {
        return dataAdmissao != null ? dataAdmissao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<HoleriteModel> getHolerites() {
        return holerites;
    }

    public void setHolerites(List<HoleriteModel> holerites) {
        this.holerites = holerites;
    }

    public FuncionarioModel(String nome, String email, LocalDate dataAdmissao, String status,
            String cpf, LocalDate dataNascimento, Cargo cargo) {
        this.nome = nome;
        this.email = email;
        this.dataAdmissao = dataAdmissao;
        this.status = status;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.cargo = cargo;
    }

}
