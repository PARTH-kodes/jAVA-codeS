// import java.util.*;

public class pattern {
    public static void srhombus_patt(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= n; k++) {
                // if ((i == 1) || (k == 1) || (k == n) || (i == n)) { -- hollow rhombus
                System.out.print("* ");
                // }
                // else {
                // System.out.print(" ");;
                // }
            }
            System.out.println();
        }
    }

    public static void hrhombus_patt(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= n; k++) {
                if ((i == 1) || (k == 1) || (k == n) || (i == n)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                    ;
                }
            }
            System.out.println();
        }
    }

    public static void char_pattern(int n) {
        char ch = '!';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch++ + " ");

            }
            System.out.println();
        }
    }

    public static void butter_patt(int n) {
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for (int k = 1; k <= n - (2 * i); k++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = n / 2; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print("* ");
            }
            for (int k = 1; k <= n - (2 * i); k++) {
                System.out.print("  ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void patt_101(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) { // (i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond(int n) {
        for (int i = 1; i <= n / 2; i++) {
            for (int j = n / 2; j >= i; j--) {
                System.out.print("  ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = n / 2; i >= 1; i--) {
            for (int j = n / 2; j >= i; j--) {
                System.out.print("  ");
            }
            for (int k = (i * 2) - 1; k >= 1; k--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 10;

        // char_pattern(n);
        // srhombus_patt(n);
        // hrhombus_patt(n);
        // butter_patt(n);
        // patt_101(n);
        diamond(n);

    }
}