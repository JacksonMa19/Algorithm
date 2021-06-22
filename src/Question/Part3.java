package Question;

public class Part3 {
    //求两个整数的最小公约数
    /**
     * 暴力枚举法
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisorV1(int a, int b) {
        int big = a>b ? a:b;
        int small = a<b ? a:b;
        if (big%small == 0) {
            return small;
        }
        for (int i = small/2; i > 1 ; i--) {
            if (big%i==0 && small%i==0) {
                return i;
            }
        }
        return 1;
    }

    //方法 2：“辗转相除法” 定理：两个正整数a和b（a>b），他们的最大公约数等于a除以b的余数c和b之间的最大公约数
    public static int getGreatestCommonDivisorV2(int a, int b) {
        int big = a>b ? a:b;
        int small = a<b ? a:b;
        if (big%small == 0) {
            return small;
        }
        return getGreatestCommonDivisorV2(big%small, small);
    }


    //方法3："更相减损术"   两个正整数a和b（a>b），他们的最大公约数等于a-b的差值c和较小数b的最大公约数
    public static int getGreatestCommonDivisorV3(int a, int b) {
        if (a == b) {
            return a;
        }
        int big = a>b ? a:b;
        int small = a<b ? a:b;

        return getGreatestCommonDivisorV3(big-small, small);
    }

    //利用移位运算性能优良
    public static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        if ((a&1)==0 && (b&1)==0) {
            return gcd(a>>1, b>>1)<<1;
        } else if ((a&1)==0 && (b&1)!=0) {
            return gcd(a>>1, b);
        } else if ((a&1)!=0 && (b&1)==0) {
            return gcd(a, b>>1);
        } else  {
            int big = a>b ? a:b;
            int small = a<b ? a:b;
            return gcd(big - small, small);
        }
    }



    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisorV2(100, 123));
        System.out.println(gcd(56, 112));
    }
}
