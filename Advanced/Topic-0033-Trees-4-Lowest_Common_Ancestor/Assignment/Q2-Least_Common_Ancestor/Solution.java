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
    public int lca(TreeNode A, int B, int C) {

        // first check both B and C is present or not
        //if one of them is not present then return -1
        if(!find(A, B) || !find(A, C)) return -1;

        //if both present then find LCA
        TreeNode node = findLCA(A, B, C);
        return node == null ? -1 : node.val;
    }

    public boolean find(TreeNode A, int X) {
        if(A == null) return false;
        if(A.val == X) return true;

        return find(A.left, X) || find(A.right, X);
    }

    public TreeNode findLCA(TreeNode A, int B, int C) {
        if(A == null) return A;

        if(A.val == B || A.val == C) return A;

        TreeNode leftHand = findLCA(A.left, B, C);
        TreeNode rightHand = findLCA(A.right, B, C);

        if(leftHand != null && rightHand != null) {
            return A;
        }

        if(leftHand != null) return leftHand;

        return rightHand;

    }
}
