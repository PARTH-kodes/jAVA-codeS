public class LargestBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class Info {
        boolean isBST;
        int min, max, size;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int maxSize = 0;

    public static Info findLargest(Node root) {
        // base case
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftTree = findLargest(root.left);
        Info rightTree = findLargest(root.right);

        int size = leftTree.size + rightTree.size + 1;
        int min = Math.min(root.data, Math.min(leftTree.min, rightTree.min));
        int max = Math.max(root.data, Math.max(leftTree.max, rightTree.max));
        

        // checking for BST valadity

        if (root.data >= rightTree.min || root.data <= leftTree.max) {
            return new Info(false, size, min, max);
        }

        if (leftTree.isBST && rightTree.isBST) {
            maxSize = Math.max(maxSize, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        findLargest(root);
        System.out.println(maxSize);
    }
}