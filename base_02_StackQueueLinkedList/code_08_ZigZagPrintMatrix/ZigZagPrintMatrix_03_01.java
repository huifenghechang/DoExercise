package code_08_ZigZagPrintMatrix;

/*编程心得：
*
* 好奇怪哦，为什么很多时候，对于编程题，总是一看就懂，自己写就是漏洞百出呢。。。
* 唉。。。
*
*
* 经过实践发现，学会调试真的很重要。在编程中，最容易犯错的，就是边界条件了。
*
* 1_21那一版本，
* 巧妙的在while()循环的括号中，对举证的X周坐标进行了限制，在循环体内，对Y轴坐标进行了限制。
* 这种设计思想，值得学习呀！
*
* 注意，在数组的问题中，一定要注意，是否越界的检查。
* 一旦越界，则需要通过调试来解决问题 ~
*
* */
public class ZigZagPrintMatrix_03_01 {

    public static void zigZagPrint(int[][] matrix) {
        if (matrix == null) {
            throw new RuntimeException("The matrix is null");
        }

        //将矩阵用两个坐标来表示，a代表右上，b代表左下、
        int aY = 0;
        int aX = 0;
        int bY = 0;
        int bX = 0;
        zigZagMatrix(matrix, aY, aX, bY, bX);
    }

    public static void zigZagMatrix(int[][] matrix,int aY,int aX,int bY,int bX){

        boolean up = false;
        int maxX = matrix[0].length - 1; // 最大的列数
        int maxY = matrix.length - 1;  // 最大的行数

        while (aX <= maxX && aY <= maxY){
            printDiagonalLine(matrix,up,aY,aX,bY,bX);
            // 对a点进行移动,先移动X坐标，在移动Y轴坐标
            if (aX < maxX){
                aX = aX + 1;
            }else {
                aY = aY + 1;
            }

            // 对b点进行移动,先移动Y左边，再移动X坐标
            if (bY < maxY){
                bY = bY + 1;
            }else {
                bX = bX + 1;
            }

            // 对打印方向进行转向
            up = !up;
        }
    }

    public static void printDiagonalLine(int[][] matrix,boolean up,int aY, int aX, int bY,int bX){
        if (up){
            // 从左下往右上打印对角线
            // while (bY >= aY)
            while (bY >= aY){
                System.out.print(matrix[bY--][bX++] + ",");
            }
        }else {
            // 从右上往左下打印对角线
            while (aY <= bY){
                System.out.print(matrix[aY++][aX--] + ",");
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        zigZagPrint(matrix);

    }
}
