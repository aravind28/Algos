
public class KthToLast {

    public LinkedListNode kToLastElements(LinkedListNode head, int k){

        LinkedListNode startPointer = head;
        LinkedListNode endPointer = head;
        for(int i = 0; i <= k - 1; i++){
            if(endPointer != null){
                endPointer = endPointer.nextNode;
            }
        }

        while(endPointer != null){
            startPointer = startPointer.nextNode;
            endPointer = endPointer.nextNode;
        }
        return startPointer;

    }

}
