/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode A) {

        //null check
        if(A == null) return A;

        //if size is 1
        if(A.next == null) return A;


        ListNode temp = A;
        while(temp != null) {
            // point to the next node
            ListNode node = temp.next;

            // go to next node untill the val is not same as temp node or node is null
            while(node != null && node.val == temp.val) {
                node = node.next;
            }

            temp.next = node;
            temp = node;
        }

        return A;
    }
}
