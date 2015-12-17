/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author carlos
 */
public class PlayerView extends javax.swing.JPanel {

    Player playerModel;
    
    
    public PlayerView() {
        initComponents();
    }
    
    public void setPlayer(Player player){
        // se actualiza el atributo de referencia
        playerModel=player;
        // se actualiza la vista del tesoro
        String my_name = "Enemigo: " + playerModel.getName();
        this.LabelName.setText(my_name);
        
        String my_level = "Enemigo: " + Integer.toString(playerModel.getLevels());
        this.LabelLevel.setText(my_level);
        
        String my_combat_level = "Enemigo: " + Integer.toString(playerModel.getCombatLevel());
        this.LabelCombatLevel.setText(my_combat_level);
        
        String my_enemy = "Enemigo: " + playerModel.getEnemy().getName();
        this.LabelEnemy.setText(my_enemy);
        
        String is_cultist = "Sectario: " + playerModel.IsCultist();
        this.LabelCultist.setText(is_cultist);
        // Actualizamos tesoros
        this.fillTreasurePanel(visibleTreasures,playerModel.getVisibleTreasures());
        this.fillTreasurePanel(hiddenTreasures,playerModel.getHiddenTreasures());
        repaint();
        revalidate();
    }
    
    private void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
        // Se elimina la información antigua, si la hubiera
        aPanel.removeAll();
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
        // al panel
        for (Treasure t : aList) {
        TreasureView aTreasureView = new TreasureView();
        aTreasureView.setTreasure (t);
        aTreasureView.setVisible (true);
        aPanel.add (aTreasureView);
        }
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
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
        LabelLevel = new javax.swing.JLabel();
        LabelCombatLevel = new javax.swing.JLabel();
        LabelEnemy = new javax.swing.JLabel();
        LabelCultist = new javax.swing.JLabel();
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();
        ButtonStealTreasure = new javax.swing.JButton();
        ButtonMakeVisible = new javax.swing.JButton();
        ButtonDiscardTreasures = new javax.swing.JButton();
        ButtonDiscardAllTreasures = new javax.swing.JButton();
        pendingBadConsequenceView1 = new GUI.PendingBadConsequenceView();

        LabelName.setText("Nombre");

        LabelLevel.setText("Nivel");

        LabelCombatLevel.setText("Nivel de combate");

        LabelEnemy.setText("Enemigo");

        LabelCultist.setText("Sectario");

        visibleTreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ButtonStealTreasure.setText("Steal Treasure");

        ButtonMakeVisible.setText("Make Visible");

        ButtonDiscardTreasures.setText("Discard Treasures");

        ButtonDiscardAllTreasures.setText("Discard All Treasures");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelName)
                    .addComponent(LabelLevel)
                    .addComponent(LabelCombatLevel)
                    .addComponent(LabelEnemy)
                    .addComponent(LabelCultist)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonDiscardTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonDiscardAllTreasures))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonStealTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonMakeVisible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pendingBadConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelLevel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelCombatLevel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelEnemy))
                    .addComponent(pendingBadConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelCultist)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonMakeVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonStealTreasure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonDiscardTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonDiscardAllTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonDiscardAllTreasures;
    private javax.swing.JButton ButtonDiscardTreasures;
    private javax.swing.JButton ButtonMakeVisible;
    private javax.swing.JButton ButtonStealTreasure;
    private javax.swing.JLabel LabelCombatLevel;
    private javax.swing.JLabel LabelCultist;
    private javax.swing.JLabel LabelEnemy;
    private javax.swing.JLabel LabelLevel;
    private javax.swing.JLabel LabelName;
    private javax.swing.JPanel hiddenTreasures;
    private GUI.PendingBadConsequenceView pendingBadConsequenceView1;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}