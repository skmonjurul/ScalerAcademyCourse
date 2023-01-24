public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<Point> points = new ArrayList<>();

        for(ArrayList<Integer> point : A) {
            Point temp = new Point(point.get(0), point.get(1));
            points.add(temp);
        }

        for(int i = points.size() / 2; i >= 0; i--) {
            minSink(points, i);
        }


        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0; i < B; i++) {
            Point temp = points.get(0);
            ArrayList<Integer> tempPoint = new ArrayList();
            tempPoint.add(temp.x);
            tempPoint.add(temp.y);

            result.add(tempPoint);

            points.set(0, points.get(points.size() - 1));
            points.remove(points.size() - 1);
            minSink(points, 0);
        }


        return result;
    }

    public void minSink(ArrayList<Point> points, int index) {

        while(true) {
            int parentIndex = index;

            int leftIndex = parentIndex * 2 + 1;
            int rightIndex = parentIndex * 2 + 2;

            if(leftIndex >= points.size()) break;

            int minIndex = leftIndex;

            if(rightIndex < points.size() && points.get(rightIndex).distance < points.get(leftIndex).distance)
                minIndex = rightIndex;

            if(points.get(parentIndex).distance > points.get(minIndex).distance) {
                Point temp = points.get(parentIndex);
                points.set(parentIndex, points.get(minIndex));
                points.set(minIndex, temp);

                index = minIndex;
            } else {
                break;
            }
        }
    }
}

class Point {
    int x;
    int y;
    int distance;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = x * x + y * y;
    }
}
