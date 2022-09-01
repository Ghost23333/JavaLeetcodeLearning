package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName testSynchronized.java
 * @Description TODO
 * @createTime 2020年11月17日 20:38:00
 */
public class testSynchronized {
    public static void main(String[] args) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(null,1);
        hashMap.put(null,2);
        for(Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue() );
        }
        b bb = new b();
    }
}

class a{
    public final int x = 5;
    public a(){
    }
}

class b extends a{
    public b(){
        super();
        System.out.println(x);
    }
}
