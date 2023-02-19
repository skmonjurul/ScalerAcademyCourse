public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> adjacency = new ArrayList<>();

        for(int i = 0; i <= A; i++) {
            adjacency.add(new ArrayList<Integer> ());
        }

        for(ArrayList<Integer> edge : B) {
            int s = edge.get(0);
            int d = edge.get(1);

            adjacency.get(s).add(d);
            adjacency.get(d).add(s);
        }

        boolean[] visited = new boolean[A + 1];

        for(int i = 1; i <= A; i++) {
            if(visited[i]) continue;
            if(isCyclePresent(i, visited, adjacency)) return 1;
        }

        return 0;
    }


    public boolean isCyclePresent(int source, boolean[] visited, ArrayList<ArrayList<Integer>> adjacency) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(source, -1));
        visited[source] = true;

        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            int v = temp.vertex;
            int parent = temp.parent;

            for(Integer d : adjacency.get(v)) {
                if(!visited[d]) {
                    visited[d] = true;
                    queue.add(new Pair(d, v));
                }

                else if(d !=parent) return true;
            }

        }

        return false;

    }
}


class Pair {
    int vertex;
    int parent;

    public Pair(int vertex, int parent) {
        this.vertex = vertex;
        this.parent = parent;
    }
}
