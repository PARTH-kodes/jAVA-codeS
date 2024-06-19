import java.util.*;

public class NoSiblings {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static ArrayList<Integer> noSiblings(Node root) {
        if (root.left == null && root.right == null) {
            return new ArrayList<>(Collections.singletonList(-1));
        }
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, list);

        if(list.size() == 0){
            list.add(-1);
            return list;
        }
        Collections.sort(list);
        return list;
    }

    private static void helper(Node root, ArrayList<Integer> list) {
        if (root.left == null && root.right == null) {
            return;
        }

        if (root.left != null && root.right == null) {
            list.add(root.left.data);
            helper(root.left, list);
        } else if (root.right != null && root.left == null) {
            list.add(root.right.data);
            helper(root.right, list);
        } else {
            helper(root.left, list);
            helper(root.right, list);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(5);
        root.right.left = new Node(6);
        root.right.left.right = new Node(7);

        System.out.println(noSiblings(root));
    }
}