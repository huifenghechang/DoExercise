package code_05_RotaryPrintingArray;


public  class RotaryPrintingArray_02_28 {
    private int[][] matrix;

    private static void rotaryShowArray(int[][] matrix){
        if (matrix == null){
            throw new RuntimeException("The matrix is empty");
        }
        int y1 = 0;
        int x1 = 0;

        int y2 =matrix.length -1;// 行坐标
        int x2 = matrix[0].length -1 ;// 列坐标
        while (y1<=y2){
            printEdge(matrix,y1++,x1++,y2--,x2--);
        }

    }

    public static void printEdge(int[][] matrix,int y1,int x1,int y2, int x2){
        // 打印四条边
        // 最上边的一条
        for (int j = x1;j < x2;j++){
            System.out.print(matrix[y1][j] + ",");
        }
        // 最右边的一条
        for (int j = y1;j< y2;j++){
            System.out.print(matrix[j++][x2]+",");
        }
        //最下面一条
        for (int j = x2;j > x1;j--){
            System.out.print(matrix[y2][j]+",");
        }
        // 最左边一条
        for (int j= y2;j>y1;j--){
            System.out.print(matrix[j][x1]+",");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        rotaryShowArray(matrix);

    }
}
