package code_01_ArrayToQueueAndStack;

public class Array_To_Stack_Queue_S01 {

    // 使用数组来实现固定大小的栈
    public static class StackByArray{
        private Integer[] arr;
        private Integer size;

        public StackByArray(Integer initSize){
            if (size < 1){
                System.out.println("The format of size is incorrect ~ ");
                return;
            }else {
                this.arr = new Integer[size];
                this.size = 0;
            }
        }

        // 入栈操作
        public  void push(int data){
            if (size >= arr.length){
                throw new ArrayIndexOutOfBoundsException("The stack is full ~ ");
            }
            arr[size++] = data;
        }

        // 出栈操作
        public  Integer  pop(){
            if (size < 1){
                throw new ArrayIndexOutOfBoundsException("The stack is empty ~ ");
            }
            return arr[size--];
        }

        // 弹出栈顶操作
        public int peek(){
            if (size < 1){
                throw new ArrayIndexOutOfBoundsException(" The stack is empty ! ");
            }
            return arr[size];
        }
    }

    // 使用数组来实现固定大小的队列
    public static class QueueByArray{
        private Integer[] arr;
        private Integer size;
        int first;
        int end;

        public QueueByArray(int initSize){
            if (initSize < 1){
                throw  new IllegalArgumentException( "The format of argument is error !" );
            }
            this.arr = new Integer[initSize];
            this.size = 0;
            this.first = 0;
            this.end = 0;
        }

        public void push(int data){
            if (size >= arr.length){
                throw new ArrayIndexOutOfBoundsException("The Queue is full ");
            }
            size ++;
            arr[end] = data;
            end = end == arr.length - 1 ? 0 :end + 1;
        }

        public Integer pop(){
            if (size < 1){
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int tmp = first;
            first = first == arr.length - 1 ? 0 :first + 1;
            return arr[tmp];
        }
    }
}
