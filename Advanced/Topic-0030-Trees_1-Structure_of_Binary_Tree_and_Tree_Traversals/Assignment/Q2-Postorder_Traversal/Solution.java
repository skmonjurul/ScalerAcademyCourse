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
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentNode = A;

        boolean check = true;
        while(!stack.isEmpty() || currentNode != null) {
            //go to most left
            if(currentNode != null && check) {
                stack.push(currentNode);
                currentNode = currentNode.left;
                continue;
            }

            if(stack.isEmpty()) break;


            //if there is node present in right
            //then go to right and then do the same steps from first
            if(currentNode != stack.peek().right) {
                currentNode = stack.peek().right;
                check = true;
                continue;
            }

            currentNode = stack.pop();
            result.add(currentNode.val);
            check = false;
        }

        return result;
    }
}
