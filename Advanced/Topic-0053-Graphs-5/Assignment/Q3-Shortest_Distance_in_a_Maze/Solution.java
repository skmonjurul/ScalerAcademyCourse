public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int n = A.size();
        int m = A.get(0).size();

        int[][] distance = new int[n][m];

        for(int[] temp : distance) {
            Arrays.fill(temp, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> p1.d.compareTo(p2.d));

        int sx = B.get(0);
        int sy = B.get(1);
        int dx = C.get(0);
        int dy = C.get(1);

        int[] moveX = new int[] {-1, 1, 0, 0};
        int[] moveY = new int[] {0, 0, -1, 1};


        queue.add(new Pair(sx, sy, 0));

        while(!queue.isEmpty() && distance[dx][dy] == Integer.MAX_VALUE) {
            Pair pair = queue.poll();
            int x = pair.x;
            int y = pair.y;
            int d = pair.d;

            if(distance[x][y] != Integer.MAX_VALUE) continue;
            else distance[x][y] = d;

            for(int i = 0; i < moveX.length; i++) {
                int x1 = x;
                int y1 = y;
                int d1 = 0;

                while(true) {
                    int x2 = x1 + moveX[i];
                    int y2 = y1 + moveY[i];

                    if(inside(x2, y2, n, m) && A.get(x2).get(y2).equals(0)) {
                        x1 = x2;
                        y1 = y2;
                        d1++;
                    }

                    else {
                        break;
                    }
                }// end of while loop

                if(d1 > 0 && distance[x1][y1] == Integer.MAX_VALUE) queue.add(new Pair(x1, y1, d + d1));
            } // end of for loop
        }

        if(distance[dx][dy] == Integer.MAX_VALUE) return -1;

        return distance[dx][dy];
    }

    public boolean inside(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}

class Pair {
    int x;
    int y;
    Integer d;

    public Pair(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
