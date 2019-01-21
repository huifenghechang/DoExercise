package code_01_ArrayToQueueAndStack;

public class Array_To_Stack_Queue {

    public static class ArrayStack{
        private Integer[] arr;
        private Integer size; // 已入栈的长度。初始为0

        public ArrayStack(int initSize){
            if(initSize < 0){
                throw new IllegalArgumentException("The initSize is less than 0");
            }
            arr = new  Integer[initSize];
            size = 0;
        }

        // peek,返回栈顶元素，但元素并不出栈
        public Integer peek(){
            if (size == 0){
                return null;
            }
            return arr[size-1];
        }

        // 入栈，入栈之前，需要检查是否满栈
        public void push(int obj){
            if (size == arr.length){
                throw new ArrayIndexOutOfBoundsException("The stack is full");
            }
            arr[size++] = obj;
        }

        // 出栈。出栈之前，需要检查是否为空栈
        public Integer pop(){
            if (size == 0){
                throw new ArrayIndexOutOfBoundsException("The stack is empty");
            }
            return arr[size--];

        }
    }

    public static class ArrayQueue{
        private Integer[] arr;
        private int size;  // 队列中已入队中元素的长度。
        private int first;// first指向队列中的最后一个元素。
        private int end; // end 指向待入队队列中的位置。

        public ArrayQueue(int initSize){
            if (initSize < 0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size=0;
            first=0;
            end=0;  // 初始情况下，first和end 都指向0位置。通过size变量，来解耦了first与end的边界关系
        }

        public Integer peek(){
            if (size == 0){
                return null;
            }
            return arr[first];
        }

        public void push(Integer obj){
            if (size == arr.length){
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[end]= obj;
            end = end == arr.length -1 ? 0: end + 1;
        }

        public Integer pop(){
            if (size == 0){
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int tmp = first;
            first = first == arr.length-1 ? 0 : first + 1;
            return arr[tmp];
        }
    }
    public static void main(String[] args){
        System.out.println("Start the examination of stack and queue !");
        ArrayQueue queue = new ArrayQueue(5);
        for (int i = 2 ;i < 4; i++){
            queue.push(i*3);
        }
        System.out.println("The peek of queue is " + queue.peek());
    }
}
