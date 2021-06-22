package SortingAlgorithm;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class QuickSort {

    public static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition1(array, startIndex, endIndex);
        //递归操作
        quickSort(array,startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    /**
     * 分治法 双边循环
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            if (array[right] > pivot && left < right) {
                right--;
            }

            if (array[right] <= pivot && left < right) {
                left++;
            }

            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        array[startIndex] = array[left];
        array[left] = pivot;

        //返回基准元素的下标
        return left;
    }

    /**
     * 单边循环
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition1(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (array[i] < pivot) {
                mark ++;
                int temp = array[mark];
                array[mark] = array[i];
                array[i] = temp;
            }
        }

        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }

    /**
     * 用栈来实现递归
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void quickSortByStack(int[] array, int startIndex, int endIndex) {
        Stack<Map<String, Integer>> quickSortStack = new Stack<Map<String, Integer>>();
        Map rootParam = new HashMap();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);

        while (!quickSortStack.isEmpty()) {
            Map<String, Integer> param = quickSortStack.pop();
            int pivotIndex = partition1(array, param.get("startIndex"), param.get("endIndex"));

            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }

            if (pivotIndex + 1 < param.get("endIndex")) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,6,8,3,2,5,67,2};
        quickSortByStack(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

}
