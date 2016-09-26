
public class LinkedListMainClass {

    public static void main(String[] args){
        int[] inputElementsOfLinkedList = new int[]{3, 6, 24, 25, 67, 202, 404, 231};
        BuildLinkedList BL = new BuildLinkedList();
        BL.addElementsToLinedList(inputElementsOfLinkedList);

        // Print all elements of Linked List
        PrintElements.printElements(BL.head);

        // Print Kth to last elements of Linked List
        KthToLast kToL = new KthToLast();
        LinkedListNode startPointer = kToL.kToLastElements(BL.head, 3);
        PrintElements.printKToLastElements(startPointer);

        //Move last node to beginning
        MoveLastElementToBeginning move = new MoveLastElementToBeginning();
        LinkedListNode node =  move.moveLastElementToBeginning(BL.head);
        PrintElements.printElements(node);

    }
}
