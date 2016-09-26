
public class MagicIndex {

    private void findMagicIndexDistinct(int[] arr, int startIndex, int endIndex){
        if(endIndex < startIndex){
            return;
        }
        int lengthOfArray = (startIndex + endIndex);
        int midIndex = lengthOfArray / 2;
        if(arr[midIndex] == midIndex){
            System.out.println("Magic Index of distinct array is: " + midIndex);
            return;
        }
        else if(arr[midIndex] > midIndex){
            findMagicIndexDistinct(arr, startIndex, midIndex - 1);
        }
        else{
            findMagicIndexDistinct(arr, midIndex + 1, endIndex);
        }
    }

    private void findMagicIndexNonDistinct(int[] arr, int startIndex, int endIndex){
        if(endIndex < startIndex){
            return;
        }
        int midIndex = (startIndex + endIndex + 1) / 2;
        if(arr[midIndex] == midIndex){
            System.out.println("Magic Index of non distinct array is: " + midIndex);
            return;
        }
        else if(arr[midIndex] < midIndex){
            findMagicIndexNonDistinct(arr, startIndex, Math.min(midIndex -1,  arr[midIndex]));
        }
        else{
            findMagicIndexNonDistinct(arr, midIndex + 1, endIndex);
        }
    }
    public static void main(String[] args){
        MagicIndex mi = new MagicIndex();
        int[] arrayDistinct = new int[]{-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        int[] arrayNonDistinct = new int[]{-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};

        mi.findMagicIndexDistinct(arrayDistinct, 0, arrayDistinct.length-1);
        mi.findMagicIndexNonDistinct(arrayNonDistinct, 0, arrayNonDistinct.length-1);
    }
}
