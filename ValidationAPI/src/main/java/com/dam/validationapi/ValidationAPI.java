/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.dam.validationapi;

/**
 *
 * @author Hector Benítez
 */
public class ValidationAPI {

    // Retorna true si el text és null o només té espais
    public static boolean esBuit(String text) {
        return text == null || text.trim().isEmpty();
    }

    // Retorna true si el text comença amb lletra majúscula
    public static boolean comencaAmbMajuscula(String text) {
        if (esBuit(text)) {
            return false;
        }
        return Character.isUpperCase(text.trim().charAt(0));
    }
}
