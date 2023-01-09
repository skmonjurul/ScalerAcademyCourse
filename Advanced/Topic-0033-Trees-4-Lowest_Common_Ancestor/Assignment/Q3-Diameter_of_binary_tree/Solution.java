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

class Pair {
    int maxDiameter;
    int maxHeight;

    public Pair(int diameter, int height) {
        maxDiameter = diameter;
        maxHeight = height;
    }
}


public class Solution {
    public int solve(TreeNode A) {
        return diameter(A).maxDiameter;
    }

    public Pair diameter(TreeNode A) {
        //if null then return maxHeight as -1, maxDiameter as Integer.MIN_VALUE
        if(A == null) return new Pair(Integer.MIN_VALUE, -1);

        Pair leftPart = diameter(A.left);
        Pair rightPart = diameter(A.right);

        // update the diameter, first find the maxDiameter between left and right part
        // then find the max between the previous and left height + right height + 2
        leftPart.maxDiameter = Math.max(Math.max(leftPart.maxDiameter, rightPart.maxDiameter), leftPart.maxHeight + rightPart.maxHeight + 2);
        //find the height of current node
        leftPart.maxHeight = Math.max(leftPart.maxHeight, rightPart.maxHeight) + 1;


        return leftPart;
    }
}
