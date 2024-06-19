import java.util.*;

// STRING IS ALWAYS VALID //
public class DuplicateParenthesis {
    public static boolean isDuplicate(String expression) {
        Stack<Character> check = new Stack<>();
        int count = 0;
        char ch;
        for (int i = 0; i < expression.length(); i++) {
            ch = expression.charAt(i);
            count = 0;
            if (ch == ')') {
                while (check.pop() != '(') {
                    count++;
                }
                if (count == 0) {
                    return true;
                }
            } else {
                check.push(ch);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(isDuplicate("(((a+b)+(c+d)))"));
    }
}