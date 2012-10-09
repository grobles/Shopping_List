/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GUI;

import com.Category;
import com.Persistance.RecordSeeker;

import javax.swing.*;

/**
 * Class: Category  Form
 * Description: In this for you can edit or add a new Category
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 9/22/12
 * Time: 12:51 PM *
 */
public class EditCategory extends JFrame {

    RecordSeeker recordSeekerCategory;

    /**
     * Creates new form NewJFrame
     */
    public EditCategory() {

        recordSeekerCategory = new RecordSeeker("Category");
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jInternalFrame1 = new JInternalFrame();
        jLabelproductName = new JLabel();
        jTextFieldCategoryName = new JTextField();
        jButtonSearch = new JButton();


        jButtonSave = new JButton();
        jButtonClear = new JButton();
        jButtonCancel = new JButton();
        jButtonDelete = new JButton();

        jInternalFrame1.setVisible(true);

        GroupLayout jInternalFrame1Layout = new GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
                jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
                jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Product");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jLabelproductName.setText("Category Name");

        jButtonSearch.setText("Search");
        jButtonSearch.setName("JButtonSearch");
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

        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.setToolTipText("");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelproductName)

                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldCategoryName, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addComponent(jButtonClear, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonSearch)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonSave, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonDelete)))
                                                .addGap(6, 6, 6)
                                                .addComponent(jButtonCancel))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelproductName)
                                .addGap(3, 3, 3)
                                .addComponent(jTextFieldCategoryName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)

                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)

                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonSave)
                                        .addComponent(jButtonCancel)
                                        .addComponent(jButtonClear)
                                        .addComponent(jButtonSearch)
                                        .addComponent(jButtonDelete))
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    /**
     * method: jButtonClearActionPerformed : Clear the form
     */
    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {
        jTextFieldCategoryName.setText("");
        jTextFieldCategoryName.requestFocus();
    }

    /**
     * method: jButtonSearchActionPerformed : Search for category
     */

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {
        String name = jTextFieldCategoryName.getText();
        Category category = (Category) recordSeekerCategory.findItem(name);
        String message = "Category not found";
        if (category != null) {
            message = "Category found";
        }
        JOptionPane.showMessageDialog(new JFrame(), message);
        jTextFieldCategoryName.requestFocus();

    }

    /**
     * method: jButtonSaveActionPerformed : save a Category
     */

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {

        JFrame frame = new JFrame();
        String categoryName = jTextFieldCategoryName.getText();
        Category categoryFound = (Category) recordSeekerCategory.findItem(categoryName);
        if (categoryName.equals("") || categoryFound != null) {
            JOptionPane.showMessageDialog(new JFrame(), "That category already exists");
        } else {
            int n = JOptionPane.showConfirmDialog(
                    frame,
                    "Would you like to save this Category?",
                    "Confirm Save Category",
                    JOptionPane.YES_NO_OPTION
            );
            if (n == 0) {
                Category newCategory = new Category(categoryName);
                recordSeekerCategory.addItem(newCategory);
                recordSeekerCategory.writToXml();
                JOptionPane.showMessageDialog(new JFrame(), "Category saved");

            }
            jTextFieldCategoryName.setText("");
            jTextFieldCategoryName.requestFocus();
        }
    }

    /**
     * method: jButtonDeleteActionPerformed : delete a category
     */
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new JFrame();
        String name = jTextFieldCategoryName.getText();
        Category categoryFound = (Category) recordSeekerCategory.findItem(name);
        if (categoryFound == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Category not found");
            jTextFieldCategoryName.requestFocus();
        } else {
            int n = JOptionPane.showConfirmDialog(
                    frame,
                    "Would you like to Delete this Category?",
                    "Confirm Delete Category",
                    JOptionPane.YES_NO_OPTION
            );
            if (n == 0) {
                recordSeekerCategory.deleteProduct(categoryFound);
                recordSeekerCategory.writToXml();
                JOptionPane.showMessageDialog(new JFrame(), "Category Deleted");

            }

            jTextFieldCategoryName.setText("");
            jTextFieldCategoryName.requestFocus();
        }
    }

    /**
     * method: jButtonCancelActionPerformed : Exit and save to file
     */
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {
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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new EditCategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JButton jButtonCancel;
    private JButton jButtonClear;
    private JButton jButtonDelete;
    private JButton jButtonSave;
    private JButton jButtonSearch;
    private JComboBox jComboBoxShop;
    private JInternalFrame jInternalFrame1;
    private JLabel jLabelproductName;
    private JTextField jTextFieldCategoryName;
    // End of variables declaration
}
