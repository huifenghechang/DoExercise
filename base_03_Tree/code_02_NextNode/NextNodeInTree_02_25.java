package code_02_NextNode;

public class NextNodeInTree_02_25 {

    public static class Node{
        int value;
        Node left;
        Node right;
        Node parent;
        public Node (int data){
            this.value = data;
        }
    }

    /*
    * 在二叉树中：
    *       将中序遍历的下一个节点，叫做某棵树节点的后继；
    *       将中序遍历的上一个节点，叫做该节点的前驱；
    *
    * 在这里，主要将节点分成两类：
    *
    *       若该节点有右子树，则后继为该右子树的最左边的孩子节点 。
    *       若该节点没有右子树，往上找，找到当前节点是其父节点的左孩子，那个parent节点就是原始节点的后继。
    * */


    public static Node findNextNode(Node node){
        if (node == null){
            return node;
        }
            // 若当前节点存在右子树的情况下：
        if (node.right != null){
            return getMostLeftNode(node.right);
        }else {
            // 当前节点不存在有字数的情况下，当前节点向上寻找。
            // 若节点为其父节点的左孩子，则，其父节点为原始节点的后继。
            Node parent = node.parent;
            while (parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    // 返回二叉树的最左边的节点
    public static Node getMostLeftNode(Node node){
        if (node == null){
            return node;
        }
        // while的作用，判断加循环。这里的循环条件为：节点的左孩子不为空！
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + findNextNode(test).value);

        test = head.left.left.right;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + findNextNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + findNextNode(test));
    }
}
