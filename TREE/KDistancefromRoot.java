import java.util.*;

public class KDistancefromRoot {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // APPROACH - 1
    /*
     * public static ArrayList<Integer> KDistance(Node root, int k) {
     * if (root == null) {
     * return list;
     * }
     * if (k == 1) { // if 0 - based levelling, then write 0, else write 1.
     * list.add(root.data);
     * return list;
     * }
     * 
     * KDistance(root.left, k - 1);
     * KDistance(root.right, k - 1);
     * 
     * return list;
     * }
     */

    // APPROACH - 2

    public static void KDistance(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        KDistance(root.left, level + 1, k);
        KDistance(root.right, level + 1, k);
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

    static ArrayList<Integer> list = new ArrayList<>();

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
        
        System.out.println("Enter the level value: ");
        int k = sc.nextInt();

        // ArrayList<Integer> answer = KDistance(root, k);
        // System.err.println(answer);

        KDistance(root, 0, k);

        sc.close();
    }
}