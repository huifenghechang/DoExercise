import java.lang.reflect.Array;
import java.util.Arrays;
/*
* Arrays的降序排序如何使用
* */
public class T455_FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
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
