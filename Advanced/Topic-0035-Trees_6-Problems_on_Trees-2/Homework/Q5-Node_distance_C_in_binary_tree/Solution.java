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
    public ArrayList<Integer> solve(TreeNode A, int B, int C) {
        ArrayList<Integer> result = new ArrayList<>();
        findNode(A, B, C, result);

        return result;
    }

    public int findNode(TreeNode A, int B, int C, ArrayList<Integer> result) {
        if(A == null) return -1;

        // as soon as found the value we need to find all nodes in C distance downwards
        // and also while returning back we need to return 1
        if(A.val == B) {
            findDownwards(A, 0, C, result);
            return 1;
        }

        // now find the left, if left -1 that means we didn't find the actual node we are looking for
        int left = findNode(A.left, B, C, result);

        // but if we find any value other than -1,
        // if we find left value is equal as C that means we got the node in C distance in upper wards
        // so we need to add the value and return -1, as we found the C distance

        //if we didn;t found -1 and also the value is not equal to C, that means we need to find downwards in the right direction
        // as we are going in the right direction we need to increase the existing value by 1
        // and return existing value + 1

        // same goes for right value
        if(left == C) {
            result.add(A.val);
            return -1;
        } else if(left != -1) {
            findDownwards(A.right, left + 1, C, result);
            return left + 1;
        }

        int right = findNode(A.right, B, C, result);

        if(right == C) {
            result.add(A.val);
            return -1;
        } else if(right != -1) {
            findDownwards(A.left, right + 1, C, result);
            return right + 1;
        }


        // if both left and right value is -1, then return -1
        return -1;
    }

    public void findDownwards(TreeNode A, int count, int C, ArrayList<Integer> result) {
        if(A == null) return;

        if(count == C) {
            result.add(A.val);
            return;
        }

        findDownwards(A.left, count + 1, C, result);
        findDownwards(A.right, count + 1, C, result);
    }
}
