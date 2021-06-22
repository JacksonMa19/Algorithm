package SortingAlgorithm;

import java.util.Arrays;

public class RadixSort {
    public static final int ASCII_RANGE = 128;

    public static String[] radixSort(String[] array, int maxLength) {
        String[] sortArray = new String[array.length];

        for (int k = maxLength - 1; k >= 0; k--) {
            int[] count = new int[ASCII_RANGE];
            for (int i = 0; i < array.length; i++) {
                int index = getCharIndex(array[i], k);
                count[index]++;
            }
            for (int i = 1; i < count.length; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (int i = array.length - 1; i >= 0; i--) {
                int index = getCharIndex(array[i], k);
                int sortIndex = count[index] - 1;
                sortArray[sortIndex] = array[i];
                count[index]--;
            }
            array = sortArray.clone();
        }
        return array;

    }

    private static int getCharIndex(String str, int k) {
        if (str.length() < (k + 1)) {
            return 0;
        }
        return str.charAt(k);
    }


    public static void main(String[] args) {
        String[] array = {"qd", "zbc", "qwe", "hhh", "a", "cws", "ope"};
        System.out.println(Arrays.toString(radixSort(array, 3)));
    }
}
