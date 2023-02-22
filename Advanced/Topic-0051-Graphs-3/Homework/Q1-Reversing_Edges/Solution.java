public class Solution {
    public int reverseEdges(int A, ArrayList<ArrayList<Integer>> B) {
        List<Pair>[] adjacency = new ArrayList[A + 1];

        for(int i = 0; i <= A; i++) {
            adjacency[i] = new ArrayList<Pair>();
        }


        for(int i = 0; i < B.size(); i++) {
            int u = B.get(i).get(0);
            int v = B.get(i).get(1);

            // original
            adjacency[u].add(new Pair(v, 0));

            // virtually created
            adjacency[v].add(new Pair(u, 1));
        }



        Set<Pair> setd = new HashSet<>();
        int[] dist = new int[A + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        // add source and its distance from itself
        setd.add(new Pair(0, 1));
        dist[1] = 0;

        while(!setd.isEmpty()) {
            Iterator<Pair> it = setd.iterator();
            Pair tmp = it.next();
            it.remove();

            int u = tmp.second;

            for(Pair pair : adjacency[u]) {
                int v = pair.first;
                int w = pair.second;

                if(dist[v] > dist[u] + w) {

                    if(dist[v] != Integer.MAX_VALUE) {
                        setd.remove(new Pair(dist[v], v));
                    }

                    dist[v] = dist[u] + w;
                    setd.add(new Pair(dist[v], v));
                }
            }
        }

        return dist[A] == Integer.MAX_VALUE ? -1 : dist[A];
    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
