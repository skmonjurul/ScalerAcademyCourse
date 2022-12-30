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

    public TreeNode buildTree(ArrayList<Integer> A, int aStart, int aEnd, ArrayList<Integer> B, int bStart, int bEnd) {

        if(aStart > aEnd || bEnd < 0) {
            return null;
        }

        int rootData = B.get(bEnd);
        int rootIndex = -1;
        for(int i = aStart; i <= aEnd; i++) {
            if(A.get(i) == rootData) {
                rootIndex = i;
                break;
            }
        }


        TreeNode root = new TreeNode(rootData);
        root.left = buildTree(A, aStart, rootIndex - 1, B, bStart, bStart + (rootIndex - 1 - aStart));
        root.right = buildTree(A, rootIndex + 1, aEnd, B, bStart + (rootIndex - 1 - aStart) + 1, bEnd - 1);

        return root;
    }
}
