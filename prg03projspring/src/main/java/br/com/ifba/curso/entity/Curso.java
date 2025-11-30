/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Entity;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author raiii
 */
@Entity
@Data
//utilizado para criar métodos repetitivos (getters, setters...)
@NoArgsConstructor
//cria um construtor vazio
@AllArgsConstructor
//cria um construtor que recebe todos atributos da classe
public class Curso extends PersistenceEntity
                    implements Serializable{
    
    private String nome;
    private String codigoCurso;
    private String cargaHoraria;
    private boolean ativo;
}
