package com.curso.api.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "materias")
public class Materia implements Serializable {

    @Serial
    private static final long serialVersionUID = 5410103450951274507L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia")
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @ManyToMany
    @JoinTable(name = "grade_materia",
            joinColumns = {
                    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_grade", referencedColumnName = "id_grade")
            })
    private Set<GradeCurricular> grades;

    public Materia() {
    }

    public Materia(String nome, Set<GradeCurricular> grades) {
        this.nome = nome;
        this.grades = grades;
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

    public Set<GradeCurricular> getGrades() {
        if (grades == null)
            grades = new HashSet<>();
        return grades;
    }

    public void setGrades(Set<GradeCurricular> grades) {
        this.grades = grades;
    }
}
