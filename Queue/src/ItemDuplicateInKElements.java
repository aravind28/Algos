import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ItemDuplicateInKElements {
    public static boolean findIfElementRepeatsInK(int[] nums, int k){
        Queue slidingWindow = new LinkedList();
        for(int i = 0; i < nums.length; i++){
            if(i > k){
                slidingWindow.remove();
            }
            if(slidingWindow.contains(nums[i])){
                return true;
            }
            else{
                slidingWindow.add(nums[i]);
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 1, 2, 3};
        int windowSize = 2;
        boolean ans = findIfElementRepeatsInK(arr, windowSize);
        System.out.println("Ans: " + ans);
    }
}
