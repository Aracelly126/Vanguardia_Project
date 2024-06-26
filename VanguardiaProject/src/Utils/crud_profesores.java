package Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class crud_profesores {

    public void cargarTabla(JTable table) {
        try {
            String query = "SELECT identificador, cedula, nombre, apellido FROM profesores";
            PreparedStatement preparedStatement = Conex.getConex().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                String identificador = resultSet.getString("identificador");
                String cedula = resultSet.getString("cedula");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                model.addRow(new Object[]{identificador, cedula, nombre, apellido});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProfesor(String identificador, String cedula, String nombre, String apellido, JTable table) {
        String insertQuery = "INSERT INTO profesores (identificador, cedula, nombre, apellido) VALUES (?, ?, ?, ?)";

        Connection connection = Conex.getConex();

        try {
            PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
            insertStmt.setString(1, identificador);
            insertStmt.setString(2, cedula);
            insertStmt.setString(3, nombre);
            insertStmt.setString(4, apellido);
            insertStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Profesor Agregado Correctamente");
            cargarTabla(table);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProfesor(String identificador, JTable table) {
        int confirmacion = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de que desea eliminar al profesor con identificador " + identificador + "?",
                "Confirmación de Eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM profesores WHERE identificador = ?";
                PreparedStatement statement = Conex.getConex().prepareStatement(sql);
                statement.setString(1, identificador);
                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "El profesor con identificador " + identificador + " ha sido eliminado correctamente.");
                    cargarTabla(table);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún profesor con el identificador " + identificador);
                }
            } catch (SQLException e) {
                System.err.println("Error al eliminar al profesor: " + e.getMessage());
            }
        }
    }

    public void editarProfesor(String identificador, String cedula, String nombre, String apellido, JTable table) {
        String updateQuery = "UPDATE profesores SET cedula = ?, nombre = ?, apellido = ? WHERE identificador = ?";

        try {
            Connection connection = Conex.getConex();
            PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
            updateStmt.setString(1, cedula);
            updateStmt.setString(2, nombre);
            updateStmt.setString(3, apellido);
            updateStmt.setString(4, identificador);
            int filasAfectadas = updateStmt.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "El profesor con identificador " + identificador + " ha sido actualizado correctamente.");
                cargarTabla(table);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún profesor con el identificador " + identificador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String obtenerUltimoIdentificador() {
        String ultimoIdentificador = null;
        String query = "SELECT identificador FROM profesores ORDER BY identificador DESC LIMIT 1";

        try {
            Connection connection = Conex.getConex();
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ultimoIdentificador = rs.getString("identificador");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ultimoIdentificador;
    }

    // Método para generar el siguiente identificador
    public String generarSiguienteIdentificador(String ultimoIdentificador) {
        if (ultimoIdentificador == null || ultimoIdentificador.isEmpty()) {
            return "PF001";
        }

        String prefix = ultimoIdentificador.substring(0, 2);
        int numero = Integer.parseInt(ultimoIdentificador.substring(2));
        numero++;

        return prefix + String.format("%03d", numero);
    }

    // Método para actualizar el label del identificador
    public void actualizarLabelIdentificador(JTextField labelIdentificador) {
        String ultimoIdentificador = obtenerUltimoIdentificador();
        String siguienteIdentificador = generarSiguienteIdentificador(ultimoIdentificador);
        labelIdentificador.setText(siguienteIdentificador);
    }

    public boolean ComprobarCedula2(String dato) {
        String cedula = dato;
        if (cedula.isEmpty()) {
            return false;
        }

        if (!cedula.matches("[0-9]{10}")) {
            JOptionPane.showMessageDialog(null, "Ingrese una cédula válida");
            return false;
        }

        int tercerdigito = Integer.parseInt(cedula.substring(2, 3));
        if (tercerdigito >= 6) {
            JOptionPane.showMessageDialog(null, "Ingrese una cédula válida");
            return false;
        }

        int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int verificador = Integer.parseInt(cedula.substring(9, 10));
        int suma = 0;
        int digito = 0;
        for (int i = 0; i < (cedula.length() - 1); i++) {
            digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
            suma += ((digito % 10) + (digito / 10));
        }
        if ((suma % 10 != 0) && (10 - (suma % 10)) != verificador) {
            JOptionPane.showMessageDialog(null, "Ingrese una cédula válida");
            return false;
        }

        return true;
    }

}
