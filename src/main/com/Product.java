package com;

import java.io.Serializable;

/**
 * Class: Product Description: holds data describing a Product object. Each
 * Product will have a shop and a Category and an optional Quantity Author:
 * Brian Arnold & Guadalupe Robles Gil Date: 20/09/12 Time: 10:12 PM *
 */
public class Product implements Item, Serializable {
    //private members of an Product object

    private String itemName;
    private Category itemCategory;
    private int itemQuantity;
    private String itemUnit;
    private Shop itemShop;

    /**
     * Class: Builder. Purpose: Builder used to instantiate Items
     */
    public static class Builder {

        private final String nameOfItem;
        private final Category categoryOfItem;
        private final Shop shopOfItem;
        private int quantityOfItem = 0;
        private String unitOfItem = "";

        /**
         * Builder of an Product object with required members.
         *
         * @param nameOfItem
         * @param categoryOfItem
         * @param shopItem
         */
        public Builder(String nameOfItem, Category categoryOfItem, Shop shopItem) {
            this.nameOfItem = nameOfItem;
            this.categoryOfItem = categoryOfItem;
            this.shopOfItem = shopItem;

        }

        /**
         * Builder for the optional Product member quantity.
         *
         * @param val
         * @return
         */
        public Builder quantity(int val) {
            quantityOfItem = val;
            return this;
        }

        /**
         * @param unit
         * @return
         */
        public Builder unit(String unit) {
            unitOfItem = unit;
            return this;
        }

        /**
         * Product object created and returned.
         *
         * @return
         */
        public Product build() {
            return new Product(this);
        }
    }

    /**
     * Product constructor that takes the Builder as a param.
     *
     * @param builder
     */
    private Product(Builder builder) {
        itemName = builder.nameOfItem;
        itemCategory = builder.categoryOfItem;
        itemQuantity = builder.quantityOfItem;
        itemUnit = builder.unitOfItem;
        itemShop = builder.shopOfItem;
    }

    /**
     * method: getItemName.
     *
     * @param itemname
     */
    public void setItemName(String itemname) {
        this.itemName = itemname;
    }

    /**
     * method: getItemName.
     *
     * @return
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * method: getItemName.
     *
     * @return
     */
    public Category getItemCategory() {
        return itemCategory;
    }

    /**
     * @param itemCategory
     */
    public void setItemCategory(Category itemCategory) {
        this.itemCategory = itemCategory;
    }

    /**
     * method: getItemShop.
     *
     * @return
     */
    public Shop getItemShop() {
        return itemShop;
    }

    /**
     * @param itemShop
     */
    public void setItemShop(Shop itemShop) {
        this.itemShop = itemShop;
    }

    /**
     * method: getItemQuantity.
     *
     * @return
     */
    public int getItemQuantity() {
        return itemQuantity;
    }

    /**
     * @param itemQuantity
     */
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /**
     * @param itemUnit
     */
    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    /**
     * @return
     */
    public String getItemUnit() {
        return itemUnit;
    }

    public String toString() {
        return String.format("%-14s", itemName) +
                String.format("%-14s", itemCategory.getItemName()) +
                String.format("%-14s", itemShop.getItemName());

    }
}
