package app;


import app.BST;

public class Runner {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello Java");
        BST heap = new BST();
        Simple s4 = new Simple(0, 4);

        for (int i = 0; i <= 10; i++) {
            int rndNum = (int)(Math.random()*100);
            if (i==4) {
                heap.add(s4);
            }   else {
                heap.add(new Simple(0, i));
            }
        }

        //System.out.println("Root: " + heap.getRoot().getPriority());
        
        //heap.preOrder(heap.getRoot());
        //System.out.println();
        //heap.inOrder(heap.getRoot());
        //System.out.println();
        //heap.postOrder(heap.getRoot());
        
        
        System.out.println("DeQueue.....\n\n");
        BST tempHeap = new BST();
        while (heap.getRoot()!=null) {
            Simple temp = (Simple)heap.deQueue();
            temp.render();
            tempHeap.add(temp.resetConnections());
        }

        tempHeap.updatePriority(s4.setPriority(22));

        
        while (tempHeap.getRoot()!=null) {
            Simple temp = (Simple)tempHeap.deQueue();
            temp.render();
        }

    }
}