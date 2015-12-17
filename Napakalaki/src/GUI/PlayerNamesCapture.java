/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author carlos
 */
public class PlayerNamesCapture extends javax.swing.JDialog {

    private ArrayList<String> names=new ArrayList();
    
    public PlayerNamesCapture(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.addWindowListener (new WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent e) {
            System.exit(0);
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelPlayer1 = new javax.swing.JLabel();
        NombrePlayer1 = new javax.swing.JTextField();
        BotonPlay = new javax.swing.JButton();
        BotonCancel = new javax.swing.JButton();
        LabelPlayer2 = new javax.swing.JLabel();
        NombrePlayer2 = new javax.swing.JTextField();
        LabelPlayer3 = new javax.swing.JLabel();
        NombrePlayer3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LabelPlayer1.setText("Jugador 1:");

        NombrePlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombrePlayer1ActionPerformed(evt);
            }
        });

        BotonPlay.setText("Play");
        BotonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPlayActionPerformed(evt);
            }
        });

        BotonCancel.setText("Cancel");
        BotonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCancelActionPerformed(evt);
            }
        });

        LabelPlayer2.setText("Jugador 2:");

        LabelPlayer3.setText("Jugador 3:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelPlayer3)
                                .addGap(18, 18, 18)
                                .addComponent(NombrePlayer3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LabelPlayer2)
                                    .addGap(18, 18, 18)
                                    .addComponent(NombrePlayer2))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LabelPlayer1)
                                    .addGap(18, 18, 18)
                                    .addComponent(NombrePlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(BotonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPlayer1)
                    .addComponent(NombrePlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPlayer2)
                    .addComponent(NombrePlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPlayer3)
                    .addComponent(NombrePlayer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonPlay)
                    .addComponent(BotonCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPlayActionPerformed
        // Añadimos los nombres introducidos
        names.add (NombrePlayer1.getText());
        names.add (NombrePlayer2.getText());
        names.add (NombrePlayer3.getText());
        
        this.dispose();
    }//GEN-LAST:event_BotonPlayActionPerformed

    private void BotonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCancelActionPerformed
        System.exit(0); // Finalizamos la ejecucion del programa
    }//GEN-LAST:event_BotonCancelActionPerformed

    private void NombrePlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombrePlayer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombrePlayer1ActionPerformed

    public ArrayList<String> getNames() {
        this.setVisible(true);
        return names;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCancel;
    private javax.swing.JButton BotonPlay;
    private javax.swing.JLabel LabelPlayer1;
    private javax.swing.JLabel LabelPlayer2;
    private javax.swing.JLabel LabelPlayer3;
    private javax.swing.JTextField NombrePlayer1;
    private javax.swing.JTextField NombrePlayer2;
    private javax.swing.JTextField NombrePlayer3;
    // End of variables declaration//GEN-END:variables
}
