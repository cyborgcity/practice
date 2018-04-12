package com.gfg.practice.tree;

/**
 * Created by Ravi on 25-03-2018.
 */
public class FindLCA {
    private BinaryTreeNode root;
    private boolean v1, v2;

    public BinaryTreeNode findLCA(int n1, int n2){
        root = BinaryTree.create();
        return findLCA(root, n1, n2);
    }

    private BinaryTreeNode findLCA(BinaryTreeNode node, int n1, int n2) {
        if(node == null)
            return null;
        if(node.data == n1 ){
            v1 = true;
            return node;
        }
        if(node.data == n2){
            v2 = true;
            return node;
        }

        BinaryTreeNode left_lca = findLCA(node.left, n1, n2);
        BinaryTreeNode right_lca = findLCA(node.right, n1, n2);

        if(left_lca != null && right_lca != null)
            return node;

        return left_lca == null ? right_lca : left_lca;
    }
    public BinaryTreeNode checkAndFindLCA(int n1, int n2){
        v1 = v2 = false;
        BinaryTreeNode node = findLCA(n1, n2);
        if(v1 && v2)
            return node;
        return null;
    }

    public static void main(String[] args) {
        FindLCA findLCA = new FindLCA();
        BinaryTreeNode node = findLCA.checkAndFindLCA(5,7);
        System.out.println(node == null ? null : node.data);
    }
}
