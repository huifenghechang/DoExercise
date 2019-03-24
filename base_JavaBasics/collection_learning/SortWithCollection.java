package collection_learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortWithCollection {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
        List<ListNode> list = new ArrayList<>();
        for (int i = 0; i< 16; i++){
            list.add(new ListNode(i*i - 10*i + 4));
        }
        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        System.out.println("The sorted queue is :");
        for (ListNode node : list){
            System.out.print(node.val + ",");
        }
    }
}
