package code_01_PreInPosTraversal;

import java.util.Stack;

public class PreInPosTraversal_unrecursive_19_02_24 {

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /*
     * 前序遍历，实现的是“中，左，右”
     *
     * 前提是：
     *  在二叉树的根节点不为空的前提下：
     *      首先，将根节点加入栈中：
     *  接下来做的是：“当栈不为空时的前提下”
     *          弹出栈顶：
     *              若右孩子不为空，则将右孩子加入栈中；
     *              若左孩子不为空，则将左孩子加入栈中；
     *  因为是要先打印左孩子，后打印右孩子，所以要将右孩子先入栈
     * */
    public static void preTraversal(Node head) {
        System.out.println("pre - Order");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);

            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");

                if (head.right != null) {
                    stack.push(head.right);
                }

                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /*中序遍历
    *
    * 基本的逻辑如下：
    *  当节点不为空时，当前节点加入栈中，并把该节点的左边界加入栈中；
    *  当节点为空时，栈顶弹出，并将弹出节点的右边界加入栈中。
    * */

    public static void inOrderTraversal(Node head){
        System.out.println("in - Order");
        if (head != null){
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null){
                // 此处循环的目的，是将head节点的左边界，加入到栈中。
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    // 若遍历到左边界的最底层，则回到其父节点，并将其右孩子加入到节点中。
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /*后序遍历
    *
    * 后序遍历的实现要比前两种要难一些，这是为什么呢？
    *
    *  ---
    *  因为先序和中序，会访问一个节点两次；
    *  但是后序遍历，要求的是，你在第三次访问这个节点的时候打印！
    *
    *  ---
    * 利用两个栈来实现后序遍历：
    *
    * 因为前序遍历的顺序为：中，左，右。 将其转换下顺序，可以轻松实现，中，右，左。
    * 最后，将其逆序，便可实现 左，右，中。即后序排序 ~
    *
    * */

    public static void posOrderTraversal(Node head){
        System.out.println("pos - Order - org");
        if (head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            // 首先，针对二叉树，进行“类前序遍历”
            stack1.add(head);

            while (!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);

                if (head.left != null){
                    stack1.push(head.left);
                }

                if (head.right != null){
                    stack1.push(head.right);
                }
            }

            // 最后，将stack2打印出来即可：
            while (!stack2.isEmpty()){
                System.out.print(stack2.pop().value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        // unrecursive
        System.out.println("============unrecursive=============");
        preTraversal(head);
        inOrderTraversal(head);
        posOrderTraversal(head);
    }
}