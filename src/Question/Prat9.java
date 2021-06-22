package Question;

public class Prat9 {
    //大整数求和
    public static String bigNumberSum(String bigNumberA, String bigNumberB) {
        int maxLength = Math.max(bigNumberA.length(), bigNumberB.length());
        int[] arrayA = new int[maxLength+1];
        for (int i = 0; i < bigNumberA.length(); i++) {
            arrayA[i] = bigNumberA.charAt(bigNumberA.length() - i -1) - '0';
        }

        int[] arrayB = new int[maxLength+1];
        for (int i = 0; i < bigNumberB.length(); i++) {
            arrayB[i] = bigNumberB.charAt(bigNumberB.length() - i -1) - '0';
        }
        
        int[] result = new int[maxLength + 1];
        for (int i = 0; i < result.length; i++) {
            int temp = result[i]; //一开始为0
            temp += arrayA[i];
            temp += arrayB[i];
            if (temp >= 10) {
                temp = temp -  10;
                result[i + 1] = 1;
            }
            result[i] = temp;
        }
        StringBuilder builder = new StringBuilder();
        boolean findFirst = false;
        for (int i = result.length - 1; i >= 0 ; i--) {
            if (!findFirst) {
                if (result[i] == 0) {
                    continue;
                }
                findFirst = true;
            }
            builder.append(result[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s1 = "12";
        String s2 = "12";
        System.out.println(bigNumberSum(s2, s1));
    }
}
