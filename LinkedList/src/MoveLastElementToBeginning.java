
public class MoveLastElementToBeginning {
    public LinkedListNode moveLastElementToBeginning(LinkedListNode head){
        LinkedListNode node = head;
        LinkedListNode neighbourNode = node.nextNode;
        if(node == null | neighbourNode == null){
            return null;
        }
        while(neighbourNode.nextNode != null){
            node = neighbourNode;
            neighbourNode = neighbourNode.nextNode;
        }
        node.nextNode = null;
        neighbourNode.nextNode = head;
        head = neighbourNode;
        return head;
    }
}
