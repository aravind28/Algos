   
public class CountingSort {
    public static int[] countingSort(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            else if(arr[i] > max){
                max = arr[i];
            }
        }
        int[] result = new int[arr.length];
        int[] temp = new int[max + 1];
        for(int i = 0; i < arr.length; i++){
            temp[arr[i]] ++;
        }
        for(int i = 1; i < temp.length; i++){
            temp[i] = temp[i] + temp[i-1];
        }
        for(int index = result.length - 1; index >= 0; index --){
            result[temp[arr[index] ] - 1] = arr[index];
            temp[arr[index]]--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 0, 2, 0, 1, 3, 4, 6, 1, 3, 2};
        int[] result = countingSort(arr);
        System.out.print("Counting sort output:");
        for(int num : result){
            System.out.print(" " + num);
        }
    }
}
