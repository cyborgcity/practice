package com.gfg.practice.tree.bst;

/**
 * Created by Ravi on 07-04-2018.
 */
public class BinarySearchTree {
    BSTNode root;

    public void insert(int data){
        root = insert(root, data);
    }

    public BSTNode insert(BSTNode root, int key){
        if(root == null){
            root = new BSTNode(key);
            return root;
        }

        if(key < root.data){
            root.left = insert(root.left, key);
        }else if(key > root.data) {
            root.right = insert(root.right, key);
        }
        return root;
    }
    public BSTNode create(){
        int[] keys = {50, 30, 20, 40, 70, 60, 80};
        create(keys);
        return root;
    }
    private void create(int[] keys){
        for(int i = 0; i < keys.length; i++){
            insert(keys[i]);
        }
    }
    public void inorder(){
        inorder(root);
        System.out.println();
    }

    private void inorder(BSTNode root) {
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public boolean search(int key){
        return search(root, key);
    }


    private boolean search(BSTNode root, int key){
        if(root == null)
            return false;
        if(root.data == key)
            return true;
        if(key < root.data)
            return search(root.left, key);
        return search(root.right, key);
    }



    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(tree.create().data);
        tree.inorder();
        System.out.println(tree.search(8));
    }

}
