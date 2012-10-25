package com.GUI.EditPanels;

import com.Category;
import com.Item;
import com.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class: EditCategory
 * Category Form Description: In this form you can edit or add a new Category. It extends EditPanel
 * Author: Brian Arnold & Guadalupe Robles Gil Date: 9/22/12 Time:
 * 12:51 PM *
 */
public class EditCategory extends EditPanels {

    /**
     * Creates new form NewJFrame
     *
     * @param list
     */
    public EditCategory(List<Item> list) {
        super(list);
        setLayout();


    }

    /**
     * override to create the Category instead of Item
     *
     * @param name
     */
    @Override
    public void addItem(String name) {
        Category newCategory = new Category(name);
        List.add(newCategory);
        JOptionPane.showMessageDialog(frame, name + " has been saved as a new Item");
        recordSeeker.writToXml();


    }

    /**
     * Deletes an Item from the List. It overrides the Super to be able to delete the products
     * assocoated with that Category
     *
     * @param item
     */

    @Override
    public void deleteItem(Item item) {
        Iterator iterator = recordSeeker.getProductList().iterator();
        List<Product> removelist = new ArrayList<Product>();
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            if (product.getItemCategory().getItemName().equals(item.getItemName())) {
                removelist.add(product);
            }
        }
        recordSeeker.getProductList().removeAll(removelist);
    }
}
