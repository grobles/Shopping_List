package com;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: grobles
 * Date: 23/09/12
 * Time: 10:22 PM
 * To change this template use File | Settings | File Templates.
 */
public interface InterfaceList {

    public Collection getList();

    public void setList(Collection list);

    public void addItem(InterfaceItems item);

    public void removeItem(InterfaceItems item);

    public void sortList();

    public void printList();

}
