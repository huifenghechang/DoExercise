package code_05_RotaryPrintingArray;

public class RotaryPrintingArray190403 {

    public static void main(String[] args){
        String s = "abcdefghijklmnop";
        char[][] matrix = new char[5][5];
        printEdge(s,matrix,0,0,4,4);
    }
    public static void printEdge(String s,char[][] matrix,int y1, int x1, int y2,int x2){
        int i = 0;
        int x_max = x2;
        int y_max = y2;

        // 打印边界

        // 打印上边界
        for(int j = x1; j < x_max;j++){
            matrix[y1][j] = s.charAt(i++);
        }

        // 打印右边界
        for (int j = y1;j < y_max;j++){
            matrix[j][x2] = s.charAt(i++);
        }

        // 打印下边界
        for (int j= x2; j >0;j-- ){
            matrix[y2][j] = s.charAt(i++);
        }

        // 打印左边界
        for(int j=y2; j >0 ;j--){
            matrix[j][x1] = s.charAt(i++);
        }

        char cc = matrix[0][0];

        System.out.println(matrix.toString());
    }
}
