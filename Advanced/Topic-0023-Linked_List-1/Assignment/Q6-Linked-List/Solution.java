// public class Solution{

private static ListNode head;
private static ListNode tail;
private static int size;

public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer

        if(position < 1 || position > size + 1) return;

        ListNode newNode = new ListNode(value);

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

        int i = 1;
        ListNode temp = head;

        while(i < position - 1) {
        temp = temp.next;
        i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;

        }

public static void delete_node(int position) {
        // @params position, integer
        if(position < 1 || position > size) return;

        if(position == 1) {
        head = head.next;
        size--;
        return;
        }

        int i = 1;

        ListNode temp = head;

        while(i < position - 1) {
        temp = temp.next;
        i++;
        }

        temp.next = temp.next.next;

        if(position == size) {
        tail = temp;
        }

        size--;
        }

public static void print_ll() {
        // Output each element followed by a space
        if(head == null) return;
        ListNode temp = head;

        while(temp != null) {
        if(temp.next == null) {
        System.out.print(temp.val);
        } else {
        System.out.print(temp.val + " ");
        }

        temp = temp.next;
        }
        }

// }





//  * Definition for singly-linked list.
static class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
