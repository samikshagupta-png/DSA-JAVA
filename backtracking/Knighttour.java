package backtracking;

public class Knighttour {
    //GivenaN*NboardwiththeKnightplacedonthefirstblockofanemptyboard.
    // Movingaccordingtotherulesofchess,knightsmustvisiteachsquareexactlyonce.
    // Printtheorderofeach cell in which they are visited.
    static int N =8;
    static int[] rowMove = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] colMove = {1, 2, 2, 1, -1, -2, -2, -1};
    public static boolean isSafe(int row,int col, int [][]board){
         return row >= 0 && row < N &&
               col >= 0 && col < N &&
               board[row][col] == -1;
    }
    public static boolean solveknighttour(int row,int col,int moveNumber,int [][] board){
        if (moveNumber == N * N) {
            return true;
        }
        // Try all 8 possible knight moves
        for (int i = 0; i < 8; i++) {

            int nextRow = row + rowMove[i];
            int nextCol = col + colMove[i];

            if (isSafe(nextRow, nextCol, board)) {

                // Make the move
                board[nextRow][nextCol] = moveNumber;

                // Recursively try to complete the tour
                if (solveknighttour(nextRow, nextCol,moveNumber + 1, board)) {
                    return true;
                }

                // Backtrack
                board[nextRow][nextCol] = -1;
            }
        }
        return false;

    }
    static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d ", board[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] board = new int[N][N];

        // Initially every cell is unvisited
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }

        // Knight starts at first block (0,0)
        board[0][0] = 0;

        if (solveknighttour(0, 0, 1, board)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
        
    }
    
}
