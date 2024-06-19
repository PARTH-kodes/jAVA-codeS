public class MAHI
{
    public static void main(String[] args)
    {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 18; j++) {
                if (j % 6 == 0) {
                    System.out.print("  ");
                }
                while (j <= 5) {
                    if (i == 1 || i == 5 || j == 3) {
                        System.out.print("M ");
                    } else {
                        System.out.print("  ");
                    }
                    j++;
                }
                if (j % 6 == 0) {
                    System.out.print("  ");
                }
                while (j >= 7 && j < 12) {
                    if ((j == 7) || (i == 5)) {
                        System.out.print("M ");
                    } else {
                        System.out.print("  ");
                    }
                    j++;
                }

                if (j % 6 == 0) {
                    System.out.print("  ");
                }

                while (j > 12 && j < 18) {
                    if ((i >= 3 && i <= 5 && j == 15)) {
                        System.out.print("M ");
                    } else if ((i <= 2) && ((j == (12 + i)) || (j == 18 - i))) {
                        System.out.print("M ");
                    } else {
                        System.out.print("  ");
                    }
                    j++;
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("M        M      A      H       H  I I I I I");
        System.out.println("M M   M  M     A A     H       H      I");
        System.out.println("M   M    M    A   A    H H H H H      I");
        System.out.println("M        M   A A A A   H       H      I");
        System.out.println("M        M  A       A  H       H  I I I I I");
    }
}