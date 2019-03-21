
public class AddTwoNumber02 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers( ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p1 = l1,p2 = l2, cur = dummyHead;
        int carry = 0;

        while (p1!= null || p2 != null){
            int x = p1 != null ? p1.val : 0;
            int y = p2 != null ? p2.val : 0;
            int sum = (carry +x + y) ;
            carry = (x + y) / 10;
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
}
