package SortingAlgorithm;

import java.util.Arrays;

public class BubbleSort {
    /**
     * 冒泡排序 version 1.0
     * @param array
     */
    public static void sort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                }

            }
        }
    }


    public static void sort1(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSort = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSort = false;
                }
            }
            //必须第一轮遍历下来才能知道是否有序，如果有序第二轮的交换操作不需要执行，从而isSort == true  直接跳出循环
            if (isSort) {
                break;
            }

        }
    }

    /**
     * 确定有序边界
     * @param array
     */
    public static void sort2(int array[]) {
        int lastExchangeIndex = 0;
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            Boolean isSort = true;
            for (int j = 0; j < sortBorder; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSort = false;
                    lastExchangeIndex = j;
                }

            }
            sortBorder = lastExchangeIndex;
            if (isSort) {
                break;
            }
        }
    }

    /**
     * 鸡尾酒排序法
     * @param array
     */
    public static void sort3(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length/2; i++) {

            boolean isSort = true;
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSort = false;
                }

            }
            if (isSort) {
                break;
            }


            for (int j = array.length - i - 1; j < i ; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    isSort = false;
                }
            }

            if (isSort) {
                break;
            }

        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{3,1,4,9,6,4,8};
        sort3(array);
        System.out.println(Arrays.toString(array));
    }
}
