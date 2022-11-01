package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1662.java
 * @Description TODO
 * @createTime 2022年11月01日 09:23:00
 */
public class L1662 {
    public static void main(String[] args) {
        new Solution1662().arrayStringsAreEqual(new String[]{"ab", "c"},new String[]{"a", "bc"});
    }
}

class Solution1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0, ii = 0, jj = 0;
        while (i < word1.length && j < word2.length) {
           if(word1[i].charAt(ii) != word2[j].charAt(jj))
               return false;
           ii++;
           if(ii == word1[i].length()){
               ii = 0;
               i++;
           }
           jj++;
           if(jj == word2[j].length()){
               jj = 0;
               j++;
           }
        }
        return i == word1.length && j == word2.length;
    }
}