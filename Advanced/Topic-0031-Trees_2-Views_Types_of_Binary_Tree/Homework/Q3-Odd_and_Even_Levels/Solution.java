/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */

class Pair {
    TreeNode node;
    int level;

    Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}



public class Solution {
    public int solve(TreeNode A) {
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(A, 1));


        long odd = 0, even = 0;

        while(!queue.isEmpty()) {
            Pair pair = queue.remove();
            TreeNode temp = pair.node;
            int level = pair.level;


            if(level % 2 == 0) {
                even += temp.val;
            } else {
                odd += temp.val;
            }


            if(temp.left != null) {
                queue.add(new Pair(temp.left, level + 1));
            }

            if(temp.right != null) {
                queue.add(new Pair(temp.right, level + 1));
            }
        }

        int diff = (int)(odd - even);

        return diff;
    }
}
