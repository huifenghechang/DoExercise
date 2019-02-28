package code_06_RotateMatrix;

import static utils.Util.printMatrix;

/* 编程心得
*    这题再次说明了，利用图形来抠边界，是十分方便的。
*    对于矩阵旋转类的操作，也可以从坐标的角度来解题。
*    棒棒哒~
* */
public class RotateMatrix_02_28 {

    public static void rotateMatrix(int[][] matrix){
        if (matrix.length != matrix[0].length){
            throw new RuntimeException("the matrix is not square");
        }

        int y1 = 0;
        int x1 = 0;
        int y2 = matrix.length - 1;
        int x2 = matrix.length - 1;
        while (x1 < x2){
            rotateEdge(matrix,y1++,x1++,y2--,x2--);
        }


    }

    public static void rotateEdge(int[][] matrix, int y1,int x1,int y2,int x2){
        int times = x2 - x1; // 需要进行旋转的边界数字的个数
        int temp = 0 ;
        for (int i=0 ;i != times;i++){
            temp = matrix[y1+i][x2];
            matrix[y1+i][x2] = matrix[y1][x1+i];
            matrix[y1][x1+i]= matrix[y2-i][x1];
            matrix[y2-i][x1] = matrix[y2][x2 -i];
            matrix[y2][x2-i] = temp;
        }

    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println("=========");
        printMatrix(matrix);
    }
}
