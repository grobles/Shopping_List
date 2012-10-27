/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GUI;

import com.Persistance.RecordSeeker;

import java.util.List;

/**
 * Class: MainPanel
 * Description: MainPanel is an Interface to hold all the Jpanels to be presented in the MainForm
 * Author: Brian Arnold & Guadalupe Robles Gil Date:
 * 24/10/12 Time: 10:09 AM *
 */
public interface MainPanel {

    /**
     *
     */
    // todo:
    // this code does not belong in an interface
    // do not use interfaces for global data or to share variables like this
    RecordSeeker recordSeeker = new RecordSeeker();

    /**
     * It will return the String to be printed or send by Email
     *
     * @return
     */


    // todo comments?
    // todo should not be public
    public List getItemList();

    // todo comments?
    // todo should not be public
    public String[][] getStringList();
}
