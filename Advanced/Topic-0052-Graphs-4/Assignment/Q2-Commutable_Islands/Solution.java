public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Collections.sort(B, (p1, p2) -> p1.get(2).compareTo(p2.get(2)));
        int[] parent = new int[A + 1];

        for(int i = 0; i <= A; i++) {
            parent[i] = i;
        }

        int ans = 0;

        for(ArrayList<Integer> edge : B) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            if(root(u, parent) != root(v, parent)) {
                ans += w;
                unite(u, v, parent);
            }
        }

        return ans;
    }

    public int root(int v, int[] parent) {
        while(v != parent[v]) {
            parent[v] = parent[parent[v]];
            v = parent[v];
        }

        return v;
    }

    public void unite(int u, int v, int[] parent) {
        int ru = root(u, parent);
        int rv = root(v, parent);

        if(ru <= rv) {
            parent[rv] = ru;
        }

        else {
            parent[ru] = rv;
        }
    }
}

class Pair {
    int u;
    int v;
    Integer w;

    public Pair(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}
