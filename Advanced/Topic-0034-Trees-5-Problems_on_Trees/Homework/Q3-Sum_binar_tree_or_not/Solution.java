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
        return sumBinaryTree(A) > -1 ? 1 : 0;

    }

    public int sumBinaryTree(TreeNode A) {
        if(A == null) return 0;
        if(A.left == null && A.right == null) return A.val;

        int leftSum = sumBinaryTree(A.left);
        if(leftSum == -1) return -1;

        int rightSum = sumBinaryTree(A.right);
        if(rightSum == -1) return -1;

        if(leftSum + rightSum == A.val) return leftSum + rightSum + A.val;

        return -1;

    }
}
