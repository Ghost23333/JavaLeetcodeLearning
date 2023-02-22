package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1971.java
 * @Description TODO
 * @createTime 2022年12月19日 16:02:00
 */
public class L1971 {
    public static void main(String[] args) {
        Solution1971 solution1971 = new Solution1971();
        solution1971.validPath(10,new int[][]{{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}},5,9);
    }
}

class Solution1971 {
    int[] fa;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        fa = new int[n];
        //init
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        for (int[] edge : edges) {
            if(find(edge[0]) != find(edge[1])){
                fa[find(edge[0])] = find(edge[1]);
            }
        }
        if(find(source) == find(destination))
            return true;
        return false;
    }


    public int find(int x) {
        if (fa[x] != x)
            fa[x] = find(fa[x]);
        return fa[x];
    }
}