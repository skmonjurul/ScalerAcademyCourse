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
    public int solve(TreeNode A, int B, int C) {
        if(A == null) return 0;
        int leftCount = solve(A.left, B, C);
        int rightCount = solve(A.right, B, C);

        if(A.val >= B && A.val <= C) {
            return rightCount + leftCount + 1;
        }

        return leftCount + rightCount;
    }
}
