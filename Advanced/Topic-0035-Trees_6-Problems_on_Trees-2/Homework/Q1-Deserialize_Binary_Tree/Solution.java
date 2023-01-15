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
    public TreeNode solve(ArrayList<Integer> A) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(A.get(0));

        queue.add(root);

        int i = 1;
        while(i < A.size()) {
            TreeNode node = queue.remove();

            // if node is null then continue to remove the element untill we find a valid element
            if(node == null) {
                continue;
            }

            //take the element and increase i
            int left = A.get(i++);
            //take the element and increase i
            int right = A.get(i++);

            TreeNode leftNode = null, rightNode = null;

            //if left and right -1 then we dont need to create a node object, -1 indicates that it is null
            if(left > -1)
                leftNode = new TreeNode(left);
            if(right > -1)
                rightNode = new TreeNode(right);


            node.left = leftNode;
            node.right = rightNode;

            queue.add(leftNode);
            queue.add(rightNode);
        }

        return root;
    }
}
