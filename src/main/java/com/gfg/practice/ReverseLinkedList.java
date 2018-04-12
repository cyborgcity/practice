package com.gfg.practice;

/**
 * Created by Ravi on 20-03-2018.
 */
public class ReverseLinkedList {
    SNode head,ptr;

    public void createList(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.create(list);
        list.print();
        head = list.getHead();
        ptr = head;
    }
    public void reversePrintByRecuersion(SNode head){
        if(ptr == null)
            return;
        reversePrintByRecuersion(ptr.next);
        System.out.print(ptr.data + " ");
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.createList();
//        list.reversePrintByRecuersion();
    }
}
