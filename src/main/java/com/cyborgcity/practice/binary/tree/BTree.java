package com.cyborgcity.practice.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ravi on 24-07-2017.
 */
public class BTree {

    private BTNode root;

    public BTree() {
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public BTNode insert(int d){
        root = insert(root, d);
        return root;
    }

    public BTNode insert(BTNode node, int d){
        if(node == null){
            node = new BTNode(d);
        }else {
            if(node.getLeft() == null){
                node.left = insert(node.left, d);
            }else {
                node.right = insert(node.right, d);
            }
        }
        return node;
    }

    public int countNodes(){
        return countNodes(root);
    }

    public int countNodes(BTNode root){
        if(root == null){
            return 0;
        }else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public boolean search(int d){
        return search(root, d);
    }

    public boolean search(BTNode node, int d){
        if(node.data == d)
            return true;
        if(node.left != null) {
            search(node.left, d);
            return true;
        }
        if (node.right != null) {
            search(node.right, d);
            return true;
        }
        return false;
    }

    public void inorder(){
        inorder(root);
        System.out.println();
    }

    public void inorder(BTNode root){
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void preorder(){
        preorder(root);
        System.out.println();
    }

    public void preorder(BTNode root){
        if (root == null)
            return;
        System.out.print(root.data + " ");
        inorder(root.left);
        inorder(root.right);
    }

    public void postorder(){
        postorder(root);
        System.out.println();
    }

    public void postorder(BTNode root){
        if (root == null)
            return;
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data + " ");
    }

    public void levelOrder(){
        levelOrder(root);
    }

    public void levelOrder(BTNode root){
        if (root == null)
            return;
        int h = height(root);
        for (int i = 1; i <= h; i++){
            printGivenLevel(root, i);
        }
        System.out.println();
    }

    void printGivenLevel(BTNode node, int level){
        if (node == null)
            return;
        if(level == 1){
            System.out.print(node.getData() + " ");
        }else {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }

    public void printLevelOrder(){
        printLevelOrder(root);
        System.out.println();
    }

    void printLevelOrder(BTNode root){
        if(root == null)
            return;
        Queue<BTNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BTNode node = q.poll();
            System.out.print(node.getData() + " ");
            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }
    }

    public BTNode createTree(){
        int arr[] = {1,2,3,4,5,6,7,8};
        BTNode root = null;
        for (int i = 0; i < arr.length; i++){
            root = insert(arr[i]);
        }
        System.out.println("Pre-Order Traversal");
        preorder();
        System.out.println("Post-Order Traversal");
        postorder();
        System.out.println("In-Order Traversal");
        inorder();
        System.out.println("Level-Order Traversal");
        levelOrder();
        System.out.println("Level-Order Traversal with Queue Impl");
        printLevelOrder();
        return root;
    }

    public int height(){
        return height(root);
    }

    public int height(BTNode root){
        if(root == null)
            return 0;
        else{
            int lheight = height(root.left);
            int rheight = height(root.right);
//            System.out.println("lheight : " + lheight);
//            System.out.println("rheight : " + rheight);
            if(lheight > rheight){
                return (lheight + 1);
            }else{
                return (rheight + 1);
            }
        }
    }
}
