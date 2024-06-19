import java.util.*;

public class VerticalSum
{
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
    
    static class Info {
        int hd;
        Node root;

        Info(Node root, int hd) {
            this.hd = hd;
            this.root = root;
        }
    }


    public static void findSum(Node root){
        Queue<Info> level = new LinkedList<>();
        ArrayList<Integer> sum = new ArrayList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        level.add(new Info(root, 0));
        
        while (!level.isEmpty()) {
            Info curr = level.remove();

            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.root);
            } else {
                int newData = map.get(curr.hd).data + curr.root.data;
                map.put(curr.hd, new Node(newData));
            }

            if (curr.root.left != null) {
                level.add(new Info(curr.root.left, curr.hd - 1));
                min = Math.min(min, curr.hd - 1);
            }

            if (curr.root.right != null) {
                level.add(new Info(curr.root.right, curr.hd + 1));
                max = Math.max(max, curr.hd + 1);
            }
        }
        
        for(int i = min; i <= max; i++){
            sum.add(map.get(i).data);
        }

        System.out.println(sum);
    }
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        findSum(root);
    }
}