package com;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: grobles
 * Date: 23/09/12
 * Time: 10:22 PM
 * To change this template use File | Settings | File Templates.
 */


/* todo perhaps your biggest problem I've noticed (but one I have made in the past too) you don't need a
 * a custom list class here. Just one one from the JDK.
 * e.g.
 * List<Item> myItems = new ArrayList<Item>
 *
 * or perhaps I am miss understanding the purpose of this class.
 * Is this really your data access layer?
 *
 * If so it needs a better name.
 *
 * In general, don't name interfaces I<somename> or Interface<somename> Just name them what they are.
 * The implementations of the interface can have more specific names.
 *
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