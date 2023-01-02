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
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();

        ArrayList<Integer> result = new ArrayList<>();

        TreeNode currentNode = A;

        while(!stack.isEmpty() || currentNode != null) {
            if(currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
                continue;
            }

            result.add(stack.peek().val);
            currentNode = stack.pop().right;
        }

        return result;
    }
}
