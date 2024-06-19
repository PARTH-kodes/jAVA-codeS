import java.util.*;

public class TopBottomViewofTree {
    static class Tree {
        int data;
        Tree left, right;

        Tree(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {
        int horDist;
        Tree root;

        Info(Tree root, int horDist) {
            this.horDist = horDist;
            this.root = root;
        }
    }

    public static void topView(Tree root) {
        if (root == null) {
            return;
        }

        Queue<Info> level = new LinkedList<>();

        HashMap<Integer, Tree> uniqueTree = new HashMap<>();

        int min = 0, max = 0;
        level.add(new Info(root, 0));

        while (!level.isEmpty()) {
            Info curr = level.remove();

            if (uniqueTree.containsKey(curr.horDist) == false) {
                uniqueTree.put(curr.horDist, curr.root);
            }

            if (curr.root.left != null) {
                level.add(new Info(curr.root.left, curr.horDist - 1));
                min = Math.min(curr.horDist - 1, min);
            }

            if (curr.root.right != null) {
                level.add(new Info(curr.root.right, curr.horDist + 1));
                max = Math.max(curr.horDist + 1, max);
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(uniqueTree.get(i).data + " ");
        }
        System.out.println();
    }

    public static void bottomView(Tree root) {
        Queue<Info> level = new LinkedList<>();
        HashMap<Integer, Tree> bottomViewMap = new HashMap<>();

        if (root == null) {
            return;
        }

        int min = 0, max = 0;
        level.add(new Info(root, 0));

        while (!level.isEmpty()) {
            Info curr = level.remove();
            bottomViewMap.put(curr.horDist, curr.root);

            if (curr.root.left != null) {
                level.add(new Info(curr.root.left, curr.horDist - 1));
                min = Math.min(curr.horDist - 1, min);
            }
            if (curr.root.right != null) {
                level.add(new Info(curr.root.right, curr.horDist + 1));
                max = Math.max(curr.horDist + 1, max);
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(bottomViewMap.get(i).data + " ");
        }
        System.out.println();

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

    public static Deque<Integer> arrToDeque(int node[]) {
        Integer Node[] = Arrays.stream(node).boxed().toArray(Integer[]::new);

        List<Integer> nodeList = Arrays.asList(Node);

        return new LinkedList<>(nodeList);
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };

        // topView(buildTree(arrToDeque(arr)));
        bottomView(buildTree(arrToDeque(arr)));
    }
}