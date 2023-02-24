public class Solution {
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[] parent = new int[A + 1];
        int[] size = new int[A + 1];

        // initialize

        for(int i = 0; i <= A; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        List<Pair> edge = new ArrayList<>();
        for(int i = 0; i < B.size(); i++) {
            int u = B.get(i).get(0);
            int v = B.get(i).get(1);
            int w = B.get(i).get(2);

            edge.add(new Pair(u, v, w, i));
        }

        edge.sort((p1, p2) -> p1.w.compareTo(p2.w));

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < B.size(); i++) {
            ans.add(0);
        }

        int i = 0;

        while(i < B.size()) {
            int j = i;

            // while(j < B.size() && edge.get(j).w.equals(edge.get(i).w)) {
            //     if(root(edge.get(j).u, parent) != root(edge.get(j).v, parent)) {
            //         ans.set(edge.get(j).index, 1);
            //         unite(edge.get(j).u, edge.get(j).v, parent, size);
            //     }
            //     j++;
            // }


            while(j < B.size() && edge.get(j).w.equals(edge.get(i).w)) {
                if(root(edge.get(j).u, parent) != root(edge.get(j).v, parent)) ans.set(edge.get(j).index, 1);
                j++;
            }

            j = i;

            while(j < B.size() && edge.get(j).w.equals(edge.get(i).w)) {
                if(root(edge.get(j).u, parent) != root(edge.get(j).v, parent)) unite(edge.get(j).u, edge.get(j).v, parent, size);
                j++;
            }

            i = j;
        }

        return ans;
    }

    public int root(int v, int[] parent) {
        while(parent[v] != v) {
            parent[v] = parent[parent[v]];
            v = parent[v];
        }

        return v;
    }

    public void unite(int u, int v, int[] parent, int[] size) {
        int ru = root(u, parent);
        int rv = root(v, parent);

        if(size[ru] <= size[rv]) {
            parent[ru] = rv;
            size[rv] += size[ru];
        }

        else {
            parent[rv] = ru;
            size[ru] += size[rv];
        }
    }
}


class Pair {
    int u;
    int v;
    Integer w;
    int index;

    public Pair(int u, int v, int w, int index) {
        this.u = u;
        this.v = v;
        this.w = w;
        this.index = index;
    }
}