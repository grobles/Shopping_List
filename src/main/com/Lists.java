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

    private Collection<InterfaceItems> List;

    public Lists(Collection list){
      this.setList(list);
    }

    public Collection getList() {
        return List;
    }

    public void setList(Collection list) {
        this.List = list;
    }

    public void addItem(InterfaceItems item){
        List.add(item);
    }

    public void removeItem(InterfaceItems item){
        List.remove(item) ;

    }
    public int getSize(){
        return List.size();
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
