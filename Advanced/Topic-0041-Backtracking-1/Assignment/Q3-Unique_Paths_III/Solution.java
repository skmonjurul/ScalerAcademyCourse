public class Solution {
    private int count;
    private int[] moveX;
    private int[] moveY;
    private int n;
    private int m;
    private int totalZeroCount;

    public int solve(ArrayList<ArrayList<Integer>> A) {
        count = 0;
        moveX = new int[] {-1, 1, 0, 0};
        moveY = new int[] {0, 0, -1, 1};

        n = A.size();
        m = A.get(0).size();

        int sx = -1, sy = -1;
        totalZeroCount = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(A.get(i).get(j).equals(1)) {
                    sx = i;
                    sy = j;
                }

                if(A.get(i).get(j).equals(0)) totalZeroCount++;
            }
        }

        if(sx == -1) return 0;

        // pathCount(sx, sy, A);
        pathCount_v2(sx, sy, A, 0);

        return count;
    }

    public void pathCount_v2(int sx, int sy, ArrayList<ArrayList<Integer>> A, int zeroCount) {
        if(A.get(sx).get(sy).equals(2) && zeroCount == totalZeroCount + 1) {
            count++;
            return;
        }

        if(A.get(sx).get(sy).equals(2)) return;

        for(int i = 0; i < moveX.length; i++) {
            int x = sx + moveX[i];
            int y = sy + moveY[i];

            if(isInside(x, y) && (A.get(x).get(y).equals(0) || A.get(x).get(y).equals(2))) {
                int number = A.get(x).get(y);
                if(number == 0)
                    A.get(x).set(y, -1);

                pathCount_v2(x, y, A, zeroCount + 1);

                if(number == 0)
                    A.get(x).set(y, 0);
            }
        }
    }


    public void pathCount(int sx, int sy, ArrayList<ArrayList<Integer>> A) {
        if(A.get(sx).get(sy).equals(2) && allZeroVisited(A)) {
            count++;
            return;
        }

        if(A.get(sx).get(sy).equals(2)) return;

        for(int i = 0; i < moveX.length; i++) {
            int x = sx + moveX[i];
            int y = sy + moveY[i];

            if(isInside(x, y) && (A.get(x).get(y).equals(0) || A.get(x).get(y).equals(2))) {
                int number = A.get(x).get(y);
                if(number == 0)
                    A.get(x).set(y, -1);

                pathCount(x, y, A);

                if(number == 0)
                    A.get(x).set(y, 0);
            }
        }
    }

    public boolean isInside(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public boolean allZeroVisited(ArrayList<ArrayList<Integer>> A) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(A.get(i).get(j).equals(0)) return false;
            }
        }

        return true;
    }
}
