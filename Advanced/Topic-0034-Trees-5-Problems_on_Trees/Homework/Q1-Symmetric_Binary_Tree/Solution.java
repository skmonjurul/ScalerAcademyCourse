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
    public int isSymmetric(TreeNode A) {
        if(A == null) return 1;
        return checkSymmetric(A.left, A.right) ? 1 : 0;
    }
    public boolean checkSymmetric(TreeNode A, TreeNode B) {
        if(A == null || B == null) return A == B;
        return checkSymmetric(A.left, B.right) && checkSymmetric(A.right, B.left);
    }
}
