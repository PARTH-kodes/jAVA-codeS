import java.util.*;

public class HasDuplicate {
    public static void main(String[] args) {
        int numbers[] = { 1, 2, 3, 4 };
        System.out.println(containsDuplicate(numbers));

    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}
