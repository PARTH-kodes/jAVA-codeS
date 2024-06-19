public class SpiralMatrix {

    public static void printSpiral(int matrix[][]) {
        int start_row = 0, start_col = 0;
        int end_row = matrix.length - 1, end_col = matrix[0].length - 1;

        while (start_row <= end_row && start_col <= end_col) {
            for (int i = start_col; i <= end_col; i++) {
                System.out.print(matrix[start_row][i] + " ");
            }

            for (int i = start_row + 1; i <= end_row; i++) {
                System.out.print(matrix[i][end_col] + " ");
            }

            for (int i = end_col - 1; i >= start_col; i--) {
                System.out.print(matrix[end_row][i] + " ");
            }

            for (int i = end_row - 1; i >= start_row + 1; i--) {
                System.out.print(matrix[i][start_col] + " ");
            }

            start_col++;
            start_row++;
            end_row--;
            end_col--;
        }
    }

    public static void diagonalSum(int matrix[][]) {
        int sum = 0;
        
        for (int i = 0; i < matrix.length; i++) {

            sum += matrix[i][i];

            if (i != matrix.length - 1 - i) {
                sum += matrix[i][matrix.length - 1 - i];
            }
        }
        System.out.println(sum);
    }    

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        printSpiral(matrix);
        // System.out.println(matrix.length);
        diagonalSum(matrix);
    }
}