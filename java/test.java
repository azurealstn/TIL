public class LinkedList {
    private Node head; //첫번째 노드
    private Node tail; //마지막 노드
    private int size = 0;

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(Object data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object data) {
        Node node = new Node(data);
        if (size == 0) {
            addFirst(data);
        } else {
            tail.next = node;
            tail = node;
            size++;
        }
    }

    Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public void add(int k, Object data) {
        if (k == 0) {
            addFirst(data);
        } else {
            Node temp1 = node(k - 1);
            Node temp2 = temp1.next;
            Node node = new Node(data);
            temp1.next = node;
            node.next = temp2;
            size++;

            if (node.next == null) {
                tail = node;
            }
        }
    }
}
