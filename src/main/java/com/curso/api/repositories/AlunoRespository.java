package com.curso.api.repositories;

import com.curso.api.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRespository extends JpaRepository<Aluno, Integer> {

}
