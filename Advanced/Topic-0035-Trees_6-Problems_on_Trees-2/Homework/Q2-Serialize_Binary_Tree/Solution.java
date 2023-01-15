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

        queue.add(A);

        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            //if node is null then add -1
            if(node == null) {
                result.add(-1);
            }
            //else add the node val
            else {
                result.add(node.val);
            }

            //if node is not null then add left and right of the ndoe
            if(node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }

        }

        return result;
    }
}
