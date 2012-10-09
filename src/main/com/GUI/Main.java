package com.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class: Main
 * Description: In this for you can edit or add a new Shop
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 9/22/12
 * Time: 12:51 PM *
 */
public class Main extends JFrame {
    //create items to add to the JPanel
    private JLabel textLabel;
    private JButton selectBtn;
    private JButton quitBtn;
    private JButton clearBtn;
    private JComboBox selectionBox;
    //options for the combo box
    private String[] options = {"Select an option...", "Product", "Category", "Shop"};

    /**
     * Creates new form Main
     */
    public Main() {

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")

    private void initComponents() {

        textLabel = new JLabel("Select an option");
        //jTextFieldShopName = new JTextField();

        selectionBox = new JComboBox(options);
        selectBtn = new JButton("Select");
        quitBtn = new JButton("Quit");
        clearBtn = new JButton("Reset");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shopping List Home");

        //reset the form
        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearAction(e);
            }
        });

        //determine the selection in the combo box
        selectBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectAction(e);
            }
        });

        //exit the GUI
        quitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quitAction(e);
            }
        });

        //set up the form layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(textLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(selectionBox, GroupLayout.Alignment.LEADING)
                                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(selectBtn)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(clearBtn)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(quitBtn)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(textLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(selectionBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(selectBtn)
                                        .addComponent(clearBtn)
                                        .addComponent(quitBtn))
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }

    /**
     * method: clearAction : Clear the form
     */
    private void clearAction(ActionEvent e) {
        selectionBox.setSelectedIndex(0);
        selectionBox.requestFocus();
    }

    /**
     * method: selectAction : Select the GUI form to run
     */

    private void selectAction(ActionEvent e) {
        //test the selection
        switch (selectionBox.getSelectedIndex()) {
            case 0:
                //not a valid selection
                JOptionPane.showMessageDialog(null, "Please make a valid selection");

            case 1:
                //run the EditProduct GUI
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new EditProduct().setVisible(true);
                    }
                });
                break;

            case 2:
                //run the EditCategory GUI
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new EditCategory().setVisible(true);
                    }
                });
                break;

            case 3:
                //run the EditShop GUI
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new EditShop().setVisible(true);
                    }
                });
                break;
        }
    }

    /**
     * method: quitAction: quit the GUI application
     */

    private void quitAction(ActionEvent e) {
        System.exit(0);

    }
    /**
     * method: jButtonCancelActionPerformed : Exit and save to file
     *
     *
     */

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
