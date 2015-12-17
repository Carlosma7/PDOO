/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.Monster;

/**
 *
 * @author carlos
 */
public class MonsterView extends javax.swing.JPanel {

    Monster monsterModel;
    
    
    public MonsterView() {
        initComponents();
    }
    
    public void setMonster(Monster t){
        // se actualiza el atributo de referencia
        monsterModel=t;
        // se actualiza la vista del tesoro
        this.LabelName.setText(monsterModel.getName());
        
        String my_levels = "Niveles (Normal/Sectario): " + monsterModel.getCombatLevel()
                + "/" + monsterModel.getCombatLevelAgainstCultistPlayer();
        this.LabelLevels.setText(my_levels);
        
        // actualizamos las vistas del prize y badConsequence
        this.VistaPrize.setPrize(t.getPrize());
        this.VistaBadConsequence.setBadConsequence(t.getBadConsequence());
        
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
        LabelLevels = new javax.swing.JLabel();
        VistaPrize = new GUI.PrizeView();
        VistaBadConsequence = new GUI.BadConsequenceView();

        LabelName.setText("Nombre");

        LabelLevels.setText("Niveles (Normal/Sectario)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(VistaPrize, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LabelName)
                        .addComponent(LabelLevels)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VistaBadConsequence, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelLevels)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(VistaBadConsequence, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(VistaPrize, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelLevels;
    private javax.swing.JLabel LabelName;
    private GUI.BadConsequenceView VistaBadConsequence;
    private GUI.PrizeView VistaPrize;
    // End of variables declaration//GEN-END:variables
}
