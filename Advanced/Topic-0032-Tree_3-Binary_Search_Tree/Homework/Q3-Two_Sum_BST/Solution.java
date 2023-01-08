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
    public int t2Sum(TreeNode A, int B) {
        Set<Integer> nodeValue = new HashSet<>();
        return findSum(A, B, nodeValue) ? 1 : 0;
    }

    public boolean findSum(TreeNode A, int B, Set<Integer> nodeValue) {
        if(A == null) return false;

        if(!nodeValue.contains(B - A.val)) {
            nodeValue.add(A.val);
        } else {
            return true;
        }

        return findSum(A.left, B, nodeValue) || findSum(A.right, B, nodeValue);
    }
}
