public class Main{
    public static void main(String[] args){
        int[] arr = new int[]{35 , 33, 43, 10, 14, 19, 27, 44, 26, 31};
        Heap heap = new Heap();

        // 44 43 35 33 31 19 27 10 26 14
        int[] maxHeap = heap.buildMaxHeap(arr);
        System.out.print("Max Heap:");
        for(int num: maxHeap){
            System.out.print(" " + num);
        }

        //10 14 19 26 31 43 27 44 35 33
        int[] minHeap = heap.buildMinHeap(arr);
        System.out.println();
        System.out.print("Min Heap:");
        for(int num: minHeap){
            System.out.print(" " + num);
        }

        int[] nonInreasingOrder = heap.extractFromMaxHeap(maxHeap);
        System.out.println();
        System.out.print("Non increasing order:");
        for(int num : nonInreasingOrder){
            System.out.print(" " + num);
        }
        int[] nonDecreasingOrder = heap.extractFromMinHeap(minHeap);
        System.out.println();
        System.out.print("Non decreasing order:");
        for(int num: nonDecreasingOrder){
            System.out.print(" " + num);
        }
    }
}
