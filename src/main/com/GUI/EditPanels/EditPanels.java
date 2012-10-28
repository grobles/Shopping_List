package com.GUI.EditPanels;

import com.GUI.MainPanel;
import com.GUI.ValidateInput;
import com.Item;

import javax.swing.*;
import java.util.List;

/**
 * Class: EditPanels
 * Description: It implements MainPanel so it can be used in the MainForm
 * Author: Brian Arnold & Guadalupe Robles Gil Date:
 * 24/10/12 Time: 01:59 PM *
 */
public abstract class EditPanels extends JPanel implements MainPanel {

    List<Item> ItemList;
    JButton jButtonClear;
    JButton jButtonDelete;
    JButton jButtonSave;
    JButton jButtonSearch;
    JLabel jLabelName;
    JTextField jTextFieldName;
    JFrame frame;

    /**
     * Constructor
     *
     * @param list
     */
    EditPanels(List<Item> list) {
        ItemList = list;
        initComponents();
    }

    /**
     * This method is just to implement the method from the MainPanel, it wont be used here
     *
     * @return
     */
    public List getItemList() {
        return ItemList;
    }

    /**
     * It sets the Layout for the Panel
     */
    void setLayout() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jLabelName).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jTextFieldName, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(jButtonClear, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jButtonSearch).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jButtonSave, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jButtonDelete))).addGap(6, 6, 6)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabelName).addGap(3, 3, 3).addComponent(jTextFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGap(23, 23, 23).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jButtonSave).addComponent(jButtonClear).addComponent(jButtonSearch).addComponent(jButtonDelete)).addContainerGap(13, Short.MAX_VALUE)));


    }// </editor-fold>

    /**
     * initalizes all the components
     */
    void initComponents() {


        jLabelName = new JLabel();
        jTextFieldName = new JTextField();
        jButtonSearch = new JButton();
        jButtonSave = new JButton();
        jButtonClear = new JButton();
        jButtonDelete = new JButton();

        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jLabelName.setText("Name");

        jButtonSearch.setText("Search");
        jButtonSearch.setName("JButtonSearch");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });


        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

    }

    /**
     * method: jButtonClearActionPerformed : Clear the form
     *
     * @param evt
     */
    void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {
        clear();
    }

    /**
     * method: jButtonSearchActionPerformed : Search for item
     *
     * @param evt
     */
    void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {
        String name = jTextFieldName.getText();

        if (ValidateInput.isText(name)) {
            Item item = recordSeeker.findItem(name, ItemList);
            String message;
            if (item != null) {
                Search(item);
                message = "Item '" + name + "' found";
                JOptionPane.showMessageDialog(frame, message);
            } else {
                message = "Item '" + name + "' is not currently an Item";
                int selection = JOptionPane.showConfirmDialog(frame, message + "\nWould you like to create it?");
                if (selection == 0) {
                    addItem(name);
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, "'" + name + "' is not a valid Item name.\nTry again.");
        }
        jTextFieldName.setText("");
        jTextFieldName.requestFocus();
    }

    /**
     * method: jButtonSaveActionPerformed : save an Item
     *
     * @param evt
     */
    void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {
        String name = jTextFieldName.getText();

        if (ValidateInput.isText(name)) {
            Item itemFound = recordSeeker.findItem(name, ItemList);
            if (itemFound != null) {
                editProduct(itemFound);
                JOptionPane.showMessageDialog(frame, "'" + name + "' already exists.");
            } else {
                int n = JOptionPane.showConfirmDialog(
                        frame,
                        "Would you like to save " + name + "?",
                        "Confirm Save Item",
                        JOptionPane.YES_NO_OPTION);
                if (n == 0) {
                    addItem(name);
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, "'" + name + "' is not a valid Item name.\nTry again.");
        }
        clear();
    }

    /**
     * method: jButtonDeleteActionPerformed : delete an Item
     *
     * @param evt
     */
    void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        String name = jTextFieldName.getText();

        if (ValidateInput.isText(name)) {
            Item itemFound = recordSeeker.findItem(name, ItemList);
            if (itemFound == null) {
                JOptionPane.showMessageDialog(frame, "The Item '" + name + "' was not found");
                jTextFieldName.requestFocus();
            } else {
                int n = JOptionPane.showConfirmDialog(
                        frame,
                        "Would you like to delete the Item '" + name + "'?\n"
                                + "Doing this will also remove the associate Products with it",
                        "Confirm Delete Item",
                        JOptionPane.YES_NO_OPTION);
                if (n == 0) {
                    deleteItem(itemFound);
                    ItemList.remove(itemFound);
                    recordSeeker.writToXml();
                    JOptionPane.showMessageDialog(frame, "'" + name + "' has been deleted.");
                }
            }
        } else {

            JOptionPane.showMessageDialog(frame, "'" + name + "' is not a valid Item name.\nTry again.");
        }
        clear();
    }

    /**
     * Method: AddItem. It will be overriden in all the implementations
     *
     * @param name
     */
    void addItem(String name) {
    }

    /**
     * Cear the textboxes
     */
    void clear() {
        jTextFieldName.setText("");
        jTextFieldName.requestFocus();
    }

    /**
     * Method search: to be overriden in some implementations
     *
     * @param item
     */
    void Search(Item item) {
    }

    /**
     * Method edit: to be overriden in some implementations
     *
     * @param item
     */

    void editProduct(Item item) {
    }


    void deleteItem(Item item) {
    }
}
