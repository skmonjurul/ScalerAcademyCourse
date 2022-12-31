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
    public int solve(TreeNode A) {
        if(A == null) return Integer.MIN_VALUE;


        int left = solve(A.left);
        int right = solve(A.right);
        return Math.max(Math.max(left, right), A.val);
    }
}
