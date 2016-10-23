public class FindMinElementInRotatedSortedArray {
    public static int findMinElement(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        int minElement = 0;
        if(arr[start] < arr[end]){
            return arr[start];
        }
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid + 1] < arr[mid]){
                return arr[mid + 1];
            }
            else if(arr[mid] > arr[start]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return minElement;
    }

    public static void main(String[] args){
        int[] arr = {78, 82, 99, 23, 35, 49, 51, 60};
        int minElement = findMinElement(arr);
        System.out.println("Minimum element in array is: " + minElement);
    }
}
