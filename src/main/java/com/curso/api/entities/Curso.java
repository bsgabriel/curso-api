package com.curso.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable {

    @Serial
    private static final long serialVersionUID = 5336703418968956115L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer id;

    @Column(name = "nome_curso", nullable = false)
    private String nome;

    @Column(name = "area_curso", nullable = false)
    private String area;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name = "data_criacao")
    @CreationTimestamp
    private LocalDateTime dtaCriacao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name = "data_atualizacao")
    @UpdateTimestamp
    private LocalDateTime dtaAtualizacao;

    @NotNull(message = "O nome de usuário não pode ser nulo")
    @NotBlank(message = "O nome de usuário não pode estar em branco")
    private String usuario;

    @Transient
    private BigDecimal vlrCurso;

    @OneToMany(mappedBy = "curso")
    private List<Aluno> alunos;

    @PostPersist
    private void aposPersistir() {
        this.nome = this.nome + " POST";
    }

    @PrePersist
    private void antesPersistir() {
        this.usuario = "admin";
    }


    public Curso() {
    }

    public Curso(String nome, String area) {
        this.nome = nome;
        this.area = area;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public LocalDateTime getDtaCriacao() {
        return dtaCriacao;
    }

    public void setDtaCriacao(LocalDateTime dtaCriacao) {
        this.dtaCriacao = dtaCriacao;
    }

    public LocalDateTime getDtaAtualizacao() {
        return dtaAtualizacao;
    }

    public void setDtaAtualizacao(LocalDateTime dtaAtualizacao) {
        this.dtaAtualizacao = dtaAtualizacao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getVlrCurso() {
        return vlrCurso;
    }

    public void setVlrCurso(BigDecimal vlrCurso) {
        this.vlrCurso = vlrCurso;
    }

    public List<Aluno> getAlunos() {
        if (alunos == null)
            alunos = new ArrayList<>();
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Curso {" + "id=" + id + ", nome='" + nome + "', area='" + area + "'" + "}";
    }
}
