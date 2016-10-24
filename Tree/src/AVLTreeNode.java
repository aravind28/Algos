
public class AVLTreeNode {
    char val;
    int heightOfNode;
    AVLTreeNode parent, leftChild, rightChild;

    AVLTreeNode(char val, int height, AVLTreeNode parentNode){
        this.val = val;
        heightOfNode = height;
        parent = parentNode;
        leftChild = null;
        rightChild = null;
    }
    AVLTreeNode(){}
}
