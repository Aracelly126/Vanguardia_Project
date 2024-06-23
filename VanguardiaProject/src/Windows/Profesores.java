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

    DefaultTableModel tablaModelo = new DefaultTableModel(new Object[]{"Profesor", "Materia", "Tipo", "Nombre", "Bloque"}, 0);
    String nombre = "";
    int idpro = 0;

    /**
     * Creates new form Profesores
     */
    public Profesores() {
        initComponents();
        jTable1.setModel(tablaModelo);
        profesores.cargarBloque(jcbxBloques);
        profesores.cargarTabla(jTable1);
        setEventHandlers();

        jtxtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtNombreFocusLost(evt);
            }
        });

    }

    private void setEventHandlers() {
        jcbxBloques.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jcbxBloques.getSelectedItem().toString());
                cargarAulasOLaboratorios();
                //profesores.cargarMaterias(jcbxMateria, jcbxBloques, jcbxTipo);
                
                System.out.println(jcbxBloques.getSelectedItem().toString());
            }
        });

        jcbxTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarAulasOLaboratorios();
                cargarMateria();
                
                
            }
        });

        jcbxMateria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarMateria();
            }
        });
    }

    private void cargarMateria() {
        String selectedBloque = (String) jcbxBloques.getSelectedItem();
        String selectedTipo = (String) jcbxTipo.getSelectedItem();
        profesores.cargarMaterias(jcbxMateria, selectedBloque, selectedTipo);
    }

    private void cargarAulasOLaboratorios() {
        Object selectedBloqueObj = jcbxBloques.getSelectedItem();
        Object selectedTipoObj = jcbxTipo.getSelectedItem();
        if (selectedBloqueObj != null && selectedTipoObj != null) {
            String selectedBloque = selectedBloqueObj.toString();
            String selectedTipo = selectedTipoObj.toString();
            System.out.println("Selected Bloque: " + selectedBloque);
            System.out.println("Selected Tipo: " + selectedTipo);
            profesores.llenarComboBoxAulas(jComboBox1, jcbxTipo, jcbxBloques);
        } else {
            System.out.println("No hay bloque o tipo seleccionado.");
        }
    }

    private void jtxtNombreFocusLost(java.awt.event.FocusEvent evt) {
        // Recuperar el texto del JTextField cuando pierde el foco
        nombre = jtxtNombre.getText();
        System.out.println(nombre);

    }

    private void mostrarDatosSeleccionados() {
        int filaSeleccionada = jTable1.getSelectedRow();

        if (filaSeleccionada >= 0) {
            String nombre = jTable1.getValueAt(filaSeleccionada, 0).toString();
            String materiaSeleccionada = (String) jTable1.getValueAt(filaSeleccionada, 1);
            String tiposeleccionado = (String) jTable1.getValueAt(filaSeleccionada, 2);
            String aulaSeleccionada = (String) jTable1.getValueAt(filaSeleccionada, 3);
            String bloqueSeleccionado = (String) jTable1.getValueAt(filaSeleccionada, 4);
            

            // Mostrar los datos en los componentes correspondientes
            jtxtNombre.setText(nombre);
            jcbxMateria.setSelectedItem(materiaSeleccionada);
            jcbxTipo.setSelectedItem(tiposeleccionado);
            jcbxBloques.setSelectedItem(bloqueSeleccionado);
            jComboBox1.setSelectedItem(aulaSeleccionada);
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
        jcbxMateria = new javax.swing.JComboBox<>();
        jcbxBloques = new javax.swing.JComboBox<>();
        jcbxTipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("PROFESORES");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));
        add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 150, -1));

        jcbxMateria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        add(jcbxMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 150, -1));

        add(jcbxBloques, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 140, -1));

        jcbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LABORATORIO", "AULA", "ESPECIAL" }));
        jcbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxTipoActionPerformed(evt);
            }
        });
        add(jcbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 140, -1));

        jLabel2.setText("Nombre:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        jLabel3.setText("Bloque:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        jLabel4.setText("Tipo:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, -1));

        jLabel5.setText("Materia:");
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

        jButton1.setText("Crear");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, -1, -1));

        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 140, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jcbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxTipoActionPerformed
        // TODO add your handling code here:
        System.out.println(jtxtNombre.getText());

    }//GEN-LAST:event_jcbxTipoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String nombre = jtxtNombre.getText();
            String materiaSeleccionada = (String) jcbxMateria.getSelectedItem();
            String bloqueSeleccionado = (String) jcbxBloques.getSelectedItem();
            String tipoSeleccionado = (String) jcbxTipo.getSelectedItem();
            String aulaSeleccionada = (String) jComboBox1.getSelectedItem();
            profesores.addProfesor(nombre, materiaSeleccionada, bloqueSeleccionado, tipoSeleccionado, aulaSeleccionada, jTable1);
            jtxtNombre.setText("");
            
        } catch (Exception ex) {
            Logger.getLogger(Profesores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada != -1) {
            String nombreProfesor = jTable1.getValueAt(filaSeleccionada, 0).toString();
            profesores.eliminarProfesor(nombreProfesor, jTable1);
        } else {
            System.out.println("Por favor, seleccione un profesor para eliminar.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        profesores.editarProfesor(nombre, jcbxTipo.getSelectedItem().toString(), jComboBox1.getSelectedItem().toString(), jcbxMateria.getSelectedItem().toString(), nombre);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        mostrarDatosSeleccionados();
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbxBloques;
    private javax.swing.JComboBox<String> jcbxMateria;
    private javax.swing.JComboBox<String> jcbxTipo;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}