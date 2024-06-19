import java.util.*;

public class QueueReversal
{
    public static void reverse(Queue<Integer> numbers) {
        Stack<Integer> temp = new Stack<>();

        while (!numbers.isEmpty()) {
            temp.add(numbers.remove());
        }
        while (!temp.isEmpty()) {
            numbers.add(temp.pop());            
        }
    }
    public static void main(String[] args)
    {
        Queue<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i + 1);
        }
        System.out.println(numbers);
        reverse(numbers);
        System.out.println(numbers);
    }
}