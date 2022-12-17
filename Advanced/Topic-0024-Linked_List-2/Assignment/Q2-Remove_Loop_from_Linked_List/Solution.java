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

        //null check
        if(A == null) return A;

        if(A.next == null) return A;

        if(A.next == A) {
            A.next = null;
            return A;
        }

        ListNode slow = A, fast = A;

        while(fast.next != null && fast.next.next != null) {
            //move slow by 1 pointer
            slow = slow.next;
            //move fast by 2 pointer
            fast = fast.next.next;

            //if they point in same node that means cycle is present
            if(slow == fast) break;
        }


        slow = A;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        //both are pointing to node where cycle begins
        //move slow pointer by 1 untill slow.next == fast
        while(slow.next != fast) {
            slow = slow.next;
        }

        slow.next = null;

        return A;

    }
}
