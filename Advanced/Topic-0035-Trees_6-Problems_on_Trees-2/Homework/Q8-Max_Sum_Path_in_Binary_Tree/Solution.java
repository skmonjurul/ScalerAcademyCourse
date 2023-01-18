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

    int maxPath = Integer.MIN_VALUE;

    public int findMaxPathSum(TreeNode A) {
        if(A == null) return 0;

        int leftPathSum =  findMaxPathSum(A.left);
        leftPathSum = Math.max(0, leftPathSum);


        int rightPathSum = findMaxPathSum(A.right);
        rightPathSum = Math.max(0, rightPathSum);

        int totalPathSum = leftPathSum + rightPathSum + A.val;
        maxPath = Math.max(maxPath, totalPathSum);

        return Math.max(leftPathSum, rightPathSum) + A.val;
    }


    public int maxPathSum(TreeNode A) {
        findMaxPathSum(A);
        return maxPath;
    }
}
