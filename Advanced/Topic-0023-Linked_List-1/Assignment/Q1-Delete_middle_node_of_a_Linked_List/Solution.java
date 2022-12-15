/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A) {
        // null check
        if(A == null) return A;

        // first calculate the size
        ListNode temp = A;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }

        // if size 1 then we need to delete the head only
        if(size == 1) {
            A = null;
            return A;
        }

        //calculate the mid number
        int mid = size / 2;

        //delete the node which at position as mid
        temp = A;

        // to stop the loop
        int count = 0;

        // if we need to need to delete the nth node, then we need to go till n - 1 th node
        while(count < mid - 1 && temp != null) {
            temp = temp.next;
            count++;
        }

        //point the reference to next to next node
        temp.next = temp.next.next;


        return A;

    }
}
