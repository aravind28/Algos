import java.util.Arrays;

public class CombinationSum2 {
    //private static int[] result;
    public static int combinationSum(int[] nums, int target) {
        int [] result = new int[target + 1];
        Arrays.fill(result, -1);
        result[0] = 1;
        return helper(result, nums, target);
    }

    public static int helper(int[] result, int[] nums, int target){
        if(result[target] != -1){
            return result[target];
        }

        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(target - nums[i] >= 0){
                res += helper(result, nums, target - nums[i]);
            }
        }
        result[target] = res;
        return result[target];
    }

    public static void main(String[] args) {
        int[] numArr = new int[]{1, 2, 3};
        int target = 4;
        int noOfCombination = combinationSum(numArr, target);
        System.out.println(noOfCombination);
    }
}


