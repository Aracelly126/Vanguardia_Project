/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Windows;

import Codes.Bloques;
import Codes.FiltradorAulas_Lab;
import Codes.Horario;
import Codes.Horarios;
import Codes.Lab_Aulas;
import com.toedter.calendar.IDateEvaluator;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class HorariosFISEI extends javax.swing.JPanel {
    
    /**
     * Creates new form HorariosFISEI
     */
    public HorariosFISEI() {
        initComponents();
        actualizarBloques();
        filtroDos();
        filtradoUno();
        configureJDateChooser();
        
    }
private void actualizarBloques() {
        Bloques bloquesDAO = new Bloques();
        List<String> bloques = bloquesDAO.BloquesUni();

        jcmbBloques.removeAllItems();
        for (String bloque : bloques) {
            jcmbBloques.addItem(bloque);
        }
    }

    public void filtradoUno() {
        String nombreBloque = (String) jcmbBloques.getSelectedItem();
        if (nombreBloque != null) {
            jcmbLabAulas.removeAllItems();
            List<String> tipos = FiltradorAulas_Lab.obtenerTiposPorBloque(nombreBloque);
            for (String tipo : tipos) {
                jcmbLabAulas.addItem(tipo);
            }
        }
    }

    public void filtroDos() {
        String nombreBloqueSeleccionado = (String) jcmbBloques.getSelectedItem();
        String tipoEspacioSeleccionado = (String) jcmbLabAulas.getSelectedItem();

        Lab_Aulas labAulas = new Lab_Aulas();
        List<String> aulas = labAulas.obtenerAulasPorBloque(nombreBloqueSeleccionado, tipoEspacioSeleccionado);

        jcmbNumLabAulas.removeAllItems();
        for (String aula : aulas) {
            jcmbNumLabAulas.addItem(aula);
        }
    }
    public void insertar() {
    Object bloqueSeleccionado = jcmbBloques.getSelectedItem();
    Object tipoEspacioSeleccionado = jcmbLabAulas.getSelectedItem();
    Object laboAulSeleccionado = jcmbNumLabAulas.getSelectedItem();
    if (bloqueSeleccionado == null || tipoEspacioSeleccionado == null || laboAulSeleccionado == null) {
        JOptionPane.showMessageDialog(null, "Seleccione un Aula o Laboratorio antes de continuar.");
        return;
    }
    String nombreBloque = bloqueSeleccionado.toString();
    String tipoEspacio = tipoEspacioSeleccionado.toString();
    String laboAul = laboAulSeleccionado.toString();
    Horarios horarios = new Horarios();
    List<Horario> horariosList = horarios.obtenerAulasPorBloqueYSala(nombreBloque, tipoEspacio, laboAul);
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);
    model.setColumnIdentifiers(new Object[]{"Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"});
    for (Horario horario : horariosList) {
        String hora = horario.getHora();
        String lunes = horario.getLunes() != null ? horario.getLunes() : "";
        String martes = horario.getMartes() != null ? horario.getMartes() : "";
        String miercoles = horario.getMiercoles() != null ? horario.getMiercoles() : "";
        String jueves = horario.getJueves() != null ? horario.getJueves() : "";
        String viernes = horario.getViernes() != null ? horario.getViernes() : "";
        model.addRow(new Object[]{hora, lunes, martes, miercoles, jueves, viernes});
    }
}
    
      private void configureJDateChooser() {
    jDateChooser2.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if ("date".equals(evt.getPropertyName())) {
                Date selectedDate = jDateChooser2.getDate();
                if (selectedDate != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(selectedDate);
                    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

                    if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
                        JOptionPane.showMessageDialog(null, "No se puede seleccionar sábados o domingos.", "Fecha no válida", JOptionPane.WARNING_MESSAGE);
                        jDateChooser2.setDate(null);
                    }
                }
            }
        }
    });
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jcmbBloques = new javax.swing.JComboBox<>();
        jcmbLabAulas = new javax.swing.JComboBox<>();
        jcmbNumLabAulas = new javax.swing.JComboBox<>();
        jbtnHorario = new javax.swing.JButton();
        jbtnReserva = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("BLOQUES");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Hora", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jcmbBloques.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcmbBloquesFocusLost(evt);
            }
        });
        jcmbBloques.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcmbBloquesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jcmbBloquesMousePressed(evt);
            }
        });
        jcmbBloques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbBloquesActionPerformed(evt);
            }
        });
        jcmbBloques.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcmbBloquesKeyPressed(evt);
            }
        });

        jcmbLabAulas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcmbLabAulasMouseClicked(evt);
            }
        });
        jcmbLabAulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbLabAulasActionPerformed(evt);
            }
        });

        jcmbNumLabAulas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcmbNumLabAulasMouseClicked(evt);
            }
        });

        jbtnHorario.setText("Ver Horario");
        jbtnHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHorarioActionPerformed(evt);
            }
        });

        jbtnReserva.setText("Realizar Reserva");

        jDateChooser2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbtnReserva)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcmbBloques, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtnHorario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jcmbLabAulas, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jcmbNumLabAulas, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(266, 266, 266))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnHorario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcmbNumLabAulas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcmbLabAulas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcmbBloques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnReserva)
                .addContainerGap(203, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcmbBloquesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcmbBloquesFocusLost

    }//GEN-LAST:event_jcmbBloquesFocusLost

    private void jcmbBloquesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmbBloquesMouseClicked

    }//GEN-LAST:event_jcmbBloquesMouseClicked

    private void jcmbBloquesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmbBloquesMousePressed

    }//GEN-LAST:event_jcmbBloquesMousePressed

    private void jcmbBloquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbBloquesActionPerformed

    }//GEN-LAST:event_jcmbBloquesActionPerformed

    private void jcmbBloquesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcmbBloquesKeyPressed

    }//GEN-LAST:event_jcmbBloquesKeyPressed

    private void jcmbLabAulasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmbLabAulasMouseClicked
        filtradoUno();
    }//GEN-LAST:event_jcmbLabAulasMouseClicked

    private void jcmbLabAulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbLabAulasActionPerformed

    }//GEN-LAST:event_jcmbLabAulasActionPerformed

    private void jcmbNumLabAulasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmbNumLabAulasMouseClicked
        filtroDos();
    }//GEN-LAST:event_jcmbNumLabAulasMouseClicked

    private void jbtnHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHorarioActionPerformed
    insertar();
    
    }//GEN-LAST:event_jbtnHorarioActionPerformed

    private void jDateChooser2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked
        
    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser2MouseClicked
       
    }//GEN-LAST:event_jDateChooser2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnHorario;
    private javax.swing.JButton jbtnReserva;
    private javax.swing.JComboBox<String> jcmbBloques;
    private javax.swing.JComboBox<String> jcmbLabAulas;
    private javax.swing.JComboBox<String> jcmbNumLabAulas;
    // End of variables declaration//GEN-END:variables
}
