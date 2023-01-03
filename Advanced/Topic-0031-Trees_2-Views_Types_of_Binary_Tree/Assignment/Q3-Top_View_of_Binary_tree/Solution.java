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

        Queue<TreeNode> queue = new LinkedList<>();

        ArrayList<Integer> result = new ArrayList<>();
        result.add(A.val);

        queue.add(A);

        while(!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if(temp != A)
                result.add(temp.val);

            if(temp.left != null) {
                queue.add(temp.left);
            }

        }

        queue.add(A);

        while(!queue.isEmpty()) {
            TreeNode temp = queue.remove();

            if(temp != A)
                result.add(temp.val);

            if(temp.right != null) {
                queue.add(temp.right);
            }

        }


        return result;
    }
}
