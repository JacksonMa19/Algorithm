package SortingAlgorithm;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1 , end);
            merge(array, start, mid, end);

        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        int p = 0;
        while ((p1 <= mid) && (p2  <= end)) {
            if (array[p1] <= array[p2]) {
                temp[p++] = array[p1++];
            } else  {
                temp[p++] = array[p2++];
            }
        }
        while (p1 <= mid) {
            temp[p++] = array[p1++];
        }
        while (p2 <= end) {
            temp[p++] = array[p2++];
        }
        for (int i = 0; i < temp.length; i++) {
            array[i + start] = temp[i];
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{6,7,4,9,3,5,3,1};
        mergeSort(array, 0 , array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
