package com.gfg.practice;

/**
 * Created by Ravi on 19-03-2018.
 */

public class SinglyLinkedList {

    SNode head;
//    SNode end;
    private int size;

    public SinglyLinkedList() {
        head = null;
//        end = null;
        size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int getSize(){
        return size;
    }

    public SNode getHead(){
        return head;
    }

    public void add(int val){
        SNode node = new SNode(val, null);
        if(head == null){
            head = node;
            size++ ;
        }else{
            SNode ptr = head;
            while (ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = node;
            size++;
        }
    }
    public void addAtPos(int val, int pos){
        SNode node = new SNode(val, null);
        if(pos == 1){
            node.next = head;
            head =  node;
            size++;
        }else{
            int currentPos = 1;
            SNode ptr = head;
            while(currentPos == pos){
                ptr = ptr.next;
                currentPos++;
            }
            node.next = ptr.next;
            ptr.next = node;
            size++;
        }
    }
    public void deleteAtPos(int pos){
        SNode ptr = head;
        if(pos == 1){
            ptr = ptr.next;
            head.next = null;
            head = ptr;
            size--;
        }else {
            int currentPos = 1;
            while (currentPos == pos){
                ptr = ptr.next;
            }
            SNode temp = ptr.next;
            ptr.next = temp.next;
            temp.next = null;
            size--;
        }
    }
    public void print(){
        SNode ptr = head;
        while (ptr != null){
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public void reverse(){
        SNode ptr1, ptr2, ptr3;
        ptr1 = null;
        ptr2 = head;
        ptr3 = null;
        while(ptr2 != null){
            ptr3 = ptr2.next;
            ptr2.next = ptr1;
            ptr1 = ptr2;
            ptr2 = ptr3;
        }
        head = ptr1;
    }
    public void reverseByRecursion(){
        SNode ptr = head;
        reversePrintByRecuersion(ptr);
    }
    public void reversePrintByRecuersion(SNode ptr){
        if(ptr == null)
            return;
        reversePrintByRecuersion(ptr.next);
        System.out.print(ptr.data + " ");
    }

    public void create(SinglyLinkedList list){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.print();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.print();
        System.out.println(list.getSize());

        list.addAtPos(11,1);
        list.print();
        System.out.println(list.getSize());

        list.deleteAtPos(1);
        list.print();
        System.out.println(list.getSize());

//        list.reverse();
//        list.print();
//        System.out.println(list.getSize());

        list.reverseByRecursion();
    }
}
