package code_11_IsPalindrome;

import java.util.Stack;

public class IsPalindrome_01_28 {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    // 需要N个单位长度的辅助空间
    public static boolean isPalindrome(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null) {
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 设置双指针来进行判断，采用 || 条件来对边界进行确定
    public static boolean isPalindrome2(Node head){
        if (head == null ||head.next == null){
            return true;
        }

        // 通过设置快慢指针来实现遍历链表，当快指针遍历完之后，慢指针打在靠近中点附件的位置。
        Node right = head.next;
        Node cur = head;
        // 这里将right的初始值指向第二个节点，cur的初始值指向第一个节点，能够保证当奇数个数字时，慢指针打在中点；偶数个时，慢指针打在右半部分第一个！
        while (cur.next != null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }

        Stack<Node> stack = new Stack<Node>();

        while (right != null){
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 通过原来数据的状态，来实现不适用额外空间。但是这种做法，需要最后还原原来的数据状态！
    public static boolean isPalindrome3(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        // 上述对n1,n2赋初始值，能够保证快指针达到终点时，慢指针打向中点。
        // 当为奇数个数字时，慢指针打在中点。当为偶数个数字时，慢指针打在前半部分的最后一个数字上。
        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;      // 慢指针
            n2 = n2.next.next;// 快指针
        }

        // 更改指针
        n2 = n1.next; // 后半部对称部分的起始节点
        n1.next = null; // 将中点的后序设置为空
        Node n3 = null; // n3 辅助节点
        while (n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        n3 = n1; // n1作为反转后的新链表的头结点，用n3作为临时变量来保存下

        n2 = head;// n2  作为原来链表的头结点
        boolean res = true;
        while (n1 != null && n2 != null){
            if (n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        n1 = n3.next; // n3为反转后的链表的头结点。
        n3.next = null;
        while (n1 != null) { // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }






}
