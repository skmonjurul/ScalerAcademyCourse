/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A, int B) {

        // null check
        if(A == null) return A;

        // first calculate the size
        ListNode temp = A;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }

        // if size 1 then we need to return the head only
        if(size == 1) {
            return A;
        }

        // total group number to be reversed
        int groupNumber = size / B;

        //point to head, current will always be next group first node
        ListNode current = A;

        //point to null value, last will always be last node of a group
        ListNode last = null;

        //loop will run total group number of times as B divides the total size of linked list
        for(int i = 1; i <= groupNumber; i++) {

            //prev pointer, which initially point to null
            ListNode prev = null;

            // tail is for the last node of a group, for a single group reveresed
            ListNode tail = current;
            //initially count = 1, we will increment by 1, we need this to match with B number nodes
            int count = 1;

            while(count <= B) {
                temp = current;
                current = current.next;
                count++;
                temp.next = prev;
                prev = temp;
            }

            // for the first time, head will point to prev
            if(i == 1) {
                A = prev;
            } else {
                //from the second time, last will point to prev
                //as prev will be head of next group, and last will be last node of previous group
                last.next = prev;
            }
            //tail will point to last node of current group, so last will take the reference of tail
            last = tail;
        }

        return A;

    }
}
