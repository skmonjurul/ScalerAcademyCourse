/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        //null check
        if(A == null) return A;

        // first calculate the size
        ListNode temp = A;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }

        // calculte the node number from first
        int nodeToBeDelete = size - B;

        // if delete node is the first node
        if(nodeToBeDelete <= 0) {
            A = A.next;
            return A;
        }

        int count = 0;
        temp = A;

        while(count < nodeToBeDelete - 1) {
            temp = temp.next;
            count++;
        }

        //point to the next to next node
        temp.next = temp.next.next;

        return A;

    }
}
