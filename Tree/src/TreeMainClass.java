import java.util.HashMap;
import java.util.Iterator;

public class TreeMainClass {
    public static void main(String[] args){
        //int[] sortedArray = new int[]{12, 23, 25, 37, 39, 41, 42, 55, 56, 59, 62, 64, 66, 67, 71};
        // int[] sortedArray = new int[]{1, 2, 3, 4, 5};
        int[] sortedArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        CreateTree createBinaryTree = new CreateTree();
        TreeNode root = createBinaryTree.constructTreeFromSortedArray(sortedArray);
        /*
        Traversals
         */
//        System.out.println("Root element of tree is " + root.value);
//        Traversal traversal = new Traversal();
//        System.out.println("Inorder Traversal");
//        traversal.inOrderTraversal(root);
//        System.out.println("PreOrder Traversal");
//        traversal.preOrderTraversal(root);
//        System.out.println("PostOrder Traversal");
//        traversal.preOrderTraversal(root);

        /*
        Vertical sum in a tree
         */
        VerticalSum verticalSum = new VerticalSum();
        HashMap<Integer, Integer> hm = verticalSum.calculateVerticalSum(root);
        Iterator<Integer> itr = hm.keySet().iterator();
//        while(itr.hasNext()){
//            System.out.println("Sum at level " + itr.next() + " is " + hm.get(itr.next()));
//        }

        for(int value : hm.keySet()){
            System.out.println("Sum at level " + value + " is " + hm.get(value));
        }
    }
}
