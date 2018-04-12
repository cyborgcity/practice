package com.gfg.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ravi on 22-03-2018.
 */
public class BinaryTree {

    private BinaryTreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(int data){
        root = insert(root, data);
    }

    public BinaryTreeNode insert(BinaryTreeNode root, int data) {
        if(root == null){
            root = new BinaryTreeNode(data);
        }else {
            if(root.left == null){
                root.left = insert(root.left, data);
            }else {
                root.right = insert(root.right, data);
            }
        }
        return root;
    }
    public int height(){
        return height(root);
    }


    public int height(BinaryTreeNode root){
        if(root == null){
            return 0;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        if(lHeight < rHeight)
            return rHeight + 1;
        else
            return lHeight + 1;

    }
    public void inorder(){
        inorder(root);
        System.out.println();
    }
    public void preorder(){
        preorder(root);
        System.out.println();
    }
    public void postorder(){
        postorder(root);
        System.out.println();
    }
    public void preorder(BinaryTreeNode root){
        if(root == null)
            return;
        System.out.print(root.data + " ");
        inorder(root.left);
        inorder(root.right);
    }
    public void inorder(BinaryTreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public void postorder(BinaryTreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data + " ");
    }
    public int countNodes(){
        return countNodes(root);
    }

    private int countNodes(BinaryTreeNode root) {
        if(root == null)
            return 0;
        else
            return 1 +
                    countNodes(root.left) +
                    countNodes(root.right);
    }

    public void levelorder(){
        levelorder(root);

    }

    private void levelorder(BinaryTreeNode root) {
        if(root == null)
            return;
        else{
            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                BinaryTreeNode node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
    }

    public void levelorderWithoutQ(){
        levelorderWithoutQ(root);
    }

    private void levelorderWithoutQ(BinaryTreeNode root) {
        if(root == null)
            return;
        else {
            int height = height(root);
            for (int i = 1; i <= height; i++){
                levelorderWithoutQ(root, i);
            }
        }
    }

    private void levelorderWithoutQ(BinaryTreeNode root, int i) {
        if(root == null)
            return;
        if(i == 1) {
            System.out.print(root.data + " ");
        }
        else{
            levelorderWithoutQ(root.left, i-1);
            levelorderWithoutQ(root.right, i-1);
        }
    }

    public void levelorderLineByLine(){
        levelorderLineByLine(root);
    }

    private void levelorderLineByLine(BinaryTreeNode root) {
        if(root == null)
            return;
        Queue<BinaryTreeNode> q1 = new LinkedList<>();
        Queue<BinaryTreeNode> q2 = new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty() || !q2.isEmpty()){
            while(!q1.isEmpty()){
                if(q1.peek().left != null){
                    q2.add(q1.peek().left);
                }
                if(q1.peek().right != null){
                    q2.add(q1.peek().right);
                }
                System.out.print(q1.poll().data + " ");
            }
            System.out.println();
            while(!q2.isEmpty()){
                if(q2.peek().left != null){
                    q1.add(q2.peek().left);
                }
                if(q2.peek().right != null){
                    q1.add(q2.peek().right);
                }
                System.out.print(q2.poll().data + " ");
            }
            System.out.println();
        }
    }

    public void levelorderLineByZigZag(){
        levelorderLineByZigZag(root);
    }

    private void levelorderLineByZigZag(BinaryTreeNode root) {
        if(root == null){
            return;
        }
        Queue<BinaryTreeNode> q1 = new LinkedList<>();
        Queue<BinaryTreeNode> q2 = new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty() || !q2.isEmpty()){
            while(!q1.isEmpty()){
                if(q1.peek().right != null){
                    q2.add(q1.peek().right);
                }
                if(q1.peek().left != null){
                    q2.add(q1.peek().left);
                }
                System.out.print(q1.poll().data + " ");
            }
            System.out.println();
            while(!q2.isEmpty()){
                if(q2.peek().left != null){
                    q1.add(q2.peek().left);
                }
                if(q2.peek().right != null){
                    q1.add(q2.peek().right);
                }
                System.out.print(q2.poll().data + " ");
            }
            System.out.println();
        }
    }
    public void findMax(){
        Integer max = Integer.MIN_VALUE;
//        findMax(root, max);
        System.out.println(findMax(root, max));
    }

    private int findMax(BinaryTreeNode root, Integer max) {
        if(root == null)
            return Integer.MIN_VALUE;
        if(root.data > max) {
            max = root.data;
        }
        int left = findMax(root.left, max);
        int right = findMax(root.right, max);
        if(left > max)
            max =left;
        if(right > max)
            max = right;
        return max;
    }

    public static BinaryTreeNode create(){
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode(1);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.right = new BinaryTreeNode(3);
        tree.root.left.left = new BinaryTreeNode(4);
        tree.root.left.right = new BinaryTreeNode(5);
        tree.root.right.left = new BinaryTreeNode(6);
        tree.root.right.right = new BinaryTreeNode(7);
        return tree.root;
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode(1);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.right = new BinaryTreeNode(3);
        tree.root.left.left = new BinaryTreeNode(4);
        tree.root.left.right = new BinaryTreeNode(5);
        tree.root.right.left = new BinaryTreeNode(6);
        tree.root.right.right = new BinaryTreeNode(7);
        tree.inorder();
        tree.preorder();
        tree.postorder();
        System.out.println(tree.height());
        System.out.println(tree.countNodes());
        tree.levelorder();
        System.out.println();
        tree.levelorderWithoutQ();
        System.out.println();
        tree.levelorderLineByLine();
        System.out.println();
        tree.levelorderLineByZigZag();
        System.out.println();
        tree.findMax();
    }

}
