// https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem

public class InsertNodeAtPosition {
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // Write your code here
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        SinglyLinkedListNode point = llist;
        for(int i = 0; i < position - 1; i++) {
            point = point.next;
        }
        SinglyLinkedListNode temp = point.next;
        point.next = node;
        node.next = temp;
        return llist;
    }

    public static void start() {
        SinglyLinkedList llist = new SinglyLinkedList();
        llist.insertNode(1);
        insertNodeAtPosition(llist.head, 2, 0);
    }
}

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}
