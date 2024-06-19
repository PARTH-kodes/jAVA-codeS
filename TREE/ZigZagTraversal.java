import java.util.*;

/* Given a binary tree with n nodes. Find the zig-zag level order traversal of the binary tree.
In zig zag traversal starting from the first level go from left to right for odd-numbered levels and right to left for even-numbered levels.

Example 1:

Input:
       1
    /     \
   2       3
  / \    /   \
 4   5  6     7
Output:
1 3 2 4 5 6 7
Explanation:
For level 1 going left to right, we get traversal as {1}.
For level 2 going right to left, we get traversal as {3,2}.
For level 3 going left to right, we get traversal as {4,5,6,7}.
Merging all this traversals in single array we get {1,3,2,4,5,6,7} */

public class ZigZagTraversal {
    int level(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(level(root.left), level(root.right));
    }

    void pre(Node root, ArrayList<Integer> list, int i) {
        if (root == null)
            return;
        if (i == 1)
            list.add(root.data);
        pre(root.left, list, i - 1);
        pre(root.right, list, i - 1);
    }

    void post(Node root, ArrayList<Integer> list, int i) {
        if (root == null)
            return;
        if (i == 1)
            list.add(root.data);
        post(root.right, list, i - 1);
        post(root.left, list, i - 1);
    }

    // Function to store the zig zag order traversal of tree in a list.
    ArrayList<Integer> zigZagTraversal(Node root) {
        // Add your code here.
        ArrayList<Integer> list = new ArrayList<>();
        int n = level(root);
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                pre(root, list, i);
            } else {
                post(root, list, i);
            }
        }
        return list;
    }
}