package com.curso.api.entities.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;

public class CursoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4240057216649878284L;

    private Integer id;

    @NotBlank(message = "Nome não informado")
    @Size(min = 5, max = 20, message = "O nome deve ter entre 5 e 20 caracteres")
    private String nome;

    @NotBlank(message = "Área não informada")
    private String area;

    public CursoDTO() {
    }

    public CursoDTO(Integer id, String nome, String area) {
        this.id = id;
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
}
