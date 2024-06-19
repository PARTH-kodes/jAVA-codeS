import java.util.*;

public class RevArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an array length: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n / 2; i++) {
            arr[i] = arr[i] + arr[n - 1 - i];
            arr[n - 1 - i] = arr[i] - arr[n - 1 - i];
            arr[i] = arr[i] - arr[n - 1 - i];
        }
        System.out.println("Array after reversing: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}