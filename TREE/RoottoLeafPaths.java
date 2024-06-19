import java.util.*;

public class RoottoLeafPaths {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    public static ArrayList<ArrayList<Integer>> allPaths(Node root) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> oneWay = new ArrayList<>();

        findPath(root, oneWay, paths);
        return paths;
    }

    private static void findPath(Node root, ArrayList<Integer> curr_path, ArrayList<ArrayList<Integer>> paths) {
        if (root == null) {
            return;
        }
        curr_path.add(root.data);

        if (root.left == null && root.right == null) {
            paths.add(new ArrayList<>(curr_path));
        } else {
            findPath(root.left, curr_path, paths);
            findPath(root.right, curr_path, paths);
        }

        curr_path.remove(curr_path.size() - 1);
    }

    public static void main(String[] args) {
        Node root = new Node(6);

        root.right = new Node(4);

        root.right.left = new Node(8);
        root.right.right = new Node(5);

        root.right.left.left = new Node(10);
        root.right.left.right = new Node(3);

        root.right.left.left.left = new Node(2);
        root.right.left.left.right = new Node(7);

        root.right.left.right.left = new Node(1);

        root.right.right.left = new Node(9);
        root.right.right.right = new Node(11);

        /*
         *
         *       6
         *        \
         *         4
         *       /    \
         *      8      5
         *     /  \   /  \
         *    10   3 9   11
         *   / \  /
         *  2   7 1  
         * 
         *   
         */

        System.out.println(allPaths(root));
    }
}