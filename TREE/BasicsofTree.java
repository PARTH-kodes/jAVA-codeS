import java.util.*;

public class BasicsofTree {
    static class Tree {
        int data;
        Tree left;
        Tree right;

        Tree(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Tree buildTree(Deque<Integer> nodes) {
        if (nodes.isEmpty() || nodes.peek() == -1) {
            nodes.poll(); /*
                           * VERY IMPORTANT STEP, TO REMOVE THE -1 THAT IS OCCURING AND THEN WORK ON THE
                           * NEXT NODE
                           */
            return null;
        }
        Tree root = new Tree(nodes.remove());
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);

        return root;
    }

    public static void printPreorder(Tree root) {
        if (root == null) {
            System.out.print("-1 ");
            return;
        }
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void printInorder(Tree rootTree) {
        if (rootTree == null) {
            System.out.print("-1 ");
            return;
        }
        printInorder(rootTree.left);
        System.out.print(rootTree.data + " ");
        printInorder(rootTree.right);
    }

    public static void printPostorder(Tree root) {
        if (root == null) {
            System.out.print("-1 ");
            return;
        }
        printPostorder(root.left);
        printPostorder(root.right);

        System.out.print(root.data + " ");
    }

    public static void printLevelorder(Tree root) {
        if (root == null) {
            return;
        }
        Queue<Tree> nodes = new LinkedList<>();

        nodes.add(root);
        nodes.add(null);

        while (!nodes.isEmpty()) {
            Tree currNode = nodes.remove();
            if (currNode == null) {
                System.out.println();
                if (nodes.isEmpty()) {
                    break;
                } else {
                    nodes.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    nodes.add(currNode.left);
                }
                if (currNode.right != null) {
                    nodes.add(currNode.right);
                }
            }
        }
    }

    public static int heightTree(Tree root) {
        if (root == null) {
            return 0;
        }

        return Integer.max(heightTree(root.left), heightTree(root.right)) + 1;
    }

    public static int countNodes(Tree root) {
        if (root == null) {
            return 0;
        }

        return (countNodes(root.left) + countNodes(root.right)
                + 1);
    }

    public static int sumOfNodes(Tree root) {
        if (root == null) {
            return 0;
        }
        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
    }

    public static int diameterOfTree(Tree root) { // O(n^2)
        if (root == null) {
            return 0;
        }

        // int leftDia = diameterOfTree(root.left);
        // int leftHt = heightTree(root.left);
        // int rightDia= diameterOfTree(root.right);
        // int rightHt = heightTree(root.right);

        // int selfDia = leftHt + rightHt + 1;

        // return Math.max(selfDia, Math.max(leftDia, rightDia));

        return Math.max((heightTree(root.left) + heightTree(root.right) + 1),
                Math.max(diameterOfTree(root.left), diameterOfTree(root.right)));
    }

    static class Info {
        int height;
        int diameter;

        Info(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static Info diameterofTree(Tree root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = diameterofTree(root.left);
        Info rightInfo = diameterofTree(root.right);

        int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter),
                leftInfo.height + rightInfo.height + 1);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(height, diameter);
    }

    public static Deque<Integer> arrToDeque(int node[]) {
        // Integer Node[] = Arrays.stream(node).boxed().toArray(Integer[]::new);

        List<Integer> nodeList = Arrays.asList(Arrays.stream(node).boxed().toArray(Integer[]::new));

        return new ArrayDeque<>(nodeList);
    }

    public static void main(String[] args) {
        int node[] = { 1, 2, 3, -1, -1, 4, -1, -1, 5, 6, 8, -1, -1, 9, 10, -1, -1, -1, -1, 7 };

        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the number of nodes, in the tree");
        // int n = sc.nextInt();

        // int[] node = new int[n];

        // System.out.println("Enter the data of nodes in the PRE-ORDER format, if null
        // then enter -1, : ");
        // for (int i = 0; i < n; i++) {
        // node[i] = sc.nextInt();
        // }

        Deque<Integer> nodes = arrToDeque(node);

        Tree root = buildTree(nodes);

        System.out.println("\nThe root of the tree is: " + root.data);

        // printPreorder(root);
        // System.out.println();

        // printInorder(root);
        // System.out.println();

        // printPostorder(root);
        // System.out.println();

        // printLevelorder(root);

        // int height = heightTree(root);
        // System.out.println("Height of the tree is: " + height);

        // int totalNodes = countNodes(root);
        // System.out.println("The tree has total " + totalNodes + " nodes.");

        // int sumOfAllNodes = sumOfNodes(root);
        // System.out.println("The sum of all the nodes of the tree is: " +
        // sumOfAllNodes);

        // int diameter = diameterOfTree(root);
        // System.out.println("The diameter of the tree is: " + diameter);

        // int diameter1 = diameterofTree(root).diameter;
        // System.out.println("The diameter of the tree is: " + diameter1);

        sc.close();
    }
}