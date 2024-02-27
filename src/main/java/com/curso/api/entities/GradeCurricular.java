package com.curso.api.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "grades_curriculares")
public class GradeCurricular implements Serializable  {

    @Serial
    private static final long serialVersionUID = -2786507068441396197L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grade")
    private Integer id;

    private String objetivo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aluno", referencedColumnName = "id_aluno")
    private Aluno aluno;

    @ManyToMany(mappedBy = "grades")
    private Set<Materia> materias;

    public GradeCurricular() {
    }

    public GradeCurricular(String objetivo, Aluno aluno) {
        this.objetivo = objetivo;
        this.aluno = aluno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Set<Materia> getMaterias() {
        if (materias == null)
            materias = new HashSet<>();
        return materias;
    }

    public void setMaterias(Set<Materia> materias) {
        this.materias = materias;
    }
}
