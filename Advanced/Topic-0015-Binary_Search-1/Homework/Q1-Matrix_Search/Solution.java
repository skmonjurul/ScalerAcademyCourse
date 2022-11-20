public class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        if(A.get(0).get(0) > B) return 0;

        for(ArrayList<Integer> row : A) {
            if(row.get(0) > B) break;
            int index = find(row, B);
            if(index > -1) return 1;
        }

        return 0;
    }

    public int find(ArrayList<Integer> row, int B) {
        int low = 0, high = row.size() - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(row.get(mid) <= B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return row.get(low - 1) == B ? low - 1 : -1;
    }
}
