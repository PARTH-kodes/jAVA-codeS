public class NQueens {
    public static void possibleQueens(char board[][], int row) {
        // base case
        if (row == board.length) {
            printBoard(board);
            return;
        }
        // recursion
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i) == true) {
                board[row][i] = 'Q';
                possibleQueens(board, row + 1);
                board[row][i] = 'x';
            }
        }
    }

    public static boolean isSafe(char board[][], int row, int col) {
        // up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // left diag
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        // right diag
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static void printBoard(char board[][]) {
        System.out.println("\n--------VALID BOARD----------\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        char[][] board = new char[n][n];
        for (int j = 0; j < board.length; j++) {
            for (int j2 = 0; j2 < board.length; j2++) {
                board[j][j2] = 'x';
            }
        }
        // printBoard(board);
        possibleQueens(board, 0);
    }
}
