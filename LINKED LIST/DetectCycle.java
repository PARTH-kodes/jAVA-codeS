// import java.util.*;

public class DetectCycle extends linked {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static boolean isCycle(Node head) {
        slow = head;
        fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(Node head, boolean cycle) {
        if (cycle == false) {
            return;
        }
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    public static Node head;
    public static Node tail;
    static Node slow, fast;

    public static void main(String[] args) {
        // LinkedList LL = new LinkedList();
        head = new Node(1);
        head.next = new Node(2);
        Node temp = head.next;
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = temp;
        // 1 -> 2 ->
        // LL.printList(head);
        System.out.println(isCycle(head));
        removeCycle(head, isCycle(head));
        System.out.println(isCycle(head));
    }
}