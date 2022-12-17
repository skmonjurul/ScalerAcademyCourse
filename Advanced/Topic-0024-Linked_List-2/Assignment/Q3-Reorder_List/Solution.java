/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reorderList(ListNode A) {
        //null check
        if(A == null) return A;

        //check only one node is present
        if(A.next == null) return A;

        //check if 2 node is present
        if(A.next.next == null) return A;

        ListNode headFirst = A;
        //find mid
        ListNode mid = findMid(headFirst);

        //point to the node next to mid
        ListNode headSecond = mid.next;

        // break the chain
        mid.next = null;

        //reverse the second chain
        headSecond = reverse(headSecond);


        while(headFirst != null && headSecond != null) {
            //point to the next node of first chain
            ListNode tempFirst = headFirst.next;

            //point to the node of second chain
            headFirst.next = headSecond;

            //point to the next node of second chain
            ListNode tempSecond = headSecond.next;

            //point to the next node of first chain
            headSecond.next = tempFirst;

            //shift the head pointer
            headFirst = tempFirst;
            headSecond = tempSecond;
        }

        return A;

    }

    public ListNode findMid(ListNode A) {
        ListNode slow = A, fast = A;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode A) {
        ListNode prev = null, current = A, temp = null;

        while(current != null) {
            temp = current;
            current = current.next;
            temp.next = prev;
            prev = temp;
        }

        return prev;

    }
}
