import java.util.Scanner;
import java.util.Stack;

public class StackInsert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();

        // 1st Method
        int n = sc.nextInt(); // -- size of the stack
        int x = sc.nextInt(); // -- element to be inserted at the bottom of the stack
        int i = 1;
        do {
            st.push(sc.nextInt());
            i++;
        } while (i <= n);
        st.add(0, x);
        for (Integer integer : st) {
            System.out.print(integer + " ");
        }

        // -- Alternate Method - in which input is taken in single line.
        /*
         * sc.nextLine();
         * String str = sc.nextLine();
         * String[] sta = str.split(" ");
         * for (String string : sta) {
         * st.push(Integer.parseInt(string));
         * }
         * st.add(0, x);
         * for (Integer integer : st) {
         * System.out.print(integer + " ");
         * }
         * System.out.println();
         */
        sc.close();

    }
}