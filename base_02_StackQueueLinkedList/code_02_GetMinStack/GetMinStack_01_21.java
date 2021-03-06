package code_02_GetMinStack;

import java.util.Stack;

public class GetMinStack_01_21 {
    public static class MyStack{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public void push(int newNum){
            if (this.stackMin.isEmpty()){
                this.stackMin.push(newNum);
            }else if (newNum < this.getMin()){
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public void pop(){
            if (this.stackData.isEmpty()){
                throw new RuntimeException("Your stack is empty");
            }
            int value = this.stackData.pop();
            if (value == this.getMin()){
                this.stackMin.pop();
            }
        }

        public int top() {
            return stackData.peek();
        }
        public  int getMin(){
            if (this.stackData.isEmpty()){
                throw new RuntimeException("Your stack is empty");
            }
            return this.stackMin.peek();
        }
    }

}
