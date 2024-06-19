public class Search2DSorted {

    public static void SearchKey(int matrix[][], int key) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col <= matrix[0].length - 1) {
            if (matrix[row][col] == key) {
                System.out.println("KEY FOUND AT: (" + row + "," + col + ")");
                return;
            } else if (key < matrix[row][col]) {
                row--;
            } else {
                col++;
            }
        }
        System.out.println("ELEMENT NOT FOUND IN THE MATRIX");
    }

    public static void main(String[] args) {
        int matrix[][] = { { 10, 20, 30, 40 }, { 20, 30, 40, 50 }, { 30, 40, 50, 60 }, { 40, 50, 60, 70 } };
        SearchKey(matrix, 50);
    }
}