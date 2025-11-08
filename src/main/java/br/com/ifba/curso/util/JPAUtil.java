/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author raiii
 */
//essa classe é feita para fazer a conexão com o banco de dados e facilitar o uso do EntityManager 
public class JPAUtil {
        //cria uma fábrica de conexões JPA
    private final static EntityManagerFactory entityManagerFactory = 
            Persistence.createEntityManagerFactory("gerenciamento_curso");
    //cria um gerenciador de entidades, ou seja, o obejto que faz as operações de CRUD
    //(salvar, buscar, remover, atualizar) no banco.
    private final static EntityManager entityManager = 
            entityManagerFactory.createEntityManager();

    public static EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
