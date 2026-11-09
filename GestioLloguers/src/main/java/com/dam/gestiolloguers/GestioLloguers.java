/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.dam.gestiolloguers;

import com.dam.gestiolloguers.gui.FinestraPrincipal;
import com.dam.gestiolloguers.logic.LogicaNegoci;

/**
 *
 * @author Hector Benítez
 */
public class GestioLloguers {

    public static void main(String[] args) {
        LogicaNegoci.carregarDadesInicials();
        FinestraPrincipal.main(args);
    }
}