
### 二叉树的遍历 


| 时间 | 笔记 |
|---|---|
|2019年2.24日|-----|
|二叉树的递归遍历|---|
| ---|递归条件：当节点不为空时，则递归调用，为空时，则返回|
|---|递归函数的主体是打印节点的值，以及对左右孩子节点递归调用该函数。|


| 时间 | 笔记 |
|---|---|
|二叉树的先序遍历- 非递归版|在非递归遍历中，由于需要返回节点走过的路径，所以，栈结构是必须要用到的数据结构|
|前序遍历：|---|
|   |当根节点不为空时，首先将根节点加入栈中。|
|   |在栈不为空的情况下，进行如下操作：|
|   |弹出栈顶元素，并分别将右孩子和做孩子加入栈中。|
|   |在上述操作中，每一轮循环，都会在弹出一个根节点时，同时将其右孩子和左孩子入栈。|


| 时间 | 笔记 |
|---|---|
|2019.2.24日|二叉树的中序遍历-非递归版|
|---|---|
|---|---|
