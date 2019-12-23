package app;

import app.BTNode;

/**
 * BST
 */
public class BST {
    private BTNode root;
    private int nodeCount;

    public BST() {
        this.root = null;
        this.nodeCount = 0;
    }

    public BST(BTNode root) {
        this.root = root;
        this.nodeCount = 1;
    }

    public BTNode getRoot() {
        return root;
    }

    public void add(BTNode newNode) {

    }

    public void addIterative(BTNode newNode) {
        int base = 2;
        int completeRows = (int)Math.floor( (Math.log(nodeCount+1)/Math.log(base)) );
        int spareCount = nodeCount-(int)Math.pow(2, completeRows)+1;
        System.out.println("NodeCount: " + nodeCount + "\n\t completeRows: " + completeRows + "\n\t spareCount: " + spareCount);
    }

    public void addRecursive(BTNode current, BTNode newNode) {

    }
    
}