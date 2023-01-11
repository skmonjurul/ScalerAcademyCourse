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
    public int kthsmallest(TreeNode A, int B) {
        TreeNode current = A;
        int count = 1;

        int kthSmallestVal = -1;

        while(current != null) {
            if(current.left == null) {
                if(count == B) {
                    kthSmallestVal = current.val;
                    break;
                }
                count++;
                current = current.right;
            }

            else {
                TreeNode temp = current.left;
                while(temp.right != null && temp.right != current) {
                    temp = temp.right;
                }

                if(temp.right == null) {
                    temp.right = current;
                    current = current.left;
                }
                else {
                    temp.right = null;
                    if(count == B) {
                        kthSmallestVal = current.val;
                        break;
                    }
                    count++;
                    current = current.right;
                }
            }
        }

        return kthSmallestVal;
    }
}
