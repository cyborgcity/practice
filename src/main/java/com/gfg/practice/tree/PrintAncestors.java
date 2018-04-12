package com.gfg.practice.tree;

/**
 * Created by Ravi on 26-03-2018.
 */
public class PrintAncestors {

    public boolean printAncestors(BinaryTreeNode root, int val){
        if(root == null)
            return false;
        if(root.data == val) {
            System.out.println(root.data);
            return true;
        }
        if(printAncestors(root.left, val)
                ||
                printAncestors(root.right, val)){
            System.out.println(root.data);
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTree.create();
        PrintAncestors ancestors = new PrintAncestors();
        System.out.println(ancestors.printAncestors(root, 7));
    }
}
