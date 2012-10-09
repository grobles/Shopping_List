/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GUI;

import com.Persistance.RecordSeeker;
import com.Shop;

import javax.swing.*;

/**
 * Class: Category
 * Description: In this for you can edit or add a new Shop
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 9/22/12
 * Time: 12:51 PM *
 */
public class EditShop extends javax.swing.JFrame {


    RecordSeeker recordSeekerShop;

    /**
     * Creates new form EditShop
     */
    public EditShop() {

        recordSeekerShop = new RecordSeeker("Shop");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabelShopName = new javax.swing.JLabel();
        jTextFieldShopName = new javax.swing.JTextField();
        jButtonClear = new javax.swing.JButton();
        jButtonSearch = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add/Edit Shop");

        jLabelShopName.setText("Shop Name");

        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelShopName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jTextFieldShopName, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(jButtonClear)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonSearch)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonSave)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonDelete)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonCancel)))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabelShopName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldShopName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonClear)
                                        .addComponent(jButtonSearch)
                                        .addComponent(jButtonSave)
                                        .addComponent(jButtonDelete)
                                        .addComponent(jButtonCancel))
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }

    /**
     * method: jButtonClearActionPerformed : Clear the form
     */
    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        jTextFieldShopName.setText("");
        jTextFieldShopName.requestFocus();
    }

    /**
     * method: jButtonSearchActionPerformed : Search for shop
     */

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {

        String name = jTextFieldShopName.getText();
        Shop shop = (Shop) recordSeekerShop.findItem(name);
        String message = "Shop not found";
        if (shop != null)
            message = "Shop found";
        JOptionPane.showMessageDialog(new JFrame(), message);
        jTextFieldShopName.requestFocus();


    }

    /**
     * method: jButtonSaveActionPerformed : save a Shop
     */

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        JFrame frame = new JFrame();
        String shopName = jTextFieldShopName.getText();
        Shop shopFound = (Shop) recordSeekerShop.findItem(shopName);
        if (shopName.equals("") || shopFound != null) {
            JOptionPane.showMessageDialog(new JFrame(), "That Shop already exists ");
            jTextFieldShopName.requestFocus();
        } else {
            int n = JOptionPane.showConfirmDialog(
                    frame,
                    "Would you like to save this Shop?",
                    "Confirm Save Shop",
                    JOptionPane.YES_NO_OPTION
            );
            if (n == 0) {

                Shop newShop = new Shop(shopName);
                recordSeekerShop.addItem(newShop);
                recordSeekerShop.writToXml();
                JOptionPane.showMessageDialog(new JFrame(), "Shop saved");
                jTextFieldShopName.setText("");
                jTextFieldShopName.requestFocus();
            } else if (n == 1)
                jTextFieldShopName.setText("");
            jTextFieldShopName.requestFocus();
        }
    }

    /**
     * method: jButtonDeleteActionPerformed : delete a Shop
     */

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        JFrame frame = new JFrame();
        String name = jTextFieldShopName.getText();
        Shop shopFound = (Shop) recordSeekerShop.findItem(name);
        if (shopFound == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Shop not found");
            jTextFieldShopName.requestFocus();
        } else {
            int n = JOptionPane.showConfirmDialog(
                    frame,
                    "Would you like to Delete this Shop?",
                    "Confirm Delete Shop",
                    JOptionPane.YES_NO_OPTION
            );
            if (n == 0) {
                recordSeekerShop.deleteProduct(shopFound);
                recordSeekerShop.writToXml();
                JOptionPane.showMessageDialog(new JFrame(), "Shop Deleted");
                jTextFieldShopName.setText("");
                jTextFieldShopName.requestFocus();
            } else if (n == 1)
                jTextFieldShopName.setText("");
            jTextFieldShopName.requestFocus();
        }
    }

    /**
     * method: jButtonCancelActionPerformed : Exit and save to file
     */

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed

        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new EditShop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabelShopName;
    private javax.swing.JTextField jTextFieldShopName;
    // End of variables declaration//GEN-END:variables
}
