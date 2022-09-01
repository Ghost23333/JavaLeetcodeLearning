package sort;

import java.util.*;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 数组的相对排序.java
 * @Description TODO
 * @createTime 2020年12月08日 09:50:00
 */
public class 数组的相对排序 {
}
/*
class Solution1112 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int []ans = new int[arr1.length + 1000];
        int index = 0;
        int index1 = arr1.length;
        for(int i = 0;i< arr2.length;i++){
            for(int j = 0;j< arr1.length;j++){
                if (arr1[j] != -1) {
                    if(arr1[j] == arr2[i]){
                        ans[index++] = arr2[i];
                    }else {
                        ans[index1++] = arr1[j];
                    }
                    arr1[j] = -1;
                }
            }
        }
        if(index < arr1.length) {
            int index2 = index;
            for (int i = arr1.length; i < index1; i++) {
                ans[index++] = ans[i];
            }
            Arrays.sort(ans,index2,index);
            return Arrays.copyOfRange(ans,0,index);
        }
        else {
            return ans;
        }

    }
}*/
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : arr1) list.add(num);
        for(int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
        Collections.sort(list, (x, y) -> {
            if(map.containsKey(x) || map.containsKey(y)) return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            return x - y;
        });
        for(int i = 0; i < arr1.length; i++) arr1[i] = list.get(i);
        return arr1;
    }
}