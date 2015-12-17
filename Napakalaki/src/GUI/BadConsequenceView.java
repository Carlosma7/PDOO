/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.BadConsequence;

/**
 *
 * @author carlos
 */
public class BadConsequenceView extends javax.swing.JPanel {

    private BadConsequence badConsequenceModel;
    
    
    public BadConsequenceView() {
        initComponents();
    }
    
    public void setBadConsequence (BadConsequence t) {
        // se actualiza el atributo de referencia
        badConsequenceModel = t;
        // se actualiza la vista del tesoro
        this.LabelBadConsequence.setText(badConsequenceModel.getText());
        
        // la siguiente instrucción hace que los cambios en la vista sean efectivos
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelBadConsequence = new javax.swing.JLabel();

        LabelBadConsequence.setText("Texto de la mala Consecuencia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelBadConsequence, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelBadConsequence)
                .addContainerGap(271, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelBadConsequence;
    // End of variables declaration//GEN-END:variables
}
