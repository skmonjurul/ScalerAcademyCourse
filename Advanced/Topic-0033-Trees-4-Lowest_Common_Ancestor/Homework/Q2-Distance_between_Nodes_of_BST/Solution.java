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

        //if root value is greater than both value, then search in left
        if(A.val > B && A.val > C) {
            return solve(A.left, B, C);
        }

        //if root value is smaller than both value, then search in right
        if(A.val < B && A.val < C) {
            return solve(A.right, B, C);
        }

        //if root value is greater equal to B and root value is smaller equal to C, then calculate the distance

        // or if root value is greater equal to C and root value is smaller equal to B, then calculate the distance
        return findDistance(A, B) + findDistance(A, C);
    }

    public int findDistance(TreeNode root, int X) {
        if(root.val == X) return 0;

        if(root.val > X) return 1 + findDistance(root.left, X);

        return 1 + findDistance(root.right, X);
    }
}
