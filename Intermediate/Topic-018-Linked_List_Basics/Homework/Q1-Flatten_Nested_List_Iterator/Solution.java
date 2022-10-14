// public class Main {
//     public static void main(String[] args) {

//     }

//     // This is the interface that allows for creating nested lists.
//     // You should not implement it, or speculate about its implementation.
//     class NestedInteger {

//         NestedInteger(int x) {
//         }

//         // Return true if this NestedInteger holds a single integer, rather than a nested list.
//         boolean isInteger() {
//         }

//         // Return the single integer that this NestedInteger holds, if it holds a single integer.
//         // The result is 1e9 if this NestedInteger holds a nested list.
//         int getInteger() {

//         }

//         // Return the nested list that this NestedInteger holds, if it holds a nested list.
//         // The result is an empty ArrayList if this NestedInteger holds a single integer.
//         ArrayList<NestedInteger> getList() {

//         }
//     }

class NestedIterator {
    Node tmp;
    Node head;
    Node tail;

    NestedIterator(ArrayList<NestedInteger> nestedList) {
        flatten(nestedList);
        tmp = head;
    }
    void flatten(ArrayList<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                if (head == null) {
                    head = new Node(nestedInteger.getInteger());
                    tail = head;
                } else {
                    Node newNode = new Node(nestedInteger.getInteger());
                    tail.next = newNode;
                    tail = newNode;
                }
            } else {
                flatten(nestedInteger.getList());
            }
        }
    }

    int next() {
        int data = tmp.data;
        tmp = tmp.next;
        return data;
    }

    boolean hasNext() {
        return tmp != null;
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}