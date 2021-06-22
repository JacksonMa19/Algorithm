package SearchAlgorithm;

public class binarySearch {
    public static int search(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = end - 1;

            }

        }
        return -1;
    }


    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println(search(array, 180));
    }
}
