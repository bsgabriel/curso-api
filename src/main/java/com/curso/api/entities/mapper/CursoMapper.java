package com.curso.api.entities.mapper;

import com.curso.api.entities.Curso;
import com.curso.api.entities.dto.CursoDTO;
import org.springframework.stereotype.Service;

@Service
public class CursoMapper {

    public Curso cursoDTOToCurso(CursoDTO dto) {
        return new Curso(dto.getNome(), dto.getArea());
    }

}
