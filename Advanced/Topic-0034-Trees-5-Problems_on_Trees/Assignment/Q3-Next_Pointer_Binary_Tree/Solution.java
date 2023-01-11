/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

class Pair {
    TreeLinkNode node;
    int level;
    public Pair(TreeLinkNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
public class Solution {
    public void connect(TreeLinkNode root) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        int prevLevel = -1;
        TreeLinkNode prev = null;

        while(!queue.isEmpty()) {
            Pair pair = queue.remove();
            TreeLinkNode temp = pair.node;
            int level = pair.level;

            if(level != prevLevel) {
                prev = null;
                temp.next = prev;
                prev = temp;
                prevLevel = level;
            }

            else {
                temp.next = prev;
                prev = temp;
            }

            if(temp.right != null) queue.add(new Pair(temp.right, level + 1));
            if(temp.left != null) queue.add(new Pair(temp.left, level + 1));
        }
    }
}
