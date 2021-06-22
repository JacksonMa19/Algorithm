package Question;

public class Part8 {
    //给出一个整数，从该整数去掉k个数字，要求剩下的新整数尽可能小

    //先求局部最优解，最终的到全局最优解的思想，叫做贪心算法

    /**
     * version 1.0
     * @param num
     * @param k
     * @return
     */
    public static String removeKDigits(String num, int k) {
        for (int i = 0; i < k; i++) {
            boolean hasCut = false;
            for (int j = 0; j < num.length(); j++) {
                if (num.charAt(j) > num.charAt(j+1)) {
                    num = num.substring(0,j) + num.substring(j+1, num.length());
                    hasCut = true;
                    break;
                }
            }
            if (!hasCut) {
                num = num.substring(0, num.length()-1);
            }
        }
        int start = 0;
        for (int i = 0; i < num.length() -1; i++) {
            if (num.charAt(i) != '0') {
                break;
            }
            start++;
        }
        num = num.substring(start, num.length());
        if (num.length() == 0) {
            return "0";
        }
        return num;
    }


    /**
     * version 2.0 利用栈直接删除数据
     * @param num
     * @param k
     * @return
     */
    public static String removeKDigits1(String num, int k) {
        int newLength = num.length() - 1;
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (top > 0 && stack[top - 1] > c && k >0) {
                top -= 1;
                k -= 1;
            }
            stack[top++] = c;//入栈
        }
        int offset = 0;
        while (offset < newLength && stack[offset] == '0') {
            offset++;
        }
        return offset == newLength?"0":new String(stack,offset, newLength-offset);
    }

    public static void main(String[] args) {
        String str = "87654321";
        System.out.println(removeKDigits1(str, 4));
    }
}
