### 判断一个链表是否为回文结构

【题目】 

给定一个链表的头节点head，请判断该链表是否为回
文结构。 例如： 1->2->1，返回true。 1->2->2->1，返回true。
15->6->15，返回true。 1->2->3，返回false。

进阶： 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂
度达到O(1)。

| 时间 | 笔记 |
|---|---|
|2019.03.01|  判断回文结构|
|技巧：|关于链表的问题，结构很简单，大部分都是时间复杂度为O(n).在实现过程中，可以考虑用辅助空间结构。|
|解法一：|使用一个栈，将链表入栈。然后再次遍历和出栈，判断每个位置的数字是否相同|
|解法二：|设置快慢两个指针。快指针走两步，慢指针走一步。最后慢指针会指向链表中点。将后序部门用栈存储，然后对比即可。|
|解法三：|设置快慢指针，将后半部分逆序，然后再次比较，最后还原即可。|