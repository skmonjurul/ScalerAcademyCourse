public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        if(n < 3) return n;

        Map<Coordinate, Integer> coordinateWithFrequency = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int overlap = 0, currentMax = 0;
            for(int j = i + 1; j < n; j++) {
                if(Objects.equals(A.get(i), A.get(j)) && Objects.equals(B.get(i), B.get(j))) overlap++;
                else {
                    int xdiff = A.get(j) - A.get(i);
                    int ydiff = B.get(j) - B.get(i);
                    int z = gcd(xdiff, ydiff);
                    xdiff /= z;
                    ydiff /= z;
                    Coordinate point = new Coordinate(xdiff, ydiff);
                    int value = coordinateWithFrequency.getOrDefault(point, 0);
                    coordinateWithFrequency.put(point, value + 1);
                    currentMax = Math.max(currentMax, value + 1);
                }
            }
            coordinateWithFrequency.clear();
            max = Math.max(max, currentMax + 1 + overlap);
        }

        return max;
    }

    public int gcd(int x, int y) {
        if(y == 0) return x;
        return gcd(y, x % y);
    }
}


class Coordinate{
    private int x, y;
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
