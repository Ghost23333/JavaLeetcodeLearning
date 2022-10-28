package 每日一题;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L934.java
 * @Description TODO
 * @createTime 2022年10月25日 09:38:00
 */
public class L934 {
    public static void main(String[] args) {
        new Solution934().shortestBridge(new int[][]{
                {0,1},{1,0}});
    }
}

class Solution934 {

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; //四个方向
        boolean findIsland = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, queue);//第一次碰到1，这时dfs求出第一个岛屿的所有点，并将其设置为2
                    findIsland = true;
                    break;
                }
            }
            if (findIsland)
                break;
        }
        int level = 0;//bfs搜索的层数
        while (!queue.isEmpty()) {
            int size = queue.size();
            //多源bfs，将第一个岛屿的所有节点遍历
            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int d = 0; d < 4; d++) { //四个方向
                    int xx = x + dirs[d][0];
                    int yy = y + dirs[d][1];
                    if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
                        if(grid[xx][yy] == 0){
                            queue.offer(new int[]{xx,yy});
                            grid[xx][yy] = 2;//标记为岛屿1的领地
                        }else if(grid[xx][yy] ==1 ){ //找到岛屿2,此时返回已经搜索的层数
                            return level;
                        }
                    }
                }
            }
            level++;
        }
        return 0; //不会走到这一步
    }

    public void dfs(int i, int j, int[][] grid, Queue<int[]> queue) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1)
            return;
        queue.add(new int[]{i, j});
        grid[i][j] = 2;//设置为2代表其为island1
        dfs(i, j + 1, grid, queue);
        dfs(i + 1, j, grid, queue);
        dfs(i, j - 1, grid, queue);
        dfs(i - 1, j, grid, queue);

    }
}