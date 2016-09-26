public class Heap {

    Heap() {
    }

    public int[] buildMaxHeap(int[] arr) {
        int maxHeapSize = arr.length;
        int[] maxHeapArr = new int[maxHeapSize];
        for (int i = 0; i < arr.length; i++) {
            insertIntoMaxHeap(arr[i], maxHeapArr, i, maxHeapSize);
        }
        return maxHeapArr;
    }

    private void insertIntoMaxHeap(int value, int[] maxHeapArr, int currentIndex, int maxHeapSize) {
        if (currentIndex <= maxHeapSize - 1) {
            maxHeapArr[currentIndex] = value;
            currentIndex++;
            bubbleUp((currentIndex - 1), maxHeapArr);
        }
    }

    private void bubbleUp(int index, int[] maxHeapArr) {
        int parentIndex = (index - 1) / 2;
        while ((index != 0) && (maxHeapArr[parentIndex] < maxHeapArr[index])) {
            int temp = maxHeapArr[parentIndex];
            maxHeapArr[parentIndex] = maxHeapArr[index];
            maxHeapArr[index] = temp;
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public int[] buildMinHeap(int[] arr) {
        int minHeapSize = arr.length;
        int[] minHeapArr = new int[minHeapSize];
        for (int i = 0; i < arr.length; i++) {
            insertIntoMinHeap(arr[i], minHeapArr, i, minHeapSize);
        }
        return minHeapArr;
    }

    private void insertIntoMinHeap(int value, int[] minHeapArr, int currentIndex, int minHeapSize) {
        if (currentIndex <= minHeapSize - 1) {
            minHeapArr[currentIndex] = value;
            currentIndex++;
            bubbleDown(currentIndex - 1, minHeapArr);
        }
    }

    private void bubbleDown(int index, int[] minHeapArr) {
        int parentIndex = (index - 1) / 2;
        while ((index != 0) && (minHeapArr[parentIndex] > minHeapArr[index])) {
            int temp = minHeapArr[parentIndex];
            minHeapArr[parentIndex] = minHeapArr[index];
            minHeapArr[index] = temp;
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public int[] extractFromMaxHeap(int[] maxHeapArr){
        int[] resultArr = new int[maxHeapArr.length];
        int[] inputArr = maxHeapArr;
        for(int i = 0; i < maxHeapArr.length; i++){
            resultArr[i] = inputArr[0];
            inputArr[0] = inputArr[inputArr.length - 1 - i];
            inputArr[inputArr.length - 1 - i] = 0;
            inputArr = maxHeapify(inputArr, 0);
        }
        return resultArr;
    }

    private int[] maxHeapify(int[] arr, int index){
        int[] tempArr = arr;

        if(tempArr.length <= 1){
            return tempArr;
        }

        int leftChild = (2 * index) + 1;
        int rightChild = (2 * index) + 2;
        int largest;

        if((leftChild < tempArr.length) && (tempArr[leftChild] > tempArr[index])){
            largest = leftChild;
        }
        else{
            largest = index;
        }
        if((rightChild < tempArr.length) && (tempArr[rightChild] > tempArr[largest])){
            largest = rightChild;
        }
        if(largest != index){
            int temp = tempArr[index];
            tempArr[index] = tempArr[largest];
            tempArr[largest] = temp;
            maxHeapify(tempArr, largest);
        }
        return tempArr;
    }

    public int[] extractFromMinHeap(int[] minHeapArr){
        int[] resultArr = new int[minHeapArr.length];
        int[] inputArr = minHeapArr;
        for(int i = 0; i < minHeapArr.length; i++){
            resultArr[i] = inputArr[0];
            inputArr[0] = inputArr[inputArr.length - 1 - i];
            inputArr[inputArr.length - 1 - i] = 0;
            inputArr = minHeapify(inputArr, 0);

        }
        return resultArr;
    }

    private int[] minHeapify(int[] arr, int index){
        int[] tempArr = arr;

        if(tempArr.length <= 1){
            return tempArr;
        }

        int leftChild = (2 * index) + 1;
        int rightChild = (2 * index) + 2;
        int smallest;

        if((leftChild < tempArr.length) && (tempArr[leftChild] < tempArr[index])
                && (tempArr[index] != 0) && (tempArr[leftChild] != 0)){
            smallest= leftChild;
        }
        else{
            smallest = index;
        }
        if((rightChild < tempArr.length) && (tempArr[rightChild] < tempArr[smallest])
                && (tempArr[index] != 0) && (tempArr[rightChild] != 0)){
            smallest = rightChild;
        }
        if(smallest != index){
            int temp = tempArr[index];
            tempArr[index] = tempArr[smallest];
            tempArr[smallest] = temp;
            minHeapify(tempArr, smallest);
        }
        return tempArr;
    }
}
