package JIEGOU;

import java.util.Arrays;

public class BinaryHeap {
    /**
     * 上浮调整
     * @param array
     */
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1)/2;

        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            //单向赋值
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1)/2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉调整
     * @param array
     * @param parentIndex
     * @param length
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex ++;
            }
            if (temp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 构建堆
     * @param array
     */
    public static void buildHeap(int[] array) {
        for (int i = (array.length - 2)/2; i >= 0 ; i--) {
            downAdjust(array, i , array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));

    }
}
