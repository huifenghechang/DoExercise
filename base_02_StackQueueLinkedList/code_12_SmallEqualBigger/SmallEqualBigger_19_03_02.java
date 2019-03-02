package code_12_SmallEqualBigger;

import static utils.utils.printfArray;
import static utils.utils.swap;

public class SmallEqualBigger_19_03_02 {

    public static class Node {
        int value;
        Node next;
        public Node(int data){
            this.value = data;
        }
    }

    public static void netherLandsFlag(int[] arr,int num){
        if (arr == null){
            return;
        }

        int less = -1;
        int more = arr.length;
        int cur = 0;
        while (cur < more){
            if (arr[cur] < num ){
                swap(arr,++less,cur++);
            }else if (arr[cur] > num){
                swap(arr,--more,cur);
            }else {
                cur++;
            }
        }
    }

    public static Node netherLandsFlagsByLinkedList(Node head,int pivot){
        if (head == null){
            return null;
        }


        Node less = null;
        Node lessTail = null;
        Node equal = null;
        Node equalTail = null;
        Node more = null;
        Node moreTail = null;
        Node next = null;

        // 遍历链表，找到第一个小于、等于、大于pivot的节点
        // 将整个链表分成小于、等于、大于三个子链表。
        Node cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = null;
            if (cur.value < pivot ){
                if (less == null){
                    less = cur;
                    lessTail = cur;
                }else {
                    lessTail.next = cur;
                    lessTail = cur;
                }
            }else if (cur.value == pivot ){
                if (equal == null){
                    equal = cur;
                    equalTail = cur;
                }else {
                    equalTail.next = cur;
                    equalTail = cur;
                }
            }else if (cur.value > pivot ){
                if (more == null){
                    more = cur;
                    moreTail = cur;
                }else {
                    moreTail.next = cur;
                    moreTail = cur;
                }

            }
            cur = next;
        }


        // 首先，将小于段和等于段相连接
        if (less != null){
            lessTail.next = equal;
            equalTail = equalTail == null ? lessTail:equalTail;
        }

        // 将等于段和大于段相连接
        if (equal != null){
            equalTail.next =more;
        }

        if (less != null){
            return less;
        }else if (equal != null){
            return equal;
        }else {
            return more;
        }
    }

    public static void main(String[] args){
        /*int[] arr = new int[]{1,3,4,5,3,4,9,-5};
        netherLandsFlag(arr,3);
        printfArray(arr);*/
        Node head1 = new  Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printNodeList(head1);
        printNodeList(netherLandsFlagsByLinkedList(head1,5));
    }

    public static void printNodeList(Node node){
        System.out.println("Linked list:");
        while (node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
