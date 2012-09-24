package com;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: grobles
 * Date: 23/09/12
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Lists implements InterfaceList {

    private Collection<InterfaceItems> list;

    public Collection getList() {
        return list;
    }

    public void setList(Collection list) {
        this.list = list;
    }

    public void addItem(InterfaceItems item){
        list.add(item);
    }

    public void removeItem(InterfaceItems item){
        list.remove(item) ;

    }


    /*  TODO add functionality to this method using comparators.
    */
    public void sortList(){

    }
    /*  TODO add functionality to this method to print the whole list already sorted.
    */
    public void printList(){

    }


   }
