package com.GUI.ListPanels;

import com.Category;
import com.Item;
import com.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class: CategoryList
 * Description: Used to display the Category List
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 10/20/12
 */
public class CategoryList extends ShowLists {

    /**
     * @param itemList
     */
    public CategoryList(List<Item> itemList) {
        super(itemList);
    }

    /**
     * Deletes an Item from the List. It overrides the Super to be able to delete the products
     * assocoated with that Category
     *
     * @param evt
     */
    @Override
    public void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {

        JFrame frame = new JFrame();
        try {
            int row = jTableShoppingProducts.getSelectedRow();
            Category category = (Category) recordSeeker.getcategoryList().get(row);
            String name = category.getItemName();
            int n = JOptionPane.showConfirmDialog(
                    frame,
                    "Would you like to delete the Category '" + name + "'?\n"
                            + "Doing this will also remove the associate Products with it",
                    "Confirm Delete Category",
                    JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                Iterator iterator = recordSeeker.getProductList().iterator();
                List<Product> removelist = new ArrayList<Product>();
                while (iterator.hasNext()) {
                    Product product = (Product) iterator.next();
                    if (product.getItemCategory().getItemName().equals(category.getItemName())) {
                        removelist.add(product);
                    }
                }
                recordSeeker.getProductList().removeAll(removelist);
                recordSeeker.getcategoryList().remove(category);
                recordSeeker.writToXml();
                JOptionPane.showMessageDialog(frame, "'" + name + "' has been deleted.");
            }
            setTable();
        } catch (Exception ex) {
        }
    }
}
