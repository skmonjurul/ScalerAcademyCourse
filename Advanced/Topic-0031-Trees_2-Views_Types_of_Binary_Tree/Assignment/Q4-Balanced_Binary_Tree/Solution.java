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

    public int isBalanced(TreeNode A) {
        return heightAndisBalanced(A) == -1 ? 0 : 1;
    }
    public int heightAndisBalanced(TreeNode A) {
        if(A == null) return 0;

        //calculate the height as well as check it is balanced or not
        int leftHeight = heightAndisBalanced(A.left);
        // -1 reperesensts it is balanced or not
        if(leftHeight == -1) return -1;

        //calculate the height as well as check it is balanced or not
        int rightHeight = heightAndisBalanced(A.right);
        if(rightHeight == -1) return -1;

        // if both balanced then check their height difference
        // if it is more than 1 the then it is not balanced

        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        //return the height
        return Math.max(leftHeight, rightHeight) + 1;

    }
}
