package code_02_GetMinStack;
/*
* 心路历程
*
* 今天晚上，一个简单的leetCode 题目，就搞了一个晚上。这效率实在是太低啦！！！
*
* 总结下，还是自己注意力不集中。以及分析问题的时候，思路不够清晰所导致的。
*
* 在不清晰的思路下，写出的代码报错。进而不想找根源，而是对比代码，最后造成自己没有解题的窘境。
*
* 这样的情况下，刷题的效率实在太低啦。。。不行，明天一定要给自己定一个目标和学习的基本步骤。
*
*  - - -
*  初步计划：
*    - 在课件上，找到题目。直接根据题目来思考。
*     - 如果不会，就去看书。看书不会，就去看视频。
*
*     嗯嗯，就这样~
*
* */
import java.util.Stack;

public class GetMinStack_02_28 {

    class MinStack {
        public Stack<Integer> dataStack;
        public Stack<Integer> minStack;

        public MinStack() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int x) {
            if (minStack.isEmpty() || x < getMin()){
                minStack.push(x);
            }else {
                minStack.push(getMin());
            }
            dataStack.push(x);
        }

        public void pop() {
            if (dataStack.isEmpty()){
                throw new RuntimeException("The stack is empty");
            }
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            if (minStack.isEmpty()){
                throw  new RuntimeException("the stack is empty");
            }
            return minStack.peek();
        }
    }

}
