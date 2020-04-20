public class Main {

    int[][] board = {
            { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
            { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
            { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
            { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
            { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
            { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
    };

    private boolean solve(int [][] board){

        int BOARD_START_INDEX = board[0][0];
        int BOARD_SIZE = board.length;
        int NO_VALUE = 0;

        for (int row = BOARD_START_INDEX; row < BOARD_SIZE  ; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE ; column++) {

                if (board[row][column] == NO_VALUE){
                    for (int k = MIN_VALUE; k < MAX_VALUE ; k++) {
                        board[row][column] = k;
                        if (isValid(board, row, column) && solve(board)){
                            return true;
                        }
                        board[row][column] = NO_VALUE;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int row, int column) {

    }

}
