/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode A, int B) {

        if(A == null) return A;

        if(A.next == null) return A;


        ListNode Head = A;

        ListNode smallHead = null, tempSmall = null, greaterHead = null, tempGreater = null;

        while(Head != null) {
            if(Head.val < B) {
                if(smallHead == null) {
                    smallHead = Head;
                    tempSmall = Head;
                    Head = Head.next;
                    tempSmall.next = null;
                } else {
                    tempSmall.next = Head;
                    tempSmall = Head;
                    Head = Head.next;
                    tempSmall.next = null;
                }
            } else {
                if(greaterHead == null) {
                    greaterHead = Head;
                    tempGreater = Head;
                    Head = Head.next;
                    tempGreater.next = null;
                } else {
                    tempGreater.next = Head;
                    tempGreater = Head;
                    Head = Head.next;
                    tempGreater.next = null;
                }
            }
        }

        if(smallHead == null) return greaterHead;

        A = smallHead;
        tempSmall.next = greaterHead;

        return A;
    }
}
