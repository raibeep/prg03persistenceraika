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
    // Cria apenas uma fábrica de conexões (isso é pesado, então faz só uma vez)
    private static final EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("gerenciamento_curso");

    // Sempre que alguém pedir um EntityManager, cria um novo
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
