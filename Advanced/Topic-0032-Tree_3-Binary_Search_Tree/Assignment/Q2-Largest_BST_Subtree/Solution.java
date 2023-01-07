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

class LargestSubTree {
    boolean isBST;
    int size;
    int min;
    int max;

    public LargestSubTree(boolean isBST, int size) {
        this.isBST = isBST;
        this.size = size;
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
    }
}


public class Solution {

    public int solve(TreeNode A) {
        return findLargestBST(A).size;
    }

    public LargestSubTree findLargestBST(TreeNode A) {
        if(A == null) return new LargestSubTree(true, 0);

        LargestSubTree leftSubTree = findLargestBST(A.left);
        LargestSubTree rightSubTree = findLargestBST(A.right);

        boolean isBST = true;
        int size = 0;

        if(leftSubTree.isBST && rightSubTree.isBST) {
            if(leftSubTree.max > A.val && rightSubTree.min < A.val) {
                isBST = false;
                size = leftSubTree.size > rightSubTree.size ? leftSubTree.size : rightSubTree.size;
            }

            else if(leftSubTree.max > A.val) {
                isBST = false;
                size = leftSubTree.size > rightSubTree.size ? leftSubTree.size : rightSubTree.size;
            }

            else if(rightSubTree.min < A.val) {
                isBST = false;
                size = rightSubTree.size > leftSubTree.size ? rightSubTree.size : leftSubTree.size;
            }

            else {
                size = leftSubTree.size + 1 + rightSubTree.size;
            }

            leftSubTree.isBST = isBST;
            leftSubTree.size = size;
            int min = Math.min(A.val, rightSubTree.min);
            int max = Math.max(A.val, leftSubTree.max);
            leftSubTree.min = min;
            leftSubTree.max = max;

            return leftSubTree;
        }

        else if(leftSubTree.isBST) {
            isBST = false;
            if(leftSubTree.max < A.val) {
                size = rightSubTree.size > leftSubTree.size ? rightSubTree.size : leftSubTree.size;
            } else {
                size = rightSubTree.size > leftSubTree.size ? rightSubTree.size : leftSubTree.size;
            }

            leftSubTree.isBST = isBST;
            leftSubTree.size = size;
            int min = Math.min(A.val, rightSubTree.min);
            int max = Math.max(A.val, leftSubTree.max);
            leftSubTree.min = min;
            leftSubTree.max = max;

            return leftSubTree;
        }

        else if(rightSubTree.isBST) {
            isBST = false;
            if(rightSubTree.min > A.val) {
                size = leftSubTree.size > rightSubTree.size ? leftSubTree.size : rightSubTree.size;
            } else {
                size = leftSubTree.size > rightSubTree.size ? leftSubTree.size : rightSubTree.size;
            }

            leftSubTree.isBST = isBST;
            leftSubTree.size = size;
            int min = Math.min(A.val, rightSubTree.min);
            int max = Math.max(A.val, leftSubTree.max);
            leftSubTree.min = min;
            leftSubTree.max = max;

            return leftSubTree;

        }

        isBST = false;
        size = leftSubTree.size > rightSubTree.size ? leftSubTree.size : rightSubTree.size;
        int min = Math.min(A.val, rightSubTree.min);
        int max = Math.max(A.val, leftSubTree.max);
        leftSubTree.min = min;
        leftSubTree.max = max;

        return leftSubTree;
    }
}
