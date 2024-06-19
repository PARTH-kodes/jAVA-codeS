import java.util.*;

public class SubsequencesRecursion {
    public static void allSubsequences(int indx, int arr[], List<Integer> seq) {

        if (indx == arr.length) {
            System.out.println(seq.toString());
            return;
        }
        // current element is picked
        seq.add(arr[indx]);
        allSubsequences(indx + 1, arr, seq);

        // current element is not picked
        seq.removeLast();
        allSubsequences(indx + 1, arr, seq);
        
    }

    public static void sumSubsequences(int indx, int arr[], LinkedList<Integer> seq, int curr_sum, int req_sum) {
        if (indx == arr.length) {
            if (curr_sum == req_sum) {
                System.out.println(seq.toString());
            }
            return;
        }
        // current element is selected
        seq.add(arr[indx]);
        curr_sum += arr[indx];

        sumSubsequences(indx + 1, arr, seq, curr_sum, req_sum);

        // current element is not selected
        curr_sum -= arr[indx];
        seq.removeLast();

        sumSubsequences(indx + 1, arr, seq, curr_sum, req_sum);
    }

    public static boolean oneSubsequnece(int indx, int arr[], List<Integer> seq, int curr_sum, int req_sum) {
        if (indx == arr.length) {
            if (curr_sum == req_sum) {
                System.out.println(seq.toString());
                return true;
            }
            return false;
        }

        // picked
        seq.add(arr[indx]);
        curr_sum += arr[indx];
        if (oneSubsequnece(indx + 1, arr, seq, curr_sum, req_sum) == true) {
            return true;
        }

        //not picked
        curr_sum -= arr[indx];
        seq.removeLast();

        if (oneSubsequnece(indx + 1, arr, seq, curr_sum, req_sum) == true) {
            return true;
        }
        return false;
    }

    public static int countSubsequences(int arr[], int indx, int curr_sum, int req_sum) {
        if (indx == arr.length) {
            if (curr_sum == req_sum) {
                return 1;
            } else {
                return 0;
            }
        }
        curr_sum += arr[indx];
        int picked = countSubsequences(arr, indx + 1, curr_sum, req_sum);

        curr_sum -= arr[indx];
        int notPicked = countSubsequences(arr, indx + 1, curr_sum, req_sum);

        return picked + notPicked;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> currentPermutation = new ArrayList<>();
        permute(nums, used, currentPermutation, result);
        return result;
    }

    public static void permute(int[] nums, boolean[] used, List<Integer> currentPermutation,
            List<List<Integer>> result) {
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                currentPermutation.add(nums[i]);
                permute(nums, used, currentPermutation, result);
                currentPermutation.remove(currentPermutation.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 2 };
        LinkedList<Integer> list = new LinkedList<>();
        // List<List<Integer>> permutations = new LinkedList<>();

        allSubsequences(0, arr, list); //---prints all the possible subsequences of
        // the provided array
        // System.out.println();

        // sumSubsequences(0, arr, list, 0, 3); //---prints all the subsequences of the
        // provided array whose sum = req_sum
        // System.out.println();

        // System.out.println(oneSubsequnece(0, arr, list, 0, 5)); //---prints only of
        // the
        // subsequence of the provided array whose sum = req_sum
        // System.out.println();

        // System.out.println(countSubsequences(arr, 0, 0, 3)); //---counts the number
        // of subsequences whose sum = req_sum
        // System.out.println();

        // permutations = permute(arr);
        // for (List<Integer> valid : permutations) {
        // System.out.println(valid);
        // }
    }
}