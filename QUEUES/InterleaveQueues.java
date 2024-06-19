import java.util.*;

public class InterleaveQueues
{
    public static Queue<Integer> printInterleave(Queue<Integer> numbers, int size){
        Queue<Integer> temp = new LinkedList<>();
        for (int i = 0; i < size / 2; i++) {
            temp.add(numbers.remove());
        }
        
        while (!temp.isEmpty()) {
            numbers.add(temp.remove());
            numbers.add(numbers.remove());
        }

        return numbers;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> numbers = new LinkedList<>();
        System.out.println("Enter the even length of the queue:");
        int n = sc.nextInt();

        System.out.println("Enter the elements of the Queue");
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        System.out.println("Before Interleaving: ");
        System.out.println(numbers);

        System.out.println("After Interleaving: ");
        numbers = printInterleave(numbers, numbers.size());
        System.out.println(numbers);

        sc.close();
    }
}