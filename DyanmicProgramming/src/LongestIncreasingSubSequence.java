
public class LongestIncreasingSubSequence {
    public static int[] findLIS(int[] arr){
        int len = arr.length;
        if(len == 1){
            return new int[0];
        }
        int result[] = new int[len];
        for(int i = 0; i < result.length; i++){
            result[i]  = 1;
        }

        //parent[i] stores the index of element smaller than arr[i] in the subsequence
        int parent[] = new int[len];

        for(int i = 1; i < len; i++){
            // length of sub-sequence for every element at index i is 1
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    int maxPresent  = result[i];
                    result[i] = Math.max(maxPresent, 1 + result[j]);
                    if(result[i] != maxPresent){
                        parent[i] = j;
                    }
                }
            }
        }

//        return result;
        return findActualSequence(arr, result, parent);
    }

    private static int[] findActualSequence(int[] inputArr, int[] resultArr, int[] parentArr){
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < resultArr.length; i++){
            if(resultArr[i] > maxValue){
                maxValue = resultArr[i];
                maxIndex = i;
            }
        }

        int[] sequence = new int[maxValue];
        int index = sequence.length - 1;
        sequence[index] = inputArr[maxIndex];
        index--;

        while(index >= 0){
            sequence[index] = inputArr[parentArr[maxIndex]];
            maxIndex = parentArr[maxIndex];
            index --;
        }
        return sequence;
    }

    public static void main(String[] args){
//        int[] arr = {3, 4, -1, 0, 6, 2, 3};
        int[] arr = {5, 27, 14, 38, 66, 55, 86, 95, 98};
        int[] result = findLIS(arr);
        System.out.print("A longest increasing sub-sequence in the array is: " );
        for(int i : result){
            System.out.print(" " + i);
        }
    }
}
