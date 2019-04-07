package dynamic_plan;

import java.util.ArrayList;
import java.util.List;

public class T120_MinimumTotal {

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0){
            return 0;
        }

        int[][] dp = new int[triangle.size()][triangle.size()];
        List<Integer> list = triangle.get(triangle.size()-1); // list初始化的时候，指向三角形的最后一行

        //  初始化dp的最后一行
        for (int i=0;i<list.size();i++){
            dp[list.size()-1][i] = list.get(i);
        }
        // 自底向上搜索
        for (int i = list.size()-2;i>=0;i-- ){
            list = triangle.get(i); // 自底向上，list指向三角形的某一行
            for (int j=0; j<list.size();j++){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + list.get(j);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();

        list1.add(2);
        list2.add(3);list2.add(4);
        list3.add(5);list3.add(6);list3.add(7);
        list4.add(4);list4.add(1);list4.add(8);list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);

        System.out.print(minimumTotal(triangle));




    }
}
