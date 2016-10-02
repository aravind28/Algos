public class QuickSortHoarePartition {
    static int[] arr;

    public static void quickSort(int startIndex, int endIndex) {
        if (startIndex < (endIndex - 1)) {
            int partitionIndex = hoarePartition(startIndex, endIndex);
            quickSort(startIndex, (partitionIndex + 1));
            quickSort((partitionIndex + 1), endIndex);
        }
    }

    public static int hoarePartition(int startIndex, int endIndex) {
        int i = startIndex - 1, j = endIndex + 1;
        int pivot = arr[startIndex];
        while(true){
            do{
                j --;
            }while(!(arr[j] <= pivot));
            do{
                i ++;
            }while(!(arr[i] >= pivot));

            if(i < j){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            else{
                return j;
            }
        }
    }

    public static void main(String[] args) {
        //arr = new int[]{13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11};
        arr = new int[]{13, 19, 9, 5, 12, 8, 7, 4, 11, 2, 6, 21};
        quickSort(0, arr.length - 1);
        System.out.println();
        System.out.print("Quick sort : ");
        for (int num : arr) {
            System.out.print(" " + num);
        }
    }
}
