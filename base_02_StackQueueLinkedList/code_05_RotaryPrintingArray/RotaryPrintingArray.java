package code_05_RotaryPrintingArray;

public class RotaryPrintingArray {
    private int[][] matrix;


    public static void rotaryMatrix(int[][] matrix){
        // 定义矩阵的左上和右下两个位置的点
        int aX = 0;
        int bY = 0;
        int cX = matrix[0].length - 1;
        int dY= matrix.length - 1; // 二维数组的matrix.length 表示二维数组的行数。
        while (aX <= cX && bY <= dY) {
            printEdge(matrix, aX++, bY++, cX--, dY--);
        }
    }



    // 采用左边轴左边（x,y）来表示矩阵中的值的时候，要注意表示的不一致。
    // 矩阵matrix[][],更改纵坐标，对应更改矩阵的行号，由第一个参数表示。
    public static void printEdge(int[][] matrix,int aX,int bY,int cX,int dY){
        for(int i = aX; i < cX ; i++){
            System.out.print(matrix[bY][i] + "、");
        }
        for (int i = bY; i < dY; i++){
            System.out.print(matrix[i][cX]+"、");
        }
        for (int j = cX; j > aX; j--){
            System.out.print(matrix[dY][j]+"、");
        }
        for (int k = dY; k > bY; k--){
            System.out.print(matrix[k][aX]+"、");
        }

    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        rotaryMatrix(matrix);

    }



}
