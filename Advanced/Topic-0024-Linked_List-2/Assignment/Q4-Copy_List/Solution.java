/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        //null check
        if(head == null) return head;

        //if size is 1
        if(head.next == null) {
            return new RandomListNode(head.label);
        }

        RandomListNode oldHead = head, newHead = null, newTemp = null;

        Map<RandomListNode, RandomListNode> nodeReference = new HashMap<>();
        //create deep copy with normal pointer
        while(oldHead != null) {
            //create a new node
            RandomListNode temp = new RandomListNode(oldHead.label);

            //store reference of new node against to old node
            nodeReference.put(oldHead, temp);

            if(oldHead == head) {
                newHead = temp;
                newTemp = temp;
            } else {
                newTemp.next = temp;
                newTemp = temp;
            }

            oldHead = oldHead.next;
        }



        oldHead = head;
        newTemp = newHead;

        while(oldHead != null) {

            //get the random node
            RandomListNode temp = oldHead.random;

            //get the new node reference saved against old random node
            //and point random pointer to the new node
            newTemp.random = nodeReference.get(temp);

            oldHead = oldHead.next;
            newTemp = newTemp.next;
        }

        return newHead;

    }
}
