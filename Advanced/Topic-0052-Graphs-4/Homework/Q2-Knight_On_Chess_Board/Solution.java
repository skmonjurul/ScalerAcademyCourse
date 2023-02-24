public class Solution {
    public int knight(int A, int B, int C, int D, int E, int F) {
        boolean[][] visited = new boolean[A][B];
        int[][] distance = new int[A][B];

        int[] moveX = new int[] {-2, -2, 2, 2, -1, -1, 1, 1};
        int[] moveY = new int[] {-1, 1, -1, 1, -2, 2, -2, 2};

        // make it 0 based index
        C--;
        D--;
        E--;
        F--;



        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(C, D));
        visited[C][D] = true;

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int x = pair.x;
            int y = pair.y;

            int parentDis = distance[x][y];

            if(x == E && y == F) return parentDis;

            for(int i = 0; i < moveX.length; i++) {
                int x1 = x + moveX[i];
                int y1 = y + moveY[i];

                if(x1 >= 0 && x1 < A && y1 >= 0 && y1 < B && !visited[x1][y1]) {
                    queue.add(new Pair(x1, y1));
                    visited[x1][y1] = true;
                    distance[x1][y1] = parentDis + 1;
                }
            }

        }

        return -1;

    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}