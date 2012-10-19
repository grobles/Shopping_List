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
public class EditProduct extends JFrame {

    private String[] comboCategory;
    private String[] comboShop;
    private String[] comboUnit;
    RecordSeeker recordSeeker;
    MainForm mainForm;

    /**
     * Creates new form NewJFrame
     */
    public EditProduct(MainForm mainform) {
        mainForm = mainform;
        recordSeeker = new RecordSeeker();
        comboUnit = recordSeeker.getUnitsList();
        comboCategory = recordSeeker.setStringArray(recordSeeker.getcategoryList());
        comboShop = recordSeeker.setStringArray(recordSeeker.getShopList());
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

        if (ValidateInput.isText(name)) {
            Product product = (Product) recordSeeker.findItem(name, "Product");

            if (product != null) {
                Search(product);
                JOptionPane.showMessageDialog(frame, name + " found.");
            } else {
                int selection = JOptionPane.showConfirmDialog(frame, "Would you like to add '"
                        + name + "' to the list?");
                if (selection == 0) {
                    Product newProduct = (Product) recordSeeker.findItem(name, "Product");
                    saveProduct(newProduct);
                } else {
                    return;
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, "'" + name + "' is not a valid product name.");
        }
        jTextFieldProductName.requestFocus();
    }

    /**
     * method: jButtonSaveActionPerformed : save a Shop
     *
     * @param evt
     */
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {


        String productName = jTextFieldProductName.getText();
        Product productFound = (Product) recordSeeker.findItem(productName, "Product");

        if (ValidateInput.isText(productName)) {
            if (!ValidateInput.isDigit(jTextFieldQuantity.getText())) {
                JOptionPane.showMessageDialog(frame, "Quantity must be numeric digits (0-9).");
                jTextFieldQuantity.requestFocus();
                return;
            } else if (productFound != null) {
                editProduct(productFound);
                JOptionPane.showMessageDialog(frame, "Product Edited");
            } else {
                saveProduct(productFound);

            }
        }

    }

    /**
     * method: jButtonDeleteActionPerformed : delete the specified product
     *
     * @param evt
     */
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        String message;
        String name = jTextFieldProductName.getText();
        if (ValidateInput.isText(name)) {

            Product productFound = (Product) recordSeeker.findItem(name, "Product");
            if (productFound == null) {
                message = "Product not found";
                System.out.println("esta pasando" + name);
            } else {
                delete(productFound);
                message = "Product Deleted";
            }
        } else {
            message = "Not a Valid Name";
        }
        JOptionPane.showMessageDialog(frame, message);
        jTextFieldProductName.setText("");
        jComboBoxUnits.setSelectedItem("");
        jTextFieldQuantity.setText("");
        jTextFieldProductName.requestFocus();
    }

    /**
     * method: jButtonCancelActionPerformed : dispose of the form
     *
     * @param evt
     */
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    /**
     * method: Search : search the XML file for the product
     *
     * @param product
     */
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

    /**
     * method: editProduct : confirm intent to edit the product and edit if requested
     *
     * @param productFound
     */
    private void editProduct(Product productFound) {
        int n = JOptionPane.showConfirmDialog(
                frame,
                "That product already exists.Would you like to edit this Product?",
                "Confirm Edit Category",
                JOptionPane.YES_NO_OPTION
        );
        if (n == 0) {
            String categoryName = jComboBoxCategory.getSelectedItem().toString();
            Category category = (Category) recordSeeker.findItem(categoryName, "Category");
            productFound.setItemCategory(category);
            String shopName = jComboBoxShops.getSelectedItem().toString();
            Shop shop = (Shop) recordSeeker.findItem(shopName, "Shop");
            productFound.setItemShop(shop);
            try {
                int quantity = Integer.parseInt(jTextFieldQuantity.getText());
                System.out.println("Product Name : ");
                productFound.setItemQuantity(quantity);
                productFound.setItemUnit(jComboBoxUnits.getSelectedItem().toString());
            } catch (Exception e) {
                System.out.println("catch : ");
            }

            recordSeeker.writToXml();
        }
    }

    /**
     * method: saveProduct : save the product the teh XML file
     *
     * @param productFound
     */
    private void saveProduct(Product productFound) {
        try {
            jComboBoxCategory.getSelectedItem().toString();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "You have to choose a Category and a Shop.");
            jTextFieldProductName.requestFocus();
            return;
        }

        int n = JOptionPane.showConfirmDialog(
                frame,
                "Would you like to save this Product?",
                "Confirm Save Category",
                JOptionPane.YES_NO_OPTION
        );
        if (n == 0) {
            String productName = jTextFieldProductName.getText().toString();
            String categoryName = jComboBoxCategory.getSelectedItem().toString();
            String shopName = jComboBoxShops.getSelectedItem().toString();
            Category category = (Category) recordSeeker.findItem(categoryName, "Category");
            Shop shop = (Shop) recordSeeker.findItem(shopName, "Shop");
            Product newProduct = new Product.Builder(productName, category, shop).build();

            try {
                int quantity = Integer.parseInt(jTextFieldQuantity.getText());
                newProduct.setItemQuantity(quantity);
                newProduct.setItemUnit(jComboBoxUnits.getSelectedItem().toString());
            } catch (Exception e) {


            }
            recordSeeker.addItem(newProduct, "Product");
            recordSeeker.writToXml();
            mainForm.setComboProduct();
            JOptionPane.showMessageDialog(frame, "Product Saved");
            jTextFieldProductName.setText("");
            jComboBoxUnits.setSelectedItem("");
            jTextFieldQuantity.setText("");
            jTextFieldProductName.requestFocus();
        }
    }

    /**
     * method: deleteProduct : confirm intent to delete the product from the list
     *
     * @param productFound
     */
    private void delete(Product productFound) {
        int n = JOptionPane.showConfirmDialog(
                frame,
                "Would you like to Delete this Product?",
                "Confirm Delete Product",
                JOptionPane.YES_NO_OPTION
        );
        if (n == 0) {
            recordSeeker.deleteProduct(productFound, "Product");
            recordSeeker.writToXml();
        }
    }


    /**
     * @param args the command line arguments
     */


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
    private JComboBox jComboBoxShops;
    private JFrame frame;
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
        jComboBoxShops = new JComboBox();

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

        jLabelShop.setText("Shop");
        jComboBoxShops.setModel(new DefaultComboBoxModel(comboShop));


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
                                        .addComponent(jComboBoxShops, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(jComboBoxShops, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
