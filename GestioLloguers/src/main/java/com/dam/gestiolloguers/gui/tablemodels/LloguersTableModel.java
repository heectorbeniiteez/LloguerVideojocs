/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam.gestiolloguers.gui.tablemodels;

import com.dam.gestiolloguers.dto.Lloguer;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hecto
 */
public class LloguersTableModel extends AbstractTableModel {

    private String[] columnes = {"Núm. registre", "Títol del joc", "Usuari que l'ha llogat", "Plataforma",
        "Data d'inici", "Data de tornada", "Gènere", "Estat"};
    private ArrayList<Lloguer> lloguers;
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public LloguersTableModel(ArrayList<Lloguer> lloguers) {
        this.lloguers = lloguers;
    }

    @Override
    public int getRowCount() {
        return lloguers.size();
    }

    @Override
    public int getColumnCount() {
        return columnes.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnes[column];
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Lloguer l = lloguers.get(fila);
        switch (columna) {
            case 0:
                return String.format("%02d", l.getNumRegistre());
            case 1:
                return l.getJoc().getNom();
            case 2:
                return l.getUsuari().toString();
            case 3:
                return l.getPlataforma();
            case 4:
                return l.getDataInici().format(format);
            case 5:
                return l.getDataPrevista().format(format);
            case 6:
                return l.getJoc().getGenere();
            case 7:
                return l.getEstat();
        }
        return null;
    }

    public Lloguer getLloguer(int fila) {
        return lloguers.get(fila);
    }
}
