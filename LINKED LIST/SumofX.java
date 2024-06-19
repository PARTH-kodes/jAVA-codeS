import java.util.*;

public class SumofX {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static class Solution {
        public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                int x, List<List<Integer>> pairs) {
            int count = 0;
            HashSet<Integer> set1 = new HashSet<>(head1);
            HashSet<Integer> set2 = new HashSet<>(head2);
            for (Integer num : set2) {
                List<Integer> current = new ArrayList<>();
                if (set1.contains(x - num)) {
                    current.add(x - num);
                    current.add(num);
                    count++;
                    pairs.add(current);
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of first list: ");
        int n1 = sc.nextInt();

        System.out.println("Enter the list elements: ");
        Integer[] arr1 = new Integer[n1];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter the size of second list: ");
        int n2 = sc.nextInt();
        Integer[] arr2 = new Integer[n2];
        System.out.println("Enter the element of 2nd list: ");

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }
        List<List<Integer>> pairs = new ArrayList<>();
        LinkedList<Integer> head1 = new LinkedList<>(Arrays.asList(arr1));
        LinkedList<Integer> head2 = new LinkedList<>(Arrays.asList(arr2));
        System.out.println("Enter the sum, whose pairs you have to find: ");
        int x = sc.nextInt();
        // Solution ob = new Solution();
        int result = Solution.countPairs(head1, head2, x, pairs);
        System.out.println("There are total " + result + " possible pairs.");
        System.out.println(pairs);
        sc.close();
    }
}