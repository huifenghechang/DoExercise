package code_08_ZigZagPrintMatrix;

public class ZigZagPrintMatrix_01_23 {
    public static void zigZagPrint(int[][] matrix) {
        if (matrix == null) {
            throw new RuntimeException("The matrix is null");
        }

        //将矩阵用两个坐标来表示，a代表右上，b代表左下、
        int aRow = 0;
        int aColumn = 0;
        int bRow = 0;
        int bColumn = 0;
        zigZagPrint(matrix, aRow, aColumn, bRow, bColumn);
    }

    public static void zigZagPrint(int[][] matrix, int aRow, int aColumn, int bRow, int bColumn) {
        int maxColumnIndex = matrix[0].length - 1;
        int maxRowIndex = matrix.length - 1;
        boolean up = true;
        while (bColumn != maxColumnIndex + 1) {
            // 两个坐标的变换
            printDiagonal(matrix, up, aRow, aColumn, bRow, bColumn);
            if (aColumn != maxColumnIndex) {
                // 如果a点的列未到达最右端，则向右端移动
                aColumn = aColumn + 1;
            } else {
                // 如果a点到达了最后端，则向下移动。
                aRow = aRow + 1;
            }

            // 对于b点的操作类似
            if (bRow != maxRowIndex) {
                // 如果b点未到达了最下端，则向下移动
                bRow = bRow + 1;
            } else {
                // 如果b点到达了最下端，则向右移动
                bColumn = bColumn + 1;
            }
            up = !up;
            // (aRow,aColumn) 先向右移动（行好不变），再向下移动（列号不变）
          /*  aColumn = aColumn == maxColumnIndex ? aColumn : aColumn + 1;// 优先是列变化
            aRow = aColumn == maxColumnIndex ? aRow+1 :aRow;*/

           /* //(bRow,bColumn)先向下移动（列号不变），在向右移动（行号不变）
            //  下面这段代码的顺序搞错了，导致最后的结构出错！！！
            // 先后顺序千万不要搞错，先对列进行操作，再对行进行操作。
            bColumn = bRow == maxRowIndex ? bColumn + 1: bColumn;
            bRow = bRow == maxRowIndex ?  bRow :bRow + 1;*/

        }

    }

    public static void printDiagonal(int[][] matrix, boolean up, int aRow, int aColumn, int bRow, int bColumn) {
        if (up){
            // 向上打印
            while (bColumn != aColumn + 1){
                System.out.print(matrix[bRow--][bColumn++] + ",");
            }
        }else {
            // 向下打印
            while (aColumn != bColumn -1){
                System.out.print(matrix[aRow++][aColumn--] + ",");
            }
        }

}

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        zigZagPrint(matrix);

    }
}
