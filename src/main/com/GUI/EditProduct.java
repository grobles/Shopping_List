package com.GUI;

import com.*;
import com.Utilities.RecordSeeker;
import com.Utilities.WriteToFile;

import java.util.Collection;

/**
 * Class: Product
 * Description: This will hold all the Items that we are making lists of: Product , categories , Shops
 * Author: Brian Arnold & Guadalupe Robles Gil
 */
public class EditProduct extends javax.swing.JFrame {
    private String[] unitsList;
    private Collection<Item> productList;
    private Collection<Item> categoryList;
    private Collection<Item> shopList;
    private DataContainers dc = DataContainers.getInstance();
    private String[] comboCategory;
    private String[] comboShop;

    /**
     * Creates new form NewJFrame
     */
    public EditProduct() {
        dc = WriteToFile.readSerializeFile();
        unitsList = dc.getUnitsList();
        productList = dc.getProductList();
        categoryList = dc.getCategoryList();
        shopList = dc.getShopList();
        comboCategory = RecordSeeker.makeCombo(categoryList);
        comboShop = RecordSeeker.makeCombo(shopList);
        initComponents();
    }

    /**
     *
     */


    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {
        String productName = jTextFieldProductName.getText();
        String unit = jComboBoxUnits.getSelectedItem().toString();
        String categoryName = jComboBoxCategory.getSelectedItem().toString();
        String shopName = jComboBoxShop.getSelectedItem().toString();
        Category categorySelected = RecordSeeker.findCategory(categoryName);
        Shop shopSelected = RecordSeeker.findShop(shopName);
        Integer itemQuantity = checkQuantity();
        Product newProduct = new Product.Builder(productName, categorySelected, shopSelected).quantity(itemQuantity).build();
        productList.add(newProduct);
        WriteToFile.writeSerializeFile(dc);

    }

    /**
     * method:
     */

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {

    }


    private int checkQuantity() {
        int quantity = 0;
        try {

            quantity = Integer.parseInt(jTextFieldQuantity.getText());

        } catch (Exception e) {
            e.printStackTrace();

        }
        return quantity;
    }


    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabelproductName = new javax.swing.JLabel();
        jTextFieldProductName = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jLabelCategory = new javax.swing.JLabel();
        jComboBoxCategory = new javax.swing.JComboBox();
        jLabelShop = new javax.swing.JLabel();
        jComboBoxShop = new javax.swing.JComboBox();
        jButtonSave = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabelQuantity = new javax.swing.JLabel();
        jTextFieldQuantity = new javax.swing.JTextField();
        jLabelUnits = new javax.swing.JLabel();
        jComboBoxUnits = new javax.swing.JComboBox();

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

        jLabelCategory.setText("Category");

        jComboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel(comboCategory));

        jLabelShop.setText("Shop");

        jComboBoxShop.setModel(new javax.swing.DefaultComboBoxModel(comboShop));

        jButtonSave.setText("Save");

        jButtonClear.setText("Clear");

        jButtonCancel.setText("Cancel");
        jButtonCancel.setToolTipText("");

        jLabelQuantity.setText("Quantity");

        jLabelUnits.setText("Units");

        jComboBoxUnits.setModel(new javax.swing.DefaultComboBoxModel(unitsList));

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
                                                        .addComponent(jComboBoxCategory, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jComboBoxShop, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(34, 34, 34)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButtonSearch, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButtonCancel)
                                                        .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelproductName)
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonSearch)
                                        .addComponent(jButtonClear))
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
                                .addGap(23, 23, 23)
                                .addComponent(jLabelShop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxShop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonSave)
                                        .addComponent(jButtonCancel))
                                .addGap(39, 39, 39))
        );
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        pack();
    }// </editor-fold>


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new EditProduct().setVisible(true);
            }
        });
    }


    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox jComboBoxCategory;
    private javax.swing.JComboBox jComboBoxShop;
    private javax.swing.JComboBox jComboBoxUnits;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabelCategory;
    private javax.swing.JLabel jLabelQuantity;
    private javax.swing.JLabel jLabelShop;
    private javax.swing.JLabel jLabelUnits;
    private javax.swing.JLabel jLabelproductName;
    private javax.swing.JTextField jTextFieldProductName;
    private javax.swing.JTextField jTextFieldQuantity;

}
