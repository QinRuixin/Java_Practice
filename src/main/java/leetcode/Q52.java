package leetcode;

/**
 * @author qin
 * @date 2020-10-17
 */
public class Q52 {

    private int res;

    public int totalNQueens(int n) {
        int[] columns = new int[100];
        for (int i = 0; i < 100; i++) {
            columns[i] = 0;
        }
        NQueens(0, n, columns);
        return res;
    }

    private void NQueens(int row, int total, int[] columns) {

        if (row == total) {
            res++;
            return;
        }

        for (int i = 0; i < total; i++) {
            // 第 row 行的棋子 放置在第 i 列
            boolean flag = true;
            for (int j = 0; j < row; j++) {
                // 检查是否与第 j 行的棋子冲突
                if (columns[j] == i || Math.abs(j - row) == Math.abs(columns[j] - i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                columns[row] = i;
                NQueens(row + 1, total, columns);
            }
        }
    }

}
