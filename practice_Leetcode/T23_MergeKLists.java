import java.util.*;

public class T23_MergeKLists {

    public  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /*
    * 编程心得：
    * 使用Collection中的sort方法。
    * 需要练习使用容器的用法。
    * */
    public ListNode mergeKLists1(ListNode[] lists) {
        ArrayList<ListNode> arrayList = new ArrayList<>();
        for (int i=0; i< lists.length;i++){
            while (lists[i] != null){
                arrayList.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        Collections.sort(arrayList, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        for (int i = 0; i< arrayList.size();i++){
            int x = arrayList.get(i).val;
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        return dummyHead.next;
    }

/*
* 总结一下，使用二分法的套路。
* 二分法，其实就是不断的递归求解。
* 本题需要总结一下Java中集合的用法：
*    使用Collection来实现自定义对象的排序，
*
* */

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        if (lists.length == 1){
            return lists[0];
        }
        if (lists.length == 2){
            return mergeTwoLists(lists[0],lists[1]);
        }

        int mid = lists.length / 2;
        ListNode[] left = new ListNode[mid];
        ListNode[] right = new ListNode[lists.length - mid];

        for (int i= 0 ; i< mid; i++){
            left[i] = lists[i];
        }

        for (int i= mid; i < lists.length;i++){
            right[i - mid] = lists[i];
        }

        ListNode l1 = mergeKLists2(left);
        ListNode l2 = mergeKLists2(right);
        return mergeTwoLists(l1,l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (l1!= null && l2!= null){
            if (l1.val < l2.val){
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        if (l1!=null){
            tail.next = l1;
        }
        if (l2!=null){
            tail.next = l2;
        }
        return dummyHead.next;
    }
}
