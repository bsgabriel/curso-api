package com.curso.api.repositories;

import com.curso.api.entities.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRespository extends JpaRepository<Materia, Integer> {

}
