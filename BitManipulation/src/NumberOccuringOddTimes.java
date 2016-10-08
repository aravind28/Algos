
public class NumberOccuringOddTimes {
    public static int findNumberOccuringOddTimes(int[] arr){
        if(arr.length == 0 || arr.length == 2){
            return 0;
        }
        else if(arr.length == 1){
            return arr[1];
        }

        int mask = arr[0];
        for(int i = 1; i < arr.length; i++){
                mask = mask ^ arr[i];
        }
        return mask;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 3, 1, 2, 2, 1, 3};
        int oddOccurenceNumber = findNumberOccuringOddTimes(arr);
        System.out.println("Number that occurs odd times: " + oddOccurenceNumber);
    }
}
