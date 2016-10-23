import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    static AVLTreeNode rootNode = null;

    public int getHeight(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.heightOfNode;
    }

    // leaf node is set to height = 1
    public int setHeight(AVLTreeNode node) {
        int heightOfLeftNode = getHeight(node.leftChild);
        int heightOfRightNode = getHeight(node.rightChild);

        return 1 + Math.max(heightOfLeftNode, heightOfRightNode);
    }

    public void leftRotate(AVLTreeNode nodeToRotate) {
        AVLTreeNode tempNode = nodeToRotate.rightChild;
        nodeToRotate.rightChild = tempNode.leftChild;
        tempNode.parent = nodeToRotate.parent;
        if (tempNode.leftChild != null) {
            tempNode.leftChild.parent = nodeToRotate;
        }
        // Make the parent node of the nodeToRotate to point to tempNode
        if (nodeToRotate.parent == null) {
            rootNode = tempNode;
        } else if (nodeToRotate == nodeToRotate.parent.leftChild) {
            nodeToRotate.parent.leftChild = tempNode;
        } else {
            nodeToRotate.parent.rightChild = tempNode;
        }
        nodeToRotate.parent = tempNode;
        tempNode.leftChild = nodeToRotate;
        nodeToRotate.heightOfNode = setHeight(nodeToRotate);
        tempNode.heightOfNode = setHeight(tempNode);
    }

    public void rightRotate(AVLTreeNode nodeToRotate) {
        AVLTreeNode tempNode = nodeToRotate.leftChild;
        nodeToRotate.leftChild = tempNode.rightChild;
        tempNode.parent = nodeToRotate.parent;
        if (tempNode.rightChild != null) {
            tempNode.rightChild.parent = nodeToRotate;
        }
        // Make the parent node nodeToRotate to point to tempNode
        if (nodeToRotate.parent == null) {
            rootNode = tempNode;
        } else if (nodeToRotate == nodeToRotate.parent.leftChild) {
            nodeToRotate.parent.leftChild = tempNode;
        } else {
            nodeToRotate.parent.rightChild = tempNode;
        }


        nodeToRotate.parent = tempNode;
        tempNode.rightChild = nodeToRotate;
        // set the heights of nodeToRotate and tempNode
        nodeToRotate.heightOfNode = setHeight(nodeToRotate);
        tempNode.heightOfNode = setHeight(tempNode);
    }

    public void balance(AVLTreeNode nodeToBalance, int newElement) {
        nodeToBalance.heightOfNode = setHeight(nodeToBalance);
        int heightOfLeftSubTree = getHeight(nodeToBalance.leftChild);
        int heightOfRightSubTree = getHeight(nodeToBalance.rightChild);
        int balance = heightOfLeftSubTree - heightOfRightSubTree;
        // if:  -1 <= balance <= 1     => sub tree rooted at nodeToBalance is already balanced
        // else if:   balance is > 1   => imbalance is in the left sub tree
        // else if:   balance is < -1  => imbalance is in the right sub tree

        if (balance > 1) {
            if (newElement > nodeToBalance.leftChild.val) {
                // There is left right imbalance in the sub tree rooted at nodeToBalance
                // First step : perform left rotation on the left child of the nodeToBalance
                // Second step : perform right rotation on the nodeToBalance
                leftRotate(nodeToBalance.leftChild);
            }
            rightRotate(nodeToBalance);
        } else if (balance < -1) {
            if (newElement < nodeToBalance.rightChild.val) {
                // There is right left imbalance in the sub tree rooted at nodeToBalance
                // First step : perform right rotation on the right child of the nodeToBalance
                // Second step : perform left rotation on the nodeToBalance
                rightRotate(nodeToBalance.rightChild);
            }
            leftRotate(nodeToBalance);
        }
    }

    public void insert(AVLTreeNode root, int elementToInsert) {
        if (rootNode == null) {
            rootNode = new AVLTreeNode(elementToInsert, 1, null);
            return;
        }

        AVLTreeNode x = root;
        AVLTreeNode y = x;
        while (x != null) {
            y = x;
            if (elementToInsert < x.val) {
                x = x.leftChild;
            } else {
                x = x.rightChild;
            }
        }
        AVLTreeNode newNode = new AVLTreeNode(elementToInsert, 1, y);

        if (elementToInsert < y.val) {
            y.leftChild = newNode;
        } else {
            y.rightChild = newNode;
        }
        if (y.parent == null) { // Implies the new node is inserted as a child of root node
            y.heightOfNode = 2;
            return;
        }
        y.heightOfNode = setHeight(y); // y node will always be balanced, so there is no need to balance y
        y = y.parent;
        while (y != null) {
            balance(y, elementToInsert);
            y = y.parent;
        }
    }

    public void inOrderTraversal(AVLTreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.leftChild);
        System.out.println("Node val: " + root.val + ",  Node height: " + root.heightOfNode);
        inOrderTraversal(root.rightChild);
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        int[] arr = {10, 5, 3, 1, 2, 7, 6, 8, 15, 13, 12, 11, 18, 16, 19, 20, 22};
//        int[] arr = {1, 2, 3, 6, 4, -2, -8, -5};
//        int[] arr = {1, 2, 3, 4, 3, 1, 3, 2, 2};
        for (int i = 0; i < arr.length; i++) {
            avlTree.insert(rootNode, arr[i]);
        }
        System.out.println("Root node is: " + rootNode.val);
//        avlTree.inOrderTraversal(rootNode);
        int noOfSpaces = (int) Math.pow(2, rootNode.heightOfNode + 1);
        for (int i = 1; i < noOfSpaces; i++) {
            System.out.print("-");
        }
        System.out.println();
        PrintNode.printAVLTree(rootNode);
        for (int i = 1; i < noOfSpaces; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
