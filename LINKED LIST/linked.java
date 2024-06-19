
public class linked {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static int size = 0;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int indx, int data) {
        if (indx == 0) {
            addFirst(data);
            return;
        }
        size++;
        Node temp = head;
        int i = 0;
        while (i < indx - 1) {
            temp = temp.next;
            i++;
        }
        Node addMiddle = new Node(data);
        addMiddle.next = temp.next;
        temp.next = addMiddle;
    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("Linked List is already empty");
        }
        size--;
        int delValue = head.data;
        head = head.next;
        return delValue;
    }

    public int removeLast() {
        int delValue;
        if (head == null) {
            delValue = head.data;
            head = null;
            return delValue;
        }
        Node prev = null;
        Node temp = head;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        delValue = tail.data;
        tail = prev;
        tail.next = null;
        return delValue;
    }

    public int removeNth(int indx) {
        int delNode = -1;
        if (head == null) {
            System.out.println("LIST IS EMPTY");
            return -1;
        }
        if (indx == 0) {
            delNode = head.data;
            head = head.next;
            return delNode;
        }
        Node temp = head;
        Node prev = null;

        int i = 0;
        while (i < indx && temp != null) {
            i++;
            prev = temp;
            temp = temp.next;
            delNode = temp.data;
        }
        prev.next = temp.next;
        return delNode;
    }

    public Node deleteEveryKthNode(int k, Node head) {
        if (k <= 1 || head == null) {
            return null;
        }
        Node dummy = new Node(0);
        Node prev = dummy;
        Node current = head;
        dummy.next = head;
        int count = 0;
        prev.next = head;

        while (current != null) {
            count++;
            if (count % k == 0) { // remove the node
                prev.next = current.next;

            } else {
                prev = current;
            }
            current = current.next;
        }
        return dummy.next;
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null\n");
    }

    public static void main(String[] args) {
        linked LL = new linked();
        LL.addFirst(3);
        LL.addFirst(1);
        LL.addLast(4);
        LL.addLast(5);
        LL.addLast(6);
        LL.addLast(7);
        LL.addLast(8);
        LL.add(1, 2);

        // Original List
        System.out.println("Origianl List:");
        LL.printList(head);

        // int delFirst = LL.removeFirst();
        // System.out.println("Node Deleted: " + delFirst);
        // int delLast = LL.removeLast();
        // System.out.println("Node Deleted: " + delLast);
        // int delNth = LL.removeNth(2);
        // System.out.println("Node Deleted: " + delNth);

        // Final List
        // System.out.println("\nFinal List:");

        LL.printList(LL.deleteEveryKthNode(2, head));
    }
}