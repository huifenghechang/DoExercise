package code_07_ReverseList;
/*
* 编程心得：
*    在写边界条件的代码时，一定要好好的思考，仔细检查。
*    很多时候，基本的思路是不错的，但是就是由于没有仔细分析好边界条件，导致自己做错啦。
* */
public class ReverseList_02_28 {
    public static class Node{
        int value;
        Node next;

        public Node(int data){
            this.value = data;
        }
    }

    public static Node reverseList(Node head){
        Node pre = null;
        Node cur = head;

        // 边界条件错误
        while (cur.next != null){
            Node next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 当到达尾结点时，head指针指向最后一个节点
        cur.next = pre;
        return cur;
    }

    public static void main(String[] args){
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        printLinkedList(reverseList(head1));
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
}
