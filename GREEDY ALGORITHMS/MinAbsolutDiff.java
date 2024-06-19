import java.util.*;

public class MinAbsolutDiff {
    public static int calculateMinDiff(int[] A, int[] B) {
        Integer a[] = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Integer b[] = Arrays.stream(B).boxed().toArray(Integer[]::new);

        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(b, Collections.reverseOrder());
        int minDiff = 0;
        System.out.println("The minimum difference will be between the pair of values: ");
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.println("|" + a[i] + " - " + b[i] + "| = " + Math.abs(a[i] - b[i]));
            minDiff += Math.abs(a[i] - b[i]);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int A[] = { 30, 40, 10, 15, 20 };
        int B[] = { 200, 40, 220, 19, 54 };
        System.out.println("Hence the total minimum difference is: " + calculateMinDiff(A, B));
    }
}