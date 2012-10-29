/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GUI;

import java.util.List;

/**
 * Class: MainPanel
 * Description: MainPanel is an Interface to hold all the Jpanels to be presented in the MainForm
 * Author: Brian Arnold & Guadalupe Robles Gil Date:
 * 24/10/12 Time: 10:09 AM *
 */
public interface MainPanel {


    /**
     * It will return the List to be printed or send by Email
     *
     * @return
     */
    public List getItemList();

    /**
     * It will return the String to be printed or send by Email
     *
     * @return
     */
    public String[][] getStringList();
}
