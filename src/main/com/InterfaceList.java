package com;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: grobles
 * Date: 23/09/12
 * Time: 10:22 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 *             Class: InterfaceLists
 * Purpose: This will hold all the Lists that we are making.
 *
 * @author Lupe Robles, Brian Arnold
 *
 */
public interface InterfaceList {

    /**
     *
     * @return
     */
    public Collection getList();

    /**
     *
     * @param list
     */
    public void setList(Collection list);

    /**
     *
     * @param item
     */
    public void addItem(InterfaceItems item);

    /**
     *
     * @param item
     */
    public void removeItem(InterfaceItems item);

    /**
     *
     */
    public void sortList();

    /**
     *
     */
    public void printList();

}