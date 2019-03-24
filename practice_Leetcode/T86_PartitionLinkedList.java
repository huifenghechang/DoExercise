public class T86_PartitionLinkedList {
/*
* 2019.03.22
* */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode partition1(ListNode head, int x) {
        ListNode smallH = null;
        ListNode smallT = null;

        ListNode biggerH = null;
        ListNode biggerT = null;

        ListNode next = null;

        while (head != null){
            next = head.next;
            // 若 节点小于X，则在原链表中删除，并将其加入到小链表中，head向后移动。
            if (head.val < x){
                if (smallH == null){
                    head.next = null;
                    smallH = head;
                    smallT = head;
                }else {
                    head.next = null;
                    smallT.next = head;
                    smallT = smallT.next;
                }
            }else {
                // 若节点大于X，则在大链表中添加之，head向后移动。
                if (biggerH == null){
                    head.next = null;
                    biggerH = head;
                    biggerT = head;
                }else {
                    head.next = null;
                    biggerT.next = head;
                    biggerT = biggerT.next;
                }
            }
            head = next;
        }

        // 将两个链表链接之
        if (smallT != null){
            smallT.next = biggerH;
            return smallH;
        }else {
            return biggerH;
        }
    }


    /*
    * 通过创建临时节点，避免了对头结点是否为空的判断，简化了流程！
    * */
    public static ListNode partition2(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode moreHead = new ListNode(0);
        ListNode less_ptr = lessHead;
        ListNode more_ptr = moreHead;

        while (head!=null){
            if (head.val < x){
                less_ptr.next = head;
                less_ptr = head;
            }
            else {
                more_ptr.next = head;
                more_ptr = head;
            }
        }
        less_ptr.next = moreHead.next;
        more_ptr.next = null;
        return less_ptr.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode head2 = partition1(head,3);
        while (head2 != null){
            System.out.println(head2.val);
            head2 = head2.next;
        }
    }
}
