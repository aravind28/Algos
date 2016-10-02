class MedianOfTwoArrays{
    public static float findMedian(int[] arr1, int arr1Start, int arr1End, int[] arr2,
                                 int arr2Start, int arr2End){
        float result;
        if(arr1Start == arr1End){
            result =  (arr1[arr1Start] + arr2[arr2Start]) /2;
            return result;
        }

        else if((arr1End - arr1Start) == 1){
            float m1 = Math.min(arr1[arr1Start], arr2[arr2Start]);
            float m2 = Math.max(arr1[arr1End], arr2[arr2End]);
            result = (m1 + m2)/2;
            return result;
        }
        int medianIndexArr1 = arr1Start + ((arr1End - arr1Start) / 2);
        int medianIndexArr2 = arr2Start + ((arr2End - arr2Start) / 2);

        if(arr1[medianIndexArr1] < arr2[medianIndexArr2]){
            arr1Start = medianIndexArr1;
            arr2End = medianIndexArr2;
        }
        else{
            arr1End = medianIndexArr1;
            arr2Start = medianIndexArr2;
        }
        return findMedian(arr1, arr1Start, arr1End, arr2, arr2Start, arr2End);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 4};
        int[] arr2 = new int[]{5,6, 7};
        float median = findMedian(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1);
        System.out.println("Median: " + median);
    }
}