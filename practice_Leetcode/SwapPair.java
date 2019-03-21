import java.util.Iterator;

public class SwapPair {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    public static ListNode swapPairs(ListNode head) {
    /*
    * 要点：设置一个节点，保存当前交换节点对中，第一个节点的前一个节点。
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

        swapPairs(head);
    }


}
