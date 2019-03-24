import java.util.HashSet;
import java.util.Set;

public class T141_DetectCycle_I {
    public  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (!set.contains(head)){
                set.add(head);
            }else {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
