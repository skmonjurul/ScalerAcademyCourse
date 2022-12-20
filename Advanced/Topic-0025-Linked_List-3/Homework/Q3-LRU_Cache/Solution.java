public class Solution {

    int size, capacity;
    Node head, tail;
    Map<Integer, Node> nodeStore;

    public Solution(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = null;
        tail = null;
        nodeStore = new HashMap<>();
    }

    public int get(int key) {
        //if key is not present retuen -1
        if(!nodeStore.containsKey(key)) {
            return -1;
        }

        //get the node
        Node temp = nodeStore.get(key);
        //delete from the Map
        nodeStore.remove(key);
        //delete the node
        delete(temp);
        //create again and put it back in Map
        nodeStore.put(key, insert(temp.value, key));

        return temp.value;

    }

    public void set(int key, int value) {

        if(nodeStore.containsKey(key)) {
            //get the node
            Node temp = nodeStore.get(key);
            //remove from the map
            nodeStore.remove(key);
            //delete the Node
            delete(temp);
            //create node again and put it back in Map
            nodeStore.put(key, insert(value, key));
            return;
        }

        //if size is equal to capacity, then remove the head
        if(size == capacity) {
            //remove from the Map
            nodeStore.remove(head.key);
            //delete the head Node
            delete(head);
            //add in the Map
            nodeStore.put(key, insert(value, key));
        }
        //if size is less than capacity, then add in map
        else {
            nodeStore.put(key, insert(value, key));
        }
    }

    private Node insert(int value, int key) {
        Node newNode = new Node(value, key);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return newNode;
    }

    private void delete(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        node.next = null;
        node.prev = null;

        if(prev != null)
            prev.next = next;

        if(next != null)
            next.prev = prev;

        if(node == head) {
            head = next;
        }

        if(node == tail) {
            tail = prev;
        }

        size--;
    }
}


class Node {
    int value;
    int key;
    Node prev, next;
    Node(int value, int key) {
        this.key = key;
        this.value = value;
    }
}
