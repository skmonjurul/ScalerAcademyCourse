public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, List<Integer>> edges = new HashMap<>();

        for(ArrayList<Integer> edge : B) {
            int firstNode = edge.get(0);
            int secondNode = edge.get(1);

            List<Integer> nodes;

            if(!edges.containsKey(firstNode)) {
                nodes = new ArrayList<>();
                edges.put(firstNode, nodes);
            }

            else {
                nodes = edges.get(firstNode);
            }

            nodes.add(secondNode);
        }

        int[] visited = new int[A + 1];
        visited[1] = 1;

        return pathExist(A, 1, edges, visited) ? 1 : 0;
    }

    public boolean pathExist(int A, int startNode, Map<Integer, List<Integer>> edges, int[] visited) {

        boolean isExist = false;
        if(!edges.containsKey(startNode)) return isExist;

        for(Integer node : edges.get(startNode)) {
            if(node == A) return true;
            if(visited[node] == 0) {
                visited[node] = 1;
                isExist = pathExist(A, node, edges, visited);
                if(isExist) break;
            }

        }

        return isExist;
    }

    // public boolean pathExist(int A, Map<Integer, List<Integer>> edges, List<Integer> )
}
