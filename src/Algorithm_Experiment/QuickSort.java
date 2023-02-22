package Algorithm_Experiment;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName QuickSort.java
 * @Description TODO
 * @createTime 2023年02月02日 11:18:00
 */
public class QuickSort implements Sort {
    private int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    private void quickSort(int[] src, int begin, int end) {
        if (begin < end) {
            int key = src[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && src[j] > key) {
                    j--;
                }
                if (i < j) {
                    src[i] = src[j];
                    i++;
                }
                while (i < j && src[i] < key) {
                    i++;
                }
                if (i < j) {
                    src[j] = src[i];
                    j--;
                }
            }
            src[i] = key;
            quickSort(src, begin, i - 1);
            quickSort(src, i + 1, end);
        }
    }

    @Override
    public void sort() {
        quickSort(array, 0, array.length - 1);
    }

    @Override
    public void printf() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
