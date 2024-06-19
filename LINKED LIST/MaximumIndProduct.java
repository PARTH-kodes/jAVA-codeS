import java.util.*;

public class MaximumIndProduct {
    public static int maxIndex(List<Integer> nums) {
        Stack<Integer> help = new Stack<>();
        int right[] = new int[nums.size()];
        int left[] = new int[nums.size()];

        for (int i = left.length - 1; i >= 0; i--) {
            while (!help.isEmpty() && nums.get(help.peek()) <= nums.get(i)) {
                help.pop();
            }
            if (help.isEmpty()) {
                left[i] = 0;
            } else {
                left[i] = help.peek() + 1;
            }
            help.push(i);
        }

        help = new Stack<>();
        for (int i = 0; i < left.length; i++) {
            while (!help.isEmpty() && nums.get(help.peek()) <= nums.get(i)) {
                help.pop();
            }
            if (help.isEmpty()) {
                right[i] = 0;
            } else {
                right[i] = help.peek() + 1;
            }
            help.push(i);
        }

        int maxIndex = 0;
        for (int i = 0; i < right.length; i++) {
            maxIndex = Integer.max(maxIndex, right[i] * left[i]);
        }

        return maxIndex;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the list of numbers: ");
        int n = sc.nextInt();
        System.out.println("Enter the numbers in the list");
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }
        int result = maxIndex(nums);
        System.out.println("Enter the maximum index product, that can exist in the given array is: " + result);

        sc.close();
    }
}