import java.util.*;

public class PushBottom_ReverseStack {
    
    public static void pushAtBottom(Stack<Integer> sample, int data) {
        if (sample.isEmpty()) {
            sample.push(data);
            return;
        }
        int top = sample.pop();
        pushAtBottom(sample, data);
        sample.push(top);
    }

    public static void reverseStack(Stack<Integer> sample) {
        if (sample.isEmpty()) {
            return;
        }

        int top = sample.pop();
        reverseStack(sample);
        pushAtBottom(sample, top);
    }

    public static void printStack(Stack<Integer> sample) {
        while (!sample.isEmpty()) {
            System.out.println(sample.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> sample = new Stack<>();
        sample.push(1);
        sample.push(2);
        sample.push(3);
        pushAtBottom(sample, 4);
        reverseStack(sample);

        printStack(sample);
    }
}