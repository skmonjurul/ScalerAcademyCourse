/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
        return cloneGraph(node, new UndirectedGraphNode(node.label), visited);
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode original, UndirectedGraphNode clone, Map<UndirectedGraphNode, UndirectedGraphNode> visited) {

        visited.put(original, clone);

        for(UndirectedGraphNode node : original.neighbors) {
            UndirectedGraphNode temp = null;
            if(visited.containsKey(node)) {
                temp = visited.get(node);
            }

            else {
                temp = cloneGraph(node, new UndirectedGraphNode(node.label), visited);
            }
            clone.neighbors.add(temp);
        }
        return clone;
    }
}
