package 回溯;

import Tree.TreeNode;

import java.util.*;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L51.java
 * @Description TODO
 * @createTime 2022年09月25日 09:58:00
 */
public class L51 {
    public static void main(String[] args) {
        Solution51_2 s = new Solution51_2();
        s.solveNQueens(4);
    }
}

class Solution51 {
    List<List<String>> ans = new ArrayList<>();
    HashMap<Integer, Integer> path = new HashMap<>();
    int[] used;

    public List<List<String>> solveNQueens(int n) {
        used = new int[n + 1];
        backTracking(n, 1);
        return ans;
    }

    public void backTracking(int n, int row) {

        if (row > n) {

            List<String> temp = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                StringBuilder str = new StringBuilder();
                int col = path.get(i);
                for (int j = 1; j < col; j++) {
                    str.append(".");
                }
                str.append("Q");
                for (int j = col + 1; j <= n; j++) {
                    str.append(".");
                }
                temp.add(str.toString());
            }
            ans.add(temp);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i] == 0) {
                boolean flag = true;
                for (Integer key : path.keySet()) {
                    if (Math.abs(key - row) == Math.abs(path.get(key) - i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    path.put(row, i);
                    used[i] = 1;
                    backTracking(n, row + 1);
                    used[i] = 0;
                    path.remove(row);
                }
            }
        }
    }
}

class Solution51_2 {
    List<List<String>> ans = new ArrayList<>();
    HashMap<Integer, Integer> path = new HashMap<>();
    int[] used;//记录某一列是否被使用过
    char[][] chessboard;

    public List<List<String>> solveNQueens(int n) {
        used = new int[n];
        chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTracking(n, 0);
        return ans;
    }

    public void backTracking(int n, int row) {

        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] chars : chessboard) {
                temp.add(String.copyValueOf(chars));
            }
            ans.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i] == 0) {
                boolean flag = true;
                for (Integer key : path.keySet()) {
                    if (Math.abs(key - row) == Math.abs(path.get(key) - i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    path.put(row, i);
                    used[i] = 1;
                    chessboard[row][i] = 'Q';
                    backTracking(n, row + 1);
                    used[i] = 0;
                    chessboard[row][i] = '.';
                    path.remove(row);
                }
            }
        }
    }
}