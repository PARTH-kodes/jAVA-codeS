import java.util.*;

// this code has also been done with the help of nodes and methods, in the linked class!! 
public class RemoveEveryKthNode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> LL = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            LL.addLast(i + 1);
        }
        System.out.println(LL);
        System.out.println("Enter the value for k: ");
        int k = sc.nextInt();
        if (k == 1) {
            LL.clear();
        }
        int n = LL.size();
        int l = k - 1;
        for (int i = 1; i <= (n / k); i++) {

            LL.remove(l);
            l += (k - 1);
        }
        System.out.println(LL);
        sc.close();
    }
}