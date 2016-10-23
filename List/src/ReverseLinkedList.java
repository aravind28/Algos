
public class ReverseLinkedList {
    public static void main(String[] args) {
        BuildLinkedList bl = new BuildLinkedList();
        int[] arr = {1, 2, 3, 2, 1};
        bl.addElementsToLinkedList(arr);
        PrintElements.printElements(bl.head);

        LinkedListNode currPointer = bl.head;
        LinkedListNode tempPointer = currPointer;
        LinkedListNode prevPointer = null;
        while(tempPointer.nextNode != null){
            tempPointer = tempPointer.nextNode;
            currPointer.nextNode = prevPointer;
            prevPointer = currPointer;
            currPointer = tempPointer;
        }
        currPointer.nextNode = prevPointer;
        PrintElements.printElements(currPointer);
    }
}
