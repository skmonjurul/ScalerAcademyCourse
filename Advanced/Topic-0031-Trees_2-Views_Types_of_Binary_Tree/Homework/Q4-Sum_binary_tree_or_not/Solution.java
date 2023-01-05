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
        return sumBinaryTreeOrNot(A) == -1 ? 0 : 1;
    }

    public int sumBinaryTreeOrNot(TreeNode A) {

        if(A == null) return 0;

        if(A.left == null && A.right == null) return A.val;

        int left = sumBinaryTreeOrNot(A.left);
        if(left == -1) return -1;
        int right = sumBinaryTreeOrNot(A.right);
        if(right == -1) return -1;

        if(left + right == A.val) return A.val + left + right;
        return -1;
    }
}
