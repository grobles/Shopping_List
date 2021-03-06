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
import com.Persistance.EmailList;
import com.Persistance.RecordSeeker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;

/**
 * Class: MainForm
 * Description: MainForm to present all the application. The Jpanels will be presented through this Frame
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date:24/10/12
 * Time: 10:09 AM
 */
public class MainForm extends JFrame {

    private MainPanel MainPanel;
    private RecordSeeker recordSeeker;

    /**
     * Creates new form NewJFrame
     */
    public MainForm() {
        recordSeeker = new RecordSeeker();
        MainPanel = new EditShoppingList(new ArrayList<Item>(), this);
        initComponents();
    }

    public RecordSeeker getRecordSeeker() {
        return recordSeeker;
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
     * It sets the Layout where we will attach the other panels
     *
     * @param panel
     */
    public void setLayout(MainPanel panel) {
        MainPanel = panel;
        this.getContentPane().removeAll();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent((Component) MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent((Component) MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE));

        pack();
    }

    /**
     * Sets the action for the open menu item
     */
    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {
        MainPanel = new ShoppingLists(this);
        setLayout(MainPanel);
        jMenuItemPrint.setEnabled(true);
        jMenuItemSendEmail.setEnabled(true);
    }

    /**
     * Sets the action for the SendEmail MenuItem
     */
    private void jMenuItemSendEmailActionPerformed(ActionEvent evt) {

        String email;
        email = JOptionPane.showInputDialog(new JPanel(), "Enter an e-mail address to send the list.");

        if (ValidateInput.isEmail(email)) {
            java.util.List listToPrint = MainPanel.getItemList();
            //EmailList class will throw a classNotFound exception if we somehow pass an unrecognized class type
            try {
                new EmailList(email, listToPrint);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(new JFrame(), JOptionPane.OK_OPTION,
                        "List error, list contains objects of an unexpected type.\n"
                                + "Expected: 'Category' or 'Product'\nReceived: " + listToPrint.toString(),
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), email + " is not a valid email address!");
        }
    }

    /**
     * Sets the action for the Print MenuItem
     */
    private void jMenuItemPrintActionPerformed(java.awt.event.ActionEvent evt) {
//        java.util.List listToPrint = MainPanel.getItemList();
//        new PrintLists(listToPrint);

        JTable table = MainPanel.getTable();
        MessageFormat headerFormat = new MessageFormat("List of Items");
        MessageFormat footerFormat = new MessageFormat("- {0} -");

        try {
            table.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (PrinterException pe) {
            JOptionPane.showMessageDialog(new JFrame(), JOptionPane.OK_OPTION, "The list was not printed.",
                    JOptionPane.ERROR_MESSAGE);
            pe.printStackTrace();
        }
    }

    /**
     * Sets the action for the Edit/Product MenuItem
     */
    private void jMenuItemEdtProductActionPerformed(java.awt.event.ActionEvent evt) {
        setLayout(new EditProduct(this));
        jMenuItemPrint.setEnabled(false);
        jMenuItemSendEmail.setEnabled(false);
    }

    /**
     * Sets the action for the Edit/Shopping MenuItem
     */
    private void jMenuItemEdtShoppingActionPerformed(java.awt.event.ActionEvent evt) {
        setLayout(new EditShoppingList(new ArrayList<Item>(), this));
        jMenuItemPrint.setEnabled(true);
        jMenuItemSendEmail.setEnabled(true);
    }

    /**
     * Sets the action for the Edit/Category MenuItem
     *
     * @param evt : event raised by editCategory action
     */
    private void jMenuItemEditCategoryActionPerformed(java.awt.event.ActionEvent evt) {
        setLayout(new EditCategory(this));
        jMenuItemPrint.setEnabled(false);
        jMenuItemSendEmail.setEnabled(false);
    }

    /**
     * Sets the action for the Edit/Shop MenuItem
     */
    private void jMenuItemEditShopActionPerformed(java.awt.event.ActionEvent evt) {
        setLayout(new EditShop(this));
        jMenuItemPrint.setEnabled(false);
        jMenuItemSendEmail.setEnabled(false);
    }

    /**
     * Sets the action for the ListProduct MenuItem
     */
    private void jMenuItemListProductsActionPerformed(java.awt.event.ActionEvent evt) {
        setLayout(new ProductList(this));
        jMenuItemPrint.setEnabled(true);
        jMenuItemSendEmail.setEnabled(true);
    }

    /**
     * Sets the action for the ListCategory MenuItem
     */
    private void jMenuItemListCategoriesActionPerformed(java.awt.event.ActionEvent evt) {
        setLayout(new CategoryList(this));
        jMenuItemPrint.setEnabled(true);
        jMenuItemSendEmail.setEnabled(true);
    }

    /**
     * Sets the action for the ListShop MenuItem
     */
    private void jMenuItemListShopsActionPerformed(java.awt.event.ActionEvent evt) {
        setLayout(new ShopList(this));
        jMenuItemPrint.setEnabled(true);
        jMenuItemSendEmail.setEnabled(true);
    }

    /**
     * Sets the action for the ListShoppingList MenuItem
     */
    private void jMenuItemListShoppinglistsActionPerformed(java.awt.event.ActionEvent evt) {
        setLayout(new ShoppingLists(this));
        jMenuItemPrint.setEnabled(true);
        jMenuItemSendEmail.setEnabled(true);
    }

    /**
     * Sets the action for the Close MenuItem
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
