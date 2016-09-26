
// Kadane's Algorithm
public class MSS {
    public static void findMaximumSumSubArray(int[] numArr){
        int subArrayIndexStart = 0;
        int subArrayIndexEnd = -1;
        int startIndex = 0;
        int maxSoFar = 0;
        int maxEndingHere = 0;

        for(int i = 0; i < numArr.length; i++){
            if((numArr[i] + maxEndingHere) <= 0){
                startIndex = i + 1;
                subArrayIndexStart = startIndex;
            }

            maxEndingHere = Math.max((numArr[i] + maxEndingHere), numArr[i]);

            if(maxEndingHere > maxSoFar){
                maxSoFar = maxEndingHere;
                subArrayIndexEnd= i;
            }
        }
        System.out.println("Max Sum: " + maxSoFar);
        System.out.println("StartIndex: " + subArrayIndexStart);
        System.out.println("End Index: " + subArrayIndexEnd);
    }
    public static void main(String[] args){
        int[] numArray = new int[]{1, -2,3, 5, -2, 3, -1};
        findMaximumSumSubArray(numArray);
    }
}
