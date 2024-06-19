import java.util.*;

public class NextGreaterElement {

    public static int[] nextGreater(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int nxtGrtr[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) { /*
                                                                 * yaa toh stack khali ho ya toh jo element hai
                                                                 * (arr[i]) wo stack ke top se chota hai, tab
                                                                 * condition false ho jaygei
                                                                 */
                st.pop();
            }
            if (st.isEmpty()) {
                nxtGrtr[i] = -1;
            } else {
                nxtGrtr[i] = arr[st.peek()];
            }
            st.push(i);

        }
        return nxtGrtr;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        int nxtGrtr[] = nextGreater(arr);
        for (int i : nxtGrtr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}