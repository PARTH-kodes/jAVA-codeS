import java.util.*;

public class SubtreeInATree {
    static class Tree {
        int data;
        Tree left;
        Tree right;

        Tree(int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }

    public static boolean isSubTree(BasicsofTree.Tree mainRoot, BasicsofTree.Tree subRoot) {
        if (mainRoot == null) {
            return false;
        }
        if (mainRoot.data == subRoot.data) {
            if (isIdentical(mainRoot, subRoot)) {
                return true;
            }
        }

        return isSubTree(mainRoot.left, subRoot) || isSubTree(mainRoot.right, subRoot);
    }

    private static boolean isIdentical(BasicsofTree.Tree mainRoot, BasicsofTree.Tree subRoot) {
        if (mainRoot == null && subRoot == null) {
            return true;
        } else if (mainRoot == null || subRoot == null || subRoot.data != mainRoot.data) {
            return false;
        }

        if (!isIdentical(mainRoot.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(mainRoot.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes of main tree, and the subtree, count null nodes also: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int mainTree[] = new int[n];
        int subTree[] = new int[m];

        System.out.println("Enter the node data of main tree, for any null node, enter -1: ");
        for (int i = 0; i < n; i++) {
            mainTree[i] = sc.nextInt();
        }

        System.out.println("Enter the node data of subtree, for any null node, enter -1: ");
        for (int i = 0; i < m; i++) {
            subTree[i] = sc.nextInt();
        }

        // BasicsofTree ob = new BasicsofTree();
        Deque<Integer> mainNodes = BasicsofTree.arrToDeque(mainTree);
        Deque<Integer> subNodes = BasicsofTree.arrToDeque(subTree);

        BasicsofTree.Tree mainRoot = BasicsofTree.buildTree(mainNodes);
        BasicsofTree.Tree subRoot = BasicsofTree.buildTree(subNodes);

        if (isSubTree(mainRoot, subRoot)) {
            System.out.println("\nYES, the subtree is a valid subtree.");
        } else {
            System.out.println("\nNO, it is not a valid subtree");
        }
        sc.close();
    }
}