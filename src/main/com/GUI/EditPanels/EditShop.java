package com.GUI.EditPanels;

import com.GUI.MainForm;
import com.Shop;

import javax.swing.*;

/**
 * Class:EditShop
 * Description: In this form you can edit or add a new Shop
 * Author: Brian Arnold & Guadalupe Robles Gil Date: 9/22/12
 */
public class EditShop extends EditPanels {

    /**
     * Creates new form EditShop
     *
     * @param mf
     */
    public EditShop(MainForm mf) {

        super(mf);
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
        ItemList.add(newshop);
        JOptionPane.showMessageDialog(frame, name + " has been saved as a new Item");
        recordSeeker.writToXml();
    }
}
