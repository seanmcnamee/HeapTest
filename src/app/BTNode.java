package app;

/**
 * BTNode
 */
public class BTNode {
    //Class variables
    private int data;
    private BTNode leftChild, rightChild;

    //Constructors
    public BTNode(int value){
        this.data = value;
        this.leftChild = this.rightChild = null;
    }

    public BTNode(int value, BTNode leftChild, BTNode rightChild) {
        this.data = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    
    //Getters
    public BTNode getLeft() {
        return this.leftChild;
    }

    public BTNode getRight() {
        return this.rightChild;
    }

    public int getData() {
        return this.data;
    }

    //Setters
    public void setData(int value) {
        this.data = value;
    }

    public void setLeftChild(BTNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BTNode rightChild) {
        this.rightChild = rightChild;
    }
}