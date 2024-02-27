package com.curso.api.services;

import com.curso.api.entities.Curso;

import java.util.List;

public interface CursoService {

    List<Curso> getCursos();

    Curso save(Curso curso);
}
