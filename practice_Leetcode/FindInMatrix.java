public class FindInMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null){
            return  false;
        }

        int max_X = matrix[0].length-1; // 矩阵的列数
        int max_Y = matrix.length - 1; // 矩阵的行数

        int x = max_X,y = 0;
        while (y <= max_Y && x>=0){
            if (matrix[y][x] == target){
                return true;
            }else if (matrix[y][x] < target){
                y++;
            }else {
                x--;
            }
        }
        return false;
    }

}
