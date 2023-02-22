package Algorithm_Experiment;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName QuickSortTest.java
 * @Description TODO
 * @createTime 2023年02月02日 11:30:00
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int []array = {-2,1,-3,4,-1,2,1,-5,4};
        QuickSort quickSort = new QuickSort(array);
        System.out.println("排序前");
        quickSort.printf();
        quickSort.sort();
        System.out.println("\n排序后");
        quickSort.printf();
    }
}
