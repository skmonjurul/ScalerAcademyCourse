public class Solution {

    private long set1 = 0;
    private long set2 = 0;

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        ArrayList<ArrayList<Integer>> adjacency = new ArrayList<>(A + 1);

        for(int i = 0; i <= A; i++) {
            adjacency.add(new ArrayList<Integer>());
        }

        for(ArrayList<Integer> edge : B) {
            int u = edge.get(0);
            int v = edge.get(1);

            adjacency.get(u).add(v);
            adjacency.get(v).add(u);
        }


        boolean[] visited = new boolean[A + 1];
        int[] color = new int[A + 1];

        for(int i = 1; i <= A; i++) {

            if(!visited[i] && !isBipartite(i, 0, adjacency, visited, color)) return 0;
        }

        long mod = 1000 * 1000 * 1000 + 7;

        long totalRoads = (set1 % mod * set2 % mod) % mod;

        return (int)(totalRoads - B.size());



    }



    public boolean isBipartite(int source, int c, ArrayList<ArrayList<Integer>> adjacency, boolean[] visited, int[] color) {
        visited[source] = true;
        color[source] = c;

        if(c == 0) set1++;
        else set2++;

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
