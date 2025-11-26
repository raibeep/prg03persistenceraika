/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import java.util.List;

/**
 *
 * @author raiii
 */
public interface CursoIController {
    public List<Curso> findAll() throws RuntimeException;
    public Curso save(Curso curso) throws RuntimeException;
    public Curso update(Curso curso) throws RuntimeException;
    public void delete(Curso curso) throws RuntimeException;
    public Curso findById(Long id) throws RuntimeException;
    public Curso findByCodigoCurso(String codigo) throws RuntimeException;
}
