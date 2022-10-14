
private static class Node {
    int data;
    Node next;
}

    private static Node head;
    private static Node tail;

    private static int size = 0;



    public static void insert_node(int position, int value) {

        if(position < 1 || position > size + 1) return;

        Node newNode = new Node();
        newNode.data = value;

        if(head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        if(position == 1) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        if(position == size + 1) {
            tail.next = newNode;
            tail = newNode;
            size++;
            return;
        }

        Node headClone = head;
        int count = 1;
        while(headClone != null) {
            if(position - 1 == count) break;
            count++;
            headClone = headClone.next;
        }

        Node tmp = headClone.next;
        headClone.next = newNode;
        newNode.next = tmp;
        size++;
        newNode = null;
        tmp = null;
        headClone = null;
    }

    public static void delete_node(int position) {
        if(position < 1 || position > size) return;
        if(position == 1) {
            head = head.next;
            size--;
            return;
        }

        Node tmp = head;
        int count = 1;
        while (tmp != null) {
            if(count == position - 1) break;
            count++;
            tmp = tmp.next;
        }

        tmp.next = tmp.next.next;
        size--;
        if(tmp.next == null) tail = tmp;
    }

    public static void print_ll() {
        Node tmp = head;
        while(tmp != null) {
            if(tmp.next == null) {
                System.out.print(tmp.data);
            } else {
                System.out.print(tmp.data + " ");
            }
            tmp = tmp.next;
        }
    }


