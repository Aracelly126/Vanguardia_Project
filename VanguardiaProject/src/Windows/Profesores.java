/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Windows;

import Utils.Conex;
import Utils.Crud_AgregarProfesor;
import Utils.crud_editarProfesor;
import Utils.crud_profesores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thexe
 */
public class Profesores extends javax.swing.JPanel {

    crud_profesores profesores = new crud_profesores();
    Crud_AgregarProfesor ps = new Crud_AgregarProfesor();
    crud_editarProfesor ep = new crud_editarProfesor();

    DefaultTableModel tablaModelo = new DefaultTableModel(new Object[]{"Identificador", "Cedula", "Nombre", "Apellido"}, 0);
    String nombre = "";
    int idpro = 0;

    /**
     * Creates new form Profesores
     */
    public Profesores() {
        initComponents();
        jTable1.setModel(tablaModelo);
        profesores.cargarTabla(jTable1);
        jbtnCancelar.setEnabled(false);
        jtxtIdentificador.setEnabled(false);
        profesores.actualizarLabelIdentificador(jtxtIdentificador);

        jtxtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtNombreFocusLost(evt);
            }
        });

    }

    private void jtxtNombreFocusLost(java.awt.event.FocusEvent evt) {
        // Recuperar el texto del JTextField cuando pierde el foco
        nombre = jtxtNombre.getText();
        System.out.println(nombre);

    }

    private void mostrarDatosSeleccionados() {
        int filaSeleccionada = jTable1.getSelectedRow();

        if (filaSeleccionada >= 0) {
            String identificador = jTable1.getValueAt(filaSeleccionada, 0).toString();
            String cedula = (String) jTable1.getValueAt(filaSeleccionada, 1);
            String nombre = (String) jTable1.getValueAt(filaSeleccionada, 2);
            String apellido = (String) jTable1.getValueAt(filaSeleccionada, 3);

            // Mostrar los datos en los componentes correspondientes
            jbtnCrear.setEnabled(false);
            jbtnCancelar.setEnabled(true);
            jtxtNombre.setText(nombre);
            jtxtCedula.setText(cedula);
            jtxtApellido.setText(apellido);
            jtxtIdentificador.setText(identificador);

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbtnCrear = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnEditar = new javax.swing.JButton();
        jtxtApellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxtCedula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtIdentificador = new javax.swing.JTextField();
        jbtnCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("PROFESORES");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));
        add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 142, 150, -1));

        jLabel2.setText("Nombre:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 145, -1, -1));

        jLabel5.setText("Apellido:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 580, 320));

        jbtnCrear.setText("Crear");
        jbtnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnCrearMouseClicked(evt);
            }
        });
        jbtnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCrearActionPerformed(evt);
            }
        });
        add(jbtnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });
        add(jbtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        jbtnEditar.setText("Editar");
        jbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditarActionPerformed(evt);
            }
        });
        add(jbtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, -1, -1));
        add(jtxtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 177, 150, -1));

        jLabel6.setText("Cedula:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));
        add(jtxtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 107, 150, -1));

        jLabel7.setText("Identificador:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, -1));
        add(jtxtIdentificador, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 107, 80, -1));

        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });
        add(jbtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCrearActionPerformed
        if (profesores.ComprobarCedula2(jtxtCedula.getText())) {
            profesores.addProfesor(jtxtIdentificador.getText(), jtxtCedula.getText(), jtxtNombre.getText(), jtxtApellido.getText(), jTable1);
            profesores.actualizarLabelIdentificador(jtxtIdentificador);
            jtxtCedula.setText("");
            jtxtNombre.setText("");
            jtxtApellido.setText("");
        }else{
            return;
        }

    }//GEN-LAST:event_jbtnCrearActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada != -1) {
            profesores.eliminarProfesor(jtxtIdentificador.getText(), jTable1);
            profesores.actualizarLabelIdentificador(jtxtIdentificador);
            jtxtCedula.setText("");
            jtxtNombre.setText("");
            jtxtApellido.setText("");
            jbtnCancelar.setEnabled(false);
            jbtnCrear.setEnabled(true);
        } else {
            System.out.println("Por favor, seleccione un profesor para eliminar.");
        }
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada != -1) {
            if (profesores.ComprobarCedula2(jtxtCedula.getText())) {
                profesores.editarProfesor(jtxtIdentificador.getText(), jtxtCedula.getText(), jtxtNombre.getText(), jtxtApellido.getText(), jTable1);
            profesores.actualizarLabelIdentificador(jtxtIdentificador);
            jtxtCedula.setText("");
            jtxtNombre.setText("");
            jtxtApellido.setText("");
            jbtnCancelar.setEnabled(false);
            jbtnCrear.setEnabled(true);
            }else{
                return;
            }
            
        } else {
            System.out.println("Por favor, seleccione un profesor para editar.");
        }

    }//GEN-LAST:event_jbtnEditarActionPerformed

    private void jbtnCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnCrearMouseClicked

    }//GEN-LAST:event_jbtnCrearMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        mostrarDatosSeleccionados();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        // TODO add your handling code here:
        profesores.actualizarLabelIdentificador(jtxtIdentificador);
        jtxtCedula.setText("");
        jtxtNombre.setText("");
        jtxtApellido.setText("");
    }//GEN-LAST:event_jbtnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnCrear;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JTextField jtxtApellido;
    private javax.swing.JTextField jtxtCedula;
    private javax.swing.JTextField jtxtIdentificador;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
