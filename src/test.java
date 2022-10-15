/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName test.java
 * @Description TODO
 * @createTime 2020年11月25日 15:14:00
 */
public class test {
    public static void main(String[] args) {
        int mod = 98987;
        System.out.println(12131% mod +   123%mod);
        System.out.println((12131 + 123) % mod);
    }

}


class Solution268 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int total = (1+len)*len/2;
        for(int i=0;i<len;i++){
            sum += nums[i];
        }
        return total - sum;
    }
}