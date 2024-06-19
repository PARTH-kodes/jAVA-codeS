import java.util.Scanner;



public class SumofTwoLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    public static Node removeLeadingZeros(Node head) {
        Node curr = head;
        while (curr != null && curr.data == 0) {
            curr = curr.next;
        }
        return curr;
    }

    public static Node getSum(Node num1, Node num2) {
        num1 = reverseNodes(removeLeadingZeros(num1));
        num2 = reverseNodes(removeLeadingZeros(num2));

        Node num3 = new Node(-1);
        Node tail = num3;
        int carry = 0, val1, val2;
        while (num1 != null || num2 != null || carry != 0) {
            val1 = (num1 == null) ? 0 : num1.data;
            val2 = (num2 == null) ? (0) : (num2.data);
            int sum = val1 + val2 + carry;

            carry = sum / 10;
            tail.next = new Node(sum % 10);
            tail = tail.next;

            if (num1 != null) {
                num1 = num1.next;
            }
            if (num2 != null) {
                num2 = num2.next;
            }
        }

        return reverseNodes(num3.next);
    }

    public static Node reverseNodes(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

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
        System.out.println("Enter the length of first number");
        int n = sc.nextInt();
        System.out.println("Enter the length of second number");
        int m = sc.nextInt();
        System.out.println("Enter num1");
        n -= 1;
        Node num1 = new Node(sc.nextInt());
        Node tail1 = num1;
        System.out.println("Enter the remaining digits as single nodes");
        while (n-- != 0) {
            tail1.next = new Node(sc.nextInt());
            tail1 = tail1.next;
        }
        System.out.println("Enter num2");
        m -= 1;
        Node num2 = new Node(sc.nextInt());
        Node tail2 = num2;
        System.out.println("Enter the remaining digits as single nodes");
        while (m-- != 0) {
            tail2.next = new Node(sc.nextInt());
            tail2 = tail2.next;
        }
        printList(num1);
        printList(num2);

        Node num3 = getSum(num1, num2);
        printList(num3);
        sc.close();
    }
}

/*
 * I/P:
 * 3 -> 4 -> 5 -> null
 * 4 -> 5 -> null
 * 
 * O/P:
 * 3 -> 9 -> 0 -> null
 */