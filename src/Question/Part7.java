package Question;

import java.util.Arrays;

public class Part7 {
    //给出一个正整数，找出这个正整数的所有数字全排列的下一个数
    //有点不知其然
    public static int[] findNearestNumber(int[] numbers) {
        int index = findTransferPoint(numbers);
        if (index == 0) {
            return null;
        }

        int[] numberCopy = Arrays.copyOf(numbers, numbers.length);
        exchangeHead(numberCopy, index);
        reverse(numberCopy, index);
        return numberCopy;
    }

    private static int[] reverse(int[] num, int index) {
        for (int i = index, j = num.length - 1; i < j; i++,j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return num;
    }

    private static int[] exchangeHead(int[] numbers, int index) {
        int head = numbers[index - 1];
        for (int i = numbers.length - 1; i > 0; i--) {
            if (head < numbers[i]) {
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
        return numbers;
    }

    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0 ; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        for (int i = 0; i < 10; i++) {
            numbers = findNearestNumber(numbers);
            outputNumbers(numbers);
        }
    }

    private static void outputNumbers(int[] numbers) {
        for (int i :
                numbers) {
            System.out.print(i);

        }
        System.out.println();
    }
}
