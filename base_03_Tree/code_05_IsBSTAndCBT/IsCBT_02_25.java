package code_05_IsBSTAndCBT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsCBT_02_25 {

    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;;
        }
    }

    // 判断是否为“搜索二叉树”
    /*
    * 按照“左、中、右”的顺序，中序遍历二叉树，
    * 若所得数据时按照升序排列的，则该树为“搜索二叉树”
    * */

    public static boolean isBST(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<>();
            Node pre = null;

            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    stack.push(head.right);
                }
            }
        }
        return  false;
    }


    /*宽度遍历二叉树：
    * 采用队列的结构来实现：
    * */
    public static void breadthTraversal(Node head){
        if (head != null){
            Queue<Node> queue = new LinkedList<Node>();
            queue.offer(head);

            while (!queue.isEmpty()){
                head = ((LinkedList<Node>) queue).pop();
                System.out.print(head.value + " , ");

                if (head.left != null){
                    queue.add(head.left);
                }

                if (head.right != null){
                    queue.add(head.right);
                }
            }
            System.out.println();
        }
    }

    // 宽度遍历，判断一棵树是否为完全二叉树
    public static boolean isCBT(Node head){
        if (head == null){
            return true;
        }

        // 层次遍历二叉树
        Queue<Node> queue = new LinkedList<Node>();
        boolean leaf = false;
        Node left = null;
        Node right = null;
        queue.offer(head);

        while (!queue.isEmpty()){
                Node node =  queue.poll();
                left = node.left;
                right = node.right;

                // leaf && (left != null ||right != null 判断条件，对应第二种情况。
                if ((leaf && (left != null ||right != null))
                        ||
                        (left== null && right != null)) {
                    return false;
                 }

                // 宽度遍历代码，将其加入到队列中~
                if (left != null){
                    queue.offer(left);
                }
                if (right != null){
                    queue.offer(right);
                }

                // 此条判断对应情况2，此时，每个后续每个节点必须为叶子节点
                if (left == null || right ==null){
                    leaf = true;
                }
            }
        return true;
    }

    public static void main(String[] args){
        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.right = new Node(3);
        head1.left.left = new Node(4);
        head1.left.right = new Node(5);
        head1.right.left = new Node(6);
        head1.right.right = new Node(7);
        System.out.println("============层次遍历=============");
        breadthTraversal(head1);

        Node head2 = new Node(4);
        head2.left = new Node(2);
        head2.right = new Node(6);
        head2.left.left = new Node(1);
        head2.left.right = new Node(3);
        head2.right.left = new Node(5);
        System.out.println(isCBT(head2));



    }

}
