package app;


import app.BST;

public class Runner {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello Java");
        int num = (int)5.92;
        BTNode node = new BTNode(num);
        BST heap = new BST(node);
        heap.addIterative(node);
        
    }
}