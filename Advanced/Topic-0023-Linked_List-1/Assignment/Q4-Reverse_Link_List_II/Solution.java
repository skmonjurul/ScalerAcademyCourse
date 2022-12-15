/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        //null check
        if(A == null) return A;

        //if size is 1
        if(A.next == null) return A;

        // if B and C are same
        if(B == C) return A;

        ListNode temp = A;
        ListNode firstTail = null, headSecond = null, tailSecond = null, headThird = null;

        // if B == 1, means from first node we need to reverse
        if(B - 1 == 0) {
            tailSecond = A;
        }

        int i = 0;
        while(temp != null) {
            //if B is not the first node, then point to the previuos node of B
            if(B - 1 > 0 && i == B - 2) {
                firstTail = temp;
            }

            //point to the Cth node, i is 0 based index, and C is 1 based index
            //whenever we find C, we dont need to traverse anymore, we can break
            if(i == C - 1) {
                headSecond = temp;
                break;
            }


            temp = temp.next;
            i++;
        }

        //poin to the first node of third group or next node to the C
        headThird = headSecond.next;


        //point to the B node if B is not the first node
        if(firstTail != null) {
            tailSecond = firstTail.next;
        }

        //reverse the portion of linked list from B to C

        ListNode prev = null, current = tailSecond;

        while(current != headThird) {
            temp = current;
            current = current.next;
            temp.next = prev;
            prev = temp;
        }



        //if headThird is null and tailSecond is the first node then we need to reverse the whole linked list
        if(headThird == null && tailSecond == A) {
            A = prev;
            tailSecond = headThird;
            return A;
        }

        //if B is the first node and C is not the last node
        if(tailSecond == A && headThird != null) {
            A = prev;
            tailSecond.next = headThird;
            return A;
        }

        //if B is not the first element and C is the last element
        if(headThird == null && tailSecond != A) {
            firstTail.next = prev;
            tailSecond.next = headThird;
            return A;
        }

        //if B is not the first and C is not the last
        firstTail.next = prev;
        tailSecond.next = headThird;

        return A;

    }
}
