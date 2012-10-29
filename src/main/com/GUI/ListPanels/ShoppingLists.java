package com.GUI.ListPanels;

import com.GUI.EditPanels.EditShoppingList;
import com.GUI.MainForm;
import com.Item;
import com.Product;
import com.ShoppingList;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: ShoppingLists
 * Description: Displays all the Shopping Lists created
 * Author: Brian Arnold & Guadalupe Robles Gil Date:
 * 24/10/12 Time: 10:09 AM *
 */
public class ShoppingLists extends ShowLists {


    /**
     * Creates new form NewJPanel
     *
     * @param mf
     */
    public ShoppingLists(MainForm mf) {
        super(mf);
        jButtonOpen.setVisible(true);
        ItemList = recordSeeker.getShoppingList();
        setTable();

    }

    /**
     * This button is only visible in this class to open the products in the selected List
     *
     * @param evt
     */
    @Override
    public void jButtonOpenActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int row = jTableShoppingProducts.getSelectedRow();
            ShoppingList shoppinglist = (ShoppingList) recordSeeker.getShoppingList().get(row);
            List<Product> productslist = shoppinglist.getProductsList();
            List<Item> list = new ArrayList<Item>();
            for (Item item : productslist) {
                Product product = (Product) item;
                list.add(product);
                Mf.setLayout(new EditShoppingList(list, Mf));
            }
        } catch (Exception ex) {

        }

    }
}
