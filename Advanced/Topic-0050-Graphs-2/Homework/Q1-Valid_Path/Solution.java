public class Solution {
    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        int[][] visited = new int[B + 1][A + 1];

        for(int[] temp : visited) {
            Arrays.fill(temp, 1);
        }

        for(int r = 0; r < B + 1; r++) {
            for(int c = 0; c < A + 1; c++) {
                int x1 = r;
                int y1 = c;

                for(int i = 0; i < E.size(); i++) {
                    int x = F.get(i);
                    int y = E.get(i);

                    int xdiff = x - x1;
                    int ydiff = y - y1;

                    if((xdiff * xdiff) + (ydiff * ydiff) <= D * D) visited[x1][y1] = 0;
                }
            }
        }


        for(int i = 0; i < E.size(); i++) {
            int y = E.get(i);
            int x = F.get(i);

            visited[x][y] = 0;

            // for(int r = 1; r <= D; r++) {
            //     if(x - r < 0) break;
            //     visited[x - r][y] = 0;
            // }

            // for(int r = 1; r <= D; r++) {
            //     if(x + r >= visited.length) break;
            //     visited[x + r][y] = 0;
            // }

            // for(int c = 1; c <= D; c++) {
            //     if(y - c < 0) break;
            //     visited[x][y - c] = 0;
            // }


            // for(int c = 1; c <= D; c++) {
            //     if(y + c >= A + 1) break;
            //     visited[x][y + c] = 0;
            // }
        }



        if(visited[0][0] == 0 || visited[B][A] == 0) return "NO" ;

        if(dfs(0, 0, visited, B, A)) return "YES";

        return "NO";
    }

    public boolean dfs(int x, int y, int[][] visited, int B, int A) {
        if(x == B && y == A) return true;

        visited[x][y] = 0;

        // upper row
        if(x - 1 >= 0 && visited[x - 1][y] == 1) {
            if(dfs(x - 1, y, visited, B, A)) return true;
        }

        // bottom row
        if(x + 1 < visited.length && visited[x + 1][y] == 1) {
            if(dfs(x + 1, y, visited, B, A)) return true;
        }

        // previous column
        if(y - 1 >= 0 && visited[x][y - 1] == 1) {
            if(dfs(x, y - 1, visited, B, A)) return true;
        }

        // next row
        if(y + 1 < A + 1 && visited[x][y + 1] == 1) {
            if(dfs(x, y + 1, visited, B, A)) return true;
        }

        if(x - 1 >= 0 && y - 1 >= 0 && visited[x - 1][y - 1] == 1) {
            if(dfs(x - 1, y - 1, visited, B, A)) return true;
        }

        if(x - 1 >= 0 && y + 1 < A + 1 && visited[x - 1][y + 1] == 1) {
            if(dfs(x - 1, y + 1, visited, B, A)) return true;
        }

        if(x + 1 < visited.length && y - 1 >= 0 && visited[x + 1][y - 1] == 1) {
            if(dfs(x + 1, y - 1, visited, B, A)) return true;
        }

        if(x + 1 < visited.length && y + 1 < A + 1 && visited[x + 1][y + 1] == 1) {
            if(dfs(x + 1, y + 1, visited, B, A)) return true;
        }
        return false;
    }
}
