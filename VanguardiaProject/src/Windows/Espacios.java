/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Windows;

import Utils.crud_bloques;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thexe
 */
public class Espacios extends javax.swing.JPanel {

    crud_bloques cb = new crud_bloques();
    DefaultTableModel tablamodelo = new DefaultTableModel(new Object[]{"Tipo", "Nombre", "Bloque"}, 0);
    int espacioID;
    /**
     * Creates new form Espacios
     */
    public Espacios() {
        initComponents();
        jTable1.setModel(tablamodelo);
        cb.cargarBloque(jcbxBloque);
        cb.cargarTabla(jTable1);
        jTable1.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            int filaSeleccionada = jTable1.getSelectedRow();
            cargarDatosDesdeTabla(filaSeleccionada);
        }
    });
    }

    private void cargarDatosDesdeTabla(int filaSeleccionada) {
        if (filaSeleccionada >= 0) {
            String tipo = (String) jTable1.getValueAt(filaSeleccionada, 0);
            String nombre = (String) jTable1.getValueAt(filaSeleccionada, 1);
            String bloque = (String) jTable1.getValueAt(filaSeleccionada, 2);
            espacioID = cb.obtenerIdEspacio(nombre, bloque);
            pnlCrearEspacio.setEnabled(false);
            jcbxTipo.setSelectedItem(tipo);
            jtxtNombre.setText(nombre);
            jcbxBloque.setSelectedItem(bloque);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbxTipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcbxBloque = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlEliminarEspacios = new Utils.PanelShadow();
        jLabel6 = new javax.swing.JLabel();
        pnlEditarEspacios = new Utils.PanelShadow();
        jLabel7 = new javax.swing.JLabel();
        pnlCrearEspacio = new Utils.PanelShadow();
        jLabel8 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("ESPACIOS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tipo:");

        jcbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LABORATORIO", "AULA", "ESPECIALl" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        jtxtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Bloque:");

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
        jScrollPane1.setViewportView(jTable1);

        pnlEliminarEspacios.setBackground(new java.awt.Color(173, 39, 46));
        pnlEliminarEspacios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlEliminarEspaciosMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ELIMINAR");

        javax.swing.GroupLayout pnlEliminarEspaciosLayout = new javax.swing.GroupLayout(pnlEliminarEspacios);
        pnlEliminarEspacios.setLayout(pnlEliminarEspaciosLayout);
        pnlEliminarEspaciosLayout.setHorizontalGroup(
            pnlEliminarEspaciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEliminarEspaciosLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(45, 45, 45))
        );
        pnlEliminarEspaciosLayout.setVerticalGroup(
            pnlEliminarEspaciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEliminarEspaciosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnlEditarEspacios.setBackground(new java.awt.Color(173, 39, 46));
        pnlEditarEspacios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlEditarEspaciosMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("EDITAR");

        javax.swing.GroupLayout pnlEditarEspaciosLayout = new javax.swing.GroupLayout(pnlEditarEspacios);
        pnlEditarEspacios.setLayout(pnlEditarEspaciosLayout);
        pnlEditarEspaciosLayout.setHorizontalGroup(
            pnlEditarEspaciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditarEspaciosLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel7)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        pnlEditarEspaciosLayout.setVerticalGroup(
            pnlEditarEspaciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditarEspaciosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pnlCrearEspacio.setBackground(new java.awt.Color(173, 39, 46));
        pnlCrearEspacio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCrearEspacioMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CREAR");

        javax.swing.GroupLayout pnlCrearEspacioLayout = new javax.swing.GroupLayout(pnlCrearEspacio);
        pnlCrearEspacio.setLayout(pnlCrearEspacioLayout);
        pnlCrearEspacioLayout.setHorizontalGroup(
            pnlCrearEspacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCrearEspacioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(64, 64, 64))
        );
        pnlCrearEspacioLayout.setVerticalGroup(
            pnlCrearEspacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCrearEspacioLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel8)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pnlEliminarEspacios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlEditarEspacios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlCrearEspacio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(347, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbxBloque, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(517, 517, 517))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jcbxBloque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlEliminarEspacios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlEditarEspacios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCrearEspacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 630));
    }// </editor-fold>//GEN-END:initComponents

    private void pnlCrearEspacioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCrearEspacioMouseClicked
        cb.crearEspacio(jcbxTipo, jtxtNombre, jcbxBloque, jTable1);   
        jtxtNombre.setText("");
    }//GEN-LAST:event_pnlCrearEspacioMouseClicked

    private void pnlEditarEspaciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEditarEspaciosMouseClicked
         cb.actualizarEspacio(espacioID,jcbxTipo, jtxtNombre, jcbxBloque, jTable1);
         jtxtNombre.setText("");
    }//GEN-LAST:event_pnlEditarEspaciosMouseClicked

    private void pnlEliminarEspaciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEliminarEspaciosMouseClicked
       cb.eliminarEspacio(espacioID, jTable1);
       jtxtNombre.setText("");
    }//GEN-LAST:event_pnlEliminarEspaciosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbxBloque;
    private javax.swing.JComboBox<String> jcbxTipo;
    private javax.swing.JTextField jtxtNombre;
    private Utils.PanelShadow pnlCrearEspacio;
    private Utils.PanelShadow pnlEditarEspacios;
    private Utils.PanelShadow pnlEliminarEspacios;
    // End of variables declaration//GEN-END:variables
}
