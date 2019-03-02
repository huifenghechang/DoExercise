package code_11_IsPalindrome;
/*编程心得：
*
*   写程序，真的是锻炼思维严谨性最好的办法。
*   知道了基本的思路，到把程序真正的实现出来，还需要很远的距离。
*   这道题目，花了一晚上的时间。发现了Bug。
*   原因出在循环结构上。
*    while (head != null && head2!=null){
            if (head.value != head2.value){
                isPa = false;
                break;     // 此处在之前，缺少了一个中断循环的命令
            }else {
                head = head.next;
                head2 = head2.next;
            }
        }
*
*  当循环中出现了自己要捕捉的情况是，一定要及时跳出循环。之前就是因为没有写break而造成程序报错。
*
*
*  其次，一定要等到思路和步骤都想的十分清楚了，再着手写代码，不然花费在条Bug，找逻辑错误上面的时间，真的是得不偿失！
* */
public class IsPalindrome_03_01 {

    public static class Node{
        int value;
        Node next;
        public Node(int data){
            this.value = data;
        }
    }

// 在设计快慢指针扫描链表时，重要的是慢指针。慢指针会指向链表的中点
    public static boolean isPalindrome(Node head){
        boolean isPa = true;
        if (head == null || head.next == null){
            return true;
        }

        Node orgHead = head;
        Node slow = head;
        Node fast = head;

        // 使用快慢指针来扫描链表
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next; // 因为需要保证fast.next.next不为空，所以必须要保证fast.next不为空。。
        }

        // 扫描完毕后，slow节点的下一个节点，即为后半部分对称的起点
        Node midNode = slow;
        Node head1 = slow.next; // 翻转前链表的指针；
        slow.next = null;

        // 链表翻转之后，新的头结点为原来链表的尾结点
        Node head2 = reverseList(head1);
        Node head_2 = head2;

        printLinkedList(head2);
        // 此处我的判断条件为: while(head != midNode)。亦可以
        while (head != null && head2!=null){
            if (head.value != head2.value){
                isPa = false;
                break;     // 此处在之前，缺少了一个中断循环的命令
            }else {
                head = head.next;
                head2 = head2.next;
            }
        }

        // 将链表复原到原状态
        Node recoverHead = reverseList(head_2);
        midNode.next = recoverHead;
        printLinkedList(orgHead);
        return isPa;
    }

    public static Node reverseList(Node head){
        Node pre = null;
        while (head != null){
            Node next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args){
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(2);
        head1.next.next.next.next= new Node(1);
        printLinkedList(head1);
        System.out.println(isPalindrome(head1));
        printLinkedList(head1);
//        printLinkedList(reverseList(head1));
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
