import java.util.*;

public class OptimalGame {
    public static long countMaximum(int arr[], int n) {

        Integer array[] = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Deque<Integer> d = new ArrayDeque<>();
        long maxCount = 0;
        for (int i = 0; i < n; i++) {
            d.add(i);
        }

        while (!d.isEmpty()) {
            if (array[d.getFirst()] > array[d.getLast()]) {
                maxCount += array[d.removeFirst()];
                if (array[d.getFirst()] > array[d.getLast()]) {
                    d.removeFirst();
                } else {
                    d.removeLast();
                }
            } else {
                maxCount += array[d.removeLast()];
                if (array[d.getFirst()] > array[d.getLast()]) {
                    d.removeFirst();
                } else {
                    d.removeLast();
                }
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {

    }
}