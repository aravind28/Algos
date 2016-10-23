import java.util.HashSet;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(hs.contains(Math.abs(target-nums[i]))){
                int j = 0;
                while (j < i) {
                    if (nums[j] == (target - nums[i])) {
                        res[0] = j;
                        res[1] = i;
                    }
                    j++;
                }
            }
            else if(!hs.contains(nums[i])){
                hs.add(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        int target = 6;
        int[] result = twoSum(arr, target);
        System.out.print("Array Index are:");
        for (int num : result){
            System.out.print(" " + num);
        }
    }
}
