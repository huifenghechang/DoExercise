package code_01_PreInPosTraversal;

public class PreInPosTraversal_recursion_02_24 {
    // 定义二叉树的节点
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        // 二叉树节点的构造函数
        public Node(int data){
            this.value = data;
        }
    }

    public static void preOrderTraversal(Node head){
        if (head == null){
            return;
        }
        System.out.print(head.value + " ");
        preOrderTraversal(head.left);
        preOrderTraversal(head.right);
    }

   public static void inOrderTraversal(Node head){
        if (head == null){
            return;
        }
        inOrderTraversal(head.left);
        System.out.print(head.value + " ");
        inOrderTraversal(head.right);
   }

   public static void posOrderTraversal(Node head){
        if (head == null){
            return;
        }
        posOrderTraversal(head.left);
        posOrderTraversal(head.right);
        System.out.print(head.value + " ");
   }

   public static void main(String[] args){
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node((4));

       // recursive
       System.out.println("==============recursive==============");
       System.out.print("pre-order: ");
       preOrderTraversal(head);
       System.out.println();
       System.out.print("in-order: ");
       inOrderTraversal(head);
       System.out.println();
       System.out.print("pos-order: ");
       posOrderTraversal(head);
       System.out.println();

   }
}
