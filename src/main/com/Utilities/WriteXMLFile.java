package com.Utilities;

import com.Category;
import com.DataContainers;
import com.Product;
import com.Shop;
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
import java.util.Collection;


public class WriteXMLFile {

    private DataContainers dc;
    private String fileName = "data.xml";

    public WriteXMLFile(DataContainers dc) {
        this.dc = dc;
    }

    public void writeFile() {

        Collection<Shop> shopList = dc.getShopList();
        Collection<Category> categoryList = dc.getCategoryList();
        Collection<Product> productList = dc.getProductList();



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
            shop.appendChild(doc.createTextNode(sh.getItemName()));
            }
            // Categories elements
            Element categories = doc.createElement("Categories");
            rootElement.appendChild(categories);

            // category elements
            for (Category ca : categoryList) {
                Element category = doc.createElement("Category");
                categories.appendChild(category);
                category.appendChild(doc.createTextNode(ca.getItemName()));
            }
            // Products elements
            Element products = doc.createElement("Products");
            rootElement.appendChild(products);

            // product elements
            for (Product pr : productList) {
                Element product = doc.createElement("Product");
                products.appendChild(product);
                Element productname = doc.createElement("ProductName");
                products.appendChild(productname);
                productname.appendChild(doc.createTextNode(pr.getItemName()));
                Element productcategory = doc.createElement("ProductCategory");
                products.appendChild(productcategory);
                productcategory.appendChild(doc.createTextNode(pr.getItemCategory().getItemName()));
                Element productshop = doc.createElement("ProductShop");
                products.appendChild(productshop);
                productshop.appendChild(doc.createTextNode(pr.getItemShop().getItemName()));
                Element productqty = doc.createElement("ProductQuantity");
                products.appendChild(productqty);
                productqty.appendChild(doc.createTextNode(Integer.toString(pr.getItemQuantity())));
                Element productunit = doc.createElement("ProductUnit");
                products.appendChild(productunit);
                productunit.appendChild(doc.createTextNode(pr.getItemUnit()));
            }



            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}