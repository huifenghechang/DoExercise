import java.util.Iterator;

public class T24_SwapPair {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  /*
  * 关于链表的题目，可以多设置几个指针，来保存节点前后的信息。
  * */
    public static ListNode swapPairs190331(ListNode head){
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode pre = dumpy;

        ListNode first ;
        ListNode second;
        while (pre.next != null && pre.next.next != null){
            first = pre.next;
            second = pre.next.next;

            // swap action
            first.next = second.next;
            second.next = first;

            pre.next = second;
            pre = pre.next.next;
        }
        return dumpy.next;
    }

    public static ListNode swapPairs190320(ListNode head) {
    /*
    * 要点：设置一个节点，保存当前交换节点对中，第一个节点对中的前一个节点。
    * */
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode res = dumpy;
        ListNode first = null;
        ListNode second = null;
        while (dumpy.next != null && dumpy.next.next != null){
            first = dumpy.next;
            second = dumpy.next.next;

            // 实现交换
            first.next = second.next;
            second.next = first;
            // 上移节点dumpy.next指向交换后的Second节点
            dumpy.next = second;
            dumpy = dumpy.next.next;
        }
        return res.next;
    }

    public ListNode swapPairs1(ListNode head) {
        ListNode cur = head;
        ListNode first = null;
        ListNode second = null;
        ListNode next = null;
        ListNode newHead = null;

        // 这种方法不对！！
        while (cur != null && cur.next != null){
            next = cur.next.next;

            first = cur;
            second = cur.next;

            if (newHead == null){
                newHead = second;
            }

            // 交换操作
            first.next = next;
            second.next = first;

            cur = next;
        }
        return newHead;

    }



    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        swapPairs190320(head);
    }


}
