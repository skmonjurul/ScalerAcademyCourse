/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode A) {
        //null check
        if(A == null) return A;

        //if only one node is present
        if(A.next == null) return A;

        ListNode mid = findMid(A);
        //point to the node next to mid
        ListNode next = mid.next;

        // break the chain
        mid.next = null;

        ListNode h1 = sortList(A);
        ListNode h2 = sortList(next);

        return mergeTwoLists(h1, h2);

    }

    public ListNode findMid(ListNode A) {
        ListNode slow = A, fast = A;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        //null check for both
        if(A == null && B == null) {
            return null;
        }
        //null check for one of them
        else if(A == null) {
            return B;
        } else if(B == null) {
            return A;
        }

        ListNode head = null;

        //initially compare the first node
        if(A.val < B.val) {
            head = A;
            A = A.next;
        } else {
            head = B;
            B = B.next;
        }

        ListNode tempA = A, tempB = B, temp = head;

        while(tempA != null && tempB != null) {
            if(tempA.val < tempB.val) {
                temp.next = tempA;
                temp = tempA;
                tempA = tempA.next;
            } else {
                temp.next = tempB;
                temp = tempB;
                tempB = tempB.next;
            }

        }


        if(tempA != null) {
            temp.next = tempA;
        }

        if(tempB != null) {
            temp.next = tempB;
        }

        return head;
    }
}
