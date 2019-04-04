package weBank;

import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        int counter = 0;
        System.out.println("Input Sample");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        for (int i = 0 ;i<= a ;i++){
            String binaryStr = Integer.toBinaryString(i); //转换为二进制数。
            if (isPalindrome(binaryStr)){
                counter++;
            }
        }
        // 判断是否为回文数，使用栈来实现。
        System.out.println("Output Sample");
        System.out.println(counter);

    }


    /*
    *
    *
时间限制：C/C++语言 2000MS；其他语言 4000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB

题目描述：
给出三个整数a，b，c，你需要计算数2^a+2^b-2^c在二进制表示下1的个数。

输入
第一行包含三个整数a,b,c。1≤c＜b＜a≤10^9

输出10
输出对应的答案。

提示：2^3+2^2-2^1=10=(1010)
     2
    * */


/*
* 时间限制：C/C++语言 2000MS；其他语言 4000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
在抽象代数中，我们学过一个关于有限域的定理：
存在一个大小为q的有限域当且仅当q是某个素数p的方幂，即q=p^k ,𝑘 ≥ 1，且在同构意义下，相同大小的有限域只有一个。
作为新时代的数学工作者，你决定运用这个定理写一个程序来计算同构意义下的不同有限域个数。
对于一个给定的输入𝑛，你需要计算有多少个不同构的有限域，它们的大小是不超过n的。

输入
第一行包含一个整数𝑛。1 ≤ 𝑛 ≤ 1000

输出
输出阶数不超过𝑛的有限域的个数。


样例输入
1
样例输出
0


*
* */


    /*
    *
    *
    *
    * */
    public static boolean isPalindrome(String string){
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i< string.length();i++){
            stack.push(string.charAt(i));
        }
        for (int i=0; i< string.length();i++){
            if (string.charAt(i) !=  stack.pop()){
                return false;
            }
        }
        return true;
    }

}
