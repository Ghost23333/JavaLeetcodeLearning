package 周赛.第317;

import java.util.*;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L6221.java
 * @Description TODO
 * @createTime 2022年10月30日 11:36:00
 */
public class L6221 {
    public static void main(String[] args) {

    }
}
class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> ans = new LinkedList<>();
        Map<String,Long> map1 = new TreeMap<>();//totalViews
        Map<String,Integer> map2 = new HashMap<>();//maxViews
        Map<String,String> map3 = new HashMap<>();//ids
        for (int i = 0; i < creators.length; i++) {
            if(map1.containsKey(creators[i])){
                map1.put(creators[i],map1.get(creators[i]) + views[i]);
                if(map2.get(creators[i]) < views[i]){
                    map2.put(creators[i],views[i]);
                    map3.put(creators[i],ids[i]);
                }else if(map2.get(creators[i]) == views[i]){
                    if(map3.get(creators[i]).compareTo(ids[i]) > 0){
                        map3.put(creators[i],ids[i]);
                    }
                }
            }else {
                map1.put(creators[i], (long) views[i]);
                map2.put(creators[i],views[i]);
                map3.put(creators[i],ids[i]);
            }
        }
        List<Map.Entry<String,Long>> list = new ArrayList<>(map1.entrySet());
        //然后通过比较器来实现排序
        list.sort(new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                return (int) (o2.getValue() - o1.getValue());
            }
        });
        List<String> temp = new LinkedList<>();
        String preKey = list.get(0).getKey();
        Long preValue = list.get(0).getValue();
        temp.add(preKey);
        temp.add(map3.get(preKey));
        ans.add(temp);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).getValue() == preValue){
                List<String> ans1 = new LinkedList<>();
                String key = list.get(i).getKey();
                ans1.add(key);
                ans1.add(map3.get(key));
                ans.add(ans1);
            }else {
                break;
            }
        }
        return ans;

    }
}