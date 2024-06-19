import java.util.*;

public class RemoveDuplicates {

    public static void duplicates(String str, int indx, StringBuilder newStr, boolean[] alpha) {
        if (indx == str.length()) {
            System.out.println(newStr);
            return;
        }

        char ch = str.charAt(indx);
        if (alpha[ch - 'a'] == true) {
            duplicates(str, indx + 1, newStr, alpha);
        } else {
            alpha[ch - 'a'] = true;
            duplicates(str, indx + 1, newStr.append(ch), alpha);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();

        StringBuilder newStr = new StringBuilder("");

        boolean[] alpha = new boolean[26];
        Arrays.fill(alpha, false);

        duplicates(str, 0, newStr, alpha);

        sc.close();
    }
}