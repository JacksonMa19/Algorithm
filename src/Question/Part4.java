package Question;

public class Part4 {
    //判断一个整数是不是2 的整数次幂
    //method 1： 暴力枚举
    public static boolean isPowerOf2(int a) {
        int temp = 1;
        while (temp <= a) {
            if (temp == a) {
                return true;
            }
            temp = temp*2;      //也可将此操作换做左移位运算
        }
        return false;
    }


    //method2 ： 发现规律
    //如果一个十进制数是2的整数次幂， 那么他的二进制数必是最高位是1，其他位是0, 且将其减一在转化为二进制数，各位都是1
    //时间复杂度著有O(1)
    public static boolean isPowerOf2v2(int num) {
        return (num&(num - 1)) == 0;
    }

    public static void main(String[] args) {

        System.out.println(isPowerOf2v2(999999999));
    }
}
