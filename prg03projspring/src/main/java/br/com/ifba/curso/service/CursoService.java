/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.repository.CursoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author raiii
 */
@Service
@Transactional
public class CursoService implements CursoIService{
    @Autowired
    private CursoRepository cursoRepository;

    
    @Override
    public Curso save(Curso curso) throws RuntimeException{
        if (curso == null){
            throw new RuntimeException("Dados do " + "curso não preenchidos.");
        }else if(curso.getId() != null){
            throw new RuntimeException("Curso " + "já existente no banco de dados.");
        }else{
            return cursoRepository.save(curso);
        }
    }
    
    @Override
    public void delete(Curso curso) throws RuntimeException{
        if(curso == null){
            throw new RuntimeException("Dados do " + "curso não preenchidos.");
        }else if(curso.getId() == null){
            throw new RuntimeException("Curso não existente no banco de dados");
        }else{
            cursoRepository.delete(curso);
        }
    }
    
    @Override
    public Curso update(Curso curso) throws RuntimeException{
        if(curso == null){
            throw new RuntimeException("Dados do " + "curso não preenchidos.");
        }else{
            return cursoRepository.save(curso);
        }
    }
    
    @Override
    public List<Curso> findAll() throws RuntimeException{
       return cursoRepository.findAll();
    }
    
    @Override
    public Curso findById(Long id) throws RuntimeException{
        return cursoRepository.findById(id).orElse(null);
    }
    
    @Override
    public Curso findByCodigoCurso(String codigo) throws RuntimeException{
        return cursoRepository.findByCodigoCurso(codigo);
    }
}

