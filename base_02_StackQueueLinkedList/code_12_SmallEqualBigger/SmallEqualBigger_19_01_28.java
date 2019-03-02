package code_12_SmallEqualBigger;

public class SmallEqualBigger_19_01_28 {
    public static class Node{
        public int data;
        public Node next;

        public Node(int data){
            this.data = data;
        }
    }

    public static Node divideLinkedList(Node head, int pivot){
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null; // save next node


        // 这一段的循环，需要注意！
        // 应该为： next = head.next;
        //            head.next = null; head = next;

        while (head != null){
            // 当data小于pivot时，分两种情况处理。
            next = head.next;
            head.next = null; // 搞不懂，为什么这里要把head.next设置为空？将head.next设置为空，是为了防止将head的next指针传递给sT、sH等指针！！！
            if ( head.data < pivot){
                if (sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = head;
                }
            }

            if (head.data == pivot){
                if (eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }

            if (head.data > pivot){
                if (bH == null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = head;
                }
            }
//            head = head.next;
            head = next;
        }

        // 将三段的链表相连接

        // 小于段与等于段之间连接
        if (sT != null){
            sT.next = eH;
            //该部分判断等于区域是否存在，若不存在，则使得eT的指针直接指向sT的指针。
            eT = eT == null ? sT : eT;
        }

        // 将等于段与大于段之间连接
        if(eT != null){
            eT.next = bH;
        }

        // 返回 拼接好的三段的头指针
        if (sH != null){
            return sH;
        }else if (eH !=null){
            return eH;
        }else {
            return bH;
        }
    }

    public static void printNodeList(Node node){
        System.out.println("Linked list:");
        while (node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args){
        Node head1 = new  Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printNodeList(head1);
        head1 = divideLinkedList(head1,5);
        printNodeList(head1);

    }


}

