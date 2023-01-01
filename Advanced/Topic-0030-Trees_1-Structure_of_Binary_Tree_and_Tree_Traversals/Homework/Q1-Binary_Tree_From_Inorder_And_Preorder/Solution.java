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
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return buildTree(A, 0, A.size() - 1, B, 0, B.size() - 1);
    }

    public TreeNode buildTree(ArrayList<Integer> preorder, int siPre, int eiPre, ArrayList<Integer> inorder, int siIn, int eiIn) {

        if(siPre >= preorder.size() || siPre > eiPre) {
            return null;
        }



        int rootData = preorder.get(siPre);
        int rootIndex = -1;

        for(int i = siIn; i <= eiIn; i++) {
            if(inorder.get(i) == rootData) {
                rootIndex = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootData);

        int noOfElementOnleftInOrder = (rootIndex - 1) - siIn + 1;
        int eiforLeftPreorder = (siPre + 1) + (noOfElementOnleftInOrder - 1);

        root.left = buildTree(preorder, siPre + 1, eiforLeftPreorder, inorder, siIn, rootIndex - 1);
        root.right = buildTree(preorder, eiforLeftPreorder + 1, eiPre, inorder, rootIndex + 1, eiIn);

        return root;

    }
}
