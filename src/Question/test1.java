package Question;

public class test1 {
    public static int countPrimes(int n) {
        if (n < 3)
            return 0;
        int count = 1;
        //i+=2是要过滤掉偶数
        for (int i = 3; i < n; i += 2) {
            count += isPrimes(i) ? 1 : 0;
        }
        return count;
    }

    //判断是否是素数
    private static boolean isPrimes(int i) {
        int sqrt = (int) Math.sqrt(i);
        //一个素数永远都不可能被偶数整除，所以这里是j+=2
        for (int j = 3; j <= sqrt; j += 2) {
            if (i % j == 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
