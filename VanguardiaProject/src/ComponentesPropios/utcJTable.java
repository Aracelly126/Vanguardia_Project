package ComponentesPropios;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class utcJTable extends JTable {

    DefaultTableModel modelotabla = new DefaultTableModel(new Object[]{"Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"}, 12);

    public utcJTable() {
        this.setModel(modelotabla);
        this.setDefaultEditor(Object.class, null); // Esto deshabilita la edición de celdas
        this.setCellSelectionEnabled(true);
        horasDia();
        cambiarTamanioCeldasAncho();
        cambiarTamanioCeldasLargo();
        aplicarEstilos();
    }

    private void aplicarEstilos() {
        DefaultTableCellRenderer renderizador = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.BLACK));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                if (value != null) {
                    label.setText("<html>" + value.toString().replaceAll("\n", "<br>"));
                } else {
                    label.setText("");
                }
                return label;
            }
        };

        for (int i = 0; i < this.getColumnCount(); i++) {
            this.getColumnModel().getColumn(i).setCellRenderer(renderizador);
        }
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int fila, int columna) {
        Component componente = super.prepareRenderer(renderer, fila, columna);
        Object valorCelda = getValueAt(fila, columna);
        String valor = String.valueOf(valorCelda);

        // Verificar si la columna es la columna de la hora
        if (columna == 0) {
            // Cambiar el color de fondo y el texto para la columna de la hora
            componente.setBackground(Color.WHITE);
            componente.setForeground(Color.BLACK);
        } else {
            // Verificar si el valor contiene "Clase" o "Reservado" para aplicar el color de fondo apropiado
            if (valor != null) {
                if (valor.contains("Clase")) {
                    componente.setBackground(new Color(243, 76, 53)); // Color rojo para clases
                    componente.setForeground(Color.BLACK);
                } else if (valor.contains("Reservado")) {
                    componente.setBackground(new Color(173, 216, 230)); // Color celeste para reservas
                    componente.setForeground(Color.BLACK);
                } else {
                    componente.setBackground(new Color(152, 251, 152)); // Verde claro, más opaco
                    componente.setForeground(Color.BLACK);
                }
            } else {
                componente.setBackground(new Color(152, 251, 152)); // Verde claro, más opaco
                componente.setForeground(Color.BLACK);
            }
        }
        return componente;
    }

    public void horasDia() { // Asegúrate de que este método sea público
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setValueAt("07:00-08:00", 0, 0);
        this.setValueAt("08:00-09:00", 1, 0);
        this.setValueAt("09:00-10:00", 2, 0);
        this.setValueAt("10:00-11:00", 3, 0);
        this.setValueAt("11:00-12:00", 4, 0);
        this.setValueAt("12:00-13:00", 5, 0);
        this.setValueAt("14:00-15:00", 6, 0);
        this.setValueAt("15:00-16:00", 7, 0);
        this.setValueAt("16:00-17:00", 8, 0);
        this.setValueAt("17:00-18:00", 9, 0);
        this.setValueAt("18:00-19:00", 10, 0);
        this.setValueAt("19:00-20:00", 11, 0);
    }

    private void cambiarTamanioCeldasLargo() {
        for (int i = 0; i < this.getColumnCount() - 1; i++) {
            this.getColumnModel().getColumn(i + 1).setPreferredWidth(160);
        }
        this.getColumnModel().getColumn(0).setPreferredWidth(100);
    }

    private void cambiarTamanioCeldasAncho() {
        for (int i = 0; i < this.getRowCount(); i++) {
            this.setRowHeight(i + 1, 85);
        }
        this.setRowHeight(0, 70);
    }
}
