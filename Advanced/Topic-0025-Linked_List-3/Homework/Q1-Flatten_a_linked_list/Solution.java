/*
class ListNode {
    int val;
    ListNode right, down;
    ListNode(int x) {
        val = x;
        right = down = null;
    }
}
*/
ListNode flatten(ListNode root) {
        if(root == null || root.right == null) return root;
        ListNode mid = findMid(root);
        ListNode secondHead = mid.right;
        mid.right = null;

        ListNode head1 = flatten(root);
        ListNode head2 = flatten(secondHead);

        return mergeTwoLists(head1, head2);

        }

public ListNode findMid(ListNode A) {
        ListNode slow = A, fast = A;

        while(fast.right != null && fast.right.right != null) {
        slow = slow.right;
        fast = fast.right.right;
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
        A = A.down;
        } else {
        head = B;
        B = B.down;
        }

        ListNode tempA = A, tempB = B, temp = head;

        while(tempA != null && tempB != null) {
        if(tempA.val < tempB.val) {
        temp.down = tempA;
        temp = tempA;
        tempA = tempA.down;
        } else {
        temp.down = tempB;
        temp = tempB;
        tempB = tempB.down;
        }

        }


        if(tempA != null) {
        temp.down = tempA;
        }

        if(tempB != null) {
        temp.down = tempB;
        }

        return head;
        }