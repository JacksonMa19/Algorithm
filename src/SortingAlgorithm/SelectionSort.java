package SortingAlgorithm;

import java.util.Arrays;

public class SelectionSort {
    /**
     * 选择排序 先找出最小放第二个，然后在剩下的数组查找最小的然乎放在第二位，如此反复
     * @param array
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }

        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{6,7,4,9,3,5,3,1};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
