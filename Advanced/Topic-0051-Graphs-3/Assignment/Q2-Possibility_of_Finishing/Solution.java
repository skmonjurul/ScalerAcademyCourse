public class Solution {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i <= A; i++) {
            adjacency.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < B.size(); i++) {
            int u = B.get(i);
            int v = C.get(i);

            adjacency.get(u).add(v);
        }

        boolean[] visited = new boolean[A + 1];
        boolean[] dfsVisited = new boolean[A + 1];

        for(int i = 1; i <= A; i++) {
            if(!visited[i]) {
                if(dfs(i, adjacency, visited, dfsVisited)) return 0;
            }
        }

        for(int i = 1; i <= A; i++) {
            if(!visited[i]) return 0;
        }

        return 1;
    }

    public boolean dfs(int source, List<List<Integer>> adjacency, boolean[] visited, boolean[]dfsVisited) {
        visited[source] = true;
        dfsVisited[source] = true;

        for(Integer u : adjacency.get(source)) {
            if(!visited[u]) {
                if(dfs(u, adjacency, visited, dfsVisited)) return true;
            }

            else if(dfsVisited[u]) return true;
        }

        dfsVisited[source] = false;

        return false;
    }
}
