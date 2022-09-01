package sort;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 按奇偶排序数组_II.java
 * @Description TODO
 * @createTime 2020年12月09日 10:24:00
 */
public class 按奇偶排序数组_II {
    public static void main(String[] args) {
        Solution922 s = new Solution922();
        s.sortArrayByParityII(new int[]{4, 2, 5, 7});
    }
}


class Solution922 {
    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int[] ans = new int[len];
        int index2 = 0;
        int index1 = 1;
        for (int i = 0; i < len; i++) {
            if (A[i] % 2 == 0) {
                ans[index2] = A[i];
                index2 += 2;
            } else {
                ans[index1] = A[i];
                index1 += 2;
            }
        }
        return ans;
    }
}

class Solution922_2 {
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}