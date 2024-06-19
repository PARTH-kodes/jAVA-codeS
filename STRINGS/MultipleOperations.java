import java.util.*;

public class MultipleOperations {
    public static void printMax(List<String> operations) {
        ListIterator<String> iterator = operations.listIterator();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();

        while (iterator.hasNext()) {
            String operate[] = iterator.next().split(" ");
            int choice = Integer.parseInt(operate[0]);
            switch (choice) {
                case 1:
                    stack.push(Integer.parseInt(operate[1]));
                    if (maxStack.isEmpty() || maxStack.peek() <= stack.peek()) {
                        maxStack.add(stack.peek());
                    }
                    break;
                case 2:
                    if (stack.peek() == maxStack.peek()) {
                        stack.pop();
                        maxStack.pop();
                    } else {
                        stack.peek();
                    }
                    break;
                case 3:
                    System.out.println(maxStack.peek());
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        List<String> operations = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the operations:");
        int n = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter the operations:");
        for (int i = 0; i < n; i++) {
            operations.add(sc.nextLine());
        }

        printMax(operations);
        sc.close();
    }
}