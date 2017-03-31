import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class FourSum {

    // create a hash map of all possible pairs of sums
    public static HashMap<Integer, int[]> createHashMapOfAllSumPairs(int[] nums){
        HashMap<Integer, int[]> hashMapOfAllSumPairs = new HashMap<>();
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length; j++){
                int pairSum = nums[i] + nums[j];
                if(!hashMapOfAllSumPairs.containsKey(pairSum)) {
                    hashMapOfAllSumPairs.put(pairSum, new int[]{i, j});
                }
            }
        }
        return hashMapOfAllSumPairs;
    }

    // find if values in 2 distinct sum pairs that sum up to a target value
    public static ArrayList<Integer> findTwoPairSum(HashMap<Integer, int[]> sumPairs, int target){
        ArrayList<Integer> result = new ArrayList<>();
        for(int sum : sumPairs.keySet()){
            if(sumPairs.containsKey(target - sum)){
                int[] indicesOfPairA = sumPairs.get(sum);
                int[] indicesOfPairB = sumPairs.get(target - sum);
                // check if there are 4 unique indices values and add to result list
                if(indicesOfPairA[0] != indicesOfPairB[0] && indicesOfPairA[1] != indicesOfPairB[1]
                        && indicesOfPairA[0] != indicesOfPairB[1] && indicesOfPairA[1] != indicesOfPairB[0]){
                    result.add(indicesOfPairA[0]);
                    result.add(indicesOfPairB[0]);
                    result.add(indicesOfPairA[1]);
                    result.add(indicesOfPairB[1]);
                    break;
                }
            }
        }
        // order the indices in increasing order
        Collections.sort(result);
        return result != null? result: new ArrayList<>();
    }

    public static ArrayList<Integer> findFourSum(int[] nums, int target){
        HashMap<Integer, int[]> sumPairs = createHashMapOfAllSumPairs(nums);
        ArrayList<Integer> result = findTwoPairSum(sumPairs, target);
        return result;
    }

    public static void main(String[] args){
        int[] nums = {2, 3, 1, -1, -4, 7, 8, 6, 3, 4, 9};
        int target = 10;
        ArrayList<Integer> result = findFourSum(nums, target);
        if(result.isEmpty()) System.out.println("No 4 values sum up to the target " + target);
        else{
            System.out.println("The 4 index in the array that sum up to" + " " + target + " are:");
            for(int num : result){
                System.out.print(" " + num);
            }
        }
    }
}
