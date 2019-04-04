public class T70_ClimbStairs {
    public int climbStairs1(int n) {
        if (n==1 || n==2){
            return n;
        }
        return climbStairs1(n-1)+climbStairs1(n-2);
    }

    public int climbStairs(int n) {
        int[] d = new int[n+3];
        if (n <=2){
            return n;
        }
        d[1] = 1;
        d[2] = 2;
        for (int i=3; i<n;i++){
            d[i] = d[i-1] + d[i-2];
        }
        return d[n];
    }
}
