package com.gfg.practice.tree;

/**
 * Created by Ravi on 04-04-2018.
 */
public class PrintVertical {

    static class Value{
        int min;
        int max;
    }

    BinaryTreeNode root;

    void findMinMax(BinaryTreeNode node, Value min, Value max, int hd){
        if(node == null)
            return;
        if(hd < min.min)
            min.min = hd;
        if(hd > max.max)
            max.max = hd;
        findMinMax(node.left, min, max, hd-1);
        findMinMax(node.right, min, max, hd+1);

    }

    void printVerticalOrder(BinaryTreeNode node, int line, int hd){
        if(node == null)
            return;
        if(line == hd)
            System.out.print(node.data);
        printVerticalOrder(node.left, line, hd-1);
        printVerticalOrder(node.right, line, hd+1);

    }

    public static void main(String[] args) {
        PrintVertical tree = new PrintVertical();
        Value val = new Value();
        tree.root = BinaryTree.create();
        tree.findMinMax(tree.root, val, val, 0 );
        System.out.println(val.min + " " + val.max);
        for (int i = val.min; i <= val.max; i++){
            tree.printVerticalOrder(tree.root, i, 0);
            System.out.println();
        }

    }
}
