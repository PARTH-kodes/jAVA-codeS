
public class MinimumPath {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    
    public static int findMin(Node root, int n1, int n2) {
        Node LCA = LCA(root, n1, n2);

        return minDist(LCA, n1) + minDist(LCA, n2);
    }

    private static Node LCA(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftTree = LCA(root.left, n1, n2);
        Node rightTree = LCA(root.right, n1, n2);

        if (leftTree == null) {
            return rightTree;
        } else if (rightTree == null) {
            return leftTree;
        } else {
            return root;
        }
    }

    private static int minDist(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftSearch = minDist(root.left, n);
        int rightSearch = minDist(root.right, n);

        if (leftSearch == -1 && rightSearch == -1) {
            return -1;
        } else if (leftSearch == -1) {
            return rightSearch + 1;
        } else {
            return leftSearch + 1;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        /*
         *
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         * 
         */

        System.out.println(findMin(root, 8, 6));
    }
}