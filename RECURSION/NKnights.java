public class NKnights {
    public static void possibleKnights(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i) == true) {
                board[row][i] = 'K';
                possibleKnights(board, row + 1);
                board[row][i] = '.';
            }
        }
    }

    public static boolean isSafe(char board[][], int row, int col) {
        // same column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'K') {
                return false;
            }
        }
        // upper L-shape
        int invalidRow[] = { -2, -1, -2, -1 };
        int invalidCol[] = { 1, 2, -1, -2 };
        for (int i = 0; i < invalidCol.length; i++) {
            int sumRow = row + invalidRow[i];
            int sumCol = col + invalidCol[i];
            if (sumRow >= 0 && sumRow < board.length && sumCol >= 0 && sumCol < board.length
                    && board[sumRow][sumCol] == 'K') {
                return false;
            }
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
        char board[][] = new char[n][n];
        // initialize
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        possibleKnights(board, 0);
    }
}