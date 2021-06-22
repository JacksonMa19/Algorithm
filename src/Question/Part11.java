package Question;

import java.util.Arrays;

public class Part11 {
    //问题：一个无序数组里若干个正整数，范围是1~100，其中99个整数出现了偶数次，只有一个整数出现了奇数次，如何找到
    public static int findOne(int[] array) {
        int one = 0;
        for (int i = 0; i < array.length; i++) {
            one ^= array[i];
        }
        return one;
    }


    //拓展：一个无序数组里若干个正整数，范围是1~100，其中98个整数出现了偶数次，只有2个整数出现了奇数次，
    public static int[] findLostNum(int[] array) {
        int[] result = new int[2];
        //第一异或运算
        int xorResult = 0;
        for (int i = 0; i < array.length; i++) {
            xorResult ^= array[i];
        }
        if (xorResult == 0) {
            return null;
        }
        //确定不同位
        int separator = 1;
        while (0 == (xorResult&separator)) {
            separator <<= 1;
        }
        //分治法
        for (int i = 0; i < array.length; i++) {
            if (0 == (array[i]&separator)) {
                result[0] ^= array[i];
            } else {
                result[1] ^= array[i];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] array =  new int[] {1,2,2,1,3,5,4,4,5};
        System.out.println(findOne(array));

        int[] array1 =  new int[] {1,2,2,1,3,5,4,4,5,8};
        int[] lostNum = findLostNum(array1);
        System.out.println(Arrays.toString(lostNum));


    }
}
