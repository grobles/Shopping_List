/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GUI.ListPanels;

import com.Comparators.ByCategory;
import com.Comparators.ByName;
import com.Comparators.ByShop;
import com.Item;
import com.Product;

import javax.swing.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Class: ProductList
 * Description: Used to display the Product List
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 10/14/12
 */
public class ProductList extends ShowLists {

    /**
     * Creates new form NewJPanel
     *
     * @param itemList
     */
    public ProductList(List<Item> itemList) {
        super(itemList);
        jComboBoxSort.setModel(new DefaultComboBoxModel(new String[]{"Sort", "Sort Alphabetically", "Sort By Category", "Sort ByCategory Shop"}));

    }

    /**
     * Creates the StringList for the Table and to Print. It overrides super because Product has 5 columns
     *
     * @return
     */
    @Override
    public String[][] setStringShoppingPanel() {

        int size = ItemList.size();

        String StringArray[][] = new String[size][5];
        Iterator iterator = ItemList.iterator();
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
     * Sorts the product. It overrides , to be able to sort by category and by Shop
     *
     * @param evt
     */
    @Override
    public void jComboBoxSortActionPerformed(java.awt.event.ActionEvent evt) {

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
     * Sets the Table
     */
    @Override
    public void setTable() {
        jTableShoppingProducts.setModel((new javax.swing.table.DefaultTableModel(
                setStringShoppingPanel(),
                new String[]{
                        "Name", "Category", "Shop", "Quantity", "Units"
                })));
    }
}