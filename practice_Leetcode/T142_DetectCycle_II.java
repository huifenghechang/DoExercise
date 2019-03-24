public class T142_DetectCycle_II {
    public  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


    /*
    * 结论： 从头结点和相交节点触发。两指针以相同的速度扫描，最后相遇的节点，即为环节点。
    *
    * 编程的时候，一定要注意边界条件。
    *
    * 特殊情况：
    *       当环节点为头结点时；
    *       当输入为单节点时；
    *
    * 编程技巧：
    *       将有环时的处理逻辑，直接写在迭代的代码中，可以不用再后续代码中进行环节点的检测处理。
    *
    *
    * */
    public ListNode detectCycle1(ListNode head) {
        ListNode fast = null;
        ListNode slow = null;

        if (head != null && head.next != null){
            /*
            * 引入了一个cur指针，来保证快指针的运行是合法的！！！
            * */
            ListNode cur = head;
            fast = head;
            slow = head;

            while (cur.next != null && cur.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast){
                    while (head != slow){
                        head = head.next;
                        slow = slow.next;
                    }
                    return slow;
                }else {
                    cur = cur.next.next;
                }
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;

       while (fast != null){
           slow = slow.next;
           fast = fast.next;

           if ( fast == null){
               return null;
           }
           fast = fast.next; // fast指针的两步，是分两步完成的。

           if (fast == slow){
               meet = fast;
               break;
           }
       }

       if (meet == null){
           return null;
       }
       while (head!=null && meet!= null){
           if (head == meet){
               return head;
           }
           head = head.next;
           meet = meet.next;
       }
       return null;
    }
}
