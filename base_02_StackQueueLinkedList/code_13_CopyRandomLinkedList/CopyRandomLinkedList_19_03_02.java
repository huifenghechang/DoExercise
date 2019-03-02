package code_13_CopyRandomLinkedList;

import java.util.HashMap;

public class CopyRandomLinkedList_19_03_02 {

    // 方法一： 利用HashMap，来建立链表节点X与节点X`之间的关系。然后在通过next指针，建立后序的关系

    public static class Node{
        int value;
        Node next;
        Node random;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node copyRandomLinkedList1(Node head){
        if (head == null ){
            return null;
        }
        HashMap<Node,Node> nodeMap = new HashMap<>();
        Node cur = head;
        while (cur!= null){
            nodeMap.put(head,new Node(cur.value));
            cur = cur.next;
        }

        // 根据原表的next指针以及HashMap的关系，实现对复制链表的指向
        cur = head;
        Node copyNode = null;
        while (cur != null){
            copyNode = nodeMap.get(cur);
            copyNode.next = nodeMap.get(cur.next);
            copyNode.random = nodeMap.get(cur.random);
            cur = cur.next;
        }
        return nodeMap.get(head);
    }

    // 使用空间复杂度为O(1)的方法实现链表的复制
    public static Node copyRandomLinkedList2(Node head){
        if (head == null){
            return null;
        }

        Node cur = head;
        Node next = null;

        // 创建一个混合链表
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur = next;
        }

        // 根据对应的关系，实现next与random指针的指向
        cur = head;
        Node copyNode = null;
        while (cur != null){
            next = cur.next.next;
            copyNode = cur.next;
            copyNode.next = cur.next.next;
            // 注意，在涉及到指针的指针时，一定要保证该指针不为空，不然会空指针异常错误。
            copyNode.random = copyNode.random != null?cur.random.next:null;
            cur = next;
        }
        Node res = head.next;
        // 将混合链表分离为两个链表：

        cur = head;
        Node copyNext = null;

        // 结合画图来做，会比较合适 ~
        while (cur != null){
            next = cur.next.next;
            copyNext = cur.next;

            cur.next = next;
            copyNext.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}
