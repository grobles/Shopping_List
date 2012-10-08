/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GUI;

import com.Category;
import com.DataContainers;
import com.Product;
import com.Utilities.RecordSeeker;

import javax.swing.*;

/**
 * Class: Product edit  Form
 * Description: In this for you can edit or add a new Product
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 9/22/12
 * Time: 12:51 PM *
 */
public class EditProduct extends JFrame {
    DataContainers dc;
    private String[] comboCategory;
    private String[] comboShop;
    private String[] comboUnit;
    RecordSeeker recordSeekerShop;
    RecordSeeker recordSeekerCategory;
    RecordSeeker recordSeekerProduct;

    /**
     * Creates new form NewJFrame
     */
    public EditProduct() {
        recordSeekerShop = new RecordSeeker("Shop");
        recordSeekerCategory = new RecordSeeker("Category");
        recordSeekerProduct = new RecordSeeker("Product");
        comboUnit = recordSeekerProduct.getDc().getUnitsList();
        comboCategory = recordSeekerCategory.makeCombo();
        comboShop = recordSeekerShop.makeCombo();
        initComponents();
    }


    /**
     * method: jComboBoxCategoryActionPerformed : Sets the right Category for the selected shop
     */

    private void jComboBoxCategoryActionPerformed(java.awt.event.ActionEvent evt) {
        String categoryName = jComboBoxCategory.getSelectedItem().toString();
        Category category = (Category) recordSeekerCategory.findItem(categoryName);
        jTextFieldShop.setText(category.getShop().getItemName());
    }

    /**
     * method: jButtonClearActionPerformed : Clear the form
     */

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {
        jTextFieldProductName.setText("");
        jTextFieldQuantity.setText("");
        jTextFieldShop.setText("");
        jTextFieldProductName.requestFocus();
    }

    /**
     * method: jButtonSearchActionPerformed : Search for category
     */
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {
        String name = jTextFieldProductName.getText();
        Product product = (Product) recordSeekerProduct.findItem(name);
        String message = "Product not found";
        if (product != null) {
            message = "Product found";
            Category category = product.getItemCategory();
            jComboBoxCategory.setSelectedItem(category.getItemName());
            String shopName = category.getShop().getItemName();
            jTextFieldShop.setText(shopName);
            String quantity = Integer.toString(product.getItemQuantity());
            jTextFieldQuantity.setText(quantity);
            jComboBoxUnits.setSelectedItem(product.getItemUnit());
        }
        JOptionPane.showMessageDialog(new JFrame(), message);
        jTextFieldProductName.requestFocus();

    }

    /**
     * method: jButtonSaveActionPerformed : save a Shop
     */
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new JFrame();
        String productName = jTextFieldProductName.getText();
        Product productFound = (Product) recordSeekerCategory.findItem(productName);
        if (productName.equals("") || productFound != null) {
            int n = JOptionPane.showConfirmDialog(
                    frame,
                    "That product already exists.Would you like to edit this Product?",
                    "Confirm Edit Category",
                    JOptionPane.YES_NO_OPTION
            );
            if (n == 0) {
                String categoryName = jComboBoxCategory.getSelectedItem().toString();
                Category category = (Category) recordSeekerShop.findItem(categoryName);
                productFound.setItemCategory(category);
                int qty = Integer.parseInt(jTextFieldQuantity.getText().toString());
                productFound.setItemQuantity(qty);
                productFound.setItemUnit(jComboBoxUnits.getSelectedItem().toString());
                JOptionPane.showMessageDialog(new JFrame(), "Product edited");
                jTextFieldProductName.setText("");
                jTextFieldProductName.requestFocus();
            } else if (n == 1)
                jTextFieldProductName.requestFocus();
        } else {
            int n = JOptionPane.showConfirmDialog(
                    frame,
                    "Would you like to save this Product?",
                    "Confirm Save Category",
                    JOptionPane.YES_NO_OPTION
            );
            if (n == 0) {
                int quantity = Integer.parseInt(jTextFieldQuantity.getText());
                String categoryName = jComboBoxCategory.getSelectedItem().toString();
                Category category = (Category) recordSeekerCategory.findItem(categoryName);
                Product newProduct = new Product.Builder(productName, category).quantity(quantity).build();
                recordSeekerProduct.addItem(newProduct);
                JOptionPane.showMessageDialog(new JFrame(), "Product saved");
                jTextFieldProductName.setText("");
                jTextFieldProductName.requestFocus();
            } else if (n == 1)
                jTextFieldProductName.setText("");
            jTextFieldProductName.requestFocus();
        }
    }


    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new JFrame();
        String name = jTextFieldProductName.getText();
        if (recordSeekerProduct.findItem(name) == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Product not found");
            jTextFieldProductName.requestFocus();
        } else {
            int n = JOptionPane.showConfirmDialog(
                    frame,
                    "Would you like to Delete this Product?",
                    "Confirm Delete Product",
                    JOptionPane.YES_NO_OPTION
            );
            if (n == 0) {
                recordSeekerProduct.deleteProduct(name);
                JOptionPane.showMessageDialog(new JFrame(), "Product Deleted");
                jTextFieldProductName.setText("");
                jTextFieldProductName.requestFocus();
            } else if (n == 1)
                jTextFieldProductName.setText("");
            jTextFieldProductName.requestFocus();
        }
    }


    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {
        recordSeekerProduct.writToFile();
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
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new EditProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JButton jButtonCancel;
    private JButton jButtonClear;
    private JButton jButtonDelete;
    private JButton jButtonSave;
    private JButton jButtonSearch;
    private JComboBox jComboBoxCategory;
    private JComboBox jComboBoxUnits;
    private JInternalFrame jInternalFrame1;
    private JLabel jLabelCategory;
    private JLabel jLabelQuantity;
    private JLabel jLabelShop;
    private JLabel jLabelUnits;
    private JLabel jLabelproductName;
    private JTextField jTextFieldProductName;
    private JTextField jTextFieldQuantity;
    private JTextField jTextFieldShop;
    // End of variables declaration

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jInternalFrame1 = new JInternalFrame();
        jLabelproductName = new JLabel();
        jTextFieldProductName = new JTextField();
        jButtonSearch = new JButton();
        jLabelCategory = new JLabel();
        jComboBoxCategory = new JComboBox();
        jLabelShop = new JLabel();
        jButtonSave = new JButton();
        jButtonClear = new JButton();
        jButtonCancel = new JButton();
        jLabelQuantity = new JLabel();
        jTextFieldQuantity = new JTextField();
        jLabelUnits = new JLabel();
        jComboBoxUnits = new JComboBox();
        jButtonDelete = new JButton();
        jTextFieldShop = new JTextField();

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

        jLabelproductName.setText("Product Name");

        jButtonSearch.setText("Search");
        jButtonSearch.setName("JButtonSearch");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabelCategory.setText("Category");

        jComboBoxCategory.setModel(new DefaultComboBoxModel(comboCategory));
        jComboBoxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoryActionPerformed(evt);
            }
        });

        jLabelShop.setText("Shop");


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

        jLabelQuantity.setText("Quantity");

        jLabelUnits.setText("Units");

        jComboBoxUnits.setModel(new DefaultComboBoxModel(comboUnit));

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
                                        .addComponent(jLabelCategory)
                                        .addComponent(jLabelShop)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(jTextFieldQuantity, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabelQuantity, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jComboBoxUnits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabelUnits)))
                                                                .addComponent(jTextFieldProductName, GroupLayout.Alignment.LEADING)
                                                                .addComponent(jComboBoxCategory, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                                .addComponent(jButtonCancel))
                                        .addComponent(jTextFieldShop, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelproductName)
                                .addGap(3, 3, 3)
                                .addComponent(jTextFieldProductName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelQuantity)
                                        .addComponent(jLabelUnits))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxUnits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelCategory)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelShop)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldShop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonClear)
                                        .addComponent(jButtonSearch)
                                        .addComponent(jButtonSave)
                                        .addComponent(jButtonDelete)
                                        .addComponent(jButtonCancel))
                                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

}
