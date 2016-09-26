import java.util.Arrays;

public class CombinationSum {

    public static int combinationSum4(int[] nums, int target){
        int[] result = new int[target + 1];

        result[0] = 1;
        for(int i = 0; i <= target; i++){
            for(int n : nums){
                if(n <= i){
                    result[i] += result[i - n];
                }
            }
        }
        return result[target];
    }
    public static void main(String[] args) {
        int[] numArr = new int[]{1, 2, 3};
        int target = 4;
        int noOfCombination = combinationSum4(numArr, target);
        System.out.println(noOfCombination);
    }
}
