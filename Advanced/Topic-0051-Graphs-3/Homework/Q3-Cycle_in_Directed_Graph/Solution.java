public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        List<Integer>[] adjacency = new ArrayList[A + 1];
        boolean[] visited = new boolean[A + 1];
        boolean[] dfsVisited = new boolean[A + 1];


        for(int i = 0; i <= A; i++) {
            adjacency[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < B.size(); i++) {
            int u = B.get(i).get(0);
            int v = B.get(i).get(1);

            adjacency[u].add(v);
        }


        for(int i = 1; i <= A; i++) {
            if(!visited[i]) {
                if(dfs(i, adjacency, visited, dfsVisited)) return 1;
            }
        }

        return 0;
    }


    public boolean dfs(int source, List<Integer>[] adjacency, boolean[] visited, boolean[] dfsVisited) {
        visited[source] = true;
        dfsVisited[source] = true;

        for(Integer u : adjacency[source]) {
            if(!visited[u]) {
                if(dfs(u, adjacency, visited, dfsVisited)) return true;
            }

            else if(dfsVisited[u]) return true;
        }

        dfsVisited[source] = false;


        return false;
    }
}
