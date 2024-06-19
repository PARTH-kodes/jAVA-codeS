import java.util.*;



public class Serialize_Deserialize {
    
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String nodeVal[] = str.split(" ");
        Node root = new Node(Integer.parseInt(nodeVal[0]));
        Queue<Node> tree = new LinkedList<>();

        tree.add(root);

        int i = 1;
        while (tree.size() > 0 && i < nodeVal.length) {
            Node currNode = tree.remove();
            String currValue = nodeVal[i];

            if (!currValue.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currValue));
                tree.add(currNode.left);
            }

            i++;
            if (i >= nodeVal.length) {
                break;
            }

            currValue = nodeVal[i];
            if (!currValue.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currValue));
                tree.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> tree = new ArrayList<>();
        inorderTraversal(root, tree);
        return tree;
    }

    public static void inorderTraversal(Node root, List<Integer> tree) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, tree);

        tree.add(root.data);

        inorderTraversal(root.right, tree);
    }

    public static Node deserialize(ArrayList<Integer> tree) {
        if (tree.isEmpty() || tree == null) {
            return null;
        }
        return buildBST(tree, 0, tree.size() - 1);
    }

    public static Node buildBST(List<Integer> tree, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;

        Node root = new Node(tree.get(mid));

        root.left = buildBST(tree, start, mid - 1);
        root.right = buildBST(tree, mid + 1, end);

        return root;
    }

    public static void deleteTree(Node root) {
        if (root == null) {
            return;
        }
        deleteTree(root.left);
        deleteTree(root.right);
        root.left = null;
        root.right = null;
    }

    public static void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the node values of the tree: ");
        String str = sc.nextLine();

        Node root = buildTree(str);
        printInorder(root);
        System.out.println();

        ArrayList<Integer> tree = serialize(root);
        System.out.println(tree);

        deleteTree(root);

        Node getNode = deserialize(tree);
        printInorder(getNode);

        sc.close();
    }
}