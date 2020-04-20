import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        System.out.println();

    }

    public static int[][] board = {
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

    public static int BOARD_START_INDEX = board[0][0];
    public static int BOARD_SIZE = 9;
    public static int SUBSECTION_SIZE = 3;
    public static int MIN_VALUE = 1;
    public static int MAX_VALUE = 9;
    public static int NO_VALUE = 0;
    public static int row;
    public static int column;

    public boolean solve(int [][] board){



        for (row = BOARD_START_INDEX; row < BOARD_SIZE  ; row++) {
            for (column = BOARD_START_INDEX; column < BOARD_SIZE ; column++) {

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
        return (rowConstraint(board, row) && columnConstraint (board, column) && subSectionConstraint(board, row, column));

    }

    private boolean subSectionConstraint(int[][] board, int row, int column) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        int subSectionRowStart = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subSectionRowEnd = subSectionRowStart + SUBSECTION_SIZE;

        int subSectionColumnStart = (column / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subSectionColumnEnd = subSectionRowStart + SUBSECTION_SIZE;

        for (int r = subSectionRowStart; r < subSectionRowEnd ; r++) {
            for (int c = subSectionColumnStart; c < subSectionColumnEnd ; c++) {
                if (!checkConstraint(board, r, constraint, c)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean columnConstraint(int[][] board, int column) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        return IntStream.range(BOARD_START_INDEX, BOARD_SIZE).allMatch(row -> checkConstraint(board, row, constraint, column));
    }

    private boolean rowConstraint(int[][] board, int row) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        return IntStream.range(BOARD_START_INDEX, BOARD_SIZE).allMatch(column -> checkConstraint(board, row, constraint, column));
    }

    private boolean checkConstraint(int[][] board, int row, boolean[] constraint, int column) {
        if (board[row][column] != NO_VALUE){
            if (!constraint[board[row][column] - 1]){
                constraint[board[row][column] - 1] = true;
            }else {
                return false;
            }
        }
        return true;
    }

    public static int getBoardStartIndex(){
        return BOARD_START_INDEX;
    }

    public void setBoardStartIndex(int BOARD_START_INDEX){
        this.BOARD_START_INDEX = BOARD_START_INDEX;
    }

    public static int getBoardSize(){
        return BOARD_SIZE;
    }
    public void setBoardSize(int BOARD_SIZE){
        this.BOARD_SIZE = BOARD_SIZE;
    }

    public void printBoard(){
        for (row = BOARD_START_INDEX; row < BOARD_SIZE ; row++) {
            for (column = BOARD_START_INDEX; column < BOARD_SIZE ; column++) {
                System.out.print(board[row][column] + " ");

            }
            System.out.println();

        }
    }

}
