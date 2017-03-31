
/*public class InsertionSort {
   *//*
    Insertion Sort using recursion
     *//*
    public static int[] recursiveInsertionSort(int[] array, int n) {
        if (n > 1) {
            recursiveInsertionSort(array, n - 1);
        }
        int key = array[n];
        int i = n - 1;
        while ((i >= 0) && (array[i] > key)){
            array[i + 1] = array[i];
            i = i - 1;
        }
        array[i + 1] = key;
        return array;
    }

    *//*
    Instead of linearly searching the index to insert arr[n]
    we perform binary search to find the index
     *//*
    public static int[] binarySearchInsertionSort(int[] arr){
        if(arr.length <= 1){
            return arr;
        }
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int startIndex = 0;
            int endIndex = i;
            int mid = 0;
            while (startIndex < endIndex){
                mid = startIndex + ((endIndex - startIndex) / 2);
                if(arr[mid] < key){
                    startIndex = mid + 1;
                }
                else{
                    endIndex = mid;
                }
            }

            int insertAtIndex = arr[mid] > key? mid: mid + 1;
            for(int ins = i-1; ins >= insertAtIndex; ins--){
                arr[ins+1] = arr[ins];
            }

            arr[insertAtIndex] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 41, 52, 26, 38, 57, 9, 49};
        int[] recursionResult = recursiveInsertionSort(arr, arr.length - 1);
        System.out.println();
        System.out.print("Sorted Array (recursive method): ");
        for(int num : recursionResult){
            System.out.print(" " + num);
        }
        System.out.println();
        System.out.print("Sorted Array (binary search method): ");
        int[] binarySearchResult = binarySearchInsertionSort(arr);
        for(int num : binarySearchResult){
            System.out.print(" " + num);
        }
    }
}*/


public class InsertionSort{

    public static int[] insertionSort(int[]arr){
        int length = arr.length;
        for(int i = 1; i < length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        return arr;
    }

    public static void main(String[] args){
        int[] arr = new int[]{15, 14, 4, 3, 41, 1, 17, 19, 22, 8, 5};
        arr = insertionSort(arr);
        for(int i = 0; i < arr.length; i++) System.out.print(" " + arr[i]);
    }
}

