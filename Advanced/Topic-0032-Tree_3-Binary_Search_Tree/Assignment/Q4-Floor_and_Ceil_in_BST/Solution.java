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
    public int[][] solve(TreeNode A, int[] B) {
        int[][] C = new int[B.length][2];

        for(int i = 0; i < B.length; i++) {
            Arrays.fill(C[i], -1);
        }

        for(int i = 0; i < B.length; i++) {
            findFloor(A, B[i], C, i);
            findCeil(A, B[i], C, i);
        }

        return C;
    }

    public void findFloor(TreeNode A, int X, int[][] C, int row) {
        if(A == null) return;

        if(A.val == X) {
            C[row][0] = X;
            return;
        } else if(A.val > X) {
            findFloor(A.left, X, C, row);
        } else {
            C[row][0] = A.val;
            findFloor(A.right, X, C, row);
        }

    }


    public void findCeil(TreeNode A, int X, int[][] C, int row) {
        if(A == null) return;

        if(A.val == X) {
            C[row][1] = X;
            return;
        } else if(A.val < X) {
            findCeil(A.right, X, C, row);
        } else {
            C[row][1] = A.val;
            findCeil(A.left, X, C, row);
        }
    }
}
