package 每日一题;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1604.java
 * @createTime 2023年02月07日 10:37:00
 */
public class L1604 {
    public static void main(String[] args) {
        Solution1604 s = new Solution1604();
        s.alertNames(new String[]{"alice","alice","alice","bob","bob","bob","bob"},new String[]{"12:01","12:00","18:00","21:00","21:20","21:30","23:00"});
    }

}
class Solution1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String s = keyName[i];
            ArrayList<Integer> list;
            if(map.containsKey(s)){
                list = map.get(s);
            }else {
                list = new ArrayList<>();
            }
            list.add(parse(keyTime[i]));
            map.put(s,list);
        }
        List<String> result = new ArrayList<>();
        for (String s : map.keySet()) {
            if(map.get(s).size() >= 3){
                ArrayList<Integer> list = map.get(s);
                list.sort(Comparator.reverseOrder());
                for (int i = 0; i + 2 < list.size(); i++) {
                    if(list.get(i) - list.get(i + 1) < 60 && list.get(i) - list.get(i+2) <= 60){
                        result.add(s);
                        break;
                    }
                }
            }
        }
        result.sort(Comparator.naturalOrder());
        return result;
    }
    private Integer parse(String data){
        String[] split = data.split(":");
        return Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
    }
}