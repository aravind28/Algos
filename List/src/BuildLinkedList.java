
public class BuildLinkedList {
    LinkedListNode head;
    LinkedListNode currentNode;

    public BuildLinkedList(){
        head = new LinkedListNode();
        currentNode = null;
    }

    public void addElementsToLinkedList(int[] elements){
        for (int i = 0; i <= elements.length - 1; i++){
            addElementInLinkedList(elements[i]);
        }
    }

    public void addElementInLinkedList(int element){
        if(head.val == 0){
            head.val = element;
            head.nextNode = null;
            currentNode = head;
        }
        else{
            currentNode.nextNode = new LinkedListNode();
            currentNode = currentNode.nextNode;
            currentNode.nextNode = null;
            currentNode.val = element;
        }
    }
}
