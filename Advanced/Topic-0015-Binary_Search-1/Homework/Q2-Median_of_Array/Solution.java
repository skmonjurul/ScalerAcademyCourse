public class Solution {
    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int firstRequired = 0, secondRequired = 0;
        int totalSize = a.size() + b.size();

        int min = 0, max = 0;

        //if a size is 0
        if(a.size() == 0) {
            if(b.size() % 2 == 0) {
                int mid = b.size() / 2;
                return (b.get(mid - 1) + b.get(mid)) / 2.0;
            } else {
                return b.get(b.size() / 2) / 1.0;
            }
        }
        //if b size is 0
        else if(b.size() == 0) {
            if(a.size() % 2 == 0) {
                int mid = a.size() / 2;
                return (a.get(mid - 1) + a.get(mid)) / 2.0;
            } else {
                return a.get(a.size() / 2) / 1.0;
            }
        }

        //find the min and max from both Array
        //min and max will be search space
        min = Math.min(a.get(0), b.get(0));
        max = Math.max(a.get(a.size() - 1), b.get(b.size() - 1));

        //if totlasize is odd
        if(totalSize % 2 != 0) {
            //there will be one median
            //considering the median there are total (n / 2) + 1 elements
            firstRequired = (totalSize / 2) + 1;
            return findMedian(a, b, min, max, firstRequired) / 1.0;
        }

        //if total size is even
        // there will be 2 median
        //considering the second median there are total (n / 2) + 1 elements from starting
        secondRequired = (totalSize / 2) + 1;
        //considering the first median there are total  (n / 2) elements from starting
        firstRequired = secondRequired - 1;

        return (findMedian(a, b, min, max, firstRequired) + findMedian(a, b, min, max, secondRequired)) / 2.0;

    }

    public int findMedian(final List<Integer> a, final List<Integer> b, int min, int max, int req) {
        int ans = -1;
        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(findCount(a, b, mid) < req) {
                min = mid + 1;
            } else {
                ans = mid;
                max = mid - 1;
            }
        }

        return ans;
    }

    public int findCount(final List<Integer> a, final List<Integer> b, int mid) {
        int count = 0;
        //find the no of elements which are less than equal to the mid in the array
        count += findMinCount(a, mid);
        count += findMinCount(b, mid);

        return count;
    }

    public int findMinCount(final List<Integer> temp, int mid) {
        int low = 0, high = temp.size() - 1;

        while(low <= high) {
            int m = low + (high - low) / 2;
            if(temp.get(m) <= mid) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }

        low = low - 1;

        return low - 0 + 1;
    }
}
