package SortingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {
    public static double[] bucketSort(double[] array) {
        double max = array[0];
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }
        double d = max - min;
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketLists = new ArrayList<>(bucketNum);
        for (int j = 0; j < bucketNum; j++) {
            bucketLists.add(new LinkedList<Double>());

        }
        //装桶
        for (int i = 0; i < array.length; i++) {
            //判断该元素属于哪个桶
            int num = (int)((array[i] - min) / d * (bucketNum - 1));
            bucketLists.get(num).add(array[i]);
        }
        //将桶内数据排序
        for (int i = 0; i < bucketLists.size(); i++) {
            Collections.sort(bucketLists.get(i));
        }

        double[] sortArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketLists) {
            for (double element: list) {
                sortArray[index++] = element;
            }
        }

        return sortArray;

    }


    public static void main(String[] args) {
        double[] array = new double[] {2.34,6.4,2.78,4,5,6.77,8.9,0.8};
        double[] doubles = bucketSort(array);
        System.out.println(Arrays.toString(doubles));

    }
}
