# 快速排序

快速排序分为普通快排和随机快排

基本思想

- 综合和划分和递归这两种手段。
- 首先是划分 partition，然后是对剩余部分进行递归调用partition

写代码前的想法：

选取最后一个数，作为Partition的枢轴。

递归的操作：
- 首先，是选择枢轴
- 按照枢轴进行划分
- 获得等于区域的范围


- 对左侧部分进行划分
- 对右侧部分进行划分
- 返回最终的结果。


写代码的过程中，一定要保证思路是正确的。而代码，就是表示思路的清晰度。

思路不清晰，盲目写代码，之后导致自己瞎调试，浪费大量的时间。

所以，写代码的时候，一定要全神贯注。

| 时间 | 笔记 |
|---|---|
|2019.1.18 |快速排序，用到了递归。注意，这里的递归出口为： if(l > r)|
|   | 快速排序，用到的就是，划分！使用不断的划分，实现数组的有序|
|2019.2.21|再次注意，划分过程中，划分的边界条件为cur < more ! 不是 cur < right 或者 less < more |