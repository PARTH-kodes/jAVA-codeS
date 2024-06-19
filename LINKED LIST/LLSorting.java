import java.util.*;



public class LLSorting {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    // public static Node sort(Node head) {
    // ArrayList<Integer> list = new ArrayList<>();
    // for (Node i = head; i != null; i = i.next) {
    // list.add(i.data);
    // }
    // Collections.sort(list);

    // Node j = head;
    // for (Integer i : list) {
    // j.data = i;
    // j = j.next;
    // }
    // return head;
    // }

    // USING MERGE SORT

    private static Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = findMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }

    private static Node merge(Node left, Node right) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                left = left.next;
                temp = temp.next;

            }else {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        } 
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    // END OF MERGE SORT

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of LL");
        int n = sc.nextInt();
        System.out.println("Enter head");
        Node head = new Node(sc.nextInt());
        Node tail = head;
        System.out.println("Enter remaining: ");
        for (int i = 1; i < n; i++) {
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }
        System.out.println("Before sorting: ");
        printList(head);

        System.out.println("After sorting: ");
        head = mergeSort(head);
        printList(head);

        sc.close();
    }
}