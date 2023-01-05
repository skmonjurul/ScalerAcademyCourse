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
        //edge case, always consider the root node value
        result.add(A.val);
        queue.add(A);
        queue.add(null);

        while(queue.size() > 1) {
            TreeNode temp = queue.remove();
            //if found null, then remove again
            // add the value in result ArrayList
            //add null value in queue
            if(temp == null) {
                temp = queue.remove();
                result.add(temp.val);
                queue.add(null);
            }

            if(temp.left != null) {
                queue.add(temp.left);
            }

            if(temp.right != null) {
                queue.add(temp.right);
            }

        }

        return result;
    }
}
