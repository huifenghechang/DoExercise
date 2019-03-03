package code_05_IsBSTAndCBT;
import code_01_PreInPosTraversal.PreInPosTraversal_recursion_19_02_24.Node;

// 递归版，设置一个节点来存储上一次遍历的值。
public class IsBST_02_27 {

    public static boolean isBSTInOrder1(Node head){
        Node prev = new Node(Integer.MIN_VALUE);
        return isBSTOrdererHelper(head,prev);
    }

    public static boolean isBSTOrdererHelper(Node head, Node pre){
        if (head == null){
            return true;
        }
        if (isBSTOrdererHelper(head.left,pre)){
            if (head.value > pre.value){
                pre = head;
                return isBSTOrdererHelper(head.right,pre);
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
