import java.awt.*;
import java.util.Stack;

public  class AddTwoNumber {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        long value1 = listToInt(l1);
        long value2 = listToInt(l2);
        long result = value1 + value2;
        // 主要的错误在这一行，求数字的长度。这个是关键！！！
        int listLen = String.valueOf(result).length();
        return intToList(result,listLen-1);
    }

    public static long listToInt(ListNode head){
        long res = 0;
        int weight = 1;
        int count = 0;
        while (head != null){
            weight = (int)Math.pow(10,count);
            count++;
            res += head.val * weight;
            head = head.next;
        }
        return res;
    }

    public static ListNode intToList(long value,int exponent){
        Stack<Integer> stack = new Stack<>();
        int weight = 1;
        long num = value;
        while (exponent >=0){
            weight = (int)Math.pow(10,exponent);
            stack.push((int)num / weight);
            num = num % weight;
            exponent--;
        }
        ListNode head = new ListNode(stack.pop());
        ListNode node = head;
        while (!stack.isEmpty()){
            node.next = new ListNode(stack.pop());
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args){
       /* ListNode head1 = intToList(5,1);
        ListNode head2 = intToList(5,1);
*/
       ListNode head1 = new ListNode(9);
       //[9]
        //             [1,9,9,9,9,9,9,9,9,9]
       ListNode head2 = new ListNode(1);
       head2.next =new ListNode(9);
        head2.next.next =new ListNode(9);
        head2.next.next.next =new ListNode(9);
        head2.next.next.next.next =new ListNode(9);
        head2.next.next.next.next.next =new ListNode(9);
        head2.next.next.next.next.next.next =new ListNode(9);
        head2.next.next.next.next.next.next.next =new ListNode(9);
        head2.next.next.next.next.next.next.next.next =new ListNode(9);
        head2.next.next.next.next.next.next.next.next.next =new ListNode(9);

        ListNode head3 = addTwoNumbers(head1,head2);

        while (head3 != null){
            System.out.println(head3.val);
            head3 = head3.next;
        }
    }

}
