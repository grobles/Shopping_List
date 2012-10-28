package com.GUI.ListPanels;

import com.Comparators.ByName;
import com.GUI.MainPanel;
import com.Item;

import javax.swing.*;
import java.util.Collections;
import java.util.List;

/**
 * Class: ShowList
 * Description: Abstract Class to present the lists
 * Author: Brian Arnold & Guadalupe Robles Gil Date:
 * 24/10/12 Time: 10:09 AM *
 */
public abstract class ShowLists extends JPanel implements MainPanel {

    final List<Item> ItemList;
    private JButton jButtonDelete;
    JButton jButtonOpen;
    JComboBox jComboBoxSort;
    private JScrollPane jScrollPane3;
    JTable jTableShoppingProducts;

    /**
     * Creates new form NewJPanel
     *
     * @param itemList
     */
    ShowLists(List<Item> itemList) {

        ItemList = itemList;
        initComponents();
        setTable();
        jButtonOpen.setVisible(false);
    }

    /**
     * Method: getItemList : To get the List to be printed
     *
     * @return
     */
    public List getItemList() {
        return ItemList;
    }

    /**
     * Method: initComponets : It initializes all the components in the Layout
     *
     * @return
     */
    void initComponents() {

        jScrollPane3 = new JScrollPane();
        jTableShoppingProducts = new JTable();
        jComboBoxSort = new JComboBox();
        jButtonDelete = new JButton();
        jButtonOpen = new JButton();

        jTableShoppingProducts.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
                }));
        jScrollPane3.setViewportView(jTableShoppingProducts);

        jComboBoxSort.setModel(new DefaultComboBoxModel(new String[]{"Sort", "Sort Alphabetically"}));
        jComboBoxSort.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSortActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jButtonOpen.setText("Open");
        jButtonOpen.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(19, 19, 19).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE).addGroup(layout.createSequentialGroup().addComponent(jComboBoxSort, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE).addGap(45, 45, 45).addComponent(jButtonOpen).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButtonDelete, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))).addContainerGap(217, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(22, 22, 22).addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jComboBoxSort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(jButtonDelete).addComponent(jButtonOpen)).addContainerGap(38, Short.MAX_VALUE)));
    }// </editor-fold>

    /**
     * It sorts the lists
     *
     * @param evt
     */
    void jComboBoxSortActionPerformed(java.awt.event.ActionEvent evt) {
        if (jComboBoxSort.getSelectedItem().toString().equals("Sort Alphabetically")) {
            Collections.sort(ItemList, new ByName());
        }
        setTable();
    }

    /**
     * To be overriden in the appropiate class
     *
     * @param evt
     */
    void jButtonOpenActionPerformed(java.awt.event.ActionEvent evt) {
    }

    /**
     * Deletes an Item from the List
     *
     * @param evt
     */
    void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int row = jTableShoppingProducts.getSelectedRow();
            Item item = ItemList.get(row);
            ItemList.remove(item);
            setTable();
            recordSeeker.writToXml();
        } catch (Exception ex) {
        }
    }

    /**
     * Sets the table to present the list
     */
    void setTable() {
        jTableShoppingProducts.setModel((new javax.swing.table.DefaultTableModel(
                recordSeeker.setTableStringArray(ItemList),
                new String[]{
                        "Name"
                })));
    }
}
