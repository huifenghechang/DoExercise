import java.util.Arrays;
import java.util.Comparator;

public class T452_FindMinArrowShots {

    /*
    * 每一个气球，肯定是被一支箭射破的。
    * 贪心策略：在射破气球的时候，尽可能多的射破多个气球。
    * */

    /*
    * 成功
显示详情
执行用时 : 49 ms, 在Minimum Number of Arrows to Burst Balloons的Java提交中击败了76.84% 的用户
内存消耗 : 69 MB, 在Minimum Number of Arrows to Burst Balloons的Java提交中击败了0.00% 的用户
    * */

    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }

        // 对数组进行排序；
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 初始化射击区间
        int[] shoot_area = new int[2];
        shoot_area[0] = points[0][0];
        shoot_area[1] = points[0][1];
        int shoot_num = 1;

        // 在写if语句的时候，一定要记住，<,<=  这些边界条件！！！
        for (int i=1; i<points.length;i++){
            if (points[i][0] <= shoot_area[1]){
                shoot_area[0] = points[i][0];
                if (points[i][1] < shoot_area[1]){
                    shoot_area[1] = points[i][1];
                }
            }else {
                shoot_num++;
                shoot_area[0] = points[i][0];
                shoot_area[1] = points[i][1];
            }
        }
        return shoot_num;
    }
}
