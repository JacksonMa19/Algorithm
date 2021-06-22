package SortingAlgorithm;

import java.util.Arrays;

public class CountSort {
    /**
     * 计数排序简版
     * @param array
     */
    public static int[] countSort(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int [] countArray = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]] ++;
        }

        int[] sortArray = new int[array.length];
        int index = 0;

        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortArray[index++] = i;
            }
        }
        return sortArray;
    }


    /**
     * 计数排序升级版
     * @param array
     * @return
     */
    public static int[] countSort1(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }

        int d = max - min;

        int[] countArray = new int[d + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min] ++;
        }

        //统计数组做变形，后面的元素等于前面的元素之和
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[ i - 1];
        }

        int[] sortArray = new int[array.length];
        for (int i = array.length - 1; i >= 0 ; i--) {
            sortArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i]  - min] --;
        }
        return sortArray;
    }

    public static void main(String[] args) {
        int[] array = new int[] {8,3,5,6,4,78,890,3,5,12};
        int[] ints = countSort1(array);
        System.out.println(Arrays.toString(ints));

    }
}
