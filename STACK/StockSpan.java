import java.util.*;

public class StockSpan {
    public static void stockSpan(int stock[], int span[], Stack<Integer> prevHigh) {
        span[0] = 1;
        prevHigh.push(0);
        for (int i = 1; i < span.length; i++) {
            while (!prevHigh.isEmpty() && stock[i] > stock[prevHigh.peek()]) {
                prevHigh.pop();
            }
            if (prevHigh.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - prevHigh.peek();
            }
            prevHigh.push(i);
        }

        for (int i : span) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int stock[] = { 100, 80, 60, 70, 60, 85, 100 };
        stockSpan(stock, new int[stock.length], new Stack<>());
    }
}