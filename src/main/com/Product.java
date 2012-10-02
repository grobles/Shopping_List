package com;

import java.io.Serializable;

/**
 * Class: Product
 * Description: holds data describing a Product object.
 * Each Product will have a shop and a Category  and an optional Quantity
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 20/09/12
 * Time: 10:12 PM *
 */

public class Product implements Item, Serializable {
    //private members of an Product object
    private String itemName;
    private Category itemCategory;
    private int itemQuantity;
    private String itemUnit;


    /**
     * Class: Builder.
     * Purpose: Builder used to instantiate Items
     */
    public static class Builder {
        private final String nameOfItem;
        private final Category categoryOfItem;

        private int quantityOfItem = 0;
        private String unitOfItem = "";

        /**
         * Builder of an Product object with required members.
         *
         * @param nameOfItem
         * @param categoryOfItem
         */
        public Builder(String nameOfItem, Category categoryOfItem) {
            this.nameOfItem = nameOfItem;
            this.categoryOfItem = categoryOfItem;

        }

        /**
         * Builder for the optional Product member quantity.
         *
         * @param val
         *
         * @return
         */
        public Builder quantity(int val) {
            quantityOfItem = val;
            return this;
        }

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
    }

    /**
     * method: getItemName.
     */

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public void setItemCategory(Category itemCategory) {
        this.itemCategory = itemCategory;
    }

    /**
     * method: getItemShop.
     *
     * @return
     */




    /**
     * method: getItemQuantity.
     *
     * @return
     */
    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public String getItemUnit() {
        return itemUnit;
    }


}
