/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode a) {

        //null check
        if(a == null) return a;
        //if only one node is present and no cycle
        if(a.next == null) return null;

        //if one node is present and cycle present
        if(a.next == a) return a;


        ListNode slow = a, fast = a;

        while(fast.next != null && fast.next.next != null) {
            //move slow by 1 pointer
            slow = slow.next;
            //move fast by 2 pointer
            fast = fast.next.next;

            //if they point in same node that means cycle is present
            if(slow == fast) break;
        }

        if(fast.next == null || fast.next.next == null) return null;

        slow = a;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }


        return slow;
    }
}
