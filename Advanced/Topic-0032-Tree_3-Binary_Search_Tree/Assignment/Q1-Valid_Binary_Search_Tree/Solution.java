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
    public int isValidBST(TreeNode A) {
        return isValid(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    public boolean isValid(TreeNode A, int min, int max) {
        if(A == null) return true;


        if(A.val < min || A.val > max) return false;

        return isValid(A.left, min, A.val - 1) && isValid(A.right, A.val + 1, max);

    }
}
