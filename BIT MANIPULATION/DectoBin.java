import java.util.*;

public class DectoBin {
    public static String converter(int n) {
        String bin = "";
        while (n != 0) {
            bin = (n % 2) + bin;
            n /= 2;
        }
        return bin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        String res = converter(n);
        System.out.println("Equivalent binary value of " + n + " is: " + res);
        sc.close();
    }
}