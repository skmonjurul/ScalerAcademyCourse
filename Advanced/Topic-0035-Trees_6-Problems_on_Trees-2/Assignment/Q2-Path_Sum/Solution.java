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
public class Solution {
    public int hasPathSum(TreeNode A, int B) {
        return hasPathSum(A, B, 0) ? 1 : 0;
    }

    public boolean hasPathSum(TreeNode A, int B, long sum) {
        //if null return false
        if(A == null) return false;

        //if nnode is leaf node then check the sum with B
        if(A.left == null && A.right == null && sum + A.val == (long)B) return true;

        // check left and right side, if one of them is true return true
        return hasPathSum(A.left, B, sum + A.val) || hasPathSum(A.right, B, sum + A.val);
    }
}
