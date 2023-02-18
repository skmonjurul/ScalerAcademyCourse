public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> adjacency = new ArrayList<>(A);

        for(int i = 0; i < A; i++) {
            adjacency.add(new ArrayList<Integer>());
        }

        for(ArrayList<Integer> edge : B) {
            int u = edge.get(0);
            int v = edge.get(1);

            adjacency.get(u).add(v);
            adjacency.get(v).add(u);
        }


        boolean[] visited = new boolean[A];
        int[] color = new int[A];

        for(int i = 0; i < A; i++) {

            if(!visited[i] && !isBipartite(i, 0, adjacency, visited, color)) return 0;
        }

        return 1;
    }

    public boolean isBipartite(int source, int c, ArrayList<ArrayList<Integer>> adjacency, boolean[] visited, int[] color) {
        visited[source] = true;
        color[source] = c;

        for(Integer u : adjacency.get(source)) {
            if(!visited[u] && !isBipartite(u, 1 - c, adjacency, visited, color)) {
                return false;
            }

            else if(color[u] == c) {
                return false;
            }
        }

        return true;

    }
}
