package com.Persistance;

/**
 * Class: Description: Author: Brian Arnold & Guadalupe Robles Gil Date: 6/10/12
 * Time: 11:00 PM *
 */

import com.Category;
import com.Product;
import com.Shop;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author grobles
 */
public class ReadXMLFile {

    private static String fileName;
    private static DataContainers dc;
    private static File fXmlFile;
    private static DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

    /**
     * @param filename
     */
    public ReadXMLFile(String filename) {
        fileName = filename;
        dc = DataContainers.getInstance();
        fXmlFile = new File(fileName);
    }

    private static void readShops() {

        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            NodeList ShopList = doc.getElementsByTagName("Shop");
            Collection<Shop> shopList = new ArrayList<Shop>();


            for (int temp = 0; temp < ShopList.getLength(); temp++) {

                Node nNode = ShopList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    Shop newShop = new Shop(getTagValue("ShopName", eElement));
                    shopList.add(newShop);
                }
            }

            dc.setShopList(shopList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void readCategories() {

        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            NodeList CategoryList = doc.getElementsByTagName("Category");
            Collection<Category> categoryList = new ArrayList<Category>();

            for (int temp = 0; temp < CategoryList.getLength(); temp++) {

                Node nNode = CategoryList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    Category newCategory = new Category(getTagValue("CategoryName", eElement));
                    categoryList.add(newCategory);
                }
            }

            dc.setCategoryList(categoryList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void readProducts() {

        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            NodeList ProductList = doc.getElementsByTagName("Product");
            Collection<Product> productList = new ArrayList<Product>();

            for (int temp = 0; temp < ProductList.getLength(); temp++) {

                Node nNode = ProductList.item(temp);
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
    public DataContainers readDC() {

        readShops();
        readCategories();
        readProducts();

        return dc;
    }
}