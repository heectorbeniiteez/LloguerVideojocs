/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam.gestiolloguers.dto;

import java.util.HashMap;

/**
 *
 * @author Hector Benítez
 */
public class Joc {

    public static final String[] PLATAFORMES = {"PS5", "Xbox", "PC", "Switch 2"};

    private String nom;
    private String genere;
    private HashMap<String, Integer> unitats;

    public Joc(String nom, String genere) {
        this.nom = nom;
        this.genere = genere;
        this.unitats = new HashMap<>();
    }

    public String getNom() {
        return nom;
    }

    public String getGenere() {
        return genere;
    }

    public int getUnitats(String plataforma) {
        if (unitats.containsKey(plataforma)) {
            return unitats.get(plataforma);
        }
        return 0;
    }
    
    public void setUnitats(String plataforma, int quantitat) {
        unitats.put(plataforma, quantitat);
    }
    
    public void restarUnitats(String plataforma) {
        unitats.put(plataforma, getUnitats(plataforma) - 1);
    }
    
    public void sumarUnitats(String plataforma) {
        unitats.put(plataforma, getUnitats(plataforma) + 1);
    }
    
    @Override
    public String toString() {
        return nom;
    }
}
