import java.util.*;

/* this code finds all the possible combinations of the elements of the arr, which result in the sum = target. Repeating a same element is allowed.*/

public class CombinationSum_I {
    public static void findCombination(int indx, int arr[], int target, List<List<Integer>> ans, List<Integer> current) {

        if (indx == arr.length) {

            if (target == 0) {

                ans.add(new ArrayList<>(current)); /*
                                                    * ans.add(new ArrayList<>(current)); is adding a copy of the current
                                                    * combination (stored in current) to the list of combinations (ans).
                                                    * This way, each combination stored in ans is independent of any
                                                    * changes made to current afterwards.
                                                    */
            }

            return;

        }

        if (arr[indx] <= target) {

            current.add(arr[indx]);

            findCombination(indx, arr, target - arr[indx], ans, current);

            current.remove(current.size() - 1);

        }

        findCombination(indx + 1, arr, target, ans, current);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");

        int size = sc.nextInt();
        
        int arr[] = new int[size];

        System.out.println("Enter the elements of the array: ");

        for (int i = 0; i < size; i++) {

            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the target: ");

        int target = sc.nextInt();

        List<Integer> ds = new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);
        
        findCombination(0, arr, target, result, ds);

        System.out.println(result);

        sc.close();

    }

}