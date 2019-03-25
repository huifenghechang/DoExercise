import java.awt.*;
import java.util.Stack;

public  class T2_AddTwoNumber {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode addTwoNumbers1( ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p1 = l1,p2 = l2, cur = dummyHead;
        int carry = 0;

        while (p1!= null || p2 != null){
            int x = (p1 != null) ? p1.val : 0;
            int y = (p2 != null) ? p2.val : 0;
            int sum = (carry +x + y) ;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        if (carry > 0){
            cur.next = new ListNode(carry);
        }

        return dummyHead.next;

    }

    public  ListNode addTwoNumbers_19_03_25(ListNode l1, ListNode l2){
        ListNode result = new ListNode(-1);
        ListNode res_tail = result;

        int counter = 0;
        while (l1!= null || l2!=null){
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;  // 在多种运算符共存的情况下，加括号保证可读性。

            int sum = x + y + counter;
            counter = sum / 10;
            res_tail.next = new ListNode(sum % 10);
            res_tail = res_tail.next;
            if (l1!= null){
                l1 = l1.next;
            }

            if (l2!= null){
                l2 = l2.next;
            }
        }
        if (counter > 0){
            res_tail.next = new ListNode(counter);
        }
        return result.next;
    }

    public static ListNode addTwoNumbers_19_03_18(ListNode l1, ListNode l2) {

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


/*
        ListNode head3 = addTwoNumbers1(head1,head2);

        while (head3 != null){
            System.out.println(head3.val);
            head3 = head3.next;
        }*/
    }

}
