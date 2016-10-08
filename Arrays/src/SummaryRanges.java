import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 0) {
            return result;
        } else if (nums.length == 1) {
            result.add(Integer.toString(nums[0]));
            return result;
        }
        int indexPointer = 0;

        while (indexPointer < nums.length) {
            int start = nums[indexPointer];
            while (indexPointer < nums.length - 1) {
                if ((nums[indexPointer + 1] - nums[indexPointer]) == 1) {
                    indexPointer += 1;
                }
                else{
                    break;
                }
            }
            if (start == nums[indexPointer]) {
                result.add(Integer.toString(start));
            } else {
                result.add(Integer.toString(start) + "->" + Integer.toString(nums[indexPointer]));
            }
            indexPointer += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 5, 7};
        List<String> res = summaryRanges(arr);
        System.out.print("Summary of Ranges are:");
        for (String range : res) {
            System.out.print(" " + range);
        }
    }
}
