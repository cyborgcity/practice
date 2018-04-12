package com.gfg.practice.tree;

/**
 * Created by Ravi on 23-03-2018.
 */
public class BoundaryPrint {

    public void printLeaves(BinaryTreeNode node){
        if(node != null){
            printLeaves(node.left);
            if (node.left == null && node.right == null)
            System.out.print(node.data + " ");
            printLeaves(node.right);

        }
    }
    public void printBoundaryLeft(BinaryTreeNode node){
        if(node != null){
            if(node.left != null){
                System.out.print(node.data + " ");
                printBoundaryLeft(node.left);
            }
            else if(node.right != null){
                System.out.print(node.data + " ");
                printBoundaryLeft(node.right);
            }
        }
    }
    public void printBoundaryRight(BinaryTreeNode node){
        if(node != null){
            if(node.right != null){
                printBoundaryRight(node.right);
                System.out.print(node.data + " ");
            }
            else if(node.left != null){
                printBoundaryRight(node.left);
                System.out.print(node.data + " ");
            }
        }
    }

    public void printBoundary(BinaryTreeNode node){
        if(node != null){
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
            printLeaves(node.left);
            printLeaves(node.right);
            printBoundaryRight(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTree.create();
        BoundaryPrint tree = new BoundaryPrint();
        tree.printBoundary(root);


    }

}
