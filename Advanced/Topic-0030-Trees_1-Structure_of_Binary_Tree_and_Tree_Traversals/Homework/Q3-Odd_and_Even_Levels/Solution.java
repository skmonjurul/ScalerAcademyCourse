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

class Pair<K, V> {
    private K node;
    private V val;

    public Pair(K node, V val) {
        this.node = node;
        this.val = val;
    }

    public K getKey() {
        return node;
    }

    public V getValue() {
        return val;
    }
}

public class Solution {
    public int solve(TreeNode A) {

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<TreeNode, Integer>(A, 1));



        long odd = 0, even = 0;


        while(!queue.isEmpty()) {
            //remove element from front
            Pair<TreeNode, Integer> temp = queue.remove();
            //get the current level
            int level = temp.getValue();
            //get the current node
            TreeNode current = temp.getKey();

            //if level is even
            if(level % 2 == 0) {
                even += (long)current.val;
            }
            //if level is odd
            else {
                odd += (long)current.val;
            }

            //if current node left is not null then add into queue
            if(current.left != null) {
                queue.add(new Pair<TreeNode, Integer>(current.left, level + 1));
            }

            //if current node right is not null then add into queue
            if(current.right != null) {
                queue.add(new Pair<TreeNode, Integer>(current.right, level + 1));
            }

        }

        // System.out.print("odd"+odd);
        // System.out.print("even"+even);

        long diff = odd - even;
        return (int)diff;
    }
}
