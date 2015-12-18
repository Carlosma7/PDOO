/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.Prize;

/**
 *
 * @author carlos
 */
public class PrizeView extends javax.swing.JPanel {

    private Prize prizeModel;
    
    
    public PrizeView() {
        initComponents();
    }
    
    public void setPrize (Prize t) {
        // se actualiza el atributo de referencia
        prizeModel = t;
        // se actualiza la vista del tesoro
        String my_prize = "Tesoros: " + Integer.toString(prizeModel.getTreasure()) +
                ". Niveles: " + Integer.toString(prizeModel.getLevel()) + ".";
        this.LabelTreasuresAndLevels.setText(my_prize);
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

        LabelTreasuresAndLevels = new javax.swing.JLabel();

        LabelTreasuresAndLevels.setText("Tesoros y niveles");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelTreasuresAndLevels, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelTreasuresAndLevels)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTreasuresAndLevels;
    // End of variables declaration//GEN-END:variables
}
