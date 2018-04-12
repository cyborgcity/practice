package com.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravi on 19-07-2017.
 */
public class BST {
    static int counter = 0;
    static class Node {
        int val;
        Node left;
        Node right;

        public Node( int val ) {
            this.val = val;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }

    static class Tree {
        Node root;

//        public void add( int val ) {
//            if( root == null ) {
//                root = new Node(val);
//            } else {
//                root = add( root, val);
//            }
//        }
//
//        private Node add( Node node, int val ) {
//            if( node != null ) {
//                if( node.val > val ) {
//                    node.left = add( node.left, val );
//                } else {
//                    node.right = add( node.right, val);
//                }
//            } else {
//                node = new Node( val );
//            }
//            return node;
//        }

        public void preorder() {
            preorder(root);
        }

        public void preorder( Node node ) {
            if(node != null) {
//                System.out.print(node.val + " ");
                preorder( node.left );
                preorder( node.right );
            }
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
//        Tree tree = new Tree();
        System.out.println("Array to Tree:");
        int[] a = new int[]{60,40,30,28,35,42,70,65,62,68,72};
        Tree tree = createTree( a );
        tree.preorder();
    }


    public static Tree createTree( int[] a ) {
        List<Integer> list = new ArrayList<>();
        List<Node> nodes = new ArrayList<Node>();
        Tree tree = new Tree();
        int n = a.length;
        int x = a[0];
        tree.root = new Node(x);
        Node node = tree.root;
        int i = 0;
        do {
            System.out.println(i);
            i++;
            if( i == a.length) {
                break;
            }
            if(a[i] < node.val && a[i] != -1) {
                node.left = new Node(a[i]);
                a[i] = -1;
                list.add(i);
                nodes.add(node.left);
                i++;
                counter++;
            }
            while( node.val > a[i] && a[i] != -1) {
                i++;
            }
            if(i < n && a[i] != -1) {
                node.right = new Node(a[i]);
                a[i] = -1;
                list.add(i);
                nodes.add(node.right);
                counter++;
            }
            if(list.isEmpty()) {
                break;
            }
            i = list.remove(0);
            node = nodes.remove(0);
        }while(node != null);
        return tree;
    }

}




