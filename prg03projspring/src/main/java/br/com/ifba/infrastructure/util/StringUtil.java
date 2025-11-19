/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

import java.text.Normalizer;

/**
 *
 * @author raiii
 */
public class StringUtil {
    
    //verifica se a String é nula, vazia ou contém apensas espaçoes
    public static boolean isEmpty(String s){
        return s == null || s.trim().isEmpty();
    }
    
    //torna a primeira letra maiúscula
    public static String capitalize(String s){
        if (isEmpty(s)) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
    
    //remove acentos 
    public static String removeAcentos(String s){
        if(s == null) return null;
        return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    }
    
    //verifica se a string só tem números
    public static boolean isNumeric(String s) {
        if (isEmpty(s)) return false;
        return s.matches("\\d+");
    }

    //Converte null para string vazia.
    public static String nullSafe(String s) {
        return s == null ? "" : s;
    }

    //Compara duas strings ignorando acentos e maiúsculas/minúsculas.
    public static boolean equalsIgnoreAccents(String a, String b) {
        if (a == null || b == null) return false;
        return removeAcentos(a).equalsIgnoreCase(removeAcentos(b));
    }
    
    //verifica se há números
    public static boolean isOnlyLetters(String s) {
        if (s == null) return false;
        return s.matches("[A-Za-zÀ-ÿ ]+");
    }

}
