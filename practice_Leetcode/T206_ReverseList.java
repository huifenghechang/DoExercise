public class T206_ReverseList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList1(ListNode head) {
        if (head != null){
            ListNode p1 = null;
            ListNode next = null;
            ListNode p2 = head;
            while (p2 != null){
                next = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = next;
            }
            return p1;
        }else {
            return head;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode head2 = reverseList(head);
        while (head2 != null){
            System.out.println(head2.val);
            head2 = head2.next;
        }

    }


}
