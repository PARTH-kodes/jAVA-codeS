// import java.io.*;
import java.util.*;

class AVLInsertion {
    static class pair {
        int first;
        boolean second;

        pair(int first, boolean second) {
            this.first = first;
            this.second = second;
        }
    }
    
    static class Node {
        int data, height;
        Node left, right;
        public Node next;

        Node(int x) {
            data = x;
            left = right = null;
            height = 1;
        }
    }
    public static boolean isBST(Node n, int lower, int upper) {
        if (n == null)
            return true;
        if (n.data <= lower || n.data >= upper)
            return false;
        return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper);
    }

    public static pair isBalanced(Node n) {
        if (n == null) {
            return new pair(0, true);
        }

        pair l = isBalanced(n.left);
        pair r = isBalanced(n.right);

        if (Math.abs(l.first - r.first) > 1)
            return new pair(0, false);

        return new pair(1 + Math.max(l.first, r.first), l.second && r.second);
    }

    public static boolean isBalancedBST(Node root) {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) == false)
            System.out.print("BST voilated, inorder traversal : ");

        else if (isBalanced(root).second == false)
            System.out.print("Unbalanced BST, inorder traversal : ");

        else
            return true;
        return false;
    }

    public static void printInorder(Node n) {
        if (n == null)
            return;
        printInorder(n.left);
        System.out.print(n.data + " ");
        printInorder(n.right);
    }

    public static void main(String args[]) {
        int ip[] = new int[2000];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter \"1\" to know what does the program do");
        int choice = sc.nextInt();
        String choices = "";

        if (choice == 1) {
            System.out.println(
                    "This program inserts \"N\" number of nodes in a Adelson-Velsky and Landis(AVL) Tree and returns the inorder of the final formed tree.\n\nIn an AVL tree, the heights of the two child subtrees of any node differ by at most one; if at any time they differ by more than one, rebalancing is done to restore this property.");
            System.out.println("Enter \"Yes\" to continue with the program.\nElse Enter \"No\" to terminate.");
            choices = sc.next();
        }
        if ("YES".equalsIgnoreCase(choices)) {
            System.out.println("Enter the number of test cases");
            int t = sc.nextInt();
            while (t-- > 0) {
                System.out.print("Enter the number of nodes to be inserted - N : ");
                int n = sc.nextInt();
                System.out.println("Enter the nodes of your AVL Tree");
                for (int i = 0; i < n; i++) {
                    ip[i] = sc.nextInt();
                }
                Node root = null;
                AVLInsertion ob = new AVLInsertion();
                for (int i = 0; i < n; i++) {
                    root = ob.insertToAVL(root, ip[i]);

                    if (isBalancedBST(root) == false)
                        break;
                }
                System.out.println("The inorder of the final AVL Tree: ");
                printInorder(root);
                System.out.println();

            }
        }

        else {
            System.out.println("PROGRAM TERMINATED");
        }
        sc.close();
    }

    public Node insertToAVL(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insertToAVL(root.left, data);
        } else if (data > root.data) {
            root.right = insertToAVL(root.right, data);
        } else {
            // Duplicate data is not allowed in AVL tree
            return root;
        }

        // Update height of the current node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get the balance factor of this ancestor node to check whether
        // this node became unbalanced
        int balance = getBalance(root);

        // Perform rotations if needed
        if (balance > 1 && data < root.left.data) {
            return rightRotate(root);
        }

        if (balance < -1 && data > root.right.data) {
            return leftRotate(root);
        }

        if (balance > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Helper function to get the height of a node
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Helper function to get the balance factor of a node
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Helper function to perform a right rotation
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    // Helper function to perform a left rotation
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }
}