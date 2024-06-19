import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class HeightBinaryTree {
    public static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return -1; // height of an empty tree is -1
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Return the maximum height of the left and right subtrees plus 1
        return Integer.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        System.out.println("Number of nodes: " + t); // Print input for debugging
        Node root = null;
        while (t > 0) {
            int data = scan.nextInt();
            System.out.println("Node data: " + data); // Print input for debugging
            root = insert(root, data);
            t--;
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}