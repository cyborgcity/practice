package com.cyborgcity.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ravi on 28-07-2017.
 */

class CNode{
    private int pageNumber;
    private CNode prev;
    private CNode next;

    public CNode(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public CNode getPrev() {
        return prev;
    }

    public void setPrev(CNode prev) {
        this.prev = prev;
    }

    public CNode getNext() {
        return next;
    }

    public void setNext(CNode next) {
        this.next = next;
    }

    public String toString() {
        return pageNumber + "  ";
    }
}

class DoublyLinkedList{

    private final int size;
    private int currSize;
    private CNode head;
    private CNode tail;
    public DoublyLinkedList(int size) {
        this.size = size;
        currSize = 0;
    }

    public void printList() {
        if(head == null) {
            return;
        }
        CNode tmp = head;
        while(tmp != null) {
            System.out.print(tmp);
            tmp = tmp.getNext();
        }
    }

    public CNode addPageToList(int pageNumber) {
        CNode pageNode = new CNode(pageNumber);
        if(head == null) {
            head = pageNode;
            tail = pageNode;
            currSize = 1;
            return pageNode;
        } else if(currSize < size) {
            currSize++;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        pageNode.setNext(head);
        head.setPrev(pageNode);
        head = pageNode;
        return pageNode;
    }

    public void movePageToHead(CNode pageNode) {
        if(pageNode == null || pageNode == head) {
            return;
        }

        if(pageNode == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
        }

        CNode prev = pageNode.getPrev();
        CNode next = pageNode.getNext();
        prev.setNext(next);

        if(next != null) {
            next.setPrev(prev);
        }

        pageNode.setPrev(null);
        pageNode.setNext(head);
        head.setPrev(pageNode);
        head = pageNode;
    }

    public int getSize() {
        return size;
    }

    public int getCurrSize() {
        return currSize;
    }

    public void setCurrSize(int currSize) {
        this.currSize = currSize;
    }

    public CNode getHead() {
        return head;
    }

    public void setHead(CNode head) {
        this.head = head;
    }

    public CNode getTail() {
        return tail;
    }

    public void setTail(CNode tail) {
        this.tail = tail;
    }
}
public class LRUCache {
    private DoublyLinkedList pageList;
    private Map<Integer, CNode> pageMap;
    private final int cacheSize;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        pageList = new DoublyLinkedList(cacheSize);
        pageMap = new HashMap<>();
    }

    public void accessPage(int pageNumber) {
        CNode pageNode = null;
        if(pageMap.containsKey(pageNumber)) {
            // If page is present in the cache, move the page to the start of list
            pageNode = pageMap.get(pageNumber);
            pageList.movePageToHead(pageNode);
        } else {
            // If the page is not present in the cache, add the page to the cache
            if(pageList.getCurrSize() == pageList.getSize()) {
                // If cache is full, we will remove the tail from the cache pageList
                // Remove it from map too
                pageMap.remove(pageList.getTail().getPageNumber());
            }
            pageNode = pageList.addPageToList(pageNumber);
            pageMap.put(pageNumber, pageNode);
        }
    }

    public void printCacheState() {
        pageList.printList();
        System.out.println();
    }

    public static void main(String[] args) {
        int cacheSize = 4;
        LRUCache cache = new LRUCache(cacheSize);
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(2);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
        cache.accessPage(7);
        cache.printCacheState();
        cache.accessPage(8);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
    }

}
