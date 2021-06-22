package SortingAlgorithm;

import java.util.Arrays;

public class HeapSort {
    /**
     * “下沉“调整
     * @param array
     * @param parentIndex
     * @param length
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex ++;
            }
            if (temp >= array[childIndex])
                break;
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }


    public static void heapSort(int[] array) {
        for (int i = (array.length - 2)/2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));

        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            downAdjust(array, 0 ,i);
        }
    }


    public static void main(String[] args) {
        int[] array = new int[] {4,5,3,6,2,812,0};
        heapSort(array);
        System.out.println(Arrays.toString(array));

    }
 }
