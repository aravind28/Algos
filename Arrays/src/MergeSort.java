
public class MergeSort {
    public static int[] tempResult;
    public static int[] arr;

    public static void mergeSort(int startIndex, int endIndex){
        if(startIndex < endIndex){
            int midIndex = startIndex + ((endIndex - startIndex) / 2);
            mergeSort(startIndex, midIndex);
            mergeSort(midIndex + 1, endIndex);
            merge(startIndex, midIndex, endIndex);
        }
    }

    public static void merge(int lowIndex, int midIndex, int endIndex){

        int i = lowIndex;
        int j = midIndex + 1;
        int tempArrayPointer = lowIndex;

        while((i <= midIndex) && (j <= endIndex)){
            if(arr[i] <= arr[j]){
                tempResult[tempArrayPointer] = arr[i];
                i++;
            }
            else{
                tempResult[tempArrayPointer] = arr[j];
                j++;
            }
            tempArrayPointer++;
        }
        while(i <= midIndex){
            tempResult[tempArrayPointer] = arr[i];
            i++;
            tempArrayPointer++;
        }

        while(j <= endIndex){
            tempResult[tempArrayPointer] = arr[j];
            j++;
            tempArrayPointer++;
        }

        for(int index = lowIndex; index <= endIndex; index++){
            arr[index] = tempResult[index];
        }
    }

    public static void main(String[] args){
        arr = new int[]{3, 4, 52, 26, 38, 57, 9, 49};
        tempResult = new int[arr.length];
        mergeSort(0, arr.length - 1);
        System.out.println("Sorted Array: ");
        for(int num : arr){
            System.out.print(" " + num);
        }
    }
}
