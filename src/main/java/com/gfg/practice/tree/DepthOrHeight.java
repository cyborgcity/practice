package com.gfg.practice.tree;

/**
 * Created by Ravi on 04-04-2018.
 */
public class DepthOrHeight {

    BinaryTreeNode root;

    private int height(){
        root = BinaryTree.create();
        return height(root);
    }

    private int height(BinaryTreeNode root) {
        if(root == null)
            return 0;

        int lh = height(root.left) + 1;
        int rh = height(root.right) + 1;

        return lh > rh ? lh : rh;
    }

    public static void main(String[] args) {
        DepthOrHeight tree = new DepthOrHeight();
        System.out.println(tree.height());
    }
}
