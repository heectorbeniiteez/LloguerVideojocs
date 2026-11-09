/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam.gestiolloguers.dto;

import java.time.LocalDate;

/**
 *
 * @author Hector Benítez
 */
public class Lloguer {

    public static final int DIES_LLOGUER = 7;

    private int numRegistre;
    private Usuari usuari;
    private Joc joc;
    private String plataforma;
    private LocalDate dataInici;
    private LocalDate dataPrevista;
    private boolean retornat;

    public Lloguer(int numRegistre, Usuari usuari, Joc joc, String plataforma, LocalDate dataInici) {
        this.numRegistre = numRegistre;
        this.usuari = usuari;
        this.joc = joc;
        this.plataforma = plataforma;
        this.dataInici = dataInici;
        this.dataPrevista = dataInici.plusDays(DIES_LLOGUER);
        this.retornat = false;
    }

    public int getNumRegistre() {
        return numRegistre;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public Joc getJoc() {
        return joc;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public LocalDate getDataInici() {
        return dataInici;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public boolean isRetornat() {
        return retornat;
    }

    public void marcarRetornat() {
        this.retornat = true;
    }

    public boolean isForaDeTermini() {
        if (retornat) {
            return false;
        }
        return LocalDate.now().isAfter(dataPrevista);
    }

    public String getEstat() {
        if (retornat) {
            return "Retornat";
        } else if (isForaDeTermini()) {
            return "Fora de termini";
        } else {
            return "Actiu";
        }
    }
}
