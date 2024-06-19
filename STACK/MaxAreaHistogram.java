import java.util.*;

public class MaxAreaHistogram {
    public static int maxArea(int height[]) {
        int maxArea = 0;
        int[] nxtSmalRht = new int[height.length];
        int[] nxtSmalLft = new int[height.length];

        Stack<Integer> help = new Stack<>();

        // NEXT SMALL IN THE RIGHT OF EVERY ELEMENT
        for (int i = height.length - 1; i >= 0; i--) {
            while (!help.isEmpty() && height[help.peek()] >= height[i]) { /*
                                                                           * IN NEXT GREATER WE POP UNTIL A BIGGER
                                                                           * NUMBER IS NOT ACHEIVED THAN THE CURRENT
                                                                           * ELEMENT, HERE WE DO THE OPPOSITE, AND POP
                                                                           * UNTIL A SMALLER ELEMENT IS NOT REACHED
                                                                           */
                help.pop();
            }
            if (help.isEmpty()) {
                nxtSmalRht[i] = height.length;
            } else {
                nxtSmalRht[i] = help.peek();
            }
            help.push(i);
        }

        help = new Stack<>();

        // NEXT SMALL IN THE LEFT OF EVERY ELEMENT
        for (int i = 0; i < height.length; i++) { /* JUST REVERSE THE LOOP OF RIGHT AND REST IS SAME */
            while (!help.isEmpty() && height[help.peek()] >= height[i]) {
                help.pop();
            }
            if (help.isEmpty()) {
                nxtSmalLft[i] = -1;
            } else {
                nxtSmalLft[i] = help.peek();
            }
            help.push(i);
        }

        // MAXIMUM AREA FOR EVERY HEIGHT
        for (int i = 0; i < height.length; i++) {
            int currArea = height[i] * (nxtSmalRht[i] - nxtSmalLft[i] - 1); /*
                                                                             * AREA = HEIGHT * WIDTH
                                                                             * WIDHT WILL BE SMALLEST TOWER IN THE RIGHT
                                                                             * - SMALLEST TOWER IN THE LEFT -
                                                                             * 1(EXCLUSIVE OF BOTH)
                                                                             */
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int heights[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println(maxArea(heights));
        // List<Integer> h = new ArrayList<>();
    }
}