package com.GUI.EditPanels;

import com.Category;
import com.GUI.MainForm;
import com.GUI.ValidateInput;
import com.Item;
import com.Product;
import com.Shop;

import javax.swing.*;

import static org.apache.commons.lang3.StringUtils.isNumeric;

/**
 * Class: Product edit Form
 * Description: In this for you can edit or add a new Product
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 9/22/12
 */
public class EditProduct extends EditPanels {

    private String[] comboCategory;
    private String[] comboShop;
    private String[] comboUnit;
    private JComboBox jComboBoxCategory;
    private JComboBox jComboBoxUnits;
    private JLabel jLabelCategory;
    private JLabel jLabelQuantity;
    private JLabel jLabelShop;
    private JLabel jLabelUnits;
    private JLabel jLabelName;
    private JTextField jTextFieldQuantity;
    private JComboBox jComboBoxShops;

    /**
     * Constructor
     *
     * @param
     */
    public EditProduct(MainForm mf) {
        super(mf);
        ItemList = recordSeeker.getProductList();
        comboUnit = recordSeeker.getUnitsList();
        comboCategory = recordSeeker.setSingleStringArray(recordSeeker.getcategoryList());
        comboShop = recordSeeker.setSingleStringArray(recordSeeker.getShopList());
        initComponents2();
        setLayout();
    }

    /**
     * Method Save. Overrides the main implementation
     *
     * @param evt
     */
    @Override
    public void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {

        String productName = jTextFieldName.getText();
        Product productFound = (Product) recordSeeker.findItem(productName, recordSeeker.getProductList());
        if (productFound == null) {
            if (ValidateInput.isText(productName)) {
                if (jComboBoxUnits.getSelectedIndex() == 1) {
                    if (isNumeric(jTextFieldQuantity.getText())) {
                        addItem(productName);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Quantity must be only numeric digits (0-9).");
                        jTextFieldQuantity.requestFocus();
                    }
                } else if (jComboBoxUnits.getSelectedIndex() == 2) {
                    if ((ValidateInput.isDecimal(jTextFieldQuantity.getText()))) {
                        addItem(productName);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Quantity must be a decimal.");
                        jTextFieldQuantity.requestFocus();
                    }
                } else {
                    addItem(productName);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please need to enter a valid product name prior to saving.");
                jTextFieldQuantity.requestFocus();
            }
        } else {
            editProduct(productFound);
        }
    }

    /**
     * Method Search: overides the implementaion to be able to fill the textboxes
     *
     * @param item
     */
    @Override
    public void Search(Item item) {

        Product product = (Product) item;
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
     * Method edit: it is just used in this class to edit the product
     *
     * @param productFound
     */

    private void editProduct(Product productFound) {
        int n = JOptionPane.showConfirmDialog(
                frame,
                "That product already exists.Would you like to edit this Product?",
                "Confirm Edit Category",
                JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            String categoryName = jComboBoxCategory.getSelectedItem().toString();
            Category category = (Category) recordSeeker.findItem(categoryName, recordSeeker.getcategoryList());
            productFound.setItemCategory(category);
            String shopName = jComboBoxShops.getSelectedItem().toString();
            Shop shop = (Shop) recordSeeker.findItem(shopName, recordSeeker.getShopList());
            productFound.setItemShop(shop);
            try {
                int quantity = Integer.parseInt(jTextFieldQuantity.getText());
                System.out.println("Product Name : ");
                productFound.setItemQuantity(quantity);
                productFound.setItemUnit(jComboBoxUnits.getSelectedItem().toString());
            } catch (Exception e) {
            }
            JOptionPane.showMessageDialog(frame, "Item Edited");
            recordSeeker.writToXml();
        }
    }

    /**
     * Method: addItem Overrides the main one to be able to construct the product
     *
     * @param name
     */
    void addItem(String name) {
        try {
            String productName = jTextFieldName.getText();
            String categoryName = jComboBoxCategory.getSelectedItem().toString();
            String shopName = jComboBoxShops.getSelectedItem().toString();
            Category category = (Category) recordSeeker.findItem(categoryName, recordSeeker.getcategoryList());
            Shop shop = (Shop) recordSeeker.findItem(shopName, recordSeeker.getShopList());
            Product newProduct = new Product.Builder(productName, category, shop).build();

            try {
                int quantity = Integer.parseInt(jTextFieldQuantity.getText());
                newProduct.setItemQuantity(quantity);
                newProduct.setItemUnit(jComboBoxUnits.getSelectedItem().toString());
            } catch (Exception ex) {
            }

            recordSeeker.getProductList().add(newProduct);
            JOptionPane.showMessageDialog(frame, name + " has been saved as a new Item");
            recordSeeker.writToXml();
            jTextFieldName.setText("");
            jComboBoxUnits.setSelectedItem("");
            jTextFieldQuantity.setText("");
            jTextFieldName.requestFocus();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(frame, "You have to choose a Category and a Shop.");
        }
    }

    /**
     * Method: Clear: it clears the appropiate textboxes
     */
    @Override
    public void clear() {
        jTextFieldName.setText("");
        jTextFieldQuantity.setText("");
        jComboBoxUnits.setSelectedItem("");
        jTextFieldName.requestFocus();
    }

    /**
     * it set the layout with the extra components
     */
    @Override
    void setLayout() {
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jLabelName).addComponent(jLabelCategory).addComponent(jLabelShop).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(jTextFieldQuantity, GroupLayout.Alignment.LEADING).addComponent(jLabelQuantity, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jComboBoxUnits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(jLabelUnits))).addComponent(jTextFieldName, GroupLayout.Alignment.LEADING).addComponent(jComboBoxCategory, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(jButtonClear, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jButtonSearch).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jButtonSave, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jButtonDelete))).addGap(6, 6, 6)).addComponent(jComboBoxShops, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)).addContainerGap(20, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabelName).addGap(3, 3, 3).addComponent(jTextFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabelQuantity).addComponent(jLabelUnits)).addGap(6, 6, 6).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jTextFieldQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(jComboBoxUnits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabelCategory).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jComboBoxCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabelShop).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jComboBoxShops, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(29, 29, 29).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jButtonClear).addComponent(jButtonSearch).addComponent(jButtonSave).addComponent(jButtonDelete)).addContainerGap(24, Short.MAX_VALUE)));


        /**
         * @param args the command line arguments
         */
    }

    /**
     * it initiates the components not included in the super
     */

    private void initComponents2() {

        jLabelName = new JLabel();
        jTextFieldName = new JTextField();
        jLabelCategory = new JLabel();
        jComboBoxCategory = new JComboBox();
        jLabelShop = new JLabel();
        jLabelQuantity = new JLabel();
        jTextFieldQuantity = new JTextField();
        jLabelUnits = new JLabel();
        jComboBoxUnits = new JComboBox();
        jComboBoxShops = new JComboBox();

        jLabelCategory.setText("Category");

        jComboBoxCategory.setModel(new DefaultComboBoxModel(comboCategory));

        jLabelShop.setText("Shop");
        jComboBoxShops.setModel(new DefaultComboBoxModel(comboShop));

        jLabelQuantity.setText("Quantity");

        jLabelUnits.setText("Units");

        jComboBoxUnits.setModel(new DefaultComboBoxModel(comboUnit));


    }// </editor-fold>
}
