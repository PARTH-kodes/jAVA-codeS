import java.util.*;

public class MaximumElement
{
    public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> element = new Stack<>();
        Stack<Integer> maxElement = new Stack<>();
        List<Integer> result = new ArrayList<>();
        for (String op : operations) {
            String[] operate = op.split(" ");
            int choice = Integer.parseInt(operate[0]);

            switch (choice) {
                case 1:
                    int insert = Integer.parseInt(operate[1]);
                    element.push(insert);
                    if (maxElement.isEmpty() == true || insert >= maxElement.peek()) {
                        maxElement.push(insert);
                    }
                    break;
                case 2:
                    int delete = element.pop();
                    if (delete == maxElement.peek()) {
                        maxElement.pop();
                    }
                    break;
                case 3:
                    result.add(maxElement.peek());
                    break;
                default:
                    break;
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        
    }
}