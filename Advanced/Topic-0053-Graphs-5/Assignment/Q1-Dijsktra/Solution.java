public class Solution {
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {

        List<List<Pair>> adjacency = new ArrayList<>(A);

        for(int i = 0; i < A; i++) {
            adjacency.add(new ArrayList<Pair> ());
        }

        for(ArrayList<Integer> edge : B) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            adjacency.get(u).add(new Pair(v, w));
            adjacency.get(v).add(new Pair(u, w));
        }


        int[] distance = new int[A];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((p1, p2) -> p1.dist.compareTo(p2.dist));

        priorityQueue.add(new Pair(C, 0));

        while(!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();
            int u = pair.node;
            int d = pair.dist;

            if(distance[u] != Integer.MAX_VALUE) continue;
            distance[u] = d;

            for(Pair temp : adjacency.get(u)) {
                int v = temp.node;
                int w = temp.dist;

                priorityQueue.add(new Pair(v, d + w));
            }
        }


        ArrayList<Integer> dist = new ArrayList<>();

        for(int d : distance) {
            if(d == Integer.MAX_VALUE) dist.add(-1);
            else dist.add(d);
        }

        return dist;
    }
}


class Pair {
    int node;
    Integer dist;

    public Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
