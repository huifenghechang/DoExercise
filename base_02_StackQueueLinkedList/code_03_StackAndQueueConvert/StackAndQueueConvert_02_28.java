package code_03_StackAndQueueConvert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
* 编程心得总结：
* 00: 两个队列交换之后，次序保持不变，但两个栈交换之后，次序发生改变。
* 01：变量的命令。尽量和其功能匹配，这样子会便于理解。
* 02: 在本题中，队列的功能，尽量要明确。每次出栈之后，保证dataStack始终指向有数据的那一个队列，可以简化编程。
*
* */
public class StackAndQueueConvert_02_28 {

    // 值得注意的是LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
    public static class StackByQueue{
        Queue<Integer> dataQueue;
        Queue<Integer> helpQueue;

        public StackByQueue(){
            this.dataQueue = new LinkedList<Integer>();
            this.helpQueue = new LinkedList<Integer>();
        }

        public void push(int x){
            dataQueue.offer(x);
        }

        public int pop(){
           if (dataQueue.isEmpty()){
               throw new RuntimeException("The stack is empty");
           }
           while (dataQueue.size()!= 1){
               helpQueue.offer(dataQueue.poll());
           }
           int returnValue = dataQueue.poll();
           swap();
           return returnValue;
        }

        //
        public int peek(){
            if (dataQueue.isEmpty()){
                throw  new RuntimeException("the stack is empty");
            }
            while (dataQueue.size() != 1){
                helpQueue.offer(dataQueue.poll());
            }
            int peekValue = dataQueue.poll();
            helpQueue.offer(peekValue);
            swap();
            return peekValue;
        }

        // 保证dataQueue指针，始终指向有数字的一个队列中。
        public void swap(){
            Queue<Integer> tmp = helpQueue;
            helpQueue = dataQueue;
            dataQueue = tmp;
        }
    }
    
    public static class QueueByStack{
        Stack<Integer> offerStack;
        Stack<Integer> popStack;
        
        public QueueByStack(){
            this.offerStack = new Stack<>();
            this.popStack = new Stack<>();
        }

        public void offer(int x){
            offerStack.push(x);
        }

        public int pop(){
            if (popStack.isEmpty()&&offerStack.isEmpty()){
                throw new RuntimeException("The queue is empty");
            }

            if (popStack.isEmpty()){
                pollToPopStack();
            }
            return popStack.pop();
        }

        public int peek(){
            if (popStack.isEmpty()&&offerStack.isEmpty()){
                throw new RuntimeException("The queue is empty");
            }
            if (popStack.isEmpty()){
                pollToPopStack();
            }
            return popStack.peek();
        }

        public void pollToPopStack(){
            if (offerStack.isEmpty()){
                return;
            }else {
                while (!offerStack.isEmpty()){
                    popStack.push(offerStack.pop());
                }
            }
        }
    }

    public static void main(String[] args){
        /*StackByQueue stack= new StackByQueue();
        addNumIntoStack(stack);
        for (int k = 1 ; k < 6; k++){
            System.out.println(stack.pop());
        }*/

        QueueByStack queue = new QueueByStack();
        offerNumIntoQueue(queue);
        for (int k = 1 ; k < 6; k++){
            System.out.println(queue.pop());
        }


    }

    public static void addNumIntoStack(StackByQueue stack){
        for (int x = 1; x < 6; x ++){
            stack.push(x);
        }
    }

    public static void offerNumIntoQueue(QueueByStack queue){
        for (int x = 1; x < 6; x ++){
            queue.offer(x);
        }
    }

    public static void printStack(){

    }

}
