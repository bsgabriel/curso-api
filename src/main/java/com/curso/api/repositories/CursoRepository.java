package com.curso.api.repositories;

import com.curso.api.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repositório para a entidade {@linkplain Curso}.
 * <p>
 * Padrão de nomenclatura para criação de consultas cosutomizadas:
 *
 * <ul><strong>Palavras de busca</strong>:
 * <li>findBy</li>
 * <li>searchBy</li>
 * <li>readBy</li>
 * <li>getBy</li>
 * </ul>
 *
 * <ul><strong>Atributo</strong>:
 * <li>Nome</li>
 * <li>Descricao</li>
 * <li>CriadoEm</li>
 * </ul>
 *
 * <ul><strong>Modificador</strong>:
 * <li>Containing</li>
 * <li>Contains</li>
 * <li>Like</li>
 * <li>Between</li>
 * </ul>
 */
public interface CursoRepository extends JpaRepository<Curso, Integer> {

    List<Curso> findByNome(String nome);

    List<Curso> findByNomeLike(String valor);

    List<Curso> findByNomeLikeIgnoreCase(String valor);

    List<Curso> findByNomeContaining(String valor);

    List<Curso> findByNomeContainingIgnoreCase(String valor);

    @Query(value = "select c.nome from Curso c")
    List<String> findByQueryNome();

    @Query(value = "select nome_curso from cursos where area_curso = :area", nativeQuery = true)
    List<String> findByQueryNomePorArea(@Param("area") String valor);

    @Query(value = "select nome_curso from cursos where area_curso = :area and nome_curso = :curso", nativeQuery = true)
    List<String> findByQueryNomePorArea(@Param("area") String area, @Param("curso") String curso);
}
