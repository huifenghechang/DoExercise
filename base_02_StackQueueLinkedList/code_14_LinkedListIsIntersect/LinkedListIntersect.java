package code_14_LinkedListIsIntersect;

import java.util.HashMap;

public class LinkedListIntersect {

    public static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public Node getFirstIntersectNode(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return null;
        }

        // 判断是否为环状
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        // 三种情况，一单链表，一环状链表情况下，不可能相交
        if (loop1 == null && loop2 == null){
            return noLoop(head1,head2);
        }

        if (loop1 != null && loop2 != null){
            return bothLoop(head1,loop1,head2,loop2);
        }

        return null;
    }

    // 该函数的功能，是判断某一单链表节点，是否存在环。若有，则返回第一个环节点。
    // 通过返回的节点，可以判断链表，是否为带环。
    /*判断一个单链表，是否存在环，有两种方法：
    * 方法一：将链表中的节点，加入到字典Map中；
    * 方法二：设置一快一慢两指针，第一次相遇的节点，就是第一个相交节点。
    * */
    public static Node getLoopNode(Node head){
        HashMap<Node,Node> map = new HashMap<>();

        while (head != null){
            map.put(head,head);
            if (map.containsKey(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }

    // 两个无环单链表之间的交点，从最后一个节点开始往前回溯。
    public static Node noLoop(Node head1, Node head2){
        Node curA = head1;
        Node curB = head2;
        int lenA = 0;
        int lenB = 0;

        // 标记尾结点
        while (curA.next != null){
            lenA = lenA + 1;
           curA = curA.next;
        }

        while (curB != null){
            lenB = lenB + 1;
            curB = curB.next;
        }

        // 若两个链表的最后一个节点不等，则不相交
        if (curA != curB){
            return null;
        }

        // 长链表指针先走abs(N - M)步

        curA = head1;
        curB = head2;
        int gap = lenA > lenB ? lenA - lenB : lenB - lenA;
        if (lenA > lenB){
            while (gap > 0){
                curA = curA.next;
                gap --;
            }
        }else {
            while (gap > 0){
                curB = curB.next;
                gap --;
            }
        }

        // A 、B 两链表，到达一样长度的时候，同步走。第一次相遇，即为第一个相交节点
        while (curA != curB){
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }

    // 两个有环单链表之间的相交，一共有三种情况。根据这三种情况，分别作处理
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){

        // 当两者的环节点相同时，按照求两个无环单链表之间交点的方法来求解。
        if (loop1 == loop2){
            Node cur1 = head1;
            Node cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            // 当两者并无相同的环节点时
            Node cur1 = loop1.next;
            while (cur1.next != loop1){
                if (cur1 == loop2){
                    return cur1;
                }
                cur1 = cur1.next;
            }
        }
        return null;

    }


    //判断单链表是否为环状
    public static void main(String[] args){

    }

}
