package com.Persistance;

import com.Item;

import java.util.Iterator;
import java.util.List;

/**
 * Class: Record Seeker
 * Description: This class with hold the code needed to get records from the container.
 * It will help sort the records , get specific data etc..
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 27/09/12
 * Time: 08:11 PM *
 */
public class RecordSeeker {


    private final DataContainers dc;
    private final ReadXMLFile rxml;
    private final String filename;


    /**
     * @param
     */
    public RecordSeeker() {
        filename = "data.xml";
        rxml = new ReadXMLFile(filename);
        dc = rxml.readDC();
    }

    public RecordSeeker(String fileName) {
        filename = fileName;
        rxml = new ReadXMLFile(filename);
        dc = rxml.readDC();
    }

    /**
     * method: findItem Given the name it returns an Item
     *
     * @return
     */
    public String getFilename() {
        return filename;
    }

    public String[] getUnitsList() {
        return dc.getUnitsList();
    }

    public List getShopList() {
        return dc.getShopList();
    }

    public List getProductList() {
        return dc.getProductList();
    }

    public List getcategoryList() {
        return dc.getCategoryList();
    }

    public List getShoppingList() {
        return dc.getShoppingLists();
    }

    /**
     *
     */
    public void writToXml() {
        WriteXMLFile wxml = new WriteXMLFile(this);
        wxml.writeFile();
    }

    /**
     * @param itemName
     *
     * @return
     */
    public Item findItem(String itemName, List<Item> list) {

        Item itemFound = null;
        for (Item item : list) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                itemFound = item;
                break;
            }
        }
        return itemFound;
    }

    /**
     * method: makeCombo It helps make the String[] needed for the combos in the
     * different forms
     *
     * @return
     */
    public String[] setStringArray(List list) {
        int size = list.size();
        String[] comboArray = new String[size];
        int i = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            String name = item.getItemName();
            comboArray[i] = name;
            i++;
        }
        return comboArray;
    }
}
