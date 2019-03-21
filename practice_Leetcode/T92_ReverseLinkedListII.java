public class T92_ReverseLinkedListII {

    public  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int len = n - m + 1;
        ListNode preHead = null;
        ListNode modify_tail = null;
        ListNode result = head;

        while (--m > 0 && head!= null){
            preHead = head;
            head = head.next;
        }

        modify_tail = head;

        // 翻转 m --->n 段的链表
        ListNode newHead = null;
        ListNode next = null;
        while (len >0 && head!=null){
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            len--;
        }
        // 将新链表的后端与剩余部分链接
        modify_tail.next = head;
        // 新链表的前端，视情况而定
        if (preHead!=null){
            preHead.next = newHead;
        }else {
            result = head;
        }
        return result;
    }
    /*
    * 编程心得：
    * 链表中的起始位置与要走的步数的关系。
    * 要走到链表中的第m个节点。
    * 如果其实节点为头节点，则只需要走m-1不即可。
    *
    * 对于m步的循环条件设置：
    * while(m-- > 0) 这种解法比较简单清晰。
    * */

    public ListNode reverseBetween_03_21_err(ListNode head, int m, int n) {
        ListNode pre_pm = null;
        ListNode pm = null;
        ListNode modify_list_tail = null;
        ListNode pn_next = null;
        ListNode newH = null;
        ListNode cur = head;

        while (--m >0&& cur != null){
            pre_pm = cur;
            cur = cur.next;
        }

        modify_list_tail = cur;
        pm = cur;
        // 对m-n段进行翻转
        ListNode next = null;
        for (int i= 1; i <= n-m+1; i++){
            next = pm.next;
            pm.next = newH;
            newH = pm;
            pm = next;
        }

        pre_pm.next = newH;
        modify_list_tail.next = pn_next;
        return head;
    }


}
