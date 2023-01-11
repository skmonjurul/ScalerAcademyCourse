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
    public TreeNode invertTree(TreeNode A) {
        if(A == null) return A;

        TreeNode temp = A.right;
        A.right = invertTree(A.left);
        A.left = invertTree(temp);

        return A;
    }
}
