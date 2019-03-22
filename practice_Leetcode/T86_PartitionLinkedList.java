public class T86_PartitionLinkedList {

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
