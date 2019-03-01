package code_09_FindNumInSortedMatrix;

public  class FindNumInSortedMatrix_03_01 {
    public  static boolean isContain(int[][] matrix,int num){
        if (matrix == null){
            return false;
        }

        // 从排序好举证的对角线数字出发。从右上角的一点出发
        int maxY = matrix.length - 1;
        int maxX = matrix[0].length - 1;

        int aY = 0;
        int aX = maxX;
        while (aY <= maxY && aX <= maxX){
            if (matrix[aY][aX] == num){
                return true;
            }else if (matrix[aY][aX] < num){
                aY ++;
            }else {
                aX--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        int K = 963;
        System.out.println(isContain( matrix,K));
    }
}
