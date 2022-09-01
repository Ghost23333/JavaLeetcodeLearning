package DP;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L392.java
 * @Description TODO
 * @createTime 2020年11月15日 19:57:00
 */
public class L392 {
}

//双指针
class Solution392 {
    public boolean isSubsequence(String s, String t) {

        int m = s.length() , n = t.length();
        int i = 0,j = 0;
        while( i != m && j != n){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            } else{
                j++;
            }
        }
        if(i == m)
            return true;
        return false;

    }
}


//DP
class Solution392_dp {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}
