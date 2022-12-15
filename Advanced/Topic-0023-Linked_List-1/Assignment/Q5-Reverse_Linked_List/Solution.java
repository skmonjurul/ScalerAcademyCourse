/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A) {
        ListNode prev = null, temp = null, current = A;

        while(current != null) {
            temp = current;
            current = current.next;
            temp.next = prev;
            prev = temp;
        }

        A = prev;

        return A;
    }
}
