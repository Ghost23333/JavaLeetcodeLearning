package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1233.java
 * @createTime 2023年02月08日 22:45:00
 */
public class L1233 {
    public static void main(String[] args) {
        new Solution1233().removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"});
    }
}
class Solution1233 {
    public List<String> removeSubfolders(String[] folder) {
        Trie root = new Trie();
        for (int i = 0; i < folder.length; ++i) {
            List<String> path = split(folder[i]);
            Trie cur = root;
            for (String name : path) {
                cur.children.putIfAbsent(name, new Trie());
                cur = cur.children.get(name);
            }
            cur.ref = i;
        }

        List<String> ans = new ArrayList<String>();
        dfs(folder, ans, root);
        return ans;
    }

    public List<String> split(String s) {
        List<String> ret = new ArrayList<String>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '/') {
                ret.add(cur.toString());
                cur.setLength(0);
            } else {
                cur.append(ch);
            }
        }
        ret.add(cur.toString());
        return ret;
    }

    public void dfs(String[] folder, List<String> ans, Trie cur) {
        if (cur.ref != -1) {
            ans.add(folder[cur.ref]);
            return;
        }
        for (Trie child : cur.children.values()) {
            dfs(folder, ans, child);
        }
    }
}

class Trie {
    int ref;
    Map<String, Trie> children;

    public Trie() {
        ref = -1;
        children = new HashMap<String, Trie>();
    }
}