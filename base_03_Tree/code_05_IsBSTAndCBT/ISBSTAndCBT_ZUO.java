package code_05_IsBSTAndCBT;

import java.util.LinkedList;
import java.util.Queue;

public class ISBSTAndCBT_ZUO {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        boolean res = true;

        Node pre = null;
        Node cur1 = head;
        Node cur2 = null; // 辅助变量，用于控制循环逻辑和流程

        while (cur1 != null) {
            cur2 = cur1.left;   // ---> 头结点的左孩子
            if (cur2 != null) { // 当cur1 存在左孩子是，需要处理之
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;  // -----> 左子树的最右边节点
                }
                if (cur2.right == null) { // 这种情况下，是cur2到达左孩子最右边节点的底部时，所做的处理
                    cur2.right = cur1;  // 利用cur2的空间，临时存储一下curl的值
                    cur1 = cur1.left;  // cur1 下移到左子树的根节点
                    continue;// 此时，后面的语句不执行，结束本层的本次循环 ~
                } else {
                    cur2.right = null;
                }
            }
            // 当cur1不存在左孩子时，只需要将根节点和其右孩子想比较即可
            // 扫描第一个节点时，pre的指针指向的为空，所以无需比较
            if (pre != null && pre.value > cur1.value) {
                res = false;
            }

            // 前面所做的所有操作，目的是为了定位到pre指针，指向遍历中的数字。
            // pre时相对于cur1而言的。
            pre = cur1; // 根节点
            cur1 = cur1.right; // 右孩子
        }

        return res;
    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<Node>();
        boolean leaf = false;

        Node l = null;
        Node r = null;
        queue.offer(head);

        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));
        System.out.println(isCBT(head));

    }
}
