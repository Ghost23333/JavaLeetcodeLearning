package Algorithm_Experiment;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName CountingSortTest.java
 * @Description TODO
 * @createTime 2023年02月02日 12:08:00
 */
public class CountingSortTest {
    public static void main(String[] args) {
        int []array = new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        CountingSort countingSort = new CountingSort(array);
        System.out.println("排序前");
        countingSort.printf();
        countingSort.sort();
        System.out.println("\n排序后");
        countingSort.printf();
    }
}
