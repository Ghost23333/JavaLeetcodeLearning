package 每日一题;

import java.util.*;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L886.java
 * @Description TODO
 * @createTime 2022年10月16日 11:11:00
 */
public class L886 {
}

class Solution886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1]; //用来存储节点的颜色,分为1 2 没染色之前为0
        List<Integer>[] g = new List[n + 1];//g数组用来存储每个节点的对立节点(不喜欢dislike)的节点链
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();//初始化g数组
        }

        //初始化节点，找到每个节点的对立节点
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }

        for(int i = 1;i<=n;i++){
            if(color[i] == 0 && !dfs(i,1,color,g)){
               return false;
            }
        }
        return true;
    }
    public boolean dfs(int curNode, int newColor, int[] color, List<Integer>[] g) {
        color[curNode] = newColor;//更新当前节点的颜色
        //dfs遍历当前节点curNode的对立节点nextNode
        for (Integer nextNode : g[curNode]) {
            //如果nextNode染过色而且和当前节点一样，则放回false
            if(color[nextNode] != 0 && color[nextNode] == newColor){
                return false;
            }
            //如果当前nextNode没染色，则将其染色为当前节点的对立色,并循环dfs nextNode，若其染色失败则返回false
            if(color[nextNode] == 0 && !dfs(nextNode,3 - newColor,color,g)){
                return false;
            }
        }
        return true;
    }
}