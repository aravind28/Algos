
public class AVLTreeNode {
    int val;
    int heightOfNode;
    AVLTreeNode parent, leftChild, rightChild;

    AVLTreeNode(int val, int height, AVLTreeNode parentNode){
        this.val = val;
        heightOfNode = height;
        parent = parentNode;
        leftChild = null;
        rightChild = null;
    }
}
