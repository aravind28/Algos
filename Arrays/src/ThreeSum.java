import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public static ArrayList<ArrayList<Integer>> findThreeSum(int[] nums, int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(nums);
        int j, k;
        for(int i = 0; i < nums.length - 2; i ++){
            j = i + 1;
            k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j ++;
                    k --;
                }
                else if(sum > target) k --;
                else j ++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums = new int[]{3, 5, 6, 4, 1, -1, 2, -4, 9};
        int target = 5;
        ArrayList<ArrayList<Integer>> result = findThreeSum(nums, target);
        System.out.println("All the 3 sums in the array that sum up to" + " " + target + " are:");
        for(ArrayList<Integer> lst : result){
            System.out.println(" " + lst.get(0) + " " + lst.get(1) + " " + lst.get(2));
        }
    }
}
