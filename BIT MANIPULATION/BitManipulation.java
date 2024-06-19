import java.util.*;

public class BitManipulation {

    public static int getIthBit(int n, int i) {
        if ((n & (1 << i)) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        return (n | (1 << i));
    }

    public static int clearIthBit(int n, int i) {
        return (n & ~(1 << i));
    }

    public static int updateIthBit(int n, int i, int updateBit) {
        if (updateBit == 0) {
            return clearIthBit(n, i);
        } else {
            return setIthBit(n, i);
        }
    }

    public static int clearlastIthbits(int n, int i) {
        return n & (-1 << i);
    }

    public static int clearRange(int n, int i, int j) {
        return (n & ((-1 << j + 1) | (1 << i - 1)));
    }

    public static boolean isPowerof2(int n) {
        return ((n & (n - 1)) == 0);
    }

    public static int pow(int a, int n) {           // calculates (a^n)
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans = a * ans;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // System.out.println("Enter the decimal number and the bit number you want");
        // System.out.println((getIthBit(sc.nextInt(), sc.nextInt())));

        // System.out.println("Enter the decimal number and the bit you want to set 1");
        // System.out.println(DectoBin.converter(setIthBit(sc.nextInt(),
        // sc.nextInt())));

        // System.out.println("Enter the decimal number and the bit number you want
        // clear");
        // System.out.println(DectoBin.converter(clearIthBit(sc.nextInt(),
        // sc.nextInt())));

        // System.out.println("Enter the decimal number and the bit number you want to
        // update and the update value");
        // System.out.println(DectoBin.converter(updateIthBit(sc.nextInt(),
        // sc.nextInt(), sc.nextInt())));

        // System.out.println("Enter the decimal number and the bit number from where
        // you want to clear the bits");
        // System.out.println(DectoBin.converter(clearlastIthbits(sc.nextInt(),
        // sc.nextInt())));

        // System.out.println("Enter the decimal number and the range of bits you want
        // to clear");
        // System.out.println(DectoBin.converter(clearRange(sc.nextInt(), sc.nextInt(),
        // sc.nextInt())));

        // System.out.println("Enter the decimal number you want to check is a power of
        // 2");
        // System.out.println(isPowerof2(sc.nextInt()));
        // int n = Integer.bitCount(152);
        // System.out.println(n);

        // System.out.println(pow(3, 5));
        sc.close();
    }
}