public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();

        long[][] distance = new long[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(A.get(i).get(j) != -1)
                    distance[i][j] = A.get(i).get(j);
                else
                    distance[i][j] = Integer.MAX_VALUE;
            }
        }



        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == k || j == k || i == j) continue;
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }




        ArrayList<ArrayList<Integer>> shortestPath = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();

            for(int j = 0; j < n; j++) {
                if(distance[i][j] >= Integer.MAX_VALUE) temp.add(-1);
                else temp.add((int)distance[i][j]);
            }

            shortestPath.add(temp);
        }

        return shortestPath;
    }
}
