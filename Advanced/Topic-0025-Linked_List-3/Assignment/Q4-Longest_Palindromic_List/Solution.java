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
        if(A == null) return 0;

        //if one node is present
        if(A.next == null) return 1;

        ListNode prev = null, current = A;
        int ans = 0;

        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            // count for even size
            ans = Math.max(ans, 2 * count(current, next));
            //count for odd size
            ans = Math.max(ans, 2 * count(prev, next) + 1);

            prev = current;
            current = next;

        }

        return ans;


    }

    public int count(ListNode A, ListNode B) {
        int count = 0;

        while(A != null && B != null) {
            if(A.val != B.val) break;
            count++;
            A = A.next;
            B = B.next;
        }

        return count;
    }
}
