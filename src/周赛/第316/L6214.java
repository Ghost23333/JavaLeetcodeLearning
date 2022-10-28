package 周赛.第316;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L6214.java
 * @Description TODO
 * @createTime 2022年10月23日 10:31:00
 */
public class L6214 {
}

class Solution6214 {
    public boolean haveConflict(String[] event1, String[] event2) {
        String[] str1 = event1[0].split(":");
        String[] str2 = event1[1].split(":");
        String[] str3 = event2[0].split(":");
        String[] str4 = event2[1].split(":");
        int startTime1 = Integer.parseInt(str1[0]) * 60 + Integer.parseInt(str1[1]);
        int startTime2 = Integer.parseInt(str3[0]) * 60 + Integer.parseInt(str3[1]);
        int endTime1 = Integer.parseInt(str2[0]) * 60 + Integer.parseInt(str2[1]);
        int endTime2 = Integer.parseInt(str4[0]) * 60 + Integer.parseInt(str4[1]);

        if(endTime1 < startTime2 || endTime2<startTime1){
            return false;
        }
        return true;
    }
}