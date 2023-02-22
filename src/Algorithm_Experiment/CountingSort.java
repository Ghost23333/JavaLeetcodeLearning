package Algorithm_Experiment;

import java.util.Arrays;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName CountingSort.java
 * @Description TODO
 * @createTime 2023年02月02日 11:50:00
 */
public class CountingSort implements Sort{

    private int[] array;

    public CountingSort(int[] array) {
        this.array = array;
    }

    @Override
    public void sort() {
        countingSort(this.array);
    }

    @Override
    public void printf() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    private void countingSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int length = array.length;
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }
        // 最大最小元素之间范围[min, max]的长度
        int offset = max - min + 1;
        // 1. 计算频率，在需要的数组长度上额外加1
        int[] count = new int[offset + 1];
        for (int i = 0; i < length; i++) {
            // 使用加1后的索引，有重复的该位置就自增
            count[array[i] - min + 1]++;
        }
        // 2. 频率 -> 元素的开始索引
        for (int i = 0; i < offset; i++) {
            count[i + 1] += count[i];
        }

        // 3. 元素按照开始索引分类，用到一个和待排数组一样大临时数组存放数据
        int[] aux = new int[length];
        for (int i = 0; i < length; i++) {
            // 填充一个数据后，自增，以便相同的数据可以填到下一个空位
            aux[count[array[i] - min]++] = array[i];
        }
        // 4. 数据回写
        for (int i = 0; i < length; i++) {
            array[i] = aux[i];
        }
    }
}
