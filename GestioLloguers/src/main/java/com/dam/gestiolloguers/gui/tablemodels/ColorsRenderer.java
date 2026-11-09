package com.dam.gestiolloguers.gui.tablemodels;


import com.dam.gestiolloguers.dto.Lloguer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorsRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (isSelected) {
            return c;
        }

        LloguersTableModel model = (LloguersTableModel) table.getModel();
        Lloguer l = model.getLloguer(row);

        if (l.isRetornat()) {
            c.setBackground(new Color(200, 240, 200));
        } else if (l.isForaDeTermini()) {
            c.setBackground(new Color(245, 200, 200));
        } else {
            c.setBackground(Color.WHITE);
        }
        return c;
    }
}