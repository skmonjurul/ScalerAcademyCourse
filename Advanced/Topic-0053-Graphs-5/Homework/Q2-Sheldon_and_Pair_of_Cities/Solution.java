public class Solution {
    public ArrayList<Integer> solve(int A, int B, int C, ArrayList<Integer> D, ArrayList<Integer> E, ArrayList<Integer> F, ArrayList<Integer> G, ArrayList<Integer> H) {

        long[][] distance = new long[A + 1][A + 1];

        for(long[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for(int i = 0; i < D.size(); i++) {
            int u = D.get(i);
            int v = E.get(i);
            int w = F.get(i);
            if(w < distance[u][v]) {
                distance[u][v] = w;
                distance[v][u] = w;
            }

        }

        for(int i = 1; i <= A; i++) {
            distance[i][i] = 0;
        }



        for(int k = 1; k <= A; k++) {
            for(int i = 1; i <= A; i++) {
                for(int j = 1; j <= A; j++) {
                    if(i == k || j == k || i == j) continue;
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }




        ArrayList<Integer> shortestPath = new ArrayList<>();

        for(int i = 0; i < G.size(); i++) {
            int u = G.get(i);
            int v = H.get(i);

            if(distance[u][v] >= Integer.MAX_VALUE) shortestPath.add(-1);
            else shortestPath.add((int)distance[u][v]);
        }

        return shortestPath;
    }
}
