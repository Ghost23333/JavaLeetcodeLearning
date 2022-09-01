package com.ch.array;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName offer11.java
 * @Description TODO
 * @createTime 2020年11月19日 10:22:00
 */
public class offer11 {
}
class Solution {
    public int minArray(int[] numbers) {

        if(numbers.length == 0)
            return 0;
        if(numbers.length == 1)
            return numbers[0];
        int temp = numbers[0];
        for(int i = 1; i< numbers.length;i++){
            if(temp > numbers[i])
                return numbers[i];
            else
                temp = numbers[i];
        }
        return numbers[0];

    }
}