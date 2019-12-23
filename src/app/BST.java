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
        System.out.println("Adding node: " + newNode.getData());
        BTNode current = root;

        //For root node insert
        if (root == null) {
            this.root = newNode;

        //For all other cases
        }   else {
            int base = 2;
            int completeRows = (int)Math.floor( (Math.log(nodeCount+1)/Math.log(base)) );
            int spareCount = nodeCount-(int)Math.pow(2, completeRows)+1;
            boolean followRight = false;
            System.out.println("\tNodeCount: " + nodeCount + "\n\t completeRows: " + completeRows + "\n\t spareCount: " + spareCount);

            
            for (int i = 0; i < completeRows; i++) {
                System.out.println("\tIteration " + i);
                int spareInPath = spareCount % ( (int)Math.pow(base, completeRows-i) );
                int leftPathFullAmount = (int)Math.pow(base, completeRows-i-1);
                followRight = (spareInPath >= leftPathFullAmount);
                
                System.out.println("\t\tSpare in path: " + spareInPath + "\n\t\tleftPathFullAmount: " + leftPathFullAmount);
                System.out.println("\t\tFollowing right: " + followRight);
                //Follow until the last iteration
                if (!(i==completeRows-1)) {
                    if (followRight) {
                        current = current.getRight();
                    }   else {
                        current = current.getLeft();
                    }
                }
            }

            //For the final iteration, make this new node the child node
            System.out.println("Out of loop. Setting child right child to new: " + followRight);
            if (followRight) {
                current.setRightChild(newNode);;
            }   else {
                current.setLeftChild(newNode);
            }
        }
        
        //Increase node count
        this.nodeCount++;

        System.out.println("Root: " + this.root.getData());
        inOrder(root);
        bubblePush(newNode);
        System.out.println("\nRoot: " + this.root.getData());
        inOrder(root);
        System.out.println();
    }

    private void bubblePush(BTNode node) {
        System.out.println("Bubble pushing " + node.getData());
        BTNode parent = node.getParent();
        if (parent != null && node.getPriority() > parent.getPriority()) {
            switchParentAndChild(node);
            bubblePush(node);
            if (parent==this.root) {
               this.root = node;
            }
        }
    }

    /**
     * Switches a parent and child node
     * May switch the tree around but it doesn't matter.
     * @param node
     */
    private void switchParentAndChild(BTNode node) {
        System.out.println("Pushing up " + node.getData());
        BTNode parent = node.getParent();
        BTNode parentParent = parent.getParent();
        BTNode parentLeft = parent.getLeft();
        BTNode parentRight = parent.getRight();
        
        int PPtoP = findRelation(parentParent, parent);
        int PtoNode = findRelation(parent, node);

        System.out.println("Node: " + node + "-" + node.getData());
        System.out.println("Parent: " + parent + "-" + parent.getData());
        System.out.println("\tL: " + parentLeft + "\n\tR: " + parentRight);
        System.out.println("\tPPtoP: " + PPtoP + "\n\tPtoNode: " + PtoNode);

        //Link to L and R
        parent.setLeftChild(node.getLeft());
        parent.setRightChild(node.getRight());

        //Link to P and temp
        if (PtoNode==1) {
            node.setRightChild(parent);
            node.setLeftChild(parentLeft);
        } 
        if (PtoNode==-1) {
            node.setLeftChild(parent);
            node.setRightChild(parentRight);
        }
        if (PtoNode==0) {
            System.out.println("Some error with parent to node relation");
        }

        //Link PP to C
        if (PPtoP==1) {
            parentParent.setRightChild(node);
        } 
        if (PPtoP==-1) {
            parentParent.setLeftChild(node);
        }
        if (PPtoP==2) {
            this.root = node;
            node.resetParent();
        }
        if (PPtoP==3) {
            System.out.println("Wtf...");
        }
        if (PPtoP==0) {
            System.out.println("Some error with parentParent to parent relation");
        }

        /*
        parent.setLeftChild(node.getLeft());
        parent.setRightChild(node.getRight());

        int parentRel = checkParentRelation(node);
        
        System.out.println("CurrentNode: " + node.getData());
        System.out.println("ParentNode: " + parent.getData());
        //System.out.println("\tParentL: " + parentNode.getData());


        BTNode parentParent = parent.getParent();
        if (parentParent==null) {
            System.out.println("Node became root!");
            root = node;
        }   else {
            System.out.println("PP: " + parentParent.getData());
            if (parentParent.getRight()==parent) {
                parentParent.setRightChild(node);
            }   else if (parentParent.getLeft()==parent) {
                parentParent.setLeftChild(node);
            }   else {
                System.out.println("ERROR!!!!!!");
            }
        }
        

        //This is the parent's right child
        if (parentRel==1) {
            System.out.println("Is parent's right");
            node.setLeftChild(parentLeft);
            node.setRightChild(parent);
        }   else {
        //This is the parent's left child
            System.out.println("Is parent's left");
            node.setRightChild(parentRight);
            node.setLeftChild(parent);
        }
        */
    }


    public int findRelation(BTNode parent, BTNode child) {
        if (parent==null) {
            return 2;
        }
        if (child==null) {
            return 3;
        }
        if (parent.getRight()==child) {
            return 1;
        }
        if (parent.getLeft()==child) {
            return -1;
        }
        return 0;
    }
    /**
     * L: -1
     * N/A: 0
     * R: 1
     */
    private int checkParentRelation(BTNode node) {
        BTNode parent = node.getParent();
        if (parent==null) {
            return 0;
        }
        if (parent.getRight()==node) {
            return 1;
        }   else {
            return -1;
        } 
    }

    public void addRecursive(BTNode current, BTNode newNode) {

    }
    
    public void preOrder(BTNode node) {
        if (node != null) {
            System.out.print(node.getData()+" ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void inOrder(BTNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getData()+" ");
            inOrder(node.getRight());
        }
    }

    public void postOrder(BTNode node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData()+" ");
        }
    }


}