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
        long sum = findSum(A);
        if(sum % 2 != 0) return 0;
        return checkSum(A, sum / 2) == sum / 2 ? 1 : 0;
    }

    public long checkSum(TreeNode A, long sum) {
        if(A == null) return 0;

        long leftSum = checkSum(A.left, sum);
        if(leftSum == sum) return leftSum;

        long rightSum = checkSum(A.right, sum);
        if(rightSum == sum) return rightSum;

        return leftSum + rightSum + A.val;
    }

    public long findSum(TreeNode A) {
        if(A == null) return 0;
        long leftSum = findSum(A.left);
        long rightSum = findSum(A.right);

        return leftSum + rightSum + A.val;
    }
}

