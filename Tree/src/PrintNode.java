import java.util.LinkedList;
import java.util.Queue;

public class PrintNode {
    AVLTreeNode node;
    int position;
    int level;

    PrintNode(AVLTreeNode node, int position, int level){
        this.node = node;
        this.position = position;
        this.level = level;
    }

    public static void printAVLTree(AVLTreeNode node) {
        Queue<PrintNode> q = new LinkedList<PrintNode>();
        int rootPosition = (int) Math.pow(2, node.heightOfNode);
        int totalSpaces = (int) Math.pow(2, node.heightOfNode + 1);
        int levelOfChildren = node.heightOfNode - 1;
        q.add(new PrintNode(node, rootPosition, levelOfChildren));
        int noOfElementsInLevel;
        while (q.size() > 0) {
            noOfElementsInLevel = q.size();
            for (int j = 1; j <= totalSpaces; j++) {
                if (noOfElementsInLevel <= 0) {
                    break;
                }
                int pos = q.peek().position;
                if (pos == j) {
                    PrintNode nodeToPrint = q.poll();
                    noOfElementsInLevel--;
                    System.out.print(nodeToPrint.node.val);
                    // If the node has children, append them into the queue along with the position at which,
                    // they should be inserted
                    // The children should be present at a distance equidistant from the parent node so,
                    // keeping the position of node as the reference, the position of its children position are computed
                    if (nodeToPrint.node.leftChild != null) {
                        AVLTreeNode leftChild = nodeToPrint.node.leftChild;
                        int positionOfLeftChild = pos - (int)Math.pow(2, nodeToPrint.level);
                        int heightLevelOfChildren = nodeToPrint.level - 1;
                        q.add(new PrintNode(leftChild, positionOfLeftChild, heightLevelOfChildren));
                    }
                    if (nodeToPrint.node.rightChild != null) {
                        AVLTreeNode rightChild = nodeToPrint.node.rightChild;
                        int positionOfRightChild = pos + (int) Math.pow(2, nodeToPrint.level);
                        int heightLevelOfChildren = nodeToPrint.level - 1;
                        q.add(new PrintNode(rightChild, positionOfRightChild, heightLevelOfChildren));
                    }
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }
}
