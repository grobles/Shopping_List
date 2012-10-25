package com.Persistance;

import com.Category;
import com.Product;
import com.Shop;
import com.ShoppingList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

/**
 * @author grobles
 */
class WriteXMLFile {

    private final List<Shop> shopList;
    private final List<Category> categoryList;
    private final List<Product> productList;
    private final List<ShoppingList> shoppingLists;
    private final String fileName;
    private final RecordSeeker recordseeker;

    /**
     * @param
     * @param
     */
    public WriteXMLFile(RecordSeeker rs) {
        recordseeker = rs;
        shopList = recordseeker.getShopList();
        categoryList = recordseeker.getcategoryList();
        productList = recordseeker.getProductList();
        shoppingLists = recordseeker.getShoppingList();
        fileName = recordseeker.getFilename();

    }

    /**
     * method: Overload constructor to be able to test
     *
     * @param
     */


    void writeFile() {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Item-Lists");
            doc.appendChild(rootElement);

            // Shops elements
            Element shops = doc.createElement("Shops");
            rootElement.appendChild(shops);

            // shorten way
            // staff.setAttribute("id", "1");

            // shop elements

            for (Shop sh : shopList) {
                Element shop = doc.createElement("Shop");
                shops.appendChild(shop);
                Element shopname = doc.createElement("ShopName");
                shop.appendChild(shopname);
                shopname.appendChild(doc.createTextNode(sh.getItemName()));
            }
            // Categories elements
            Element categories = doc.createElement("Categories");
            rootElement.appendChild(categories);

            // category elements

            for (Category ca : categoryList) {
                Element category = doc.createElement("Category");
                categories.appendChild(category);
                Element categoryname = doc.createElement("CategoryName");
                category.appendChild(categoryname);
                categoryname.appendChild(doc.createTextNode(ca.getItemName()));
            }
            // Products elements
            Element products = doc.createElement("Products");
            rootElement.appendChild(products);

            // product elements

            for (Product pr : productList) {
                Element product = doc.createElement("Product");
                products.appendChild(product);
                Element productname = doc.createElement("ProductName");
                product.appendChild(productname);
                productname.appendChild(doc.createTextNode(pr.getItemName()));
                Element productcategory = doc.createElement("ProductCategory");
                product.appendChild(productcategory);
                productcategory.appendChild(doc.createTextNode(pr.getItemCategory().getItemName()));
                Element productshop = doc.createElement("ProductShop");
                product.appendChild(productshop);
                productshop.appendChild(doc.createTextNode(pr.getItemShop().getItemName()));
                Element productqty = doc.createElement("ProductQuantity");
                product.appendChild(productqty);
                productqty.appendChild(doc.createTextNode(Integer.toString(pr.getItemQuantity())));
                Element productunit = doc.createElement("ProductUnit");
                product.appendChild(productunit);
                productunit.appendChild(doc.createTextNode(pr.getItemUnit()));
            }
            // Products elements
            Element ShoppingLists = doc.createElement("ShoppingLists");
            rootElement.appendChild(ShoppingLists);

            // product elements

            for (ShoppingList list : shoppingLists) {
                Element ShoppingList = doc.createElement("ShoppingList");
                ShoppingLists.appendChild(ShoppingList);
                Element shoppingListName = doc.createElement("ShoppingListName");
                ShoppingList.appendChild(shoppingListName);
                shoppingListName.appendChild(doc.createTextNode(list.getItemName()));


                Element shoppingListproducts = doc.createElement("ShoppingListProducts");
                ShoppingList.appendChild(shoppingListproducts);

                for (Product pr : list.getProductsList()) {
                    Element shoppingproduct = doc.createElement("ShoppingProduct");
                    shoppingListproducts.appendChild(shoppingproduct);
                    Element productname = doc.createElement("ProductName");
                    shoppingproduct.appendChild(productname);
                    productname.appendChild(doc.createTextNode(pr.getItemName()));
                    Element productcategory = doc.createElement("ProductCategory");
                    shoppingproduct.appendChild(productcategory);
                    productcategory.appendChild(doc.createTextNode(pr.getItemCategory().getItemName()));
                    Element productshop = doc.createElement("ProductShop");
                    shoppingproduct.appendChild(productshop);
                    productshop.appendChild(doc.createTextNode(pr.getItemShop().getItemName()));
                    Element productqty = doc.createElement("ProductQuantity");
                    shoppingproduct.appendChild(productqty);
                    productqty.appendChild(doc.createTextNode(Integer.toString(pr.getItemQuantity())));
                    Element productunit = doc.createElement("ProductUnit");
                    shoppingproduct.appendChild(productunit);
                    productunit.appendChild(doc.createTextNode(pr.getItemUnit()));
                }
            }


            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}