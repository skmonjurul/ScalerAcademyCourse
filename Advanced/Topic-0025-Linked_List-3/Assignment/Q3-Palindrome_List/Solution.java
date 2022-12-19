/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int lPalin(ListNode A) {
        if(A.next == null) return 1;

        ListNode mid = findMid(A);
        ListNode headSecond = mid.next;
        mid.next = null;
        headSecond = reverse(headSecond);

        ListNode headFirst = A;

        while(headFirst != null && headSecond != null) {
            if(headFirst.val != headSecond.val) return 0;
            headFirst = headFirst.next;
            headSecond = headSecond.next;
        }

        return 1;

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
