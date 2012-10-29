package com.GUI.ListPanels;

import com.GUI.MainForm;

/**
 * Class: ShopList
 * Description: Used to display the Category List
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 10/20/12
 */
public class ShopList extends ShowLists {
    /**
     * Creates new form NewJPanel
     */
    public ShopList(MainForm mf) {
        super(mf);
        ItemList = recordSeeker.getShopList();
        setTable();
    }
}
