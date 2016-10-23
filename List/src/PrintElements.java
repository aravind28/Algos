
public class PrintElements {

    // Print all elements
    public static void printElements(LinkedListNode node){
        System.out.println();
        System.out.println("The linked list elements are: ");
        while(node != null){
            System.out.print("->" + node.val);
            node = node.nextNode;
        }
    }

    // Print Kth to Last elements
    public static void printKToLastElements(LinkedListNode startPointer){
        System.out.println();
        System.out.println("The kth to the last elements are: ");
        while(startPointer != null){
            System.out.print("->" + startPointer.val);
            startPointer = startPointer.nextNode;
        }
    }
}
