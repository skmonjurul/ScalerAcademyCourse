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
        Stack<Integer> stack = new Stack<>();

        queue.add(A);

        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            stack.push(node.val);

            if(node.right != null) {
                queue.add(node.right);
            }

            if(node.left != null) {
                queue.add(node.left);
            }

        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }
}
