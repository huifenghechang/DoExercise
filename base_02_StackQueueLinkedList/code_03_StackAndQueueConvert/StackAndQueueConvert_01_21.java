package code_03_StackAndQueueConvert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert_01_21 {
    public static class TwoStacksQueue {
        private Stack<Integer> stackPush = new Stack<>();
        private Stack<Integer> stackPop = new Stack<>();

        public void push(int pushInt){
            stackPush.push(pushInt);

        }
        public TwoStacksQueue(){
           this.stackPush.push(5);
            this.stackPush.push(4);

        }
        // 使用两个栈来实现队列的功能。
        public Integer peek(){
            if (stackPop.empty()&&stackPush.empty()){
                throw new RuntimeException("Queue is empty");
            }else if (stackPop.empty()){
                convert();
            }
            return stackPop.peek();
        }

        public Integer pop(){
            if (stackPop.empty()&&stackPush.empty()){
                throw new RuntimeException("Queue is empty");
            }else {
                convert();
            }
            return stackPop.pop();

        }

        public  void convert(){
            if (!stackPop.isEmpty()){
                return;
            }else {
                while (!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }
    }

    public static class TwoQueueStack{
        private static Queue<Integer> queue;
        private static Queue<Integer> help;

        public TwoQueueStack(){
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int pushInt){
            queue.add(pushInt);
        }

        public int pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;
        }

        public int peek(){
            if (queue.isEmpty()){
                throw new RuntimeException("Stack is empty");
            }
            while (queue.size() != 1){
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);

            return res;
        }

        //通过调用两个栈的指针，来实现数据状态的跟踪，保证queue指向现有的所有数字。
        private void swap(){
            Queue<Integer> tmp = help;
            help = queue;
            queue = tmp;
        }
    }
    public static void main(String[] args){
        TwoStacksQueue queue= new TwoStacksQueue();
        System.out.println("the peek of queue is" +queue.peek());
    }
}
