/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam.gestiolloguers.logic;

import com.dam.gestiolloguers.dto.Joc;
import com.dam.gestiolloguers.dto.Lloguer;
import com.dam.gestiolloguers.dto.Usuari;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author hecto
 */
public class LogicaNegoci {
    private static ArrayList<Usuari> usuaris = new ArrayList<>();
    private static ArrayList<Joc> jocs = new ArrayList<>();
    private static ArrayList<Lloguer> lloguers = new ArrayList<>();
    private static int seguentNumRegistre = 1;

    public static ArrayList<Usuari> getUsuaris() {
        return usuaris;
    }

    public static ArrayList<Joc> getJocs() {
        return jocs;
    }

    public static ArrayList<Lloguer> getLloguers() {
        return lloguers;
    }

    public static int getSeguentNumRegistre() {
        return seguentNumRegistre;
    }
        public static void registrarLloguer(Usuari usuari, Joc joc, String plataforma, LocalDate dataInici) throws Exception {
        if (usuari == null || joc == null || plataforma == null) {
            throw new Exception("Has de seleccionar un usuari, un joc i una plataforma.");
        }

        if (joc.getUnitats(plataforma) <= 0) {
            throw new Exception("No hi ha unitats disponibles de " + joc.getNom() + " per a " + plataforma + ".");
        }

        for (Lloguer l : lloguers) {
            if (!l.isRetornat() && l.getUsuari() == usuari && l.getJoc() == joc && l.getPlataforma().equals(plataforma)) {
                throw new Exception("Aquest usuari ja té aquest joc llogat per a " + plataforma + ".");
            }
        }

        Lloguer nou = new Lloguer(seguentNumRegistre, usuari, joc, plataforma, dataInici);
        lloguers.add(nou);
        joc.restarUnitats(plataforma);
        seguentNumRegistre++;
    }
        public static void tornarLloguer(Lloguer lloguer) throws Exception {
        if (lloguer == null) {
            throw new Exception("Has de seleccionar un lloguer.");
        }

        if (lloguer.isRetornat()) {
            throw new Exception("Aquest lloguer ja està retornat.");
        }

        lloguer.marcarRetornat();
        lloguer.getJoc().sumarUnitats(lloguer.getPlataforma());
    }

    public static ArrayList<Lloguer> getLloguersActius() {
        ArrayList<Lloguer> actius = new ArrayList<>();
        for (Lloguer l : lloguers) {
            if (!l.isRetornat()) {
                actius.add(l);
            }
        }
        return actius;
    }
}
