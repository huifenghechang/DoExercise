import java.lang.reflect.Array;
import java.util.Arrays;
/*
* Arrays的降序排序如何使用
* */
public class T455_FindContentChildren {

    public int findContentChildren190407(int[] g, int[] s){

        /*
        * 两个数组，轮询遍历！采用while()结构循环，可以保证数组不越界！
        *
        * 贪心算法，分步求解。每次的选择满足局部最优！！！
        *
        * */
        Arrays.sort(g);
        Arrays.sort(s);
        int children = 0;
        int cookie = 0;
        int counter = 0;
        while (children < s.length && cookie < g.length){
            if (g[cookie] >= s[children]){
                children++;
                counter++;
            }
            cookie++;
        }
        return counter;
    }

    public int findContentChildren190327(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;

        while (child < g.length && cookie < s.length){
            if (g[child] <= s[cookie]){
                child++;
            }
            cookie++;
        }
        return child;
    }

    public int findContentChildren001(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int childStart = 0;
        int cookieCur = 0;
//按照贪心策略，有限将小的数值匹配。从最小的糖果开始匹配
        while ( childStart < g.length && cookieCur < s.length) {
            for (; cookieCur < s.length; cookieCur++) {
                for (int j = childStart; j < g.length; j++) {
                    if (s[cookieCur] >= g[j]) {
                        childStart = j + 1;
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}
