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

    public static void afegirUsuari(Usuari usuari) throws Exception {
        for (Usuari u : usuaris) {
            if (u.getDni().equalsIgnoreCase(usuari.getDni())) {
                throw new Exception("Ja existeix un usuari amb el DNI " + usuari.getDni() + ".");
            }
        }
        usuaris.add(usuari);
    }

    public static void eliminarUsuari(Usuari usuari) throws Exception {
        if (usuari == null) {
            throw new Exception("Has de seleccionar un usuari.");
        }

        for (Lloguer l : lloguers) {
            if (!l.isRetornat() && l.getUsuari() == usuari) {
                throw new Exception("No es pot eliminar l'usuari " + usuari + " perquè té lloguers actius.");
            }
        }

        usuaris.remove(usuari);
    }

    public static void afegirJoc(Joc joc) throws Exception {
        for (Joc j : jocs) {
            if (j.getNom().equalsIgnoreCase(joc.getNom())) {
                throw new Exception("Ja existeix un joc amb el nom " + joc.getNom() + ".");
            }
        }
        jocs.add(joc);
    }

    public static void eliminarJoc(Joc joc) throws Exception {
        if (joc == null) {
            throw new Exception("Has de seleccionar un joc.");
        }

        for (Lloguer l : lloguers) {
            if (!l.isRetornat() && l.getJoc() == joc) {
                throw new Exception("No es pot eliminar el joc " + joc.getNom() + " perquè té lloguers actius.");
            }
        }

        jocs.remove(joc);
    }

    public static void carregarDadesInicials() {
        Usuari u1 = new Usuari("Laura", "García", "Pons", "12345678A", "600111222");
        Usuari u2 = new Usuari("Marc", "López", "Ferrer", "87654321B", "600333444");
        usuaris.add(u1);
        usuaris.add(u2);

        Joc j1 = new Joc("Minecraft", "Aventura");
        j1.setUnitats("PS5", 2);
        j1.setUnitats("Switch 2", 1);

        Joc j2 = new Joc("Cyberpunk 2077", "Acció");
        j2.setUnitats("Xbox", 1);
        j2.setUnitats("PC", 2);

        jocs.add(j1);
        jocs.add(j2);

        try {
            // Aquest lloguer va començar fa 10 dies, per tant surt fora de termini (vermell)
            registrarLloguer(u1, j1, "Switch 2", LocalDate.now().minusDays(10));
            registrarLloguer(u2, j2, "PC", LocalDate.now());
        } catch (Exception e) {
            System.out.println("Error carregant les dades inicials: " + e.getMessage());
        }
    }
}
