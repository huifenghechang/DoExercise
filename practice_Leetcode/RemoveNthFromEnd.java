public class RemoveNthFromEnd {

    public  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode cur = head;
        ListNode pk = null;

        /*
        * 用while语句替代更好。
        * 快慢指针的起始，从dummy指针出起步，可以有效的避免头结点问题。
        *
        * */
        for (int i = 1;i <= n && cur != null;i++ ){
            cur = cur.next;
            if (i == n){
                pk = cur;
            }
        }
        //从pk为开始遍历，cur 从head 开始遍历。当pk到达末尾时，cur 指向的便是倒数第n个。
        if (pk == null){
            throw  new IllegalArgumentException("The n is more than list's Length.");
        }else {
            cur = head;
            while (pk.next != null){
                cur = cur.next;
                pk = pk.next;
            }
            // 此时cur指向的便是 倒数第K个数的前一个进行删除之。
           cur.next = cur.next.next;
        }
        return head;
    }

    /*
    * 双指针+ dummyHead法
    *
    * 找到倒数第N个节点的前驱，快指针先往前走N+1步，然后快慢指针一起走。
    * 最终慢指针指向的便是倒数第N个节点的前驱。
    *
    * 快慢指针同步的过程中，需要注意While循环的执行次数与判断条件的关系。
    *
    * 尽量不要在While循环汇总加判断，这样会导致结构混乱。
    *
    * 如果不用Dummy指针，当输入为一个节点时，这种情况较难判断。！！！所以，建议用头指针
    * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead,slow = dummyHead;

        while(n>=0){
            fast = fast.next;
            n--;
        }

        while(fast != null){
            // fast语句位置的不同，导致最后slow走的步数不一样！
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode fast = head;// 这样命名，默认fast指针已经走了一步。
        ListNode slow = null;
        ListNode res = head;

        while (n > 1){
            fast = fast.next; // 如果n为1，只有一个节点，会导致这种情况难以处理！
            n--;
        }                  // 此循环运行完之后，快指针走了 n + 1 步。如果是[1],1则会导致空指针异常。

        // 删除倒数第n个节点，则需要找到第n个节点的前驱。
        // fast 指针先移动n+1步，然后快慢指针一起移动，就能够保证最后能够指向其前驱。
        //  需要判断边界条件。链表长度是否大于n+1等等，，，

        //  所以，用这种方法十分麻烦！！！

        // 使用dummyHead指针可以有效避免这种情况。
        // 快慢指针从dummy节点出发，可以规避头结点的异常情况。

        return res;


    }

}
