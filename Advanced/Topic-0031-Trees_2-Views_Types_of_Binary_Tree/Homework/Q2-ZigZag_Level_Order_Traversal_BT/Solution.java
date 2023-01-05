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

    Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        Queue<Pair> queue = new LinkedList<>();
        Stack<Pair> stack = new Stack<>();
        Map<Integer, ArrayList<Integer>> nodeAsPerLevel = new HashMap<>();

        queue.add(new Pair(A, 0));
        queue.add(null);

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            Pair pair = queue.remove();

            // if null then start popping from stack
            //based on even level or odd level, put it into queue
            if(pair == null) {
                while(!stack.isEmpty()) {
                    Pair stackPair = stack.pop();
                    TreeNode stackNode = stackPair.node;
                    int stackLevel = stackPair.level;

                    if(stackLevel % 2 == 0) {
                        if(stackNode.right != null) {
                            queue.add(new Pair(stackNode.right, stackLevel + 1));
                        }

                        if(stackNode.left != null) {
                            queue.add(new Pair(stackNode.left, stackLevel + 1));
                        }
                    } else {
                        if(stackNode.left != null) {
                            queue.add(new Pair(stackNode.left, stackLevel + 1));
                        }

                        if(stackNode.right != null) {
                            queue.add(new Pair(stackNode.right, stackLevel + 1));
                        }
                    }

                }
                if(!queue.isEmpty())
                    queue.add(null);
            }
            else {

                // if not null
                stack.push(pair);
                TreeNode temp = pair.node;
                int level = pair.level;

                min = Math.min(min, level);
                max = Math.max(max, level);

                ArrayList<Integer> nodes = nodeAsPerLevel.getOrDefault(level, null);
                if(nodes == null) {
                    nodes = new ArrayList<>();
                }

                nodes.add(temp.val);
                nodeAsPerLevel.put(level, nodes);
            }

        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = min; i <= max; i++) {
            result.add(nodeAsPerLevel.get(i));
        }

        return result;
    }
}
