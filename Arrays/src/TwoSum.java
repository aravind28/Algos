import java.util.ArrayList;
import java.util.Arrays;

public class TwoSum {

    public static ArrayList<ArrayList<Integer>> findTwoSum(int[] nums, int target) {
        // result stores the combination of all lists totalling to a particular sum
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == target) {
                result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j])));
                i ++;
                j --;
            }
            else if(sum > target) i ++;
            else j --;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1, 5, 0, 6};
        int target = 6;
        ArrayList<ArrayList<Integer>> result = findTwoSum(arr, target);
        System.out.println("All the 2 sums in the array that sum up to" + " " + target + " are:");
        for (ArrayList num : result){
            System.out.println(" " + num.get(0) + " " + num.get(1));
        }
    }
}
