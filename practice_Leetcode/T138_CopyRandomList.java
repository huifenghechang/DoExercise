import java.util.HashMap;

public class T138_CopyRandomList {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        if (head != null){
            HashMap<Node,Node> map = new HashMap<>();
            Node cur = head;

            while (cur != null){
                map.put(cur,new Node(cur.val,null,null));
                cur = cur.next;
            }

            cur = head;
            while (cur != null){
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            Node head1 = map.get(head);
            return head1;
        }else {
            throw  new IllegalArgumentException("The NodeList is empty");
        }
    }
}
