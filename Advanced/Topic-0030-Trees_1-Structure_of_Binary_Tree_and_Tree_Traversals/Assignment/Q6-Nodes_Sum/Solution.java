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
        if(A == null) return 0;

        int leftSum = solve(A.left);
        int rightSum = solve(A.right);

        return leftSum + rightSum + A.val;
    }
}
