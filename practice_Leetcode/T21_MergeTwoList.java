public class T21_MergeTwoList {
    public  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode mergeTwoLists_03_24_X1(ListNode l1, ListNode l2) {
        ListNode newH = new ListNode(-1);
        ListNode newT = newH;
        ListNode next = null;
        while (l1!= null && l2 !=null){
            if (l1.val < l2.val){
                next = l1.next;
                l1.next = null;
                newT.next = l1;
                newT = l1;
                l1 = next;
            }else {
                next = l2.next;
                l2.next = null;
                newT.next = l2;
                newT = l2;
                l2 = next;
            }
        }
        if (l1!=null){
            newT.next = l1;
        }

        if (l2 != null){
            newT.next = l2;
        }
        return newH.next;
    }

/*
* 编程心得：
*
* 在合并节点的时候，对于插入的节点，其指针信息可以不用清空，因为会在后面的连接中，被覆盖掉。
* */
    public ListNode mergeTwoLists_03_24_X2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        while (l1!= null && l2!=null){
            if (l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if (l1 != null){
            pre.next = l1;
        }
        if (l2 != null){
            pre.next = l2;
        }
        return dummyHead.next;
    }
}
