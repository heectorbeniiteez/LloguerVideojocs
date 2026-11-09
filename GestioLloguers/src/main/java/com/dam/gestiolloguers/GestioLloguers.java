/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.dam.gestiolloguers;

import com.dam.gestiolloguers.dto.Joc;
import com.dam.gestiolloguers.dto.Lloguer;
import com.dam.gestiolloguers.dto.Usuari;
import com.dam.gestiolloguers.logic.LogicaNegoci;
import java.time.LocalDate;

/**
 *
 * @author Hector Benítez
 */
public class GestioLloguers {

    public static void main(String[] args) {
        Usuari u1 = new Usuari("Laura", "García", "Pons", "12345678A", "600111222");
        Joc j1 = new Joc("Minecraft", "Aventura");
        j1.setUnitats("PS5", 2);
        j1.setUnitats("Switch 2", 1);

        LogicaNegoci.getUsuaris().add(u1);
        LogicaNegoci.getJocs().add(j1);

        try {
            LogicaNegoci.registrarLloguer(u1, j1, "Switch 2", LocalDate.now());
            System.out.println("Lloguer registrat. Unitats Switch 2: " + j1.getUnitats("Switch 2"));

            // Aquest ha de fallar perquè ja no queden unitats
            LogicaNegoci.registrarLloguer(u1, j1, "Switch 2", LocalDate.now());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Lloguer l = LogicaNegoci.getLloguers().get(0);
            LogicaNegoci.tornarLloguer(l);
            System.out.println("Lloguer retornat. Unitats Switch 2: " + j1.getUnitats("Switch 2"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (Lloguer l : LogicaNegoci.getLloguers()) {
            System.out.println(l.getNumRegistre() + " | " + l.getJoc() + " | " + l.getUsuari() + " | "
                    + l.getPlataforma() + " | " + l.getDataInici() + " -> " + l.getDataPrevista() + " | " + l.getEstat());
        }
    }
}
