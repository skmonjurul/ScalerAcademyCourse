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
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        TreeNode currentNode = A;
        Stack<TreeNode> stack = new Stack<>();

        ArrayList<Integer> result = new ArrayList<>();

        while(!stack.isEmpty() || currentNode != null) {
            //if currentNode is not null, then add the currentNode val in result ArrayList
            //push into the stack, then go left
            if(currentNode != null) {
                result.add(currentNode.val);
                stack.push(currentNode);
                currentNode = currentNode.left;
                continue;
            }

            //if all left is done
            //then pop from stack, then go right of the popped item
            currentNode = stack.pop().right;
        }

        return result;
    }
}
