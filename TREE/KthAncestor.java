import java.util.*;

public class KthAncestor {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static int kAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = kAncestor(root.left, n, k);
        // if (leftDist != 0) {
        int rightDist = kAncestor(root.right, n, k);
        // }
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);
        if (max + 1 == k) {
            System.out.println("The Kth ancestor will be: " + root.data);
        }

        return max + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the node and the value of K for the ancestor: ");
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        System.out.println("The distance between the ancestor and the node provided is: " + kAncestor(root, n, k));
    }
}