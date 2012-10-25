package com.GUI.EditPanels;

import com.Item;
import com.Shop;

import javax.swing.*;
import java.util.List;

/**
 * Class:EditShop
 * Description: In this form you can edit or add a new Shop
 * Author: Brian Arnold & Guadalupe Robles Gil Date: 9/22/12 Time: 12:51 PM *
 */
public class EditShop extends EditPanels {

    /**
     * Creates new form EditShop
     *
     * @param list
     */
    public EditShop(List<Item> list) {

        super(list);
        setLayout();

    }

    /**
     * Method: addItem: It overides the super to be able to construct the Shop
     *
     * @param name
     */
    @Override
    public void addItem(String name) {
        Shop newshop = new Shop(name);
        List.add(newshop);
        JOptionPane.showMessageDialog(frame, name + " has been saved as a new Item");
        recordSeeker.writToXml();

    }
}
