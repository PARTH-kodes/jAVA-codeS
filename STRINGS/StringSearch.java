import java.util.*;

public class StringSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the test cases: ");
        int test = sc.nextInt();
        while (test >= 0) {
            System.out.println("Enter the text and pattern strings: ");
            String text = sc.nextLine();
            String patt = sc.nextLine();

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.search(text, patt);
            if (result.isEmpty()) {
                System.out.println("The given pattern is not found in the provided string.");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    System.out.print(result.get(i) + " ");
                }
                System.out.println();
            }
            
            test--;
        }
        sc.close();
    }
}

class Solution {
    ArrayList<Integer> search(String base, String pattern) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        String str = "";
        int length = pattern.length();
        for (int i = 0; i < base.length() - length; i++) {
            str = base.substring(i, i + length);
            if (str.equals(pattern)) {
                arr.add(i + 1);
            }
        }
        return arr;
    }
}