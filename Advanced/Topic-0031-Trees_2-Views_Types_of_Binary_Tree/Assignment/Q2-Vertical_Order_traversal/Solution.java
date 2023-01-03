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

class Pair {
    TreeNode node;
    int level;

    public Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}


public class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        //to maintain the horizontal order
        Queue<Pair> queue = new LinkedList<>();
        //to store node value as per vertical level
        Map<Integer, ArrayList<Integer>> nodeAsPerLevel = new HashMap<>();

        //first add root node with vertical level 0
        queue.add(new Pair(A, 0));

        //as hashmap not sorted, we need to track min and max
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        while(!queue.isEmpty()) {
            Pair pair = queue.remove();
            TreeNode temp = pair.node;
            int level = pair.level;

            min = Math.min(min, level);
            max = Math.max(max, level);

            //check in the map if there is already list present for that level
            //if not create a list, add the value in the list, add put it on map
            ArrayList<Integer> nodeList = nodeAsPerLevel.getOrDefault(level, null);
            if(nodeList == null) {
                nodeList = new ArrayList<>();
            }
            nodeList.add(temp.val);
            nodeAsPerLevel.put(level, nodeList);

            //now check for the node if left and right present
            if(temp.left != null) {
                queue.add(new Pair(temp.left, level - 1));
            }

            if(temp.right != null) {
                queue.add(new Pair(temp.right, level + 1));
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        //as hashmap not sorted, we need to track min and max
        for(int i = min; i <= max; i++) {
            result.add(nodeAsPerLevel.get(i));
        }

        return result;

    }
}
