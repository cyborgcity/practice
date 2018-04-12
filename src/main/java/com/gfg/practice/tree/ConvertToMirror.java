package com.gfg.practice.tree;

/**
 * Created by Ravi on 04-04-2018.
 */
public class ConvertToMirror {

    BinaryTreeNode root;

    void mirror(){
        root = mirror(root);
    }

    private BinaryTreeNode mirror(BinaryTreeNode node) {
        if(node == null)
            return node;
        BinaryTreeNode leftNode = mirror(node.left);
        BinaryTreeNode rightNode = mirror(node.right);
        node.left = rightNode;
        node.right = leftNode;
        return node;
    }
    private void inorder(BinaryTreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        ConvertToMirror tree = new ConvertToMirror();
        tree.root = BinaryTree.create();
        tree.inorder(tree.root);
        System.out.println();
        tree.mirror();
        tree.inorder(tree.root);
    }
}
