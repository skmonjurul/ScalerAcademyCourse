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
    public ArrayList<Integer> recoverTree(TreeNode A) {
        List<Integer> inorder = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        inorderTraverse(A, inorder);

        int i = 0, j = inorder.size() - 1;


        while(i < j) {
            while(i < inorder.size() && inorder.get(i) < inorder.get(i + 1)) {
                i++;
            }

            while(j > 0 && inorder.get(j) > inorder.get(j - 1)) {
                j--;
            }

            if(i < j) {
                result.add(inorder.get(j));
                result.add(inorder.get(i));
                i++;
                j--;
            }
        }



        return result;

    }
    public void inorderTraverse(TreeNode A, List<Integer> inorder) {
        if(A == null) return;
        inorderTraverse(A.left, inorder);
        inorder.add(A.val);
        inorderTraverse(A.right, inorder);
    }
}
