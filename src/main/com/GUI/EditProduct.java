/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GUI;

import com.Category;
import com.Persistance.RecordSeeker;
import com.Product;
import com.Shop;

import javax.swing.*;

/**
 * Class: Product edit  Form
 * Description: In this for you can edit or add a new Product
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 9/22/12
 * Time: 12:51 PM *
 */
public class EditProduct extends javax.swing.JFrame {

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
     * method: jButtonClearActionPerformed : Clear the form
     */

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {
        jTextFieldProductName.setText("");
        jTextFieldQuantity.setText("");
        jComboBoxUnits.setSelectedItem("");
        jTextFieldProductName.requestFocus();
    }

    /**
     * method: jButtonSearchActionPerformed : Search for category
     */
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {
        String name = jTextFieldProductName.getText();
        Product product = (Product) recordSeekerProduct.findItem(name);
        String message = "";
        if (product != null) {
            Search(product);
            message = "Product found";
        }

        JOptionPane.showMessageDialog(new JFrame(), message);
        jTextFieldProductName.requestFocus();

    }

    /**
     * method: jButtonSaveActionPerformed : save a Shop
     */
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {
        String message;
        String productName = jTextFieldProductName.getText();
        Product productFound = (Product) recordSeekerProduct.findItem(productName);
        if (productName.equals(""))
            message = "Not a valid name";
        else if (productFound != null) {
            editProduct(productFound);
            message = "Product edited";
        } else {
            saveProduct();
            message = "Product Saved";
        }

        JOptionPane.showMessageDialog(new JFrame(), message);
        jTextFieldProductName.setText("");
        jComboBoxUnits.setSelectedItem("");
        jTextFieldQuantity.setText("");
        jTextFieldProductName.requestFocus();
    }


    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {

        String message;
        String name = jTextFieldProductName.getText();
        Product productFound = (Product) recordSeekerProduct.findItem(name);
        if (recordSeekerProduct.findItem(name) == null) {
            message = "Product not found";
        } else {
            delete(productFound);
            message = "Product Deleted";
        }

        jTextFieldProductName.setText("");
        jComboBoxUnits.setSelectedItem("");
        jTextFieldQuantity.setText("");
        jTextFieldProductName.requestFocus();
    }


    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void Search(Product product) {

        Category category = product.getItemCategory();
        Shop shop = product.getItemShop();
        jComboBoxCategory.setSelectedItem(category.getItemName());
        jComboBoxShops.setSelectedItem(shop.getItemName());
        try {
            String quantity = Integer.toString(product.getItemQuantity());
            jTextFieldQuantity.setText(quantity);
            jComboBoxUnits.setSelectedItem(product.getItemUnit());
        } catch (Exception e) {

        }
    }


    private void editProduct(Product productFound) {
        JFrame frame = new JFrame();
        int n = JOptionPane.showConfirmDialog(
                frame,
                "That product already exists.Would you like to edit this Product?",
                "Confirm Edit Category",
                JOptionPane.YES_NO_OPTION
        );
        if (n == 0) {
            String categoryName = jComboBoxCategory.getSelectedItem().toString();
            Category category = (Category) recordSeekerCategory.findItem(categoryName);
            productFound.setItemCategory(category);
            String shopName = jComboBoxShops.getSelectedItem().toString();
            Shop shop = (Shop) recordSeekerShop.findItem(shopName);
            productFound.setItemShop(shop);
            try {
                int quantity = Integer.parseInt(jTextFieldQuantity.getText());
                System.out.println("Product Name : ");
                productFound.setItemQuantity(quantity);
                productFound.setItemUnit(jComboBoxUnits.getSelectedItem().toString());
            } catch (Exception e) {
                System.out.println("catch : ");
            }

            recordSeekerProduct.writToXml();
        }
    }

    private void saveProduct() {
        JFrame frame = new JFrame();
        int n = JOptionPane.showConfirmDialog(
                frame,
                "Would you like to save this Product?",
                "Confirm Save Category",
                JOptionPane.YES_NO_OPTION
        );
        if (n == 0) {
            String productName = jTextFieldProductName.getText().toString();
            String categoryName = jComboBoxCategory.getSelectedItem().toString();
            Category category = (Category) recordSeekerCategory.findItem(categoryName);
            String shopName = jComboBoxShops.getSelectedItem().toString();
            Shop shop = (Shop) recordSeekerShop.findItem(shopName);
            Product newProduct = new Product.Builder(productName, category, shop).build();
            try {
                int quantity = Integer.parseInt(jTextFieldQuantity.getText());
                newProduct.setItemQuantity(quantity);
                newProduct.setItemUnit(jComboBoxUnits.getSelectedItem().toString());
            } catch (Exception e) {

            }
            recordSeekerProduct.addItem(newProduct);
            recordSeekerProduct.writToXml();
        }
    }

    private void delete(Product productFound) {
        JFrame frame = new JFrame();
        int n = JOptionPane.showConfirmDialog(
                frame,
                "Would you like to Delete this Product?",
                "Confirm Delete Product",
                JOptionPane.YES_NO_OPTION
        );
        if (n == 0) {
            recordSeekerProduct.deleteProduct(productFound);
            recordSeekerProduct.writToXml();

        }
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
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
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
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox jComboBoxCategory;
    private javax.swing.JComboBox jComboBoxUnits;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabelCategory;
    private javax.swing.JLabel jLabelQuantity;
    private javax.swing.JLabel jLabelShop;
    private javax.swing.JLabel jLabelUnits;
    private javax.swing.JLabel jLabelproductName;
    private javax.swing.JTextField jTextFieldProductName;
    private javax.swing.JTextField jTextFieldQuantity;
    private javax.swing.JComboBox jComboBoxShops;
    // End of variables declaration

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")

    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabelproductName = new javax.swing.JLabel();
        jTextFieldProductName = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jLabelCategory = new javax.swing.JLabel();
        jComboBoxCategory = new javax.swing.JComboBox();
        jLabelShop = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabelQuantity = new javax.swing.JLabel();
        jTextFieldQuantity = new javax.swing.JTextField();
        jLabelUnits = new javax.swing.JLabel();
        jComboBoxUnits = new javax.swing.JComboBox();
        jButtonDelete = new javax.swing.JButton();
        jComboBoxShops = new javax.swing.JComboBox();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
                jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
                jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jComboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel(comboCategory));

        jLabelShop.setText("Shop");
        jComboBoxShops.setModel(new javax.swing.DefaultComboBoxModel(comboShop));


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

        jComboBoxUnits.setModel(new javax.swing.DefaultComboBoxModel(comboUnit));

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelproductName)
                                        .addComponent(jLabelCategory)
                                        .addComponent(jLabelShop)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabelQuantity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jComboBoxUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabelUnits)))
                                                                .addComponent(jTextFieldProductName, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jComboBoxCategory, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonSearch)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonDelete)))
                                                .addGap(6, 6, 6)
                                                .addComponent(jButtonCancel))
                                        .addComponent(jComboBoxShops, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelproductName)
                                .addGap(3, 3, 3)
                                .addComponent(jTextFieldProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelQuantity)
                                        .addComponent(jLabelUnits))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelCategory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelShop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxShops, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
