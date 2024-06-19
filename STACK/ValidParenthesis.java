import java.util.*;

public class ValidParenthesis {
    public static boolean isValid(String brackets, Stack<Character> check) {
        for (int i = 0; i < brackets.length(); i++) {
            char current = brackets.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                check.push(current);
            } else {
                if (check.isEmpty()) {
                    return false;
                }
                char top = check.peek();
                if ((top == '(' && current == ')') || (top == '{' && current == '}')
                        || (top == '[' && current == ']')) {
                    check.pop();
                } else {
                    return false;
                }
            }
        }
        if (!check.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String brackets = "(";
        System.out.println(isValid(brackets, new Stack<>()));
    }
}