public class T160_IntersectionOfTwoLinkedLists {

    public  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        if (lenA > lenB){
            headA = forward_long_list(headA,lenA,lenB);
        }else {
            headB = forward_long_list(headB,lenB,lenA);
        }

        while (headA!=null&&headB!=null){
            if (headA == headB){
                return headA;
            }else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    public int getLength(ListNode head){
        int count = 0;
        while (head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode forward_long_list(ListNode longList,int longLen, int shortLen){
        int steps = longLen - shortLen;
        while (steps > 0 && longList!=null){
            longList = longList.next;
            steps--;
        }
        return longList;

    }


    /*
    * 编程心得
    * 遍历链表，一定要保证其指针不为空。
    * 其次，在对于A和B的操作中，使用子函数forward来进行，可以保证其代码更加简洁。
    *
    * */
}
