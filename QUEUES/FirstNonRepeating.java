import java.util.*;

public class FirstNonRepeating {

    public static void nonRepeat(String str) {
        Queue<Character> result = new LinkedList<>();
        int arr[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.add(ch);
            arr[ch - 'a']++;
            while (!result.isEmpty() && arr[result.peek() - 'a'] > 1) {
                result.remove();
            }
            if (result.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(result.peek() + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        nonRepeat("aabccxb");
    }
}