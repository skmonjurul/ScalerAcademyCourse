public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(ArrayList<Integer> A, final int B, final int C) {
        int n = A.size();
        // if(C == n) return 0;
        List<List<Integer>> adjacency = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            int v = A.get(i);
            adjacency.get(v).add(i + 1);
        }

        int[] visited = new int[n];

        return isReachable(C, B, adjacency, visited) ? 1 : 0;
    }

    public boolean isReachable(int source, int destination, List<List<Integer>> adjacency, int[] visited) {
        if(source == destination) return true;

        if(source < visited.length && visited[source] == 0) {
            visited[source] = 1;
            for(Integer v : adjacency.get(source)) {
                if(isReachable(v, destination, adjacency, visited)) return true;
            }
        }

        return false;
    }
}
