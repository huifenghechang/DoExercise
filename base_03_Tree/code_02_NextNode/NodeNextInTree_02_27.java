package code_02_NextNode;

public class NodeNextInTree_02_27 {

    public static class Node{
        Node left;
        Node right;
        Node parent;
        int value;

        public Node (int value){
            this.value = value;
        }
    }

    public static Node getNextNode(Node head){
        if (head == null){
            return null;
        }

        if (head.right != null){
            return getLeftestNode(head.right);
        }else {
            // 当节点 X 没有右孩子时,node 为当前节点.后序节点为当前节点X的祖先节点
            Node node = head;
            Node parent = node.parent;

            while (node.parent != null && node != parent.left){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftestNode(Node node){
        if (node == null){
            return null;
        }
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

}
