public class AVLTree {
    private AVLTreeNode rootNode;

    public int getHeight(AVLTreeNode node) {
        if (node == null) {
            return -1;
        }
        return node.heightOfNode;
    }

    // leaf node is set to height = 0
    public int setHeight(AVLTreeNode node) {
        return 1 + Math.max(getHeight(node.leftChild), getHeight(node.rightChild));
    }

    public AVLTreeNode leftRotate(AVLTreeNode nodeToRotate) {
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
        return tempNode;
    }

    public AVLTreeNode rightRotate(AVLTreeNode nodeToRotate) {
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
        return tempNode;
    }

    public AVLTreeNode balance(AVLTreeNode nodeToBalance, char newElement) {
        nodeToBalance.heightOfNode = setHeight(nodeToBalance);
        int heightOfLeftSubTree = getHeight(nodeToBalance.leftChild);
        int heightOfRightSubTree = getHeight(nodeToBalance.rightChild);
        int balance = heightOfLeftSubTree - heightOfRightSubTree;

        // if:  -1 <= balance <= 1     => sub tree rooted at nodeToBalance is already balanced
        // else if:   balance is > 1   => imbalance is in the left sub tree
        // else if:   balance is < -1  => imbalance is in the right sub tree

        AVLTreeNode tempNode;
        if (balance > 1) {
            if (newElement > nodeToBalance.leftChild.val) {
                // There is left right imbalance in the sub tree rooted at nodeToBalance
                // First step : perform left rotation on the left child of the nodeToBalance
                // Second step : perform right rotation on the nodeToBalance
                tempNode = leftRotate(nodeToBalance.leftChild);
                nodeToBalance = tempNode.parent;
            }
            return rightRotate(nodeToBalance);
        } else if (balance < -1) {
            if (newElement < nodeToBalance.rightChild.val) {
                // There is right left imbalance in the sub tree rooted at nodeToBalance
                // First step : perform right rotation on the right child of the nodeToBalance
                // Second step : perform left rotation on the nodeToBalance
                tempNode = rightRotate(nodeToBalance.rightChild);
                nodeToBalance =  tempNode.parent;
            }
            return leftRotate(nodeToBalance);
        }
        return nodeToBalance;
    }

    public AVLTreeNode insert(AVLTreeNode node, char elementToInsert) {
        if (rootNode == null) {
            rootNode = new AVLTreeNode(elementToInsert, 0, null);
            return rootNode;
        }

        AVLTreeNode x = node;
        AVLTreeNode y = x;
        while (x != null) {
            y = x;
            if (elementToInsert < x.val) {
                x = x.leftChild;
            } else {
                x = x.rightChild;
            }
        }
        AVLTreeNode newNode = new AVLTreeNode(elementToInsert, 0, y);

        if (elementToInsert < y.val) {
            y.leftChild = newNode;
        } else {
            y.rightChild = newNode;
        }
        if (y.parent == null) { // Implies the new node is inserted as a child of root node
            y.heightOfNode = 1;
            return y;
        }
        y.heightOfNode = setHeight(y); // 'y' node will always be balanced, so there is no need to balance y
        y = y.parent;
        while (y != null) {
            y = balance(y, elementToInsert);
            y = y.parent;
        }
        return rootNode;
    }

    public void inOrderTraversal(AVLTreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.leftChild);
        System.out.print(" " + root.val);
//        System.out.println("Node val: " + root.val + ",  Node height: " + root.heightOfNode);
        inOrderTraversal(root.rightChild);
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode();
        String ip = "abcdefghijklmnopqrstuvwxyz";
//        String ip = "Algorithms";
        for (int i = 0; i <= ip.length()- 1; i++) {
            root = avlTree.insert(root, ip.charAt(i));
            PrintNode.printEveryIteration(root);
        }
        System.out.print("In Order Traversal of AVL Tree :");
        avlTree.inOrderTraversal(avlTree.rootNode);
        System.out.println();
    }
}
