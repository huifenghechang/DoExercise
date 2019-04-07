
import java.util.Stack;

public class T402_RemoveKdigits {

    /*
    * 退出条件， k == 0 或者 栈为空，或者
    * */
    public static String removeKdigits2(String num, int k) {
        if (num.length() < 1){
            return "0";
        }
        StringBuilder res = new StringBuilder("");
        Stack<Integer> stack = new Stack<>();
        stack.push(num.charAt(0) - '0');

        for (int i = 1; i < num.length();i++){
            int number = num.charAt(i) - '0';
            while (!stack.isEmpty() && k > 0 && number < stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(number);
        }

        while (k >0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }

       // 从栈底到栈顶一次读取数字，就是所得的最小数。
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }

        String  minResult = res.reverse().toString();
        int i=0;
        
        while (i < minResult.length()&& minResult.charAt(i)=='0'){
            i++;
        }

        String result = minResult.substring(i);
        return  result.equals("")?"0":result;
    }

    public static String removeKdigits1(String num, int k) {
        int len=num.length(),i=0;
        if(len==k) return "0";
        if(k==0) return num;
        Stack<Character> s=new Stack<>();
        s.push(num.charAt(i));

        char temp;
        while(k>0&&i<len-1){
            i++;
            temp=num.charAt(i);
            if(k>0&&!s.isEmpty()&&s.peek()>=temp){
                while(k>0&&!s.isEmpty()&&s.peek()>temp){
                    s.pop();
                    k--;
                }
            }
            if(!(s.isEmpty()&&temp=='0'))  s.push(temp);
        }
        String res="";
        while(!s.isEmpty())  res+=s.pop();
        res=new StringBuilder(res).reverse().toString()+num.substring(i+1);
        i=0;

        while(i<res.length()&&res.charAt(i)=='0')
            i++;

        String t=res.substring(i);
        return (t.equals(""))?"0":t.substring(0,t.length()-k);
    }

    public static String removeKdigits(String num, int k) {
        String res = "";
        int startIndex = 0;
        int endIndex = k;
        for (int i=0; i < num.length()-k; i++){
            // 最优子结构，寻找第K位上最小的数字
            int minIndex = startIndex;

            for (int j = startIndex; j <= endIndex;j++){
                if (num.charAt(j) < num.charAt(minIndex)){
                    minIndex = j;
                }
            }

            startIndex = minIndex+1;
            endIndex++;
            res += num.charAt(minIndex);
        }
        // 将后面的位数加到末尾
        res += num.substring(2*k);
        return res;
    }

    public static void main(String[] args){
        String num =  "10200";
        int k = 1;
        System.out.println(removeKdigits2(num,k));
    }
}
