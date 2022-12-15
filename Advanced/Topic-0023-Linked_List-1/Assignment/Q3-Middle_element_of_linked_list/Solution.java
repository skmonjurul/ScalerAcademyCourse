/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int solve(ListNode A) {
        //null check
        if(A == null) return -1;

        // first calculate the size
        ListNode temp = A;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }

        // if size 1 then we need to delete the head only
        if(size == 1) {
            return A.val;
        }

        //calculate the mid number
        int mid = size / 2;

        int count = 0;
        temp = A;

        while(count < mid) {
            temp = temp.next;
            count++;
        }

        return temp.val;



    }
}
