class MedianOfTwoArrays {
    public static float findMedian(int[] x, int startIndexOfX, int endIndexOfX,
                                   int[] y, int startIndexOfY, int endIndexOfY){
        float result;

        if(startIndexOfX == endIndexOfX){
            result = (x[startIndexOfX] + y[startIndexOfY]) / 2.0f;
            return result;
        }
        if (endIndexOfX - startIndexOfX == 1){
            int middleElementOne = Math.max(x[startIndexOfX], y[startIndexOfY]);
            int middleElementTwo = Math.min(x[endIndexOfX], y[endIndexOfY]);
            return (middleElementOne + middleElementTwo) / 2.0f;
        }
        int medianOfX = getMedianValue(x, startIndexOfX, endIndexOfX);
        int medianOfY = getMedianValue(y, startIndexOfY, endIndexOfY);

        if (medianOfX == medianOfY){
            return medianOfX;
        }

        int midIndexOfX = startIndexOfX + (endIndexOfX - startIndexOfX) / 2;
        int midIndexOfY = startIndexOfY + (endIndexOfY - startIndexOfY) / 2;

        if(medianOfX < medianOfY){
            if((endIndexOfY - startIndexOfY) % 2 == 1){
                midIndexOfY = midIndexOfY + 1;
            }
            return findMedian(x,  midIndexOfX, endIndexOfX, y, startIndexOfY, midIndexOfY);
        }
        else{
            if((endIndexOfX - startIndexOfX) % 2 == 1){
                midIndexOfX = midIndexOfX + 1;
            }

            return findMedian(x, startIndexOfX, midIndexOfX, y, midIndexOfY, endIndexOfY);
        }
    }

    private static int getMedianValue(int[] arr, int startIndex, int endIndex){
        int medianIndex = (startIndex) + (endIndex - startIndex) / 2;
        int median = arr[medianIndex];
        if((endIndex - startIndex) % 2 == 1 ){            // if even number of elements are present median
            median = (median + arr[medianIndex + 1]) / 2; // is the average of two middle elements
        }
        return median;
    }

    public static void main(String[] args) {
//        int[] arr1 = {1, 12, 15, 26, 38};
//        int[] arr2 = {2, 13, 17, 30, 45};
        int[] arr1 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int[] arr2 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
//        int[] arr1 = {4};
//        int[] arr2 = {2};
//        int[] arr1 = {1, 22, 25};
//        int[] arr2 = {4, 22, 33};
//        int[] arr1 = {1, 14, 22, 25, 27, 47, 75, 88};
//        int[] arr2 = {1, 4, 7, 18, 34, 68, 77, 78};
        float median = findMedian(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1);
        System.out.println("Median: " + median);
    }
}