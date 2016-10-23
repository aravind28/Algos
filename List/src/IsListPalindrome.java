import java.util.Stack;

public class IsListPalindrome {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public boolean isPalindrome(ListNode head) {
        ListNode nodeItr = head;
        Stack<Integer> hs = new Stack<Integer>();
        int count = 0;

        while(nodeItr.next != null){
            hs.add(nodeItr.val);
            nodeItr = nodeItr.next;
            count ++;
        }
        count = (count % 2 == 0)? count / 2: count/2 +1;
        while(count >= 0){
            if((head.val == hs.peek())){
                head = head.next;
                hs.pop();
            }else{
                return false;
            }
            count --;
        }
        return true;
    }
}
