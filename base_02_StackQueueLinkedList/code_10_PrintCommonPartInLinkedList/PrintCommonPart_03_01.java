package code_10_PrintCommonPartInLinkedList;
/*
* 编程心得：
*
* 复习这一题时，没有看清楚题目。题中是打印两个有序链表的部分。
* 而我自己编程是，看成了打印两个链表的公共部分。
*
* 这一题中，得到的经验是：
*
* 在链表中，遍历的循环条件是：cur指针是否为空！
*
* */
public class PrintCommonPart_03_01 {

    public static class Node {
        int value;
        Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int getLength(Node head){
            int count = 0;
            while (head != null){
                head = head.next;
                count++;
            }
            return count;
        }

    public static Node getSameNode(Node head1,Node head2){
        Node p1 = null;
        Node p2 = null;
        int len1 = getLength(head1);
        int len2 = getLength(head2);

        p1 = len1 > len2 ? head1 : head2; // p1指向较长链表
        p2 = len1 < len2 ? head1 : head2; // p2指向较短链表

        for (int i = 0 ; i < Math.abs(len1 - len2); i++){
            p1 = p1.next;
        }

        while (p1 != null && p2 != null){
            if (p1 != p2){
                p1= p1.next;
                p2 = p2.next;
            }else {
                return p1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = node1.next;

        printLinkedList(node1);
        printLinkedList(node2);
        printLinkedList(getSameNode(node1,node2));
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }



}
