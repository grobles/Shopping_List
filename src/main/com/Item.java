package com;

/**
 * Created with IntelliJ IDEA.
 * User: grobles
 * Date: 20/09/12
 * Time: 10:12 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 *             Class: Item
 * Purpose: holds data describing an Item object
 *
 * @author Lupe Robles, Brian Arnold
 */
public class Item {
    //private members of an Item object
    private final String itemName;
    private final Category itemCategory;
    private final Shop itemShop;
    private final int itemQuantity;
    /**
     * Class: Builder.
     * Purpose: Builder used to instantiate Items
     */
    public static class Builder {
        private final String nameOfItem;
        private final Category categoryOfItem;
        private final Shop shopOfItem;

        private int quantityOfItem = 0;
        /**
         * Builder of an Item object with required members.
         * @param nameOfItem
         * @param categoryOfItem
         */
        public Builder(String nameOfItem, Category categoryOfItem, Shop shopOfItem) {
            this.nameOfItem = nameOfItem;
            this.categoryOfItem = categoryOfItem;
            this.shopOfItem = shopOfItem;
        }
        /**
         * Builder for the optional Item member quantity.
         * @param val
         * @return
         */
        public Builder quantity(int val)
            { quantityOfItem = val; return this; }

        /**
         * Item object created and returned.
         * @return
         */
        public Item build() {
            return new Item(this);
        }
    }
    /**
     * Item constructor that takes the Builder as a param.
     * @param builder
     */
    private Item(Builder builder) {
        itemName = builder.nameOfItem;
        itemCategory = builder.categoryOfItem;
        itemShop = builder.shopOfItem;
        itemQuantity = builder.quantityOfItem;
    }

    /**
     * method: getItemName.
     * @return
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * method: getItemName.
     * @return
     */
    public Category getItemCategory() {
        return itemCategory;
    }

    /**
     * method: getItemShop.
     * @return
     */
    public Shop getItemShop() {
        return itemShop;
    }

    /**
     * method: getItemQuantity.
     * @return
     */
    public int getItemQuantity() {
        return itemQuantity;
    }
}
