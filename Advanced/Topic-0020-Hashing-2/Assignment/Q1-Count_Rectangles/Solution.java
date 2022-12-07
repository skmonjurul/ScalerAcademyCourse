public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Set<Coordinate> uniqueCoordinate = new HashSet<>();
        List<Coordinate> coordinates = new ArrayList<>();

        for(int i = 0; i < A.size(); i++) {
            Coordinate coordinate = new Coordinate(A.get(i), B.get(i));
            coordinates.add(coordinate);
            uniqueCoordinate.add(coordinate);
        }

        int count = 0;

        for(int i = 0; i < coordinates.size(); i++) {
            Coordinate first = coordinates.get(i);
            for(int j = i + 1; j < coordinates.size(); j++) {
                Coordinate third = coordinates.get(j);
                if(first.x == third.x || first.y == third.y) continue;
                Coordinate second = new Coordinate(third.x, first.y);
                Coordinate fourth = new Coordinate(first.x, third.y);
                if(uniqueCoordinate.contains(second) && uniqueCoordinate.contains(fourth)) count++;

            }
        }

        return count / 2;
    }
}

class Coordinate{
    int x, y;
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
