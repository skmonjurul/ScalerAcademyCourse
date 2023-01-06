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
        return symmetricCheck(A, A) ? 1 : 0;
    }

    public boolean symmetricCheck(TreeNode leftHand, TreeNode rightHand) {
        if(leftHand == null || rightHand == null) {
            return leftHand == rightHand;
        }

        if(leftHand.val != rightHand.val) return false;

        return symmetricCheck(leftHand.left, rightHand.right) && symmetricCheck(leftHand.right, rightHand.left);
    }
}
