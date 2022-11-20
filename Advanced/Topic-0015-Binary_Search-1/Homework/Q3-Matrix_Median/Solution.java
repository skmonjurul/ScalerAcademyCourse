public class Solution {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int required = ((A.size() * A.get(0).size()) / 2) + 1;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(ArrayList<Integer> row : A) {
            min = Math.min(min, row.get(0));
            max = Math.max(max, row.get(row.size() - 1));
        }

        int ans = -1;

        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(findCount(A, mid) >= required) {
                ans = mid;
                max = mid - 1;

            } else {
                min = mid + 1;
            }
        }

        return ans;
    }

    public int findCount(ArrayList<ArrayList<Integer>> A, int mid) {
        int count = 0;

        for(ArrayList<Integer> row : A) {
            if(row.get(0) > mid) continue;
            count += findMinCount(row, mid);
        }

        return count;
    }

    public int findMinCount(ArrayList<Integer> row, int mid) {
        int i = 0, j = row.size() - 1;

        while(i <= j) {
            int m = i + (j - i) / 2;
            if(row.get(m) <= mid) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }

        i -= 1;
        return i - 0 + 1;
    }
}
