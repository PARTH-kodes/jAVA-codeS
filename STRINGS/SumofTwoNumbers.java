import java.math.*;

public class SumofTwoNumbers {
    public static String findSum(String X, String Y) {
        int lenX = X.length();
        int lenY = Y.length();
        StringBuffer result = new StringBuffer();
        int endX = lenX - 1;
        int endY = lenY - 1;
        int sum = 0, carry = 0;
        while (endX >= 0 || endY >= 0 || carry != 0) {
            int v1 = 0;
            int v2 = 0;
            if (endX >= 0) {
                v1 = X.charAt(endX) - '0';
            }
            if (endY >= 0) {
                v2 = Y.charAt(endY) - '0';
            }

            sum = (v1 + v2 + carry) % 10;
            carry = (v1 + v2 + carry) / 10;

            result.append(sum);
            endX--;
            endY--;
        }
        String ans = result.reverse().toString();
        ans = removeStartingZeros(new StringBuilder(ans), result.length(), ' ');
        if (ans.isEmpty()) {
            return "0";
        }
        return ans;
    }

    private static String removeStartingZeros(StringBuilder result, int length, char c) {
        int start = 0;
        while (start < length) {
            if (result.charAt(start) == '0') {
                result.setCharAt(start, ' ');
            } else {
                break;
            }
            start++;
        }
        return result.toString().trim();
    }

    // APPROACH - 2 ----> remember ---> requires import java.util.math.*;
    public static String getSum(String x, String y) {
        BigInteger a = new BigInteger(x);
        BigInteger b = new BigInteger(y);
        System.out.println(a.add(b));
        return (a.add(b)).toString();
    }

    public static void main(String[] args) {
        System.out.println(findSum("0000", "0000000"));
        getSum("000000000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000034000000000000000");
    }
}