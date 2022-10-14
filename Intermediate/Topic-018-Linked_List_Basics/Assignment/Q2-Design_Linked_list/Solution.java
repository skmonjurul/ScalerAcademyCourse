/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {

    ListNode head;
    ListNode tail;
    int size = 0;

    public ListNode solve(ArrayList<ArrayList<Integer>> arr) {

        for(int i = 0; i < arr.size(); i++) {
            int operation = arr.get(i).get(0);
            if(operation == 0) {
                insertAtFirst(arr.get(i).get(1));
            }

            if(operation == 1) {
                insertAtLast(arr.get(i).get(1));
            }

            if(operation == 2) {
                insertAtIndex(arr.get(i).get(2), arr.get(i).get(1));
            }

            if(operation == 3) {
                delete(arr.get(i).get(1));
            }

        }

        return head;
    }




    public void insertAtFirst(int value) {
        ListNode newNode = createNode(value);
        if(head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAtLast(int value) {
        ListNode newNode = createNode(value);
        if(head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void insertAtIndex(int index, int value) {
        if(index < 0 && index > size) return;

        if(index == size) {
            insertAtLast(value);
            return;
        }

        if(index == 0) {
            insertAtFirst(value);
            return;
        }

        int count = 0;
        ListNode tmp = head;
        while(index - 1 != count) {
            tmp = tmp.next;
            count++;
        }

        ListNode newNode = createNode(value);
        size++;
        newNode.next = tmp.next;
        tmp.next = newNode;
    }

    public void delete(int index) {
        if(index < 0 || index >= size) return;
        if(index == 0) {
            head = head.next;
            if(head == null) tail = head;
            size--;
            return;
        }

        int count = 0;
        ListNode tmp = head;
        while(index - 1 != count) {
            tmp = tmp.next;
            count++;
        }

        tmp.next = tmp.next.next;
        size--;
        if(tmp.next == null) tail = tmp;

    }

    private ListNode createNode(int value) {
        return new ListNode(value);
    }
}
