import java.util.*;

public class ReverseLevelOrderTraversal {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static ArrayList<Integer> reversalLevelOrder(Node root) {
        Queue<Node> level = new LinkedList<>();
        ArrayList<Integer> data = new ArrayList<>();

        level.add(root);
        while (!level.isEmpty()) {
            Node curr = level.poll();
            data.add(curr.data);
            if (curr.right != null) {
                level.add(curr.right);
            }
            if (curr.left != null) {
                level.add(curr.left);
            }
        }

        Collections.reverse(data);
        return data;
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
    }
}