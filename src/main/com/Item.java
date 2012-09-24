package com;

/**
 * Created with IntelliJ IDEA.
 * User: grobles
 * Date: 23/09/12
 * Time: 09:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class Item implements InterfaceItems {

    private String itemName;
    private Category itemCategory;
    private Shop itemShop;
    private int itemQuantity;

    public Item(String itemName, Category itemCategory, Shop itemShop, int itemQuantity) {
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemShop = itemShop;
        this.itemQuantity = itemQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Category getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(Category itemCategory) {
        this.itemCategory = itemCategory;
    }

    public Shop getItemShop() {
        return itemShop;
    }

    public void setItemShop(Shop itemShop) {
        this.itemShop = itemShop;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
