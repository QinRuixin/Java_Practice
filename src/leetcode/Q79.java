package leetcode;

/**
 * @author qin
 * @date 2020-09-13
 */
public class Q79 {

    private int row;
    private int column;
    private int strLen;
    private boolean[][] used;
    private char[][] board;

    private boolean res = false;
    int[][] tryList;

    public static void main(String[] args) {
        Q79 test = new Q79();
        char[][] list = new char[3][4];
        list[0][0] = 'A';
        list[0][1] = 'B';
        list[0][2] = 'C';
        list[0][3] = 'E';
        list[1][0] = 'S';
        list[1][1] = 'F';
        list[1][2] = 'C';
        list[1][3] = 'S';
        list[2][0] = 'A';
        list[2][1] = 'D';
        list[2][2] = 'E';
        list[2][3] = 'E';


        test.exist(list,
                "ABCB");
    }

    public boolean exist(char[][] board, String word) {
        row = board.length;
        column = board[0].length;
        strLen = word.length();
        used = new boolean[row][column];
        this.board = board;
        tryList = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                used[i][j] = false;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    dfs(i, j, 1, word);
                    if (res) {
                        return res;
                    }
                    used[i][j] = false;
                }
            }
        }
        return res;

    }

    private void dfs(int r, int c, int strIdx, String word) {
        if (res) {
            return;
        }
        if (strIdx == strLen) {
            res = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (r + tryList[i][0] >= 0 && r + tryList[i][0] < row && c + tryList[i][1] >= 0 && c + tryList[i][1] < column
                    && !used[r + tryList[i][0]][c + tryList[i][1]] && board[r + tryList[i][0]][c + tryList[i][1]] == word.charAt(strIdx)) {
                used[r + tryList[i][0]][c + tryList[i][1]] = true;
                dfs(r - 1, c, strIdx + 1, word);
                used[r + tryList[i][0]][c + tryList[i][1]] = false;
            }
            if (res) {
                return;
            }
        }
//        if (r - 1 >= 0 && !used[r - 1][c] && board[r - 1][c] == word.charAt(strIdx)) {
//            used[r - 1][c] = true;
//            dfs(r - 1, c, strIdx + 1, word);
//            used[r - 1][c] = false;
//        }
//        if (r + 1 < row && !used[r + 1][c] && board[r + 1][c] == word.charAt(strIdx)) {
//            used[r + 1][c] = true;
//            dfs(r + 1, c, strIdx + 1, word);
//            used[r + 1][c] = false;
//        }
//        if (c - 1 >= 0 && !used[r][c - 1] && board[r][c - 1] == word.charAt(strIdx)) {
//            used[r][c - 1] = true;
//            dfs(r, c - 1, strIdx + 1, word);
//            used[r][c - 1] = false;
//        }
//        if (c + 1 < column && !used[r][c + 1] && board[r][c + 1] == word.charAt(strIdx)) {
//            used[r][c + 1] = true;
//            dfs(r, c + 1, strIdx + 1, word);
//            used[r][c + 1] = false;
//        }

    }

}
