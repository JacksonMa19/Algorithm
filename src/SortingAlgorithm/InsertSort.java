package SortingAlgorithm;

import java.util.Arrays;

public class InsertSort {
    /**
     * 插入排序
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertValue = array[i];
            int j = i - 1;
            for (; (j >= 0) && (insertValue < array[j]) ; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = insertValue;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{6,7,4,9,3,5,3,1};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
