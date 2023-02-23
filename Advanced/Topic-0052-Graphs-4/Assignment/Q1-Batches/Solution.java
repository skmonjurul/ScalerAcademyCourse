public class Solution {
    public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C, int D) {
        List<List<Integer>> adjacency = new ArrayList<>(A + 1);

        for(int i = 0; i <= A; i++) {
            adjacency.add(new ArrayList<Integer> ());
        }

        for(ArrayList<Integer> edge : C) {
            int u = edge.get(0);
            int v = edge.get(1);

            adjacency.get(u).add(v);
            adjacency.get(v).add(u);
        }



        boolean[] visited = new boolean[A + 1];

        int noOfBatch = 0;

        for(int i = 1; i <= A; i++) {
            int strength = 0;
            if(!visited[i]) {
                strength += dfs(i, adjacency, visited, B);
            }

            if(strength >= D) noOfBatch++;
        }

        return noOfBatch;
    }


    public int dfs(int source, List<List<Integer>> adjacency, boolean[] visited, ArrayList<Integer> B) {
        visited[source] = true;

        int strength = 0;

        for(Integer u : adjacency.get(source)) {
            if(!visited[u]) {
                strength += dfs(u, adjacency, visited, B);
            }
        }

        return strength + B.get(source - 1);

    }
}
