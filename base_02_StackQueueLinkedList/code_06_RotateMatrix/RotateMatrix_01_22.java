package code_06_RotateMatrix;

import static utils.Util.printMatrix;

public class RotateMatrix_01_22 {
    public static void rotateMatrix(int[][] matrix){
        if (matrix == null){
            return;
        }
        if (matrix.length != matrix[0].length){
            throw new RuntimeException("The matrix must be square");
        }
        int aY = 0;
        int aX = 0;
        int bY = matrix.length - 1;
        int bX = matrix.length - 1;
        while (aX < bX){
            rotateEdge(matrix,aY++,aX++,bY--,bX--);
        }
    }

    public static void rotateEdge(int[][] matrix,int aY,int aX,int bY,int bX){
        int times = bY - aY;
        int tmp = 0;
        for (int i=0;i != times;i++){
            tmp = matrix[aY][aX+i];
            matrix[aY][aX+i] = matrix[bY-i][aX];
            matrix[bY-i][aX] = matrix[bY][bX-i];
            matrix[bY][bX-i] = matrix[aY+i][bX];
            matrix[aY+i][bX] = tmp;
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
