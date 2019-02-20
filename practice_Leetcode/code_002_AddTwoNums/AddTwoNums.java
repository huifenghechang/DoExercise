package code_002_AddTwoNums;

import utils.Util;

/*
* 卡住了，看来还是链表的操作不够熟练啊···
*
* 下午最后一个小时，来编写这道题目，发现运行起来是有错误的。
*
* */
public class AddTwoNums {

    // 定义链表节点
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

    public static ListNode addTwoNums(ListNode l1, ListNode l2){
        int value1 = recoverToDecimal(l1);
        int value2 = recoverToDecimal(l2);

        int len1 = getListLength(l1);
        int len2 = getListLength(l2);
        ListNode res = splitDecimalToList(value1+value2,len1,len2);

        while (res != null){
            System.out.print(res.val);
            res = res.next;
        }

        return res;
    }

    public static int getListLength(ListNode list){
        int counter = 0;
        ListNode node = list;
        while (node != null){
            counter ++;
            node = node.next;
        }
        return counter;
    }

    public static int recoverToDecimal(ListNode list){
        int listLen = getListLength(list);
        int value = 0;
        ListNode curNode = list;
        for (int i=0; i < listLen; i++){
            value += curNode.val * 10 ^ (i);
            curNode = curNode.next;
        }
        return value;
    }

    public static ListNode splitDecimalToList(int value,int len1, int len2){
        int len = Math.max(len1,len2) + 1;

        // 相加后的链表，最后的长度只可能为两者的最大长度加一
        if( value / (10^(len)) == 0){
            len = len - 1;
        }

        // 创建链表的第一个节点，将数字加入链表中，并返回值 ！
        ListNode p = new ListNode(0);
        ListNode head = p;
        for (int k = 0; k < len; k++){
            // 新建节点
           p.next = new ListNode(value / (10 ^ (len -1)));
           p = p.next;
        }
        return head.next;
    }

    public static void main(String[] args){

        // 创建链表 L1
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // 创建链表 L2
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        addTwoNums(l1,l2);



    }


}
