public class Solution {
    public int solve(ArrayList<Integer> A) {
        List<List<Integer>> adjacency = new ArrayList<>(A.size());

        for(int i = 0; i < A.size(); i++) {
            adjacency.add(new ArrayList<Integer> ());
        }

        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) != -1) {
                adjacency.get(A.get(i)).add(i);
                adjacency.get(i).add(A.get(i));
            }
        }

        Pair pair = new Pair(-1, -1);

        dfs(0, -1, 0, adjacency, pair);

        int v = pair.node;

        pair.node = -1;
        pair.distance = -1;

        dfs(v, -1, 0, adjacency, pair);

        return pair.distance;
    }

    public void dfs(int node, int parent, int d, List<List<Integer>> adjacency, Pair pair) {
        if(d > pair.distance) {
            pair.distance = d;
            pair.node = node;
        }

        for(Integer v : adjacency.get(node)) {
            if(v != parent)
                dfs(v, node, d + 1, adjacency, pair);
        }
    }
}


class Pair {
    int node;
    int distance;

    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}