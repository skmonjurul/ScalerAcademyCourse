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
    public ArrayList<Integer> solve(TreeNode A) {
        return boundaryValue(A);
    }

    public ArrayList<Integer> boundaryValue(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if(A == null) return result;

        TreeNode temp = A;

        //if left null collet data and go right
        // once found left stop
        while(temp != null && temp.left == null) {
            result.add(temp.val);
            temp = temp.right;
        }

        // now consider temp node as root node
        // add root data
        result.add(temp.val);

        // go to left, collect all left boundary node data, dont collect leaf node
        findLeftMost(temp.left, result);
        // go to the left and collect only leaf node
        findLeafNode(temp.left, result);
        //go to right and collect only leaf node
        findLeafNode(temp.right, result);
        //go to right and collect all right boundary data, dont collect leaf node
        findRightMost(temp.right, result);

        return result;
    }

    public void findLeftMost(TreeNode A, ArrayList<Integer> result) {
        if(A == null) return;

        // if not leaf node
        if(A.left != null || A.right != null) result.add(A.val);

        //if left present then go left
        if(A.left != null) findLeftMost(A.left, result);
            //otherwise go right
        else if(A.right != null) findLeftMost(A.right, result);
    }

    public void findLeafNode(TreeNode A, ArrayList<Integer> result) {
        if(A == null) return;

        // if leaf node
        if(A.left == null && A.right == null) {
            result.add(A.val);
            return;
        }

        findLeafNode(A.left, result);
        findLeafNode(A.right, result);
    }

    public void findRightMost(TreeNode A, ArrayList<Integer> result) {
        if(A == null) return;

        //if right present then go right
        if(A.right != null) findRightMost(A.right, result);
            //otherwise go left
        else if(A.left != null) findRightMost(A.left, result);

        // if not leaf node
        if(A.left != null || A.right != null) result.add(A.val);

    }

}
