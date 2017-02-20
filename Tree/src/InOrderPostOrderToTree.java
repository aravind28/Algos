public class InOrderPostOrderToTree {
    public static TreeNode constructTree(int[] inOrderArray, int[] preOrderArray){
        int inOrderStart = 0;
        int preOrderStart = 0;
        int inOrderEnd = inOrderArray.length - 1;
        int preOrderEnd = preOrderArray.length - 1;
        TreeNode root = constructTree(inOrderStart, inOrderEnd, preOrderStart, preOrderEnd, inOrderArray, preOrderArray);
        return root;
    }

    public static TreeNode constructTree(int inOrderStart, int inOrderEnd, int preOrderStart, int preOrderEnd,
                                    int[] inOrderArray, int[] preOrderArray){
        if((preOrderStart > preOrderEnd) || (inOrderStart > inOrderEnd)) return null;
        int rootVal = preOrderArray[preOrderStart];
        int rootValueIndex = 0;
        TreeNode root = new TreeNode(rootVal);
        for(int i = inOrderStart; i <= inOrderEnd; i++){
            if(inOrderArray[i] == rootVal) rootValueIndex = i;
        }

        root.left = constructTree(inOrderStart, rootValueIndex - 1, preOrderStart + 1, preOrderEnd, inOrderArray, preOrderArray);
        root.right = constructTree(rootValueIndex + 1, inOrderEnd, preOrderStart + rootValueIndex - inOrderStart + 1,
                                    preOrderEnd, inOrderArray, preOrderArray);
        return root;
    }

    public static void main(String[] args){
        int[] inOrderTraversal = {1, 5, 10, 14, 15, 18};
        int[] preOrderTraversal = {10, 5, 1, 15, 14, 18};
        TreeNode root = constructTree(inOrderTraversal, preOrderTraversal);
        Traversal.inOrderTraversal(root);
    }
}
