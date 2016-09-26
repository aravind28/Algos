import java.util.HashMap;

public class VerticalSum {
    public HashMap<Integer, Integer> calculateVerticalSum(TreeNode root){
        if(root == null){
            return null;
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm = calculateVerticalSum(root, 0, hm);
        return hm;
    }

    public HashMap<Integer, Integer> calculateVerticalSum(TreeNode node, int horizontalDistance,
                                                          HashMap<Integer, Integer> hm){
        if(node == null){
            return null;
        }
        calculateVerticalSum(node.left, horizontalDistance - 1, hm);

        int sumAtLevel = node.value;
        if(hm.get(horizontalDistance) != null){
            sumAtLevel += hm.get(horizontalDistance);
        }
        hm.put(horizontalDistance, sumAtLevel);

        calculateVerticalSum(node.right, horizontalDistance + 1, hm);
        return hm;
    }
}
