package SortingAlgorithm;

import java.util.Arrays;

public class ShellSort {
    public static void shellSort(int[] array) {
        int d = array.length;
        while (d > 1) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i = i + d) {
                    int temp = array[i];
                    int j;
                    for (j = i - d; (j >= 0) && (array[j] > temp); j = j - d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{6,7,4,9,3,5,3,1};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
