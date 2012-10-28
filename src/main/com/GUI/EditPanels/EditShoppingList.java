package com.GUI.EditPanels;

import com.Comparators.ByCategory;
import com.Comparators.ByName;
import com.Comparators.ByShop;
import com.GUI.MainPanel;
import com.Item;
import com.Product;
import com.ShoppingList;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Class: ShoppingList edit Form
 * Description: In this for you can eadd products to create a new Shopping List. It implements Main Panel
 * to be able to get the string list to print
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 10/22/12 Time: 12:51  PM *
 */
public class EditShoppingList extends JPanel implements MainPanel {

    private List<Item> ItemList;
    private String[][] stringList;

    /**
     * Creates new form NewJPanel
     *
     * @param list
     */
    public EditShoppingList(List<Item> list) {
        ItemList = list;
        String[] comboCategory = recordSeeker.setSingleStringArray(recordSeeker.getcategoryList());
        initComponents();
        jComboBoxCategory.setModel(new DefaultComboBoxModel(comboCategory));
        setComboProduct();
        setTable();

    }

    /**
     * This method is just to return the ItemList to be printed
     *
     * @return
     */
    public List getItemList() {
        return ItemList;
    }

    public String[][] getStringList() {
        return recordSeeker.setStringProductArray(ItemList);
    }

    /**
     * Method: initComponents. It initalizes all the components in the panel
     *
     * @return
     */
    private void initComponents() {

        jLabelProduct = new javax.swing.JLabel();
        jComboBoxProduct = new javax.swing.JComboBox();
        jButtonClear = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jComboBoxCategory = new javax.swing.JComboBox();
        jLabelCategory = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableShoppingProducts = new javax.swing.JTable();
        jLabelProduct.setText("Product");
        jComboBoxSort = new javax.swing.JComboBox();

        jComboBoxProduct.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));


        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jComboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jComboBoxCategory.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoryActionPerformed(evt);
            }
        });

        jLabelCategory.setText("Category");

        jTableShoppingProducts.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
                }));
        jScrollPane3.setViewportView(jTableShoppingProducts);

        jComboBoxSort.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Sort", "Sort Alphabetically", "Sort By Category", "Sort By Shop"}));
        jComboBoxSort.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSortActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jComboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(layout.createSequentialGroup().addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButtonDelete).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButtonClear))).addGroup(layout.createSequentialGroup().addGap(78, 78, 78).addComponent(jLabelCategory)).addComponent(jComboBoxProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(layout.createSequentialGroup().addGap(72, 72, 72).addComponent(jLabelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()).addGroup(layout.createSequentialGroup().addComponent(jComboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButtonSave).addGap(0, 0, 100)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(50, 50, 50).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jLabelCategory).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jComboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(41, 41, 41).addComponent(jLabelProduct).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jComboBoxProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(33, 33, 33).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButtonAdd).addComponent(jButtonDelete).addComponent(jButtonClear))).addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jComboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jButtonSave))));
    }// </editor-fold>

    /**
     * It clears the textboxes
     *
     * @return
     */
    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {
        ItemList = new ArrayList<Item>();
        setTable();
    }

    /**
     * It sorts the product List
     *
     * @return
     */
    private void jComboBoxSortActionPerformed(java.awt.event.ActionEvent evt) {
        if (jComboBoxSort.getSelectedItem().toString().equals("Sort Alphabetically")) {
            Collections.sort(ItemList, new ByName());
        } else if (jComboBoxSort.getSelectedItem().toString().equals("Sort By Category")) {
            Collections.sort(ItemList, new ByCategory());
        } else if (jComboBoxSort.getSelectedItem().toString().equals("Sort By Shop")) {
            Collections.sort(ItemList, new ByShop());
        }

        setTable();
    }

    /**
     * It deletes an item from the list
     *
     * @return
     */
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int row = jTableShoppingProducts.getSelectedRow();
            Product product = (Product) ItemList.get(row);
            ItemList.remove(product);
            setTable();
        } catch (Exception ex) {
        }
    }

    /**
     * It adds a product to the list
     *
     * @return
     */
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Product product = (Product) recordSeeker.findItem(jComboBoxProduct.getSelectedItem().toString(), recordSeeker.getProductList());
            ItemList.add(product);
            setTable();
        } catch (Exception ex) {            //todo nice job here, but don't catch all exceptions just the right ones.
            //todo see chapter nine of effective Java
            JOptionPane.showMessageDialog(new JFrame(), "You have to choose a Product");
        }
    }

    /**
     * It sets the table evry time needed
     *
     * @return
     */
    private void setTable() {
        jTableShoppingProducts.setModel((new javax.swing.table.DefaultTableModel(
                setStringShoppingPanel(ItemList),
                new String[]{
                        "Product", "Category", "Shop", "Quantity", "Unit"
                })));
    }

    /**
     * It makes the string used in the table , and also the one that will be printed
     *
     * @return
     */
    private String[][] setStringShoppingPanel(List arraylist) {
        int size = arraylist.size();
        String StringArray[][] = new String[size][5];

        Iterator iterator = arraylist.iterator();
        while (iterator.hasNext()) {
            for (int row = 0; row < ItemList.size(); row++) {
                Product product = (Product) iterator.next();
                StringArray[row][0] = product.getItemName();
                StringArray[row][1] = product.getItemCategory().getItemName();
                StringArray[row][2] = product.getItemShop().getItemName();
                StringArray[row][3] = Integer.toString(product.getItemQuantity());
                StringArray[row][4] = product.getItemUnit();
            }
        }
        return StringArray;
    }

    /**
     * It makes the Product ComboBox so it only shows products from that Category
     *
     * @return
     */
    private void jComboBoxCategoryActionPerformed(java.awt.event.ActionEvent evt) {
        this.setComboProduct();
    }

    /**
     * It Saves the product list into a Shopping List
     *
     * @return
     */
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {

        if (ItemList.size() > 0) {

            String name =
                    JOptionPane.showInputDialog("Enter the name for the Shopping List");

            if (name == null) {
            } else if (name.equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Enter a valid name for the Shopping List");
            } else if (recordSeeker.findItem(name, recordSeeker.getShoppingList()) != null) {
                JOptionPane.showMessageDialog(new JFrame(), "That name already exists");
            } else {
                Iterator iterator = ItemList.iterator();
                List<Product> newList = new ArrayList<Product>();
                while (iterator.hasNext()) {
                    Product product = (Product) iterator.next();
                    newList.add(product);
                }
                ShoppingList ShoppingList = new ShoppingList(name, newList);
                recordSeeker.getShoppingList().add(ShoppingList);
                recordSeeker.writToXml();
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "You have to add products to the list");
        }
    }

    /**
     * It makes the Product ComboBox so it only shows products from that Category
     *
     * @return
     */
    void setComboProduct() {
        String categoryName;
        try {
            categoryName = jComboBoxCategory.getSelectedItem().toString();
            List<Item> productList = recordSeeker.getProductList();
            List<Item> list = new ArrayList<Item>();
            for (Item pro : productList) {
                Product product = (Product) pro;
                if (product.getItemCategory().getItemName().equals(categoryName)) {
                    list.add(product);
                }
            }
            jComboBoxProduct.setModel(new javax.swing.DefaultComboBoxModel(recordSeeker.setSingleStringArray(list)));
        } catch (Exception ex) {
        }


    }

    // Variables declaration
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComboBoxCategory;
    private javax.swing.JComboBox jComboBoxProduct;
    private javax.swing.JLabel jLabelCategory;
    private javax.swing.JLabel jLabelProduct;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableShoppingProducts;
    private javax.swing.JComboBox jComboBoxSort;
    // End of variables declaration
}
