package com.GUI;

import com.GUI.EditPanels.EditCategory;
import com.GUI.EditPanels.EditProduct;
import com.GUI.EditPanels.EditShop;
import com.GUI.EditPanels.EditShoppingList;
import com.GUI.ListPanels.CategoryList;
import com.GUI.ListPanels.ProductList;
import com.GUI.ListPanels.ShopList;
import com.GUI.ListPanels.ShoppingLists;
import com.Item;
import com.Persistance.RecordSeeker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class: MainForm
 * Description: MainForm to present all the application. The Jpanels will be presented through this Frame
 * Author: Brian Arnold & Guadalupe Robles Gil Date:
 * 24/10/12 Time: 10:09 AM *
 */
public class MainForm extends JFrame {

    private final RecordSeeker recordSeeker;
    private MainPanel MainPanel;


    /**
     * Creates new form NewJFrame
     */
    public MainForm() {
        recordSeeker = new RecordSeeker();
        MainPanel = new EditShoppingList(new ArrayList<Item>());
        initComponents();

    }

    /**
     * It initalizes the main components in the form
     */
    private void initComponents() {


        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemSendEmail = new javax.swing.JMenuItem();
        jMenuItemPrint = new javax.swing.JMenuItem();
        jMenuItemClose = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemEdtProduct = new javax.swing.JMenuItem();
        jMenuItemEdtShopping = new javax.swing.JMenuItem();
        jMenuItemEditCategory = new javax.swing.JMenuItem();
        jMenuItemEditShop = new javax.swing.JMenuItem();
        jMenuLists = new javax.swing.JMenu();
        jMenuItemListProducts = new javax.swing.JMenuItem();
        jMenuItemListCategories = new javax.swing.JMenuItem();
        jMenuItemListShops = new javax.swing.JMenuItem();
        jMenuItemListShoppinglists = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shopping List App");


        jMenuFile.setText("File");

        jMenuItemOpen.setText("Open");
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpen);


        jMenuItemSendEmail.setText("Send By Email");
        jMenuItemSendEmail.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSendEmailActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSendEmail);

        jMenuItemPrint.setText("Print");
        jMenuItemPrint.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPrintActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemPrint);

        jMenuItemClose.setText("Close");
        jMenuFile.add(jMenuItemClose);

        jMenuItemClose.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCloseActionPerformed(evt);
            }
        });

        jMenuBar.add(jMenuFile);

        jMenuEdit.setText("Edit");

        jMenuItemEdtProduct.setText("Edit/Add Product");
        jMenuItemEdtProduct.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEdtProductActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemEdtProduct);

        jMenuItemEditCategory.setText("Edit/Add Category");
        jMenuItemEditCategory.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditCategoryActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemEditCategory);

        jMenuItemEditShop.setText("Edit/Add Shop");
        jMenuItemEditShop.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditShopActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemEditShop);

        jMenuItemEdtShopping.setText("Edit/Add Shopping List");
        jMenuItemEdtShopping.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEdtShoppingActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemEdtShopping);

        jMenuBar.add(jMenuEdit);

        jMenuLists.setText("Lists");

        jMenuItemListProducts.setText("Products");
        jMenuItemListProducts.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListProductsActionPerformed(evt);
            }
        });
        jMenuLists.add(jMenuItemListProducts);

        jMenuItemListCategories.setText("Categories");
        jMenuItemListCategories.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListCategoriesActionPerformed(evt);
            }
        });
        jMenuLists.add(jMenuItemListCategories);

        jMenuItemListShops.setText("Shops");
        jMenuItemListShops.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListShopsActionPerformed(evt);
            }
        });
        jMenuLists.add(jMenuItemListShops);

        jMenuItemListShoppinglists.setText("Shopping Lists");
        jMenuItemListShoppinglists.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListShoppinglistsActionPerformed(evt);
            }
        });
        jMenuLists.add(jMenuItemListShoppinglists);


        jMenuBar.add(jMenuLists);

        jMenuHelp.setText("Help");

        jMenuItemAbout.setText("About");
        jMenuHelp.add(jMenuItemAbout);

        jMenuBar.add(jMenuHelp);

        setJMenuBar(jMenuBar);
        setMinimumSize(new java.awt.Dimension(700, 500));

        setLayout(MainPanel);

        pack();
    }// </editor-fold>

    /**
     * It sets the Layput where we will attach the other panels
     *
     * @param panel
     */
    public void setLayout(MainPanel panel) {
        this.getContentPane().removeAll();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent((Component) panel, javax.swing.GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent((Component) panel, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE));

        pack();
    }

    /**
     * Sets the action for the Openmenuitem
     */
    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {
        MainPanel = new ShoppingLists(recordSeeker.getShoppingList());
        setLayout(MainPanel);
        jMenuItemPrint.setEnabled(true);
        jMenuItemSendEmail.setEnabled(true);
    }

    /**
     * Sets the action for the SendEmail MenuIten
     */
    private void jMenuItemSendEmailActionPerformed(java.awt.event.ActionEvent evt) {

        List stringToPrint = MainPanel.getItemList();
    }

    /**
     * Sets the action for the Print MenuIten
     */
    private void jMenuItemPrintActionPerformed(java.awt.event.ActionEvent evt) {

        List listToPrint = MainPanel.getItemList();
        String[][] stringToPrint = MainPanel.getStringList();

    }

    /**
     * Sets the action for the Edit/Product MenuIten
     */
    private void jMenuItemEdtProductActionPerformed(java.awt.event.ActionEvent evt) {
        MainPanel = new EditProduct(recordSeeker.getProductList());
        setLayout(MainPanel);
        jMenuItemPrint.setEnabled(false);
        jMenuItemSendEmail.setEnabled(false);

    }

    /**
     * Sets the action for the Edit/Shopping MenuIten
     */
    private void jMenuItemEdtShoppingActionPerformed(java.awt.event.ActionEvent evt) {
        MainPanel = new EditShoppingList(new ArrayList<Item>());
        setLayout(MainPanel);
        jMenuItemPrint.setEnabled(true);
        jMenuItemSendEmail.setEnabled(true);
    }

    /**
     * Sets the action for the Edit/Category MenuIten
     */
    private void jMenuItemEditCategoryActionPerformed(java.awt.event.ActionEvent evt) {
        MainPanel = new EditCategory(recordSeeker.getcategoryList());
        setLayout(MainPanel);
        jMenuItemPrint.setEnabled(false);
        jMenuItemSendEmail.setEnabled(false);

    }

    /**
     * Sets the action for the Edit/Shop MenuIten
     */
    private void jMenuItemEditShopActionPerformed(java.awt.event.ActionEvent evt) {
        MainPanel = new EditShop(recordSeeker.getShopList());
        setLayout(MainPanel);
        jMenuItemPrint.setEnabled(false);
        jMenuItemSendEmail.setEnabled(false);
    }

    /**
     * Sets the action for the ListProduct MenuIten
     */
    private void jMenuItemListProductsActionPerformed(java.awt.event.ActionEvent evt) {
        MainPanel = new ProductList(recordSeeker.getProductList());
        setLayout(MainPanel);
        jMenuItemPrint.setEnabled(true);
        jMenuItemSendEmail.setEnabled(true);

    }

    /**
     * Sets the action for the ListCategory MenuIten
     */
    private void jMenuItemListCategoriesActionPerformed(java.awt.event.ActionEvent evt) {
        MainPanel = new CategoryList(recordSeeker.getcategoryList());
        setLayout(MainPanel);
        jMenuItemPrint.setEnabled(true);
        jMenuItemSendEmail.setEnabled(true);
    }

    /**
     * Sets the action for the ListShop MenuIten
     */
    private void jMenuItemListShopsActionPerformed(java.awt.event.ActionEvent evt) {
        MainPanel = new ShopList(recordSeeker.getShopList());
        setLayout(MainPanel);
        jMenuItemPrint.setEnabled(true);
        jMenuItemSendEmail.setEnabled(true);
    }

    /**
     * Sets the action for the ListShoppingList MenuIten
     */
    private void jMenuItemListShoppinglistsActionPerformed(java.awt.event.ActionEvent evt) {
        MainPanel = new ShoppingLists(recordSeeker.getShoppingList());
        setLayout(MainPanel);
        jMenuItemPrint.setEnabled(true);
        jMenuItemSendEmail.setEnabled(true);
    }

    /**
     * Sets the action for the Close MenuIten
     */
    private void jMenuItemCloseActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainForm().setVisible(true);

            }
        });
    }

    // Variables declaration
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemClose;
    private javax.swing.JMenuItem jMenuItemEditCategory;
    private javax.swing.JMenuItem jMenuItemEditShop;
    private javax.swing.JMenuItem jMenuItemEdtProduct;
    private javax.swing.JMenuItem jMenuItemEdtShopping;
    private javax.swing.JMenuItem jMenuItemListCategories;
    private javax.swing.JMenuItem jMenuItemListProducts;
    private javax.swing.JMenuItem jMenuItemListShops;
    private javax.swing.JMenuItem jMenuItemListShoppinglists;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemPrint;
    private javax.swing.JMenuItem jMenuItemSendEmail;
    private javax.swing.JMenu jMenuLists;
    // End of variables declaration
}
