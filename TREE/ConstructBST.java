import java.util.*;

public class ConstructBST {

    static class Tree {
        int data;
        Tree left;
        Tree right;

        Tree(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Tree treeBuilder(int[] post, int[] in, int n) {
        if (post == null || in == null || post.length != in.length) {
            return null;
        }

        HashMap<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            inMap.put(in[i], i);
        }

        return build(in, 0, in.length - 1, post, 0, post.length - 1, inMap);

    }

    private static Tree build(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd,
            Map<Integer, Integer> inMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        Tree root = new Tree(post[postEnd]);

        int rootIndex = inMap.get(root.data);
        int leftSubtreeSize = rootIndex - inStart;

        root.left = build(in, inStart, rootIndex - 1, post, postStart, postStart + leftSubtreeSize - 1, inMap);
        root.right = build(in, rootIndex + 1, inEnd, post, postStart + leftSubtreeSize, postEnd - 1, inMap);

        return root;
    }

    public static void printPreorder(Tree root) {
        if (root == null) {
            // System.out.print("-1 ");
            return;
        }

        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt();
        sc.nextLine();

        int in[] = new int[n];
        int post[] = new int[n];

        System.out.println("Enter the INORDER of the tree, in space seperated integer form: ");
        String inorder = sc.nextLine();

        System.out.println("Enter the POST-ORDER of the tree, in space seperated integer form: ");
        String postorder = sc.nextLine();

        in = Arrays.stream(inorder.split(" ")).mapToInt(Integer::parseInt).toArray();

        post = Arrays.stream(postorder.split(" ")).mapToInt(Integer::parseInt).toArray();

        Tree rootTree = treeBuilder(post, in, n);

        System.out.println("\nThe PRE-ORDER of the required tree will be: ");
        printPreorder(rootTree);

        sc.close();
    }
}