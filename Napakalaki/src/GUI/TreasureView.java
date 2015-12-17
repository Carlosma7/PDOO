/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.Treasure;

/**
 *
 * @author carlos
 */
public class TreasureView extends javax.swing.JPanel {

    Treasure treasureModel;
    
    
    public TreasureView() {
        initComponents();
    }
    
    public void setTreasure (Treasure aTreasure) {
        // se actualiza el atributo de referencia
        treasureModel = aTreasure;
        // se actualiza la vista del tesoro
        this.LabelName.setText (treasureModel.getName());
        
        String my_bonus = "Bonus: " + Integer.toString(treasureModel.getBonus());
        this.LabelBonus.setText(my_bonus);
        
        String my_type = "Tipo: " + treasureModel.getType().toString();
        this.LabelType.setText(my_type);
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

        LabelName = new javax.swing.JLabel();
        LabelBonus = new javax.swing.JLabel();
        LabelType = new javax.swing.JLabel();

        LabelName.setText("Nombre:");

        LabelBonus.setText("Bonus:");

        LabelType.setText("Tipo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelType, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelName)
                    .addComponent(LabelBonus)
                    .addComponent(LabelType))
                .addContainerGap(255, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelBonus;
    private javax.swing.JLabel LabelName;
    private javax.swing.JLabel LabelType;
    // End of variables declaration//GEN-END:variables
}
