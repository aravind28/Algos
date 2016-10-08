class QuickSort {
    static int[] arr;

    public static void quickSort(int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partitionIndex = partition(startIndex, endIndex);
            System.out.println();
            for (int num : arr){
                System.out.print(" " + num);
            }
            quickSort(startIndex, partitionIndex - 1);
            quickSort(partitionIndex + 1, endIndex);
        }
    }

    public static int partition(int startIndex, int endIndex) {
        int i = startIndex - 1, j;
        int pivotElement = arr[endIndex];
        for (j = startIndex; j < endIndex; j++) {
            if (arr[j] < pivotElement) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        System.out.println();
        System.out.println("I : "+ i);
        return i;
    }

    public static void main(String[] args) {
        //arr = new int[]{13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11};
        arr = new int[]{42, 24, 22, 21, 17, 12, 10, 5, 2};
        quickSort(0, arr.length - 1);
        System.out.println();
        System.out.print("Quick sort : ");
        for (int num : arr) {
            System.out.print(" " + num + " |");
        }
    }
}
