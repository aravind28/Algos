
public class MinimumSizeSubArraySum {
    public static int findMinSizeSubArray(int[] arr, int sum) {
        int sumTillHere = 0;
        int startIndex = 0;
        int count = Integer.MAX_VALUE;
        for (int i = startIndex; i < arr.length; i++) {
            sumTillHere += arr[i];
            while (sumTillHere >= sum) {
                count = Math.min(count, (i - startIndex + 1));
                sumTillHere -= arr[startIndex];
                startIndex++;
            }
        }
        if(count == Integer.MAX_VALUE){
            return 0;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int reqdSum = 11;
        int minSize = findMinSizeSubArray(arr, reqdSum);
        System.out.println(minSize);
    }
}
