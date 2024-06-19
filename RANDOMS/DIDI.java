public class DIDI
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
                        System.out.print("I ");
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
                        System.out.print("L ");
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
                        System.out.print("Y ");
                    } else if ((i <= 2) && ((j == (12 + i)) || (j == 18 - i))) {
                        System.out.print("Y ");
                    } else {
                        System.out.print("  ");
                    }
                    j++;
                }
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.println("D D     I I I I I   D D     I I I I I");
        System.out.println("D   D       I       D   D       I");
        System.out.println("D    D      I       D    D      I");
        System.out.println("D   D       I       D   D       I");
        System.out.println("D D     I I I I I   D D     I I I I I");
    }
}