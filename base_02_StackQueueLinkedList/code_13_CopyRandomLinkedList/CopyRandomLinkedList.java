package code_13_CopyRandomLinkedList;

import java.util.HashMap;

public class CopyRandomLinkedList {
    public static class Node{
        int data;
        Node next;
        Node random;

        public Node(int data){
            this.data = data;
        }
    }

    public static Node copyRandomLinkedList1(Node head){

        // 采用hash表来实现数据的复制
        HashMap<Node,Node>  myHashMap = new HashMap<Node,Node>();
        Node cur = head;
        while (cur != null){
            myHashMap.put(cur,new Node(cur.data));
            cur = cur.next;
        }
        // 第二次遍历，实现对新建链表中指针的指引，妙！！！
        cur = head;
        while (cur != null){
            myHashMap.get(cur).random = myHashMap.get(cur.random);
            myHashMap.get(cur).next = myHashMap.get(cur.next);
            cur = cur.next;
        }
        return myHashMap.get(head);
    }

    public static Node copyListWithRandom(Node head){
        if (head == null){
            return null;
        }
        Node cur = head;
        Node next = null;

        // create new nodes in Linked List
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.data);
            cur = next;
        }

        // linked the new Nodes
        cur = head;
        Node copyCur = null;
        while ( cur != null){
            next = cur.next.next;
            copyCur = cur.next;
            // cur.random.next 表示为复制链表中的节点
            copyCur.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        while (cur != null){
            next = cur.next.next;
            copyCur = cur.next;
            cur.next = next;
            copyCur.next = next ;
        }
        return res;
    }
}
