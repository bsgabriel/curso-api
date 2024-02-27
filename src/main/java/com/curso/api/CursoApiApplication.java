package com.curso.api;

import com.curso.api.entities.Curso;
import com.curso.api.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoApiApplication implements CommandLineRunner {

    @Autowired
    private CursoRepository cursoRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursoApiApplication.class, args);
    }

    @Override
    public void run(String... args) {
        this.cursoRepository.save(new Curso("Graduação em TI", "Exatas"));
        this.cursoRepository.save(new Curso("Graduação em Economia", "Humanas"));
        this.cursoRepository.save(new Curso("Graduação em Administração", "Humanas"));
        this.cursoRepository.save(new Curso("Graduação em Educação Física", "Humanas"));
    }

}
