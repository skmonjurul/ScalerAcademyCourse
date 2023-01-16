/*
class TreeNode {
    int val;
    TreeNode left, right;
    ListNode(int x) {
        val = x;
        left = right = null;
    }
}
*/

TreeNode prev = null;


        TreeNode solve (TreeNode root) {
        // initialize dummy node to handle edge cases
        TreeNode dummy = new TreeNode(-1);
        prev = dummy;
        // perform inorder traversal and rearrange links
        inorderTraversal(root);
        // return new head
        return dummy.right;
        }

private void inorderTraversal(TreeNode root) {
        // base case
        if (root == null) return;

        // left subtree recursive call
        inorderTraversal(root.left);

        // rearrange links
        prev.right = root;
        root.left = prev;
        prev = prev.right;

        // right subtree recursive call
        inorderTraversal(root.right);
        }