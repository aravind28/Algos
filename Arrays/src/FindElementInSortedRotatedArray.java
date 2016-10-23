
public class FindElementInSortedRotatedArray {
    public static int findElement(int[] arr, int element){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == element){
                return mid;
            }
            else if(arr[mid] > arr[start]){
                if(arr[mid] > element){
                    end = mid - 1;
                } else{
                    start = mid + 1;
                }
            }
            else{
                if((arr[mid] < element) && (arr[start] > element)) {
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return - 1;
    }
    public static void main(String[] args){
        int[] arr = {78, 82, 99, 23, 35, 49, 51, 60};
        int element = 82;
        int minElement = findElement(arr, element);
        System.out.println("Array index of element in array is: " + minElement);
    }
}
