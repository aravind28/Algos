
public class CreateTree {

    CreateTree(){

    }

    public TreeNode constructTreeFromSortedArray(int[] arr){
        TreeNode rootNode = constructTreeFromSortedArray(arr, 0, arr.length - 1);
        return rootNode;
    }

    public TreeNode constructTreeFromSortedArray(int[] arr, int startIndex, int endIndex){
        if(endIndex < startIndex){
            return null;
        }
        int midIndex = (startIndex + endIndex) / 2;
        TreeNode node = new TreeNode(arr[midIndex]);

        node.left = constructTreeFromSortedArray(arr, startIndex, midIndex - 1);
        node.right = constructTreeFromSortedArray(arr, midIndex + 1, endIndex);
        return node;
    }
}
