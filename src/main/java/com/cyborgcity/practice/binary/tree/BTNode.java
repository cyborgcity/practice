package com.cyborgcity.practice.binary.tree;

/**
 * Created by Ravi on 24-07-2017.
 */
public class BTNode {

    BTNode left, right;
    int data;

    public BTNode() {
        left = null;
        right = null;
        data = 0;
    }

    public BTNode(int data) {
        left = null;
        right = null;
        this.data = data;
    }

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}


