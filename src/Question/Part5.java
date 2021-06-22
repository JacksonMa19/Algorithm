package Question;

import java.util.ArrayList;

public class Part5 {
    //有一个无序整型数组，求排序后的任意两个相邻元素的最大差值
    //思路1：可用计数排序

    /**
     *
     * @param array
     * @return
     */
    public static int getMaxSortedDistance(int[] array) {
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
        if (max == min) {
            return 0;
        }

        int[] countArray = new int[d + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min] ++;
        }

        int distance = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] == 0) {
                distance ++;
                continue;
            }
            if (countArray[i] != 0) {
                list.add(distance);
                distance = 0;

            }
        }
        int maxDistance = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > maxDistance) {
                maxDistance = list.get(i);
            }
        }
        return maxDistance + 1;
    }

    //思路2：采用桶排序

    /**
     *
     * @param array
     * @return
     */
    public static int getMaxSortedDistance1(int[] array) {
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
        if (d == 0) {
            return 0;
        }

        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }

        for (int i = 0; i < array.length; i++) {
            int index = ((array[i] - min)  * (bucketNum - 1) /d);
            if (buckets[index].min == null || buckets[index].min > array[i]) {
                buckets[index].min = array[i];
            }
            if (buckets[index].max == null || buckets[index].max < array[i]) {
                buckets[index].max = array[i];
            }
         }

        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null) {  //代表桶为空
                continue;
            }
            if (buckets[i].min - leftMax > maxDistance) {
                maxDistance = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }
        return maxDistance;

    }

    //桶里只有最大值和最小值
    private static class Bucket {
        Integer max;
        Integer min;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,1,1,1,1};
        int[] array1 = new int[] {1,4,5,6,7,8};
        System.out.println(getMaxSortedDistance1(array1));
    }
}
