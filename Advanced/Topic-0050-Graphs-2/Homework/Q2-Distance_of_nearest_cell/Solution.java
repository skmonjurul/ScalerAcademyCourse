public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {

        int n = A.size();
        int m = A.get(0).size();

        boolean[][] visited = new boolean[n][m];

        ArrayList<ArrayList<Integer>> result = new ArrayList<>(n);

        for(int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>(m);
            for(int j = 0; j < m; j++) {
                temp.add(null);
            }
            result.add(temp);
        }


        Queue<Pair> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j< m; j++) {
                if(A.get(i).get(j) == 1) {
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;
                    result.get(i).set(j, 0);
                }
            }
        }




        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            int x = temp.x;
            int y = temp.y;

            int value = result.get(x).get(y);

            if(x - 1 >= 0 && !visited[x - 1][y]) {
                visited[x - 1][y] = true;
                result.get(x - 1).set(y, value + 1);
                queue.add(new Pair(x - 1, y));
            }

            if(x + 1 < n && !visited[x + 1][y]) {
                visited[x + 1][y] = true;
                result.get(x + 1).set(y, value + 1);
                queue.add(new Pair(x + 1, y));
            }

            if(y - 1 >= 0 && !visited[x][y - 1]) {
                visited[x][y - 1] = true;
                result.get(x).set(y - 1, value + 1);
                queue.add(new Pair(x, y - 1));
            }

            if(y + 1 < m && !visited[x][y + 1]) {
                visited[x][y + 1] = true;
                result.get(x).set(y + 1, value + 1);
                queue.add(new Pair(x, y + 1));
            }
        }


        return result;

    }
}



class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
