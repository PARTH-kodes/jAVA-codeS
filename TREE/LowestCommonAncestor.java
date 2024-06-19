import java.util.*;

public class LowestCommonAncestor {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }

    // APPROACH - 1

    public static Node findAncestor(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        if (path1.isEmpty() || path2.isEmpty()) {
            return new Node(-1);
        }

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        return path1.get(i - 1);
    }

    private static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root);
        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;
    }

    // APPROACH - 2

    public static Node findLCA(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLCA = findLCA(root.left, n1, n2);
        Node rightLCA = findLCA(root.right, n1, n2);

        if (rightLCA == null) {
            return leftLCA;
        } else if (leftLCA == null) {
            return rightLCA;
        } else {
            return root;
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

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the 2 nodes whose Lowest Common Ancestor is to be found: ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println(
                "The Lowest Common Ancestor to " + n1 + " and " + n2 + " is: " + (findLCA(root, n1, n2)).data);

        if (findAncestor(root, n1, n2).data == -1) {
            System.out.println("It means that one of your node was not a valid or exisitng node in the tree.");
        }

        sc.close();

    }
}