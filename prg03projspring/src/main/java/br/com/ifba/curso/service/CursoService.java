/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.repository.CursoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author raiii
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CursoService implements CursoIService{
    
    private final CursoRepository cursoRepository;

    private static final Logger log = LoggerFactory.getLogger(CursoService.class);
    
    @Override
    public Curso save(Curso curso) throws RuntimeException{
        if (curso == null){
            throw new RuntimeException("Dados do " + "curso não preenchidos.");
        }else if(curso.getId() != null){
            throw new RuntimeException("Curso " + "já existente no banco de dados.");
        }else{
            log.info("Salvando o objeto curso.");
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
            log.info("Deletando o objeto curso.");
            cursoRepository.delete(curso);
        }
    }
    
    @Override
    public Curso update(Curso curso) throws RuntimeException{
        if(curso == null){
            throw new RuntimeException("Dados do " + "curso não preenchidos.");
        }else{
            log.info("Atualizando o objeto curso.");
            return cursoRepository.save(curso);
        }
    }
    
    @Override
    public List<Curso> findAll() throws RuntimeException{
        log.info("Listando os objetos curso.");
       return cursoRepository.findAll();
    }
    
    @Override
    public Curso findById(Long id) throws RuntimeException{
        log.info("Buscando por ID o objeto curso.");
        return cursoRepository.findById(id).orElse(null);
    }
    
    @Override
    public Curso findByCodigoCurso(String codigo) throws RuntimeException{
        log.info("Buscando por código o objeto curso.");
        return cursoRepository.findByCodigoCurso(codigo);
    }
}

