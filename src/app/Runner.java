package app;


import app.BST;

public class Runner {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello Java");
        BST heap = new BST();

        for (int i = 0; i <= 10; i++) {
            heap.addIterative(new BTNode(i));
        }

        System.out.println("Root: " + heap.getRoot().getData());
        
        heap.preOrder(heap.getRoot());
        System.out.println();
        heap.inOrder(heap.getRoot());
        System.out.println();
        heap.postOrder(heap.getRoot());
    }
}