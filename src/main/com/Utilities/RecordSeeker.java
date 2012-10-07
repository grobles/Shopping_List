package com.Utilities;

import com.*;

import java.util.*;

/**
 * Class: Product
 * Description: This will hold all the Items that we are making lists of: Product , categories , Shops
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 23/09/12
 * Time: 10:13 PM *
 */

/**
 * Class: Record Seeker Description: This class with hold the code needed to get
 * records from the container. It will help sort the records , get specific data
 * etc.. Author: Brian Arnold & Guadalupe Robles Gil Date: 27/09/12 Time: 08:11
 * PM *
 */
public class RecordSeeker {

    private Collection<Item> List;
    private DataContainers dc;
    private WriteXMLFile xml;

    public RecordSeeker(String itemClass) {

        dc = WriteToFile.readSerializeFile();
        xml = new WriteXMLFile(dc);
        if (itemClass.equals("Shop"))
            List = dc.getShopList();
        else if (itemClass.equals("Category"))
            List = dc.getCategoryList();
        else if (itemClass.equals("Product"))
            List = dc.getProductList();
    }
    /**
     * method: findItem  Given the name it returns an Item
     *
     * @param
     *
     * @return
     */
    public DataContainers getDc(){
        return dc;
    }

    public void addItem(Item item){
        List.add(item);
    }

    public void writToFile(){
        WriteToFile.writeSerializeFile(dc);
    }

    public void writToXml(){
       xml.writeFile();
    }

    public Collection<Item> getList() {
        return List;
    }


    public  Item findItem(String itemName) {

         Item itemFound = null;

        for (Item item : List) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                itemFound = item;

            }

        }
        return itemFound;
    }
    /**
     * method: findItem  Given the name it returns an Item
     *
     * @param itemName
     *
     * @return
     */
    public  boolean deleteProduct(Item itemToDelete ) {

        boolean result;

        for (Item item : List) {
                List.remove(itemToDelete);
                return true;
            }


        return false;
    }

     /**
     * method: makeCombo It helps make the String[] needed for the combos in the different forms
     *
     * @param
     *
     * @return
     */
    public  String[] makeCombo() {
        int size = List.size();
        String[] comboArray = new String[size];
        int i = 0;
        Iterator iterator = List.iterator();
        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            String name = item.getItemName();
            comboArray[i] = name;
            i++;
        }
        return comboArray;
    }


    /**
     * method: sort This method will help sort by Name the different lists
     *
     *
     * @param
     *
     * @return
     */
    public  Collection Sort(Collection<Item> listToSort) {

        Collection ListSorted = new TreeSet(new ByName());
        for (Item item : listToSort) {
            ListSorted.add(item);
        }


        return ListSorted;


    }
}

/**
 * Class: ByName
 * Description: This will be the class used in the TreeSet to sort By Name
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 23/09/12
 * Time: 10:13 PM *
 */

class ByName implements Comparator {

    public int compare(Object o1, Object o2) {
        Item item1 = (Item) o1;
        Item item2 = (Item) o2;

        return item1.getItemName().compareTo(item2.getItemName());
    }
}