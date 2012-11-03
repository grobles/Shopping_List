package com.Persistance;

/**
 * Class: Description: Author: Brian Arnold & Guadalupe Robles Gil Date: 6/10/12
 * Time: 11:00 PM *
 */

import com.Category;
import com.Product;
import com.Shop;
import com.ShoppingList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author grobles
 */
class ReadXMLFile {


    private static DataContainers dc;
    private static File fXmlFile;
    private static final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

    /**
     * @param filename
     */
    ReadXMLFile(String filename) {

        dc = DataContainers.getInstance();
        fXmlFile = new File(filename);
    }

    private static void readShops() {

        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            NodeList ShopList = doc.getElementsByTagName("Shop");
            List<Shop> shopList = new ArrayList<Shop>();


            for (int temp = 0; temp < ShopList.getLength(); temp++) {

                Node nNode = ShopList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    Shop newShop = new Shop(getTagValue("ShopName", eElement));
                    shopList.add(newShop);
                }
            }

            dc.setShopList(shopList);
        } catch (FileNotFoundException e) {

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void readCategories() {

        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            NodeList CategoryList = doc.getElementsByTagName("Category");
            List<Category> categoryList = new ArrayList<Category>();

            for (int temp = 0; temp < CategoryList.getLength(); temp++) {

                Node nNode = CategoryList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    Category newCategory = new Category(getTagValue("CategoryName", eElement));
                    categoryList.add(newCategory);
                }
            }

            dc.setCategoryList(categoryList);
        } catch (FileNotFoundException e) {
            dc.setCategoryList(new ArrayList<Category>());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void readProducts() {

        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            NodeList PL = doc.getElementsByTagName("Product");
            List<Product> productList = new ArrayList<Product>();
            for (int temp = 0; temp < PL.getLength(); temp++) {

                Node nNode = PL.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {


                    Element eElement = (Element) nNode;
                    Category category = new Category(getTagValue("ProductCategory", eElement));
                    Shop shop = new Shop(getTagValue("ProductShop", eElement));
                    Product newProduct = new Product.Builder(getTagValue("ProductName", eElement), category, shop).build();
                    try {
                        newProduct.setItemQuantity(Integer.parseInt(getTagValue("ProductQuantity", eElement)));
                        newProduct.setItemUnit(getTagValue("ProductUnit", eElement));
                    } catch (Exception e) {
                    }
                    productList.add(newProduct);

                }
            }

            dc.setProductList(productList);
        } catch (FileNotFoundException e) {
            dc.setProductList(new ArrayList<Product>());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readShoppingLists() {

        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            NodeList SHL = doc.getElementsByTagName("ShoppingList");
            List<ShoppingList> shoppingLists = new ArrayList<ShoppingList>();
            for (int temp = 0; temp < SHL.getLength(); temp++) {


                Node nNode = SHL.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    String name = getTagValue("ShoppingListName", eElement);

                    NodeList ShoppingProductList = doc.getElementsByTagName("ShoppingProduct");
                    List<Product> productList = new ArrayList<Product>();

                    for (int temp1 = 0; temp1 < ShoppingProductList.getLength(); temp1++) {


                        Node nNode1 = ShoppingProductList.item(temp1);
                        if (nNode1.getNodeType() == Node.ELEMENT_NODE) {

                            Element eElement1 = (Element) nNode;
                            Category category = new Category(getTagValue("ProductCategory", eElement1));
                            Shop shop = new Shop(getTagValue("ProductShop", eElement1));
                            Product newProduct = new Product.Builder(getTagValue("ProductName", eElement1), category, shop).build();
                            try {
                                newProduct.setItemQuantity(Integer.parseInt(getTagValue("ProductQuantity", eElement1)));
                                newProduct.setItemUnit(getTagValue("ProductUnit", eElement1));
                            } catch (Exception e) {
                            }
                            productList.add(newProduct);
                            System.out.println("Algo " + newProduct.getItemName());
                        }
                    }

                    ShoppingList newList = new ShoppingList(name, productList);
                    shoppingLists.add(newList);

                }
            }

            dc.setShoppingLists(shoppingLists);
        } catch (FileNotFoundException e) {
            dc.setShoppingLists(new ArrayList<ShoppingList>());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();

        Node nValue = nlList.item(0);

        return nValue.getNodeValue();
    }

    /**
     * @return
     */
    DataContainers readDC() {

        readShops();
        readCategories();
        readProducts();
        readShoppingLists();

        return dc;
    }
}