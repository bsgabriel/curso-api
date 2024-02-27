package com.curso.api.resources;

import com.curso.api.entities.Curso;
import com.curso.api.entities.dto.CursoDTO;
import com.curso.api.entities.mapper.CursoMapper;
import com.curso.api.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoResource {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursoMapper cursoMapper;

    @GetMapping
    public ResponseEntity<List<Curso>> getCursos() {
        final List<Curso> lst = this.cursoService.getCursos();
        return ResponseEntity.ok().body(lst);
    }

    @PostMapping
    public ResponseEntity<Curso> saveCurso(@Valid @RequestBody CursoDTO curso) throws URISyntaxException {
        final Curso c = this.cursoService.save(cursoMapper.cursoDTOToCurso(curso));
        return ResponseEntity.created(new URI("/cursos/" + c.getId()))
                .body(c);
    }
}
