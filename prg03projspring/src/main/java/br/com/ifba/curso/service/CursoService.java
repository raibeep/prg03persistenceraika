/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
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
    private CursoIDao cursoIDao;
    
    @Override
    public Curso save(Curso curso) throws RuntimeException{
        if (curso == null){
            throw new RuntimeException("Dados do " + "curso não preenchidos.");
        }else if(curso.getId() != null){
            throw new RuntimeException("Curso " + "já existente no banco de dados.");
        }else{
            return cursoIDao.save(curso);
        }
    }
    
    @Override
    public void delete(Curso curso) throws RuntimeException{
        if(curso == null){
            throw new RuntimeException("Dados do " + "curso não preenchidos.");
        }else if(curso.getId() == null){
            throw new RuntimeException("Curso não existente no banco de dados");
        }else{
            cursoIDao.delete(curso);
        }
    }
    
    @Override
    public Curso update(Curso curso) throws RuntimeException{
        if(curso == null){
            throw new RuntimeException("Dados do " + "curso não preenchidos.");
        }else{
            return cursoIDao.update(curso);
        }
    }
    
    @Override
    public List<Curso> findAll() throws RuntimeException{
       return cursoIDao.findAll();
    }
    
    @Override
    public Curso findById(Long id) throws RuntimeException{
        return cursoIDao.findById(id);
    }
    
    @Override
    public Curso findByCodigo(String codigo) throws RuntimeException{
        return cursoIDao.findByCodigo(codigo);
    }
}

