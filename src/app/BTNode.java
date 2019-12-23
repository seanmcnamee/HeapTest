package app;

/**
 * BTNode
 */
public class BTNode {
    //Class variables
    private int data;
    private BTNode parent, leftChild, rightChild;

    //Constructors
    public BTNode(int value){
        this.data = value;
        this.parent = null;
        this.leftChild = this.rightChild = null;
    }

    public BTNode(int value, BTNode leftChild, BTNode rightChild) {
        this.data = value;
        this.parent = null;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    //Priority Number
    public int getPriority() {
        return this.data;
    }
    
    //Getters
    public BTNode getLeft() {
        return this.leftChild;
    }

    public BTNode getRight() {
        return this.rightChild;
    }

    public BTNode getParent() {
        return this.parent;
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
        if (this.leftChild!= null) {
            this.leftChild.parent = this;
        }
    }

    public void setRightChild(BTNode rightChild) {
        this.rightChild = rightChild;
        if (this.rightChild!= null) {
            this.rightChild.parent = this;
        }
    }

    public void resetParent() {
        parent=null;
    }
    /*
    public boolean setParent(BTNode parent, BTNode oldPoint) {
        if (parent!=null) {
            if (parent.getLeft()==oldPoint) {
                parent.setLeftChild(this);
            }   else if (parent.getRight()==oldPoint) {
                parent.setRightChild(this);
            }   else {
                System.out.println("ERROR!!! GAVE AN INVALID EXISTING CHILD!");
                this.parent = parent;
            }
            return false;
        }   else {
            System.out.println("ERROR!!!!! PARENTS CAN't BE NULL Unless root?");
            this.parent = parent;
            return true;
        }
    }
    */
}