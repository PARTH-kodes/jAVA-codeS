import java.util.*;

/* this code finds all the unique combinations of the elements of the arr, which result in the sum = target. Repeating a same element is NOT allowed.*/

public class CombinationSum_II {
    public static void findUniqueCombinations(int indx, int target, int arr[], List<Integer> current,
            TreeSet<List<Integer>> result1) {
        if (indx == arr.length) {
            if (target == 0) {
                result1.add(new ArrayList<>(current));
            }
            return;
        }
        if (arr[indx] <= target) {
            current.add(arr[indx]);
            findUniqueCombinations(indx + 1, target - arr[indx], arr, current, result1);
            current.remove(current.size() - 1);
        }
        findUniqueCombinations(indx + 1, target, arr, current, result1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 3, 5 };
        List<Integer> ds = new ArrayList<>();
        // HashSet<List<Integer>> result = new HashSet<>();
        List<List<Integer>> finalResult = new ArrayList<>();

        TreeSet<List<Integer>> result1 = new TreeSet<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> list1, List<Integer> list2) {
                // Compare lists lexicographically
                // int sizeComparison = Integer.compare(list1.size(), list2.size()); /*
                // lexicographically arrange krne ke liye, elements compare kre jaate hai size
                // ka koi relation nhi hota */
                // if (sizeComparison != 0) {
                // return sizeComparison;
                // }
                for (int i = 0; i < list1.size(); i++) {
                    int elementComparison = Integer.compare(list1.get(i), list2.get(i));
                    if (elementComparison != 0) {
                        return elementComparison;
                    }
                }
                return 0;
            }
        });

        int target = 7;
        Arrays.sort(arr);
        findUniqueCombinations(0, target, arr, ds, result1);
        for (List<Integer> list : result1) {
            finalResult.add(list);
        }
        // Collections.sort(finalResult);
        System.out.println(finalResult);
    }
}